import { useEffect, useState } from "react";
import { Card, Col, Row } from "react-bootstrap";

const Authors = () => {
  const [Authors, setAuthoers] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const typeResponse = await fetch("http://localhost:8080/api/author");

        if (!typeResponse.ok) {
          throw new Error(`HTTP error! Status: ${typeResponse.status}`);
        }

        const data = await typeResponse.json();
        setAuthoers(data);
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
        <h1>Authors</h1>
        {Authors.map((author) => (
          <Col >
            <Card border="info" style={{ width: "18rem" }}>
              <Card.Body style={{backgroundColor:"aquamarine"}}>
                <div style={{ display: "flex", justifyContent: "center" }}>
                  <img
                    src={author.pdfurl}
                    alt="Mike"
                    style={{ width: "150px", height: "200px"}}
                  />
                </div>
                <Card.Title> Author name = {author.authorname}</Card.Title>
                <Card.Text> Royaltie charges = {author.authorcharges}</Card.Text>
                <a href={`/authorroylties/${author.authorid}/${author.authorname}`}>Show Royalty</a>
              </Card.Body>
            </Card>
          </Col>
        ))}
      </Row>
    </div>
  );
};
export default Authors;
