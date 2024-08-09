import { useEffect, useState } from "react";
import { Button, Card, Col, Container, Row } from "react-bootstrap";





const TypeOfProduct = () => {
  const [type, setType] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
         const token =localStorage.getItem("token")
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
    <div>
      <h1>List of Product Types</h1>
     
        {type.map((item, index) => (
          <Container>
          <Row>
          <Col md={4}>
            <Card className='card-container'>
              <a href="/Language">
                <Card.Img className="Cardimg" variant="top" src="/Images/EBOOKS.jpeg" />
              </a>
              <Card.Body>
                <Card.Title>{item.typeDesc}</Card.Title>
                <Button href={`/typelanguage/${item.typeId}`}>Language</Button>
                <br />
              </Card.Body>
            </Card>
          </Col>
        </Row>
      </Container>
    
        ))}
      
      </div>
  );
      }  

export default TypeOfProduct;
