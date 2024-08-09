import { useEffect, useState } from "react";
import { Table } from "react-bootstrap";


const BackupBuy = () => {
  const [BackupBuys, setBackbuy] = useState([]);
 
  useEffect(() => {
    const fetchData = async () => {
      try {
        const AuthorRoyalties = await fetch(`http://localhost:8080/api/backup/buy`);

        if (!AuthorRoyalties.ok) {
          throw new Error(`HTTP error! Status: ${AuthorRoyalties.status}`);
        }

        const data = await AuthorRoyalties.json();
        setBackbuy(data);
        console.log(data);
        
      } catch (error) {
        console.error("Fetch error:", error);
        // Handle error (e.g., set a state for error message)
      }
    };

    fetchData();
  }, []); // Ensure to include id in the dependency array for useEffect

  return (
    <div>
     <h3>Backup Of All Lented Book</h3>
      <Table striped bordered hover variant="wh">
        <thead>
          <tr>
            <th>Index</th>
            <th>Product name</th>
            <th>Product price</th>
            <th>User Id</th>
            <th>Customer Name</th>
            <th>Author Name</th>
            <th>Publisher Name</th>
            
            <th>Issue Date</th>
            {/* Add more table headers as needed */}
          </tr>
        </thead>
        <tbody>
          {BackupBuys.map((item, index) => (
            <tr key={index}>
              <td>{index + 1}</td>
              <td>{item.productname}</td>
              <td>{item.productprice}</td>
              <td>{item.userid}</td>
              <td>{item.username}</td>
              <td>{item.authorname}</td>
              <td>{item.publishername}</td>
              <td>{item.date}</td>
             
              {/* Render other item details as needed */}
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
};

export default BackupBuy;
