import { useState } from "react";
import { Card, CardBody } from "react-bootstrap";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import { connect } from "react-redux";
import { addtodo } from "../Redux/Actions/Todos";
const AddTodo=({addTodo})=>
{
    const[User,SetUser]=useState({Email_address:'', Password:''})
      
   const handleSubmit=(event)=>{
        event.preventDefault();
          console.log("mayur");
         addTodo(User)
        console.log(User);
        SetUser(
            {
                Email_address:'', 
                Password:''
            }
           
        )

   }

    return(
             <div>
                <p>In AddTodo</p>
                <Card>
                    <CardBody>

                
                <Form onSubmit={handleSubmit}>
      <Form.Group className="mb-3" controlId="formBasicEmail">
        <Form.Label>Email address</Form.Label>
        <Form.Control type="email" placeholder="Enter email"
          value={User.Email_address}
          onChange={event=>SetUser({ ...User,Email_address:event.target.value})}
         />
         
        <Form.Text className="text-muted">

          We'll never share your email with anyone else.
        </Form.Text>
      </Form.Group>

      <Form.Group className="mb-3" controlId="formBasicPassword">
        <Form.Label>Password</Form.Label>
        <Form.Control type="password" placeholder="Password" 
          value={User.Password}
          onChange={event=>SetUser({ ...User,Password:event.target.value})}
        />
      </Form.Group>
      <Form.Group className="mb-3" controlId="formBasicCheckbox">
        <Form.Check type="checkbox" label="Check me out" />
      </Form.Group>
      <Button variant="primary" type="submit">
        Submit
      </Button>
    </Form>
    </CardBody>
                </Card>
             </div> 
        )
}
const mapStateToProps = (state) => ({});

const mapDispatchToProps = (dispatch) => ({
    addTodo:(user)=> (dispatch(addtodo(user)))
})

export default connect(mapStateToProps, mapDispatchToProps)(AddTodo);
