import React from 'react';

const Demo2 = (props) => {
  const { array } = props;
  console.log(array);
  return (
    <div>
        <h1> In Demo2 </h1>
      {array.map((item, index) => (
        <div key={index} style={{ display: "flex", alignItems: "center", marginLeft: "10cm" }}>
          <h1>{item.name} </h1>
          <span style={{ marginLeft: "1cm" }}>
            <input style={{ transform: 'scale(1.5)' }} type="checkbox" 
                          checked={item.value}
                          readOnly 
            />
          </span>
        </div>
      ))}
    </div>
  );
};

export default Demo2;
