import { useEffect, useState } from "react";
import { Table } from "react-bootstrap";
import { useParams } from "react-router-dom";

const AuthorRoyalties = () => {
  const [Authorsroyalti, setAuthoerroyaties] = useState([]);
  const { id } = useParams();
  const{name} = useParams();
  useEffect(() => {
    const fetchData = async () => {
      try {
        const AuthorRoyalties = await fetch(`http://localhost:8080/api/Royalty/author/${id}`);

        if (!AuthorRoyalties.ok) {
          throw new Error(`HTTP error! Status: ${AuthorRoyalties.status}`);
        }

        const data = await AuthorRoyalties.json();
        setAuthoerroyaties(data);
        console.log(data);
        
      } catch (error) {
        console.error("Fetch error:", error);
        // Handle error (e.g., set a state for error message)
      }
    };

    fetchData();
  }, [id]); // Ensure to include id in the dependency array for useEffect

  return (
    <div>
      <h3>Royaltie of Author: {name}</h3>
      <Table striped bordered hover variant="wh">
        <thead>
          <tr>
            <th>Index</th>
            <th>Product name</th>
            <th>Product price</th>
            <th>Customer id</th>
            <th>Customer Name</th>
            <th>Royalty Amount</th>
            <th>Purchase type</th>
            {/* Add more table headers as needed */}
          </tr>
        </thead>
        <tbody>
          {Authorsroyalti.map((item, index) => (
            <tr key={index}>
              <td>{index + 1}</td>
              <td>{item.productName}</td>
              <td>{item.productprice}</td>
              <td>{item.customerID}</td>
              <td>{item.customerName}</td>
              <td>{item.amount}</td>
              <td>{item.type}</td>
              {/* Render other item details as needed */}
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
};

export default AuthorRoyalties;
