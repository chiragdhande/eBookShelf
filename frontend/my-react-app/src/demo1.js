import React, { useState } from "react";
 // Import your CSS file
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import './Assets/product.css'

const YourComponent = () => {
  const array = [1, 2, 3, 4, 5, 6,7,9,10,1];
  const [counts, setCounts] = useState(Array(array.length).fill(0));

  // Function to handle increment and decrement for a specific card
  const handleIncrement = (index) => {
    const newCounts = [...counts];
    newCounts[index]++;
    setCounts(newCounts);
  };

  const handleDecrement = (index) => {
    const newCounts = [...counts];
    if (newCounts[index] > 0) {
      newCounts[index]--;
      setCounts(newCounts);
    }
  }
    return (
      <div className="products-grid">
        {array.map((item, index) => (
          <div className="product-card" key={index}>
            <Card style={{ width: "150%", maxWidth: "16rem", margin: "auto" }}>
              <Card.Img
                variant="top"
                src={"/product_img/project_img.jpg"}
                style={{
                  height: "auto",
                  width: "auto",
                  background: "red",
                  display: "block",
                  objectFit: "cover",
                }}
              />
              <Card.Body style={{ backgroundColor: "rgb(182, 215, 246)" }}>
                <Card.Title>Card Title</Card.Title>
                <Card.Text>
                  Count: {counts[index]} {/* Display count for this card */}
                </Card.Text>
                <Button variant="primary" onClick={() => handleIncrement(index)}>
                  Increment
                </Button>
                <Button variant="secondary" onClick={() => handleDecrement(index)}>
                  Decrement
                </Button>
              </Card.Body>
            </Card>
          </div>
        ))}
      </div>
    );
  };
  export default YourComponent