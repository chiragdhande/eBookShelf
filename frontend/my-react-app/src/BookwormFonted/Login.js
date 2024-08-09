import React, { useState } from "react";
import { Card, CardBody } from "react-bootstrap";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import { adduser } from "../Redux/Actions/Todos";
import { connect } from "react-redux";

const Login = ({adduser}) => {
  const [Customer, SetCustomer] = useState({ email: '', password: '' });
  const [UserCredential, SetUserCredential] = useState({ jwtToken: "", username: "", userId: "" });

  const handleSubmit = async (event) => {
        
    event.preventDefault();
      console.log(Customer);
      console.log("*****");
    try {
      const response = await fetch("http://localhost:8080/auth/login", {
        method: 'POST',
        body: JSON.stringify(Customer), // Send Customer details in the request body
        headers: {
          'Content-Type': 'application/json'
        }
      });

      if (!response.ok) {
        throw new Error("User details not found");
      } else {
        const data = await response.json();
        console.log(data);
        SetUserCredential({ ...UserCredential, ...data });
        adduser({userId: data.userId});
        localStorage.setItem('token',data.jwtToken)
        SetCustomer(
            {
              email:'',
              password:''
            }
        )
      }
    } catch (error) {
      console.error("Fetch error:", error);
    }
     

    
   
  };

  return (
    <div style={{ display: 'flex', justifyContent: 'center', padding: '0 400px ' ,  }}>
    <Card style={{  maxWidth: '400px', width: '200%' , marginTop:'4cm' }}>
        <CardBody >
          <Form   onSubmit={handleSubmit}>
            <Form.Group className="mb-3" controlId="formBasicEmail">
              <Form.Label>Email address</Form.Label>
              <Form.Control
                type="text"
                placeholder="Enter email"
                value={Customer.email}
                onChange={(event) =>
                  SetCustomer({ ...Customer, email: event.target.value })
                }
              />
              <Form.Text className="text-muted">
                We'll never share your email with anyone else.
              </Form.Text>
            </Form.Group>
            
            <Form.Group className="mb-3" controlId="formBasicPassword">
              <Form.Label>Password</Form.Label>
              <Form.Control
                type="password"
                placeholder="Password"
                value={Customer.password}
                onChange={(event) =>
                  SetCustomer({ ...Customer, password: event.target.value })
                }
              />
            </Form.Group>
            
            <Form.Group className="mb-3" controlId="formBasicCheckbox">
              <Form.Check type="checkbox" label="Check me out" />
            </Form.Group>
            
            <Button style={{marginLeft:'3.5cm'}} variant="primary" type="submit">
              Submit
            </Button>
          </Form>
        </CardBody>
      </Card>
    </div>
  );
};
 
const mapStateToProps=(state)=>({})
const mapDispatchToProps = (dispatch) => ({
  adduser:(user)=> (dispatch(adduser(user)))
})
export default connect(mapStateToProps, mapDispatchToProps) (Login);
