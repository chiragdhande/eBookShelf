import { useEffect, useState } from "react";
import { Table } from "react-bootstrap";

const UserRentShelf =()=>{
    const[shelf ,SetShelf]=useState([])

    useEffect(() => {
        const fetchData = async () => {
          try {
            const token = sessionStorage.getItem("token");
            const selfId  = sessionStorage.getItem("selfId");
              console.log(selfId);
      
            const products = await fetch(
              `http://localhost:8080/api/UserRentShelf/${selfId}`,
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
              SetShelf(data);
         
            }
          } catch (error) {
            console.log("fetch error", error);
          }
        };
    
        fetchData(); // Invoke the function to fetch data
      }, []); // Add languageId to the dependency array
    return(
        <div >
            <h3> Rent shelf</h3>
            <Table  striped bordered hover variant="">
        <thead>
          <tr>
          
            <th>NO</th>
            <th>Book Logo</th>
            <th>ProductName</th>
            <th>days left</th>
            <th>startdate</th>
            <th>Book pdf</th>
            
            
            
            {/* Add more table headers as needed */}
          </tr>
        </thead>
        <tbody>
          {shelf.map((item, index) => (
            <tr key={index}>
                
              <td>{index + 1}</td>
              <img src={item.imgpath} width="70" height="70" />
              <td>{item.productname}</td>
              <td>{item.days}</td>
              <td>{item.startdate}</td>
              <td><a
                  href={item.pdfUrl} // Set the correct PDF URL here
                  target="_blank" // Open in a new tab
                  className="btn btn-primary"
                >
                  Read
                </a></td>
             
              
              {/* Render other item details as needed */}
              
            </tr>
               
          ))}
        </tbody>
      </Table>
        </div>
    )
}
export default UserRentShelf;