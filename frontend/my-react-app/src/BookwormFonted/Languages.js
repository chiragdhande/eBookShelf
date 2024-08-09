import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { Col, Row } from "react-bootstrap";
import Card from "react-bootstrap/Card";
import { Link } from "react-router-dom";

const Language = () => {
  const { typeId } = useParams();

  console.log(typeId);
  const [languages, setlanguages] = useState([]);
  useEffect(() => {
    const fetchlanguages = async () => {
      try {
       
        const languageResponse = await fetch(
          `http://localhost:8080/api/languageMaster/getlanguagebytypeid/${typeId}`
       
        );
        if (!languageResponse.ok) {
          throw new Error(`Http error! status: ${languageResponse.status}`);
        }
        const data = await languageResponse.json();
        setlanguages(data);
        console.log(data);
      } catch (error) {
        console.log("fetch Error:", error);
      }
    };
    fetchlanguages();
  }, []);

  return (
    <Row>
    <h1>
  Languages
</h1>

  {languages.map((cat) => (
    <Col>
      <Link to={"/ProductByid/"+ cat.languageId}>
        <Card border='info' style={{ width: "18rem" }}>
          <Card.Header>{cat.categoryName}</Card.Header>
          <Card.Body>
            <Card.Img src={cat.images}></Card.Img> 
            <Card.Title></Card.Title>
            <Card.Text></Card.Text>
          </Card.Body>
        </Card>
      </Link>
    </Col>
  ))}
</Row>
    
      
   
     
  );
};
export default Language;

