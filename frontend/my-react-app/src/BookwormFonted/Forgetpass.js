import { useState } from "react";

const Forgetpass = () => {
  const [userdetail, Setuserdetail] = useState({ username: '', password: '' });
  const [showPassword, setShowPassword] = useState(false);

  const handleUsernameChange = (event) => {
    Setuserdetail({ ...userdetail, username: event.target.value });
    setShowPassword(true); // Show password input when username is entered
  };

  const handleSubmit= async (event)=>{
    event.preventDefault();
      const response = await fetch("http://localhost:8080/auth/update",{
        method:"POST",
        body:JSON.stringify(userdetail),
        headers:{
            'Content-Type': 'application/json'
        }
        
      })
        console.log(response);
      
      if(response.status==200)
      {
        window.alert( "upadate Successfully")
      }
      else{
        window.alert( "Invalid Username")
      }
  }
     
  return (
    <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', height: '100vh' }}>
      <div className="card text-center" style={{ width: '300px', marginTop: '0cm' }}>
        <div className="card-header h5 text-white bg-primary">Password Reset</div>
        <div className="card-body px-5">
          <p className="card-text py-2">
            First enter your username
          </p>
          <div className="form-outline">
            <input
              type="text"
              className="form-control my-3"
              placeholder="Username"
              value={userdetail.username}
              onChange={handleUsernameChange}
            />
          </div>
          {showPassword && ( // Render password input only when showPassword is true
            <div className="form-outline">
              <input
                type="password"
                className="form-control my-3"
                placeholder="New Password"
                value={userdetail.password}
                onChange={(event) => Setuserdetail({ ...userdetail, password: event.target.value })}
              />
            </div>
          )}
          <a href="#" className="btn btn-primary w-100" onClick={handleSubmit}>
            Reset password
          </a>
          <div className="d-flex justify-content-between mt-4">
            <a href="#">
              Login
            </a>
            <a href="#">
              Register
            </a>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Forgetpass;
