import { useEffect, useState } from "react";
import {
  MDBCol,
  MDBContainer,
  MDBRow,
  MDBCard,
  MDBCardText,
  MDBCardBody,
  MDBCardImage,
  MDBBtn,
  MDBBreadcrumb,
  MDBBreadcrumbItem,
  MDBProgress,
  MDBProgressBar,
  MDBIcon,
  MDBListGroup,
  MDBListGroupItem,
} from "mdb-react-ui-kit";
const Profile = () => {
  const [Customer, SetCustomer] = useState();
  const [count, Setcount] = useState();
  useEffect(() => {
    const fetchData = async () => {
      try {
        const token = sessionStorage.getItem("token");
        const id = sessionStorage.getItem("userId");
        const selfId = sessionStorage.getItem("selfId");
        const detailresponse = await fetch(
          `http://localhost:8080/api/Customer/${id}`,
          {
            method: "GET",
            headers: {
              Authorization: `Bearer ${token}`,
              "Content-Type": "application/json",
            },
          }
        );

        if (!detailresponse.ok) {
          throw new Error(
            `Request failed with status: ${detailresponse.status}`
          );
        } else {
          const data = await detailresponse.json();
          console.log(data);
          SetCustomer(data);
        }
        const Countresponse = await fetch(
          `http://localhost:8080/api/Customer/count/${selfId}`,
          {
            method: "GET",
            headers: {
              Authorization: `Bearer ${token}`,
              "Content-Type": "application/json",
            },
          }
        );

        if (!Countresponse.ok) {
          throw new Error(
            `Request failed with status: ${Countresponse.status}`
          );
        } else {
          const data = await Countresponse.json();
          console.log(data);
          Setcount(data);
        }
      } catch (error) {
        console.log("fetch error", error);
      }
    };

    fetchData(); // Invoke the function to fetch data
  }, []); // Add lan

  return (
    <div>
      {Customer && (
        <section style={{ backgroundColor: "#eee" }}>
          <MDBContainer className="py-5">
            <MDBRow>
              <MDBCol lg="4">
                <MDBCard className="mb-4">
                  <MDBCardBody className="text-center">
                    <MDBCardImage
                      src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp"
                      alt="avatar"
                      className="rounded-circle"
                      style={{ width: "150px" }}
                      fluid
                    />
                    <p className="text-muted mb-1">
                      Welcome {Customer.username}
                    </p>
                  </MDBCardBody>
                </MDBCard>
                {count && (
                  <MDBListGroup flush className="rounded-3">
                    <MDBListGroupItem className="d-flex justify-content-between align-items-center p-3">
                      <MDBIcon
                        fab
                       
                        style={{ color: "#ac2bac" }}
                      />
                      <i class="fas fa-book-open"></i>
                      <MDBCardText>
                        No of Buyed Books = {count.Buybookcount}
                      </MDBCardText>
                    </MDBListGroupItem>
                    <MDBListGroupItem className="d-flex justify-content-between align-items-center p-3">
                      <MDBIcon
                        fab
                       
                        style={{ color: "#3b5998" }}
                      />
                      <i class="fas fa-book-open"></i>
                      <MDBCardText>
                        No of Rented Books = {count.RentBookcount}
                      </MDBCardText>
                    </MDBListGroupItem>
                  </MDBListGroup>
                )}
              </MDBCol>
              <MDBCol lg="8">
                <MDBCard className="mb-4">
                  <MDBCardBody>
                    <MDBRow>
                      <MDBCol sm="3">
                        <MDBCardText>Full Name</MDBCardText>
                      </MDBCol>
                      <MDBCol sm="9">
                        <MDBCardText className="text-muted">
                          {Customer.customerName}
                        </MDBCardText>
                      </MDBCol>
                    </MDBRow>
                    <hr />
                    <MDBRow>
                      <MDBCol sm="3">
                        <MDBCardText>Email</MDBCardText>
                      </MDBCol>
                      <MDBCol sm="9">
                        <MDBCardText className="text-muted">
                          {Customer.customerEmail}
                        </MDBCardText>
                      </MDBCol>
                    </MDBRow>
                    <hr />
                    <MDBRow>
                      <MDBCol sm="3">
                        <MDBCardText>Mobile</MDBCardText>
                      </MDBCol>
                      <MDBCol sm="9">
                        <MDBCardText className="text-muted">
                          {Customer.contactNo}
                        </MDBCardText>
                      </MDBCol>
                    </MDBRow>
                    <hr />
                    <MDBRow>
                      <MDBCol sm="3">
                        <MDBCardText>Address</MDBCardText>
                      </MDBCol>
                      <MDBCol sm="9">
                        <MDBCardText className="text-muted">
                          {Customer.address}
                        </MDBCardText>
                      </MDBCol>
                    </MDBRow>
                    <hr />
                    <MDBRow>
                      <MDBCol sm="3">
                        <MDBCardText>City</MDBCardText>
                      </MDBCol>
                      <MDBCol sm="9">
                        <MDBCardText className="text-muted">
                          {Customer.city}
                        </MDBCardText>
                      </MDBCol>
                    </MDBRow>
                    <hr></hr>
                    <MDBRow>
                      <MDBCol sm="3">
                        <MDBCardText>Pincode</MDBCardText>
                      </MDBCol>
                      <MDBCol sm="9">
                        <MDBCardText className="text-muted">
                          {Customer.pincode}
                        </MDBCardText>
                      </MDBCol>
                    </MDBRow>
                  </MDBCardBody>
                </MDBCard>
              </MDBCol>
            </MDBRow>
          </MDBContainer>
        </section>
      )}
    </div>
  );
};
export default Profile;
