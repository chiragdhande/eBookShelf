import React from "react";
import Carousel from "react-bootstrap/Carousel";

export default function SlideShow() {
  return (
    <Carousel data-bs-theme='dark'>
      <Carousel.Item>
        <img
          className='d-block w-100'
          src={"/SlideShow_img/img2.jpg"}
          alt='First slide'
        />
        <Carousel.Caption></Carousel.Caption>
      </Carousel.Item>

      <Carousel.Item>
        <img
          className='d-block w-100'
          src={"/SlideShow_img/img3.jpg"}
          alt='First slide'
        />
        <Carousel.Caption></Carousel.Caption>
      </Carousel.Item>

      <Carousel.Item>
        <img
          className='d-block w-100'
          src={"/SlideShow_img/img5.jpg"}
          alt='First slide'
        />
        <Carousel.Caption></Carousel.Caption>
      </Carousel.Item>

      <Carousel.Item>
        <img
          className='d-block w-100'
          src={"/SlideShow_img/img4.jpg"}
          alt='Second slide'
        />
        <Carousel.Caption></Carousel.Caption>
      </Carousel.Item>
          </Carousel>
  );
}
