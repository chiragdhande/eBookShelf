import { useState } from 'react';

const ContactUs = () => {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    subject: '',
    message: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // Perform actions here with formData (send form data, etc.)
    console.log(formData);
    // Reset form after submission
    setFormData({ name: '', email: '', subject: '', message: '' });
  };

  return (
    <div style={{backgroundColor:"lightblue"}}>
      <section className="mb-4">
        <h2 className="h1-responsive font-weight-bold text-center my-4">Contact us</h2>
        <p className="text-center w-responsive mx-auto mb-5">
          Do you have any questions? Please do not hesitate to contact us directly. Our team will come back to you within
          a matter of hours to help you.
        </p>

        <div className="row">
          <div className="col-md-9 mb-md-0 mb-5">
            <form onSubmit={handleSubmit}>
              <div className="row">
                <div className="col-md-6">
                  <div className="md-form mb-0">
                  <label htmlFor="name" className="">
                      Your name
                    </label>
                    <input 
                      
                      type="text"
                      id="name"
                      name="name"
                      className="form-control"
                      value={formData.name}
                      onChange={handleChange}
                      placeholder='Your name'
                    />
                    <label htmlFor="name" className="">
                     
                    </label>
                  </div>
                </div>

                <div className="col-md-6">
                  <div className="md-form mb-0">
                  <label htmlFor="email" className="">
                      Your email
                    </label>
                    <input
                      type="text"
                      id="email"
                      name="email"
                      className="form-control"
                      value={formData.email}
                      onChange={handleChange}
                      placeholder=' Your email'
                    />
                    <label htmlFor="email" className="">
                      
                    </label>
                  </div>
                </div>
              </div>

              <div className="row">
                <div className="col-md-12">
                  <div className="md-form mb-0">
                  <label htmlFor="subject" className="">
                     subject
                      </label>
                    <input
                      type="text"
                      id="subject"
                      name="subject"
                      className="form-control"
                      value={formData.subject}
                      onChange={handleChange}
                      placeholder='Subject'
                    />
                    <label htmlFor="subject" className="">
                      
                    </label>
                  </div>
                </div>
              </div>

              <div className="row">
                <div className="col-md-12">
                  <div className="md-form">
                  <label htmlFor="message">Your message</label>
                    <textarea
                      type="text"
                      id="message"
                      name="message"
                      rows="2"
                      className="form-control md-textarea"
                      value={formData.message}
                      onChange={handleChange}
                      placeholder='message'
                    ></textarea>
                    <label htmlFor="message"></label>
                  </div>
                </div>
              </div>

              <div className="text-center text-md-left">
                <button className="btn btn-primary" type="submit">
                  Send
                </button>
              </div>
              <div className="status"></div>
            </form>
          </div>

          <div className="col-md-3 text-center">
            <ul className="list-unstyled mb-0">
              <li>
                <i className="fas fa-map-marker-alt fa-2x"></i>
                <p>Near Mangalam traders, Gujrat Colony, Kothrud,Pune, Maharashtra 411038</p>
              </li>

              <li>
                <i className="fas fa-phone mt-4 fa-2x"></i>
                <p>+91 9511796787</p>
              </li>

              <li>
                <i className="fas fa-envelope mt-4 fa-2x"></i>
                <p>saurabhsakharkar26@gmail.com</p>
              </li>
            </ul>
          </div>
        </div>
      </section>
    </div>
  );
};

export default ContactUs;
