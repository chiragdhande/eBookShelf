import { useEffect, useState } from "react";
import { Card, Col, Row } from "react-bootstrap";

const Publisher = () => {
  const [Publishers, setpublisher] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const typeResponse = await fetch("http://localhost:8080/api/Publisher");

        if (!typeResponse.ok) {
          throw new Error(`HTTP error! Status: ${typeResponse.status}`);
        }

        const data = await typeResponse.json();
        setpublisher(data);
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

      <Row>
        <h1>Publisher</h1>
        {Publishers.map((author) => (
          <Col>
            <Card border="info" style={{ width: "18rem" }}>
              <Card.Body>
                <div style={{ display: "flex", justifyContent: "center" }}>
                  <img
                    src={author.pdfurl}
                    alt="Mike"
                    style={{ width: "300px" ,height:"200px"}}
                  />
                </div>
                <Card.Title> Publisher name = {author.publisherName}</Card.Title>
                <Card.Text> Royaltie charges = {author.publishercharges}</Card.Text>
                <a href={`/publisherroylties/${author.publisherid}/${author.publisherName}`}>Show Royalty</a>
              </Card.Body>
            </Card>
          </Col>
        ))}
      </Row>
    </div>
  );
};
export default Publisher;
