import { useEffect, useState } from "react";
import { jwtDecode } from "jwt-decode";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import NavDropdown from "react-bootstrap/NavDropdown";
import { useCart } from "../Contextapi/CartProvider";
function Header() {
  const [isLoggedIn, setIsLoggedIn] = useState(sessionStorage.getItem("token"));
  const [role, Setrole] = useState();
  const { cartCount } = useCart();
  useEffect(() => {
    const token = sessionStorage.getItem("token");
    if (token) {
      const decoded = jwtDecode(token);
      console.log(decoded);
      const Role = decoded.role;
      Setrole(Role);
    }
  }, []);

  useEffect(() => {
    console.log(cartCount);
  }, [cartCount]);

  const handleLogout = () => {
    // Perform logout actions
    sessionStorage.removeItem("token");
    // Update state to reflect logout
    window.location.reload();
    setIsLoggedIn(false);
  };

  return (
    <Navbar
      style={{ width: "36cm", backgroundColor: "white" }}
      expand="lg"
    >
      <Container>
        
        <Navbar.Brand href="">Ebookshelf </Navbar.Brand>

        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link href="/">
              <span style={{ fontWeight: "bolder" }}>Home</span>
            </Nav.Link>
            <Nav.Link href="/Aboutus">
              <span style={{ fontWeight: "bolder" }}>AboutUs</span>
            </Nav.Link>
            <Nav.Link href="/contactus">
              <span style={{ fontWeight: "bolder" }}>ContactUs</span>
            </Nav.Link>
            {isLoggedIn && (
              <>
                <Nav.Link href="/Myshelf"> <span style={{ fontWeight: "bolder" }}>My_Shelf</span></Nav.Link>

                <Nav.Link href="/history"><span style={{ fontWeight: "bolder" }}>History</span></Nav.Link>
              </>
            )}
          </Nav>
          <Nav>
            {role === "admin" && (
              <div style={{ marginRight: "20px" }}>
                <NavDropdown title="Admin Part" id="basic-nav-dropdown">
                  <NavDropdown.Item href="/authors">
                    Authors
                  </NavDropdown.Item>
                  <NavDropdown.Item href="/publisher">
                   Publisher
                  </NavDropdown.Item>
                  <NavDropdown.Divider />
                  <NavDropdown.Item href="/buybackup">
                    Backup of Lented Book
                  </NavDropdown.Item>
                  
                  <NavDropdown.Item href="/rentbackup">
                  Backup of Rented Book
                  </NavDropdown.Item>
                </NavDropdown>
              </div>
            )}
          </Nav>
          <Nav>
            {isLoggedIn && (
              <>
                <a
                  href="/cart"
                  className="btn-primary position-relative"
                  style={{
                    marginTop: "13px",
                    marginRight: "10px",
                    fontSize: "19px",
                  }}
                >
                  <i className="fas fa-shopping-cart"></i>
                  <span
                    className="position-absolute top-0 start-100 translate-middle badge rounded-pill"
                    style={{
                      backgroundColor: "rgb(209, 27, 27)",
                      fontSize: "10px",
                    }}
                  >
                    {cartCount}
                    <span className="visually-hidden">unread messages</span>
                  </span>
                </a>

                {/* <div className="Nav">
                  <li class="nav-item me-3 me-lg-0">
                    <a className="cart" href="/cart">
                      <i class="fas fa-shopping-cart">
                        <span className="badge">{cartCount}</span>
                      </i>
                    </a>
                  </li>
                </div> */}
                <NavDropdown
                  class="fas fa-user mx-1"
                  title="Profile"
                  id="basic-nav-dropdown"
                >
                  <NavDropdown.Item
                    href="/profile"
                    className="nav-link  text-black"
                  >
                    <i class="fas fa-user mx-1"></i>My Account
                  </NavDropdown.Item>
                  <NavDropdown.Item
                    href="/register"
                    className="nav-link text-black"
                    style={{ display: "flex", justifyContent: "normal" }}
                  >
                    <span style={{ fontWeight: "revert" }}>Register</span>
                  </NavDropdown.Item>
                </NavDropdown>
              </>
              //  <Nav.Link href="/profile">Profile</Nav.Link>
            )}
          </Nav>
          <Nav>
            {isLoggedIn ? (
              <Nav.Link onClick={handleLogout}><span style={{ fontWeight: "bolder" }}>Logout</span></Nav.Link>
            ) : (
              <Nav.Link href="/login"><span style={{ fontWeight: "bolder" }}>Login</span></Nav.Link>
            )}
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default Header;
