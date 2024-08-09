import React from "react";
import { MDBFooter, MDBContainer, MDBIcon, MDBBtn } from "mdb-react-ui-kit";
import '@fortawesome/fontawesome-free/css/all.min.css'
import "../Assets/Footer.css";

export default function Footer() {
  return (
    <MDBFooter className='bg-light text-center text-white footer'>
      <MDBContainer className='p-4 pb-0'>
        <section className='mb-4'>
          <MDBBtn
            floating
            className='m-1'
            style={{ backgroundColor: "#3b5998" }}
            href='https://www.facebook.com/dhandechirag?sfnsn=wiwspwa&mibextid=RUbZ1f'
            role='button'
          >
            <MDBIcon fab icon='facebook-f' />
          </MDBBtn>

          <MDBBtn
            floating
            className='m-1'
            style={{ backgroundColor: "#ac2bac" }}
            href='https://www.instagram.com/chiragdhande_?utm_source=ig_web_button_share_sheet&igsh=ZDNlZDc0MzIxNw=='
            role='button'
          >
            <MDBIcon fab icon='instagram' />
          </MDBBtn>

          <MDBBtn
            floating
            className='m-1'
            style={{ backgroundColor: "#0082ca" }}
            href='https://www.linkedin.com/in/chirag-dhande-09561a212'
            role='button'
          >
            <MDBIcon fab icon='linkedin-in' />
          </MDBBtn>

          <MDBBtn
            floating
            className='m-1'
            style={{ backgroundColor: "#333333" }}
            href='https://github.com/saurabhrs26/Ebookshelf'
            role='button'
          >
            <MDBIcon fab icon='github' />
          </MDBBtn>
        </section>
      </MDBContainer>

      <div
        className='text-center p-3'
        style={{ backgroundColor: "rgba(0, 0, 0, 0.1)" }}
      >
        © 2024 Copyright:
        <a className='text-white' href='#'>
          Ebookshelf
        </a>
      </div>
    </MDBFooter>
  );
}
