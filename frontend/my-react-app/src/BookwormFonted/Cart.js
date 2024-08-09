import React, { useEffect, useState } from "react";
import { Button, Card, Table } from "react-bootstrap";

import CalendarDemo from "../Calender/Calenderdemo";

const Cart = () => {
  
  const [cartItems, setCartItems] = useState([]);

  const [refresh, setRefresh] = useState(1);
  const [b, Setb] = useState(false);
  // var totalAmount=0;
  const [totalAmountOfBuy, SettotalAmountofBuy] = useState(0);
  const [totalAmountOfRent, SettotalAmountofRent] = useState(0);
  const [Expdates, Setexpdate] = useState([]);
  const [RentAmount, SetRentedAmount] = useState([]);
  const [diff, setDiff] = useState([]);
  const [buyItems ,SetbuyItems] = useState([]);
  const [rentItems,SetrentItems]=useState([]);
  const [startdate , setStartDate]= useState([]);
 
  var count =0; 

  useEffect(() => {
    const fetchData = async () => {
      try {
        const token = sessionStorage.getItem("token");
        const cartId = sessionStorage.getItem("cartId");
        const response = await fetch(
          `http://localhost:8080/api/purchescontroller/getcartbycartid/${cartId}`,
          {
            method: "GET",
            headers: {
              Authorization: `Bearer ${token}`,
              "Content-Type": "application/json",
            },
          }
        );
        if (response.ok) {
          const data = await response.json();
          setCartItems(data);
          const buyItemsData = data.filter((item) => item.type === "Buy");
          const rentItemsData = data.filter((item) => item.type === "Rent");
          SetbuyItems(buyItemsData);
          SetrentItems(rentItemsData);
          
        } else {
          console.error("Failed to fetch data");
        }
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    };
  
    fetchData();
  }, [refresh]);
  
 
    
 
  if (cartItems.length > 0) {
     console.log(cartItems);
     console.log(rentItems);
     console.log(buyItems);

  }
  useEffect(() => {
    if (rentItems) {
      setDiff(Array(rentItems.length).fill(0));
      SetRentedAmount(Array(rentItems.length).fill(0));
      Setexpdate(Array(rentItems.length).fill(0));
      setStartDate(Array(rentItems.length).fill(0));
    }
  }, [b, rentItems]);
 


  const handleDifferenceChange = (difference, end, start,index) => {
   
    const newdiff = [...diff];
    newdiff[index] = difference;
    setDiff(newdiff);
    const newRentAmount = [...RentAmount];
    newRentAmount[index] = 7 + difference * 7;
    SetRentedAmount(newRentAmount);
    const newdate = [...Expdates];
    const formattedDate = new Date(end).toISOString().split('T')[0];
    newdate[index] = formattedDate;
    Setexpdate(newdate);
    const newsatrtdate=[...startdate];
    const formattedsatrtDate = new Date(start).toISOString().split('T')[0];
    newsatrtdate[index]=formattedsatrtDate;
     setStartDate(newsatrtdate);
   
  };

  useEffect(() => {
    if (buyItems) {
      let sum = 0;
      buyItems.forEach((item) => {
        if (item.type === "Buy") {
          sum += item.productPrice;
        }
      });
      SettotalAmountofBuy(sum);
    }
  }, [b, buyItems]);

  useEffect(() => {
    if (rentItems && diff && RentAmount) {
      let sum = 0;
      rentItems.forEach((item, index) => {
        if (item.type === "Rent") {
          sum += RentAmount[index];
        }
      });
      SettotalAmountofRent(sum);
    }
  }, [b, rentItems, diff, RentAmount]);

  const handleDelete = async (id) => {
    console.log(id);
    try {
      const token = sessionStorage.getItem("token");
      const response = await fetch(
        `http://localhost:8080/api/purchescontroller/delete/${id}`,
        {
          method: "DELETE",
          headers: {
            Authorization: `Bearer ${token}`,
            "Content-Type": "application/json",
          },
        }
      );

      if (response.ok) {
        // Increment refresh to trigger re-render
        setRefresh(refresh + 1);
        // console.log(refresh);
      } else {
        console.error("Failed to delete item");
      }
    } catch (error) {
      console.error("Error deleting item:", error);
    }
  };

  const handleSubmitogBuy = async () => {
    const myshelfdtoslist = buyItems
      .filter((item) => item.type === "Buy")
      .map((item) => ({productId: item.productid}));
    console.log(myshelfdtoslist);

    const token = sessionStorage.getItem("token");
    const cartId = sessionStorage.getItem("cartId");
    const selfId = sessionStorage.getItem("selfId");
    const type = "Buy";
    const respond = await fetch(
      `http://localhost:8080/api/Usermyshelf/add/${cartId}/${selfId}/${type}`,
      {
        method: "POST",
        body: JSON.stringify(myshelfdtoslist),
        headers: {
          Authorization: `Bearer ${token}`,
          "Content-Type": "application/json",
        },
      }
    );
    if (respond.ok) {
      window.alert("order place");
      setRefresh(refresh + 1);
    }
  };

  const handleSubmitOfRent = async () => {
    let myshelfdtoslist = [];
    console.log(diff);
    console.log(Expdates);
    console.log(RentAmount);
    let invalidDays = false; // Flag to check if any invalid days are selected

    for (let i = 0; i < rentItems.length; i++) {
      if (rentItems[i].type === "Rent") {
        if (diff[i] < 0 || RentAmount[i] === 0) {
          invalidDays = true; // Set flag for invalid days
          break;
        } else {
          myshelfdtoslist.push({
            productId: rentItems[i].productid,
            days: diff[i],
            expDate: Expdates[i],
            startDate:startdate[i],
            rentamount: RentAmount[i],
          });
        }
      }
    }
  console.log(JSON.stringify(myshelfdtoslist));
    if (invalidDays) {
      // Show a warning or alert to the user about invalid days selection
      window.alert("Please select days for rented items.");
    } else {
      console.log(myshelfdtoslist);
      const token = sessionStorage.getItem("token");
      const cartId = sessionStorage.getItem("cartId");
      const selfId = sessionStorage.getItem("selfId");
           
      const type = "Rent";
      const respond = await fetch(`http://localhost:8080/api/UserRentShelf/addRentShelf/${cartId}/${selfId}/${type}`,
        {
          method: "POST",
          body: JSON.stringify(myshelfdtoslist),
          headers: {
            Authorization: `Bearer ${token}`,
            "Content-Type": "application/json",
          },
        }
      );
      if (respond.ok) {
        window.alert("order place");
        setRefresh(refresh + 1);
      }
    }
    };

  // Rest of your code to handle API call and further logic

  return (
    <div>
      {/* Buyed table */}
      <h5>Buyed Books</h5>
      <Table striped bordered hover variant="dark">
        <thead>
          <tr>
            <th>#</th>
            <th>Image Path</th>
            <th>Product Name</th>
            <th>Product Price</th>
            <th>Type</th>
            <th>Delete</th>
          </tr>
        </thead>
        <tbody>
          {buyItems
            .filter((item) => item.type === "Buy")
            .map((item, index) => (
              <tr key={index}>
                <td>{index + 1}</td>
                <td> <img src={item.imagePpath} width="70" height="70" /></td>
                <td>{item.productName}</td>
                <td>{item.productPrice}</td>
                <td>{item.type}</td>
                <td>
                  <Button
                    variant="danger"
                    onClick={() => handleDelete(item.cartid)}
                  >
                    Delete
                  </Button>
                </td>
              </tr>
            ))}
        </tbody>
      </Table>
      <Card className="text-center">
        <Card.Header style={{ backgroundColor: "yellowgreen" }}></Card.Header>
        <Card.Body style={{ backgroundColor: "whitesmoke" }}>
          <Card.Title>Total Amount :</Card.Title>
          <Card.Title>{totalAmountOfBuy}</Card.Title>
          <Button
            variant="success"
            onClick={() => {
              handleSubmitogBuy();
            }}
          >
            Place Order of Buy
          </Button>
        </Card.Body>
      </Card>
      {/*  Rented table*/}
      <h5>Rented Books</h5>
      <Table striped bordered hover variant="dark">
        <thead>
          <tr>
            <th>#</th>
            <th>Image Path</th>
            <th>Product Name</th>
            <th>Product Price</th>
            <th>Type</th>
            <th>Select date</th>
            <th>No of Days Left</th>
            <th>Total Price</th>

            <th>Delete</th>
          </tr>
        </thead>
        <tbody>
          {rentItems
            .filter((item) => item.type === "Rent")
            .map((item, index) => (
              <tr key={index}>
                <td>{index + 1}</td>
                <td><img src={item.imagePpath} width="70" height="70" /></td>
                <td>{item.productName}</td>
                <td>{item.productPrice}</td>
                <td>{item.type}</td>
                <td>
                  <CalendarDemo
                    onDifferenceChange={(difference, end,start) =>
                      handleDifferenceChange(difference, end,start, index)
                    }
                  />{" "}
                </td>
                <td>{diff[index]}</td>
                {/* <td onChange={handlechangeforRentAmount(event.target.value , index) }>{diff[index] * 7} </td> */}
                <td>{RentAmount[index]}</td>
                <td>
                  <Button
                    variant="danger"
                    onClick={() => handleDelete(item.cartid)}
                  >
                    Delete
                  </Button>
                </td>
              </tr>
            ))}
        </tbody>
      </Table>
      <Card className="text-center">
        <Card.Header style={{ backgroundColor: "yellowgreen" }}></Card.Header>
        <Card.Body style={{ backgroundColor: "whitesmoke" }}>
          <Card.Title>Total Amount :</Card.Title>
          <Card.Title>{totalAmountOfRent}</Card.Title>
          <Button
            variant="success"
            onClick={() => {
              handleSubmitOfRent();
            }}
          >
            Place Order of Rent
          </Button>
        </Card.Body>
      </Card>
      <br></br>
    </div>
  );
};

export default Cart;
