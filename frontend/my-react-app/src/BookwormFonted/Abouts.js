const AboutUs = () => {
  return (
    <div>
      <br></br>
      <div style={{ backgroundColor: "whitesmoke" }} className="about-section">
        <h1>About Us</h1>
        ● Technologies :- Java,JavaScript
       <br></br>
        
          ● FrameWork and Libraries used:- Spring Boot, Bootstrap, React JS.
          <br></br>
        ● Description:
      
          ➢ Led the development of a virtual bookshop platform, enabling users to buy, store, and read book.{" "}
        
          {" "}
          <br></br>
          ➢ Conceptualized and finalized the application's concept through
          effective brainstorming sessions.{" "}
          <br></br>
        
          ➢ Achieved seamless integration of various technologies to deliver a
          user-friendly and feature-rich platform.
        
      </div>

      <h2 style={{ textAlign: "", backgroundColor: "" }}>Our Team</h2>
      <div className="row">
        <div className="column">
          <div style={{ backgroundColor: "whitesmoke" }} className="card">
            <div style={{ display: "flex", justifyContent: "center" }}>
              <img
                src={"/Owner/Saurabh.jpeg"}
                alt="Mike"
                style={{ width: "150px" }}
              />
            </div>
            <div className="container">
              <h2>Saurabh Sakharkar</h2>
              <p>
                Recent graduate and aspiring Full-Stack Developer eager to contribute technical skills and passion for innovation to a dynamic organization. Committed to continuous learning and embracing new technologies to drive impactful solutions.
              </p>
              <p>saurabhsakharkar26@gmail.com</p>
              <p>Contact NO : 9511796787</p>
            </div>
          </div>
        </div>

        {/* Repeat the structure for other team members */}
        {/* For example: */}
      </div>
      <div className="row">
        <div className="column">
          <div style={{ backgroundColor: "whitesmoke" }} className="card">
            <div style={{ display: "flex", justifyContent: "center" }}>
              <img
                src={"/Owner/Chirag_Dhande.JPG"}
                alt="Mike"
                style={{ width: "150px" }}
              />
            </div>
            <div className="container">
              <h2>Chirag Dhande</h2>
              <p>
                Recent graduate and aspiring Full-Stack Developer eager to
                contribute technical skills and passion for innovation to a
                dynamic organization. Committed to continuous learning and
                embracing new technologies to drive impactful solutions.
              </p>
              <p>dhandec2@gmail.com</p>
              <p>Contact NO :  9561687618</p>
            </div>
          </div>
        </div>

        <div className="row">
        <div className="column">
          <div style={{ backgroundColor: "whitesmoke" }} className="card">
            <div style={{ display: "flex", justifyContent: "center" }}>
              <img
                src={"/Owner/Gajanan.jpg"}
                alt="Mike"
                style={{ width: "150px" }}
              />
            </div>
            <div className="container">
              <h2>Gajanan Birajdar</h2>
              <p>
                Recent graduate and aspiring Full-Stack Developer eager to
                contribute technical skills and passion for innovation to a
                dynamic organization. Committed to continuous learning and
                embracing new technologies to drive impactful solutions.
              </p>
              <p>gajananbirajdar3240@gmail.com</p>
              <p>Contact NO : 84469 90034</p>
            </div>
          </div>
        </div>

        {/* Repeat the structure for other team members */}
        {/* For example: */}
      </div>

      <div className="row">
        <div className="column">
          <div style={{ backgroundColor: "whitesmoke" }} className="card">
            <div style={{ display: "flex", justifyContent: "center" }}>
              <img
                src={"/Owner/Shubhankar.jpeg"}
                alt="Mike"
                style={{ width: "150px" }}
              />
            </div>
            <div className="container">
              <h2>Shubhankar Gebad</h2>
              <p>
                Recent graduate and aspiring Full-Stack Developer eager to
                contribute technical skills and passion for innovation to a
                dynamic organization. Committed to continuous learning and
                embracing new technologies to drive impactful solutions.
              </p>
              <p>shubhankargebad108@gmail.com</p>
              <p>Contact NO : 8275728760</p>
            </div>
          </div>
        </div>

        {/* Repeat the structure for other team members */}
        {/* For example: */}
      </div>
      </div>
    </div>
    
  );
};

export default AboutUs;
