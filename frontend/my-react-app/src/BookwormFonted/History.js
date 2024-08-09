import { useEffect, useState } from "react";
import { Table } from "react-bootstrap";

const History = () => {
  const [buyHistory, setBuyHistory] = useState([]);
  const [rentHistory, setRentHistory] = useState([]);
  const [showMethodtbuy, setShowMethodbuy] = useState(false);
  const [showMethodrent, setShowMethodrent] = useState(false);


  const fetchBuyData = async () => {
    try {
      const token = sessionStorage.getItem("token");
      const userID = sessionStorage.getItem("userId");
      const type = "Buy";
      const products = await fetch(
        `http://localhost:8080/api/history/${userID}/${type}`,
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
        setBuyHistory(data);
        setShowMethodbuy(true)
        setShowMethodrent(false)
      }
    } catch (error) {
      console.log("fetch error", error);
    }
  };

  const fetchRentData = async () => {
    try {
      const token = sessionStorage.getItem("token");
      const userID = sessionStorage.getItem("userId");
      const type = "Rent";
      const products = await fetch(
        `http://localhost:8080/api/history/${userID}/${type}`,
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
        setRentHistory(data);
        setShowMethodbuy(false)
        setShowMethodrent(true)

      }
    } catch (error) {
      console.log("fetch error", error);
    }
  };

  return (
    <div>

    <h1>History</h1>
    <div style={{ marginBottom: '20px' }}>
    <button type="button" class="btn btn-outline-success"  onClick={fetchBuyData}>Buy History</button>
      <span style={{ margin: '0 10px' }}></span>
      <button type="button" class="btn btn-outline-success"  onClick={fetchRentData}>Rent History</button>
   
    </div>
      <Table striped bordered hover variant="wh">
        <thead>
          <tr>
            <th>NO</th>
            {/* <th>Book Logo</th> */}
            <th>ProductName</th>
            <th>Price</th>
            <th>productISBN</th>
            <th>Date </th>
            <th>Time</th>

            {/* Add more table headers as needed */}
          </tr>
        </thead>
        <tbody>
          { showMethodtbuy &&   buyHistory.map((item, index) => (
            <tr key={index}>
              <td>{index + 1}</td>
              {/* <td>{item.imagePpath}</td> */}
              <td>{item.productName}</td>
              <td>{item.productPrice}</td>
              <td>{item.productISBN}</td>
              <td>{item.date}</td>
              <td>{item.time}</td>

              {/* Render other item details as needed */}
            </tr>
          ))}
        </tbody>
        <tbody>
          { showMethodrent &&   rentHistory.map((item, index) => (
            <tr key={index}>
              <td>{index + 1}</td>
              {/* <td>{item.imagePpath}</td> */}
              <td>{item.productName}</td>
              <td>{item.productPrice}</td>
              <td>{item.productISBN}</td>
              <td>{item.date}</td>
              <td>{item.time}</td>

              {/* Render other item details as needed */}
            </tr>
          ))}
        </tbody>
      </Table>
      
    </div>
  );
};
export default History;
