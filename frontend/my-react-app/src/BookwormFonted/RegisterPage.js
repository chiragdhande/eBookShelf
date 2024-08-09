import {
    MDBBtn,
    MDBContainer,
    MDBCard,
    MDBCardBody,
    MDBInput,
   
    MDBRadio,
  } from "mdb-react-ui-kit";
import { useState } from "react";
const RegisterPage=()=>
{
 
    const[Customer,SetCustomer]=useState({});
     const [flag,Setflag]=useState(false);
    const [role,SetRole] = useState('user');
    const [companyid,Setcompanyid] = useState();

const onverify=() =>
{
   console.log(companyid ,role);
  if((role==="admin" && companyid === "12345"))
     window.alert("ID  match .......... ");
   else 
   window.alert("ID does not match. Please fill in the correct ID.");
}

 const handleChange = (event) => {
  const name = event.target.name;
  const value = event.target.value;

     if(value==="admin")
     {
        Setflag(true);
        SetRole(value);
     }
     else if(value==="user")
     {
      Setflag(false)
      SetRole(value);
     }
     if(name==="companyid")
     {
        Setcompanyid(value)
        console.log(value);
     }
   


  SetCustomer((user) => ({ ...user, [name]: value }));
}

 const handleSubmit= async (event)=>{
    event.preventDefault();
    console.log(Customer);
    console.log("*****");
    try{
           const response=  await fetch("http://localhost:8080/auth/create-user",{
            method:"POST",
            body: JSON.stringify(Customer), // Send Customer details in the request body
            headers: {
              'Content-Type': 'application/json'
            } })
            if (!response.ok) {
                throw new Error("User details not found");
              } else {
                console.log("OK");
                window.alert("sucessfully register...........");
                window.location.reload();
              }
    } 
    catch(error) {
        console.error("Fetch error:", error);
      }

 }
     
   return(
    <MDBContainer
    fluid
    className='d-flex align-items-center justify-content-center bg-image'
    style={{
      backgroundImage:
        "url(https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp)",
    }}
  >
    <div className='mask gradient-custom-3'></div>
    <MDBCard className='m-5' style={{ maxWidth: "600px" }}>
      <MDBCardBody className='px-5'>
        <h2 className='text-uppercase text-center mb-5'>Create an account</h2>


        <div style={{ display: 'flex', alignItems: 'center' }}>
  <span style={{ marginRight: '20px' }}>Role-</span>
  <MDBRadio
    name='role'
    value='user'
    label='User'
    style={{ textAlign: 'center' }}
    onChange={handleChange}
    inline
  />
  <MDBRadio
    name='role'
    value='admin'
    label='admin'
    style={{ textAlign: 'center' }}
    onChange={handleChange}
    inline
  />
</div>
   <p></p>
   <p></p>
     {/* {
       flag && 
       <>
          <MDBInput
          wrapperClass='mb-4'
          label='Company id'
          size='lg'
          id='form1'
          type='text'
          name='companyid'
          placeholder="company id"
          onChange={handleChange}
        />
       
        <button style={{ marginBottom: '10px' }} onClick={onverify}> Verify</button>
        
       </>


     } */}
        <p></p>
        <MDBInput
          wrapperClass='mb-4'
          label='Your Name'
          size='lg'
          id='form1'
          type='text'
          name='customerName'
          placeholder="Full Name"
          onChange={handleChange}
        />
        <MDBInput
          wrapperClass='mb-4'
          label='Your Email'
          size='lg'
          id='form2'
          type='text'
          name='email'
          placeholder="email"
          onChange={handleChange}
        />
        <MDBInput
          wrapperClass='mb-4'
          label='Username'
          size='lg'
          id='form3'
          type='text'
          name='customerEmail'
          placeholder="username"
          onChange={handleChange}
        />
        <MDBInput
          wrapperClass='mb-4'
          label='Password'
          size='lg'
          id='form4'
          type='password'
          name='password'
          placeholder="password"
          onChange={handleChange}
        />
        <MDBInput
          wrapperClass='mb-4'
          label='Phone'
          size='lg'
          id='form5'
          type='number'
          name='contactNo'
          placeholder="ContactNo"
          onChange={handleChange}
        />
        <p>Gender</p>
        <MDBRadio
          name='gender'
          value='Male'
          label='Male'
          onChange={handleChange}
          inline
        />
        <MDBRadio
          name='gender'
          value='F'
          label='Female'
          onChange={handleChange}
          inline
        />
       <br></br>
       <br></br>
       {/* <p>Premium</p>
<MDBRadio
    name='primium'
    value='Yes'
    label='Premium'
    onChange={handleChange}
    // Reflect the state of isPremium
    inline
/>
<MDBRadio
    name='primium'
    value='No'
    label='Normal'
    onChange={handleChange}
    // Reflect the state of isPremium
    inline
/>
       <br></br> */}
       <br></br>
        <MDBInput
          wrapperClass='mb-4'
          label='Address'
          size='lg'
          id='form7'
          type='text'
          name='address'
          placeholder="Address"
          onChange={handleChange}
        />
      
        <MDBInput
          wrapperClass='mb-4'
          label='City'
          size='lg'
          id='form9'
          type='text'
          name='city'
          placeholder="city"
          onChange={handleChange}
        />
        <MDBInput
          wrapperClass='mb-4'
          label='Pincode'
          size='lg'
          id='form10'
          type='number'
          name='pincode'
          placeholder="pincode"
          onChange={handleChange}
        />
        
        <MDBBtn
          className='mb-4 w-100 gradient-custom-4'
          size='lg'
          onClick={handleSubmit}
        >
          Register
        </MDBBtn>
      </MDBCardBody>
    </MDBCard>
  </MDBContainer>

   );

}
export default RegisterPage;

