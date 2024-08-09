import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
//import "../YourComponent.css"; // Import your CSS file
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";

import { useCart } from "../Contextapi/CartProvider";

const Product = () => {
  const { languageId } = useParams();
  console.log(languageId);
  const [product, setProduct] = useState([]); // Initialize state with a default value

  const [b, Setb] = useState(false);

  const [count, setCounts] = useState(0);

  const { updateCartCount, cartCount } = useCart();
  useEffect(() => {
    const fetchData = async () => {
      try {
        const products = await fetch(
          `http://localhost:8080/api/productmaster/getproductbylanguage/${languageId}`
        );

        if (!products.ok) {
          throw new Error(`Request failed with status: ${products.status}`);
        } else {
          const data = await products.json();
          console.log(data);
          setProduct(data);
          Setb(true);
        }
      } catch (error) {
        console.log("fetch error", error);
      }
    };

    fetchData(); // Invoke the function to fetch data
  }, []); // Add languageId to the dependency array

  const navigate = useNavigate();

  const handleSubmit = async (item, type) => {
    const token = sessionStorage.getItem("token");
    console.log(type);
    if (!token) {
      window.alert("Your not login First login then Add the Product");
      navigate("/login");
      return;
    }

    const productId = item.productId;
    console.log(productId);
    const cartId = sessionStorage.getItem("cartId");
    const obj = { productId, cartId, type };

    try {
      const respond = await fetch(
        "http://localhost:8080/api/purchescontroller",
        {
          method: "POST",
          body: JSON.stringify(obj),
          headers: {
            Authorization: `Bearer ${token}`,
            "Content-Type": "application/json",
          },
        }
      );

      if (respond.status === 200) {
        setCounts((pre) => pre + 1);
      } else {
        window.alert("Failed to add item to cart");
      }
    } catch (error) {
      console.error("Error:", error);
      window.alert("An error occurred. Please try again.");
    }
  };
  useEffect(() => {
    updateCartCount(count);
    console.log(count);
  }, [count]);
  return (
    <div className="products-grid">
      {" "}
      {/* Apply the class for the grid */}
      {b &&
        product.map((item, index) => (
          <div className="product-card" key={index}>
            {" "}
            {/* Apply the class for the card */}
            <span key={index}>
              <Card
                style={{ width: "150%", maxWidth: "16rem", margin: "auto" }}
              >
                <Card.Img
                  variant="top"
                  src={item.imagePpath}
                  style={{
                    height: "350px", // Add 'px' to specify pixels
                    width: "auto", // Add 'px' to specify pixels
                    background: "red",
                    display: "block",
                    objectFit: "cover", // Ensures image scales within its container
                  }}
                />

                <Card.Body style={{ backgroundColor: "rgb(182, 215, 246)" }}>
                  <Card.Title>{item.productName}</Card.Title>
                  <Card.Text> Price : {item.productBasePrice}</Card.Text>
                  <Card.Text>
                    Descripation : {item.productDescription}{" "}
                  </Card.Text>

                  {item.quantity === 0 ? (
                    <div style={{ textAlign: "center", color: "red" }}>
                      <p style={{ fontSize: "1.2em", fontWeight: "bold" }}>
                        Out of Stock
                      </p>
                      <p style={{ fontStyle: "italic" }}>
                        Sorry, this product is currently out of stock.
                      </p>
                    </div>
                  ) : (
                    <div>
                      <div>
                        <Button
                          variant="primary"
                          onClick={() => handleSubmit(item, "Buy")}
                        >
                          Buy
                        </Button>
                        <span style={{ margin: "0 5px" }}></span>{" "}
                        {/* Adjust the space by changing the margin */}
                        <Button
                          variant="primary"
                          onClick={() => handleSubmit(item, "Rent")}
                        >
                          Rent
                        </Button>
                      </div>

                      <br></br>
                    </div>
                  )}
                </Card.Body>
              </Card>
            </span>
          </div>
        ))}
    </div>
  );
};

export default Product;
