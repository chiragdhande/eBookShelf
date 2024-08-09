import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
//import "../YourComponent.css"; // Import your CSS file
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import { connect } from "react-redux";

const Product = ({getuser}) => {
  const { languageId } = useParams();
  console.log(languageId);
  const [product, setProduct] = useState([]); // Initialize state with a default value
     console.log(getuser);
   const [b,Setb]=useState(false);
  useEffect(() => {
    const fetchData = async () => {
      try {
        const token = localStorage.getItem("token");
        const products = await fetch(
          `http://localhost:8080/api/productmaster/getproductbylanguage/${languageId}`,
          {
            method: "GET",
            headers: {
              Authorization: `Bearer ${token}`,
              "Content-Type": "application/json",
            },
          }
        );

        if (!products.ok) {
          throw new Error(`Request failed with status: ${products.status}`);
        } else {
          const data = await products.json();
          console.log(data);
          setProduct(data);
          Setb(true)
        }
      } catch (error) {
        console.log("fetch error", error);
      }
    };

    fetchData(); // Invoke the function to fetch data
  }, []); // Add languageId to the dependency array


  const [counts, setCounts] = useState(0);
  useEffect(() => {
    if (b) {
      setCounts(Array(product.length).fill(1));
    }
  }, [b, product]);

  const handleIncrement = async (index,item) => {
      const newCounts = [...counts];
      newCounts[index]++;
      setCounts(newCounts);
  };

  const handleDecrement = async (index, item) => {
      const newCounts = [...counts];
      if (newCounts[index] > 1) {
        newCounts[index]--;
        setCounts(newCounts);
      } else {
        console.log("Count is already at zero.");
      }
    } 
    
    const handleSubmit= async (index ,item)=>{
         const quantity=counts[index];
          console.log(quantity);
          const productId=item.productId;
           const cartId=localStorage.getItem('cartId');
           const obj={quantity,productId,cartId};
           const respond = await fetch("http://localhost:8080/api/purchescontroller",{
              method:"POST",
              body:JSON.stringify(obj),
              headers:{
                "Content-Type": "application/json"
              }

           })
             if(respond.status===200)
             {
              window.alert("cart add")
             }
             else{
              window.alert("not add")
             }

    }
  

  
  
 

  return (
    <div className="products-grid">
      {" "}
      {/* Apply the class for the grid */}
      
      {b && product.map((item, index) => (
        <div className="product-card" key={index}>
          {" "}
          {/* Apply the class for the card */}
          <span key={index}>
            <Card style={{ width: "150%", maxWidth: "16rem", margin: "auto" }}>
              <Card.Img
                variant="top"
                src={"/product_img/project_img.jpg"}
                style={{
                  height: "auto",
                  width: "auto",
                  background: "red",
                  display: "block",
                  objectFit: "cover", // Ensures image scales within its container
                }}
              />
              <Card.Body style={{ backgroundColor: "rgb(182, 215, 246)" }}>
                <Card.Title>{item.productName}</Card.Title>
                <Card.Text> Price : {item.productBasePrice}</Card.Text>
                <Card.Text>Descripation : {item.productDescription} </Card.Text>

                   {
                      item.quantity===0 ?(
                        <div style={{ textAlign: "center", color: "red" }}>
                        <p style={{ fontSize: "1.2em", fontWeight: "bold" }}>Out of Stock</p>
                        <p style={{ fontStyle: "italic" }}>Sorry, this product is currently out of stock.</p>
                      </div>
        
                      ):(
                          
                        <div>
                        <Card.Text>
                        quantity: {counts[index]} {/* Display count for this card */}
                      </Card.Text>
                      <Button variant="primary" onClick={() => handleIncrement(index,item)}>
                        Increment
                      </Button>
                      <Button variant="secondary" onClick={() => handleDecrement(index,item)}>
                        Decrement
                      </Button>
                      <Button variant="primary" onClick={ () =>handleSubmit(index,item)} >  Go somewhere </Button>
   
                      <br></br>
                      
                      </div>
                      )
                   }

                   
                
              </Card.Body>
            </Card>
          </span>

        </div>
      ))}
              
    </div>
  );
};

const mapStateToProps = (state) => ({
  getuser: state.Todoreducer,
});
export default connect(mapStateToProps) (Product);
