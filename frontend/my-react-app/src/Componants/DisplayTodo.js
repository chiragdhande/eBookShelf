import React from "react";
import { Card } from "react-bootstrap";
import { connect } from "react-redux";

const DisplayTodo = ({ User }) => {
  console.log(User);
  if (!User || !User.user || !User.user.userId) {
    return <p>Loading...</p>; // Or any other UI indicating data is loading
  }

  return (
    <div>
      <p>In DisplayTodo</p>
      <Card>
        <Card.Body>
            
                 
          <h1>{ User.user.userId}</h1>
         
         
      
        </Card.Body>
      </Card>
    </div>
  );
};

const mapStateToProps = (state) => {
  return { User: state.Todoreducer }; 
};

const mapDispatchToProps = (dispatch) => ({});

export default connect(mapStateToProps, mapDispatchToProps)(DisplayTodo);
