import { useEffect, useState } from "react";
import { Col, Row } from "react-bootstrap";
import Card from "react-bootstrap/Card";
import { Link } from "react-router-dom";

export default function Categories() {
    const [type, setType] = useState([]);

    useEffect(() => {
      const fetchData = async () => {
        try {
           
          const typeResponse = await fetch("http://localhost:8080/api/producttype");
  
          if (!typeResponse.ok) {
            throw new Error(`HTTP error! Status: ${typeResponse.status}`);
          }
  
          const data = await typeResponse.json();
            setType(data);
            console.log(data);
        } catch (error) {
          console.error("Fetch error:", error);
          // Handle error (e.g., set a state for error message)
        }
      };
  
      fetchData();
    }, []);
  
   

  return (
       
    <Row>
        <h1> Books Available</h1>
      {type.map((cat) => (
        <Col>
          <Link to={"/typelanguage/"+ cat.typeId}>
            <Card border='info' style={{ width: "18rem" }}>
              <Card.Header>{cat.categoryName}</Card.Header>
              <Card.Body>
                <Card.Img src={cat.image}></Card.Img> 
                <Card.Title></Card.Title>
                <Card.Text></Card.Text>
              </Card.Body>
            </Card>
          </Link>
        </Col>
      ))}
    </Row>
  );
}


