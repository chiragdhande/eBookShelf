import React, { useState } from 'react';
import {
  MDBBtn,
  MDBContainer,
  MDBRow,
  MDBCol,
  MDBCard,
  MDBCardBody,
  MDBInput,
  MDBIcon,
  MDBCheckbox
}
from 'mdb-react-ui-kit';

import { Button } from 'react-bootstrap';

function Logindemo() {

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
        
        console.log(data.cardId);
        sessionStorage.setItem('cartId',data.cardId);
        sessionStorage.setItem('token',data.jwtToken);
        sessionStorage.setItem('selfId',data.myshelfId);
        sessionStorage.setItem("userId",data.userId);
        SetCustomer(
            {
              email:'',
              password:''
            }

        )
        window.location.reload();
      }
    } catch (error) {
      console.error("Fetch error:", error);
    }
     

    
   
  };
return (
    <MDBContainer fluid>

      <MDBRow className='d-flex justify-content-center align-items-center h-100'>
        <MDBCol col='12'>

          <MDBCard className='bg-white my-5 mx-auto' style={{borderRadius: '1rem', maxWidth: '500px'}}>
            <MDBCardBody className='p-5 w-100 d-flex flex-column'>

              <h2 className="fw-bold mb-2 text-center">Sign in</h2>
              <p className="text-white-50 mb-3">Please enter your login and password!</p>

              <MDBInput wrapperClass='mb-4 w-100'  placeholder="Enter email"  value={Customer.email} label='Email address' id='formControlLg' type='email' size="lg"  onChange={(event) =>
                  SetCustomer({ ...Customer, email: event.target.value })
                } />
              <MDBInput wrapperClass='mb-4 w-100' label='Password' id='formControlLg' type='password' size="lg" 
                placeholder="Password"
                value={Customer.password}
                onChange={(event) =>
                  SetCustomer({ ...Customer, password: event.target.value })
                } />

              <MDBCheckbox name='flexCheck' id='flexCheckDefault' className='mb-4' label='Remember password' />

              

              <Button size='lg'
                className='mb-4 w-100 gradient-custom-4'
                onClick={handleSubmit}>
                
                Login
              </Button>
                 
              <a href={`/forgetpass`}>Forget password</a>
              <a href='/register'>Register</a>

              <hr className="my-4" />

              <MDBBtn className="mb-2 w-100" size="lg" style={{backgroundColor: '#dd4b39'}}>
                <MDBIcon fab icon="google" className="mx-2"/>
                Sign in with google
              </MDBBtn>

              <MDBBtn className="mb-4 w-100" size="lg" style={{backgroundColor: '#3b5998'}}>
                <MDBIcon fab icon="facebook-f" className="mx-2"/>
                Sign in with facebook
              </MDBBtn>

            </MDBCardBody>
          </MDBCard>

        </MDBCol>
      </MDBRow>

    </MDBContainer>
  );
}


export default  Logindemo;