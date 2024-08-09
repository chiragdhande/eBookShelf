import React, { useState } from 'react';
import Demo2 from './Demo2';

const Demo = () => {
  const [array, setArray] = useState([
    { name: "Mayur", value: false },
    { name: "Piyush", value: false },
    { name: "Rajesh", value: false },
    { name: "Kamesh", value: false },
  ]);

  const handlechange = (index) => {
    // Create a copy of the array
    const newArray = [...array];
    // Toggle the value of the clicked checkbox
    newArray[index].value = !newArray[index].value;
    // Update the state with the new array
    setArray(newArray);
  };

  return (
    <div>
      {array.map((item, index) => (
        <div key={index} style={{ display: "flex", alignItems: "center", marginLeft: "10cm" }}>
          <h1>{item.name}</h1>
          <span style={{ marginLeft: "1cm" }}>
            <input onChange={() => handlechange(index)} style={{ transform: 'scale(1.5)' }} type="checkbox" />
          </span>
        </div>
      ))}
      <br />
      <hr />
      <Demo2 array={array} />
    </div>
  );
};

export default Demo;
