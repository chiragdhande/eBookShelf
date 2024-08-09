import React from "react";
import "./App.css";

import { Outlet } from "react-router-dom";
import Header from "./BookwormFonted/Header";

import Footer from "./BookwormFonted/Footer";


import { Container } from "react-bootstrap";

import { CartProvider } from "./Contextapi/CartProvider";
// Assuming YourComponent contains the card layout

function App() {
  return (
    <CartProvider>
    <div>
      <Container>
        <Header />
        <div className="App">
          <Outlet></Outlet>
        </div>
        <Footer />
      </Container>
    </div>
    </CartProvider>
  );
}

export default App;
