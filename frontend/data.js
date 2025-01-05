import react from 'react';
//import images from '.images.jpg';
import image from '../src/images.jpg';
import image2 from '../src/images2.jpg';
import image3 from '../src/images3.jpg';
import image4 from '../src/images4.jpg';
import image5 from '../src/images5.jpg';
import image6 from '../src/images6.jpg';
import image7 from '../src/images7.jpg';
import image8 from '../src/images8.jpg';
export const storeProducts = [
  {
    id: 1,
    title: "western dress",
    img: image,
    price: 5000, 
    info:
      "A pink dress with frill",
    inCart: false,
    count: 0,
    total: 0,
    category: {id: 0}
    },
  {
    id: 2,
    title: "Black t-shirt",
    img: image2,
    price: 300,
    
    //company: "SAMSUNG",
    info:
      "A black funcy top with happy inked",
    inCart: false,
    count: 0,
    total: 0,
    category: {id: 1}
  },
  {
    id: 3,
    title: "jumpsuit",
    img: image3,
    price: 400,
    //company: "htc",
    info:
    "unicorn jumpsuit with shoulder cut.",
    inCart: false,
    count: 0,
    total: 0
  },
  // {
  //   id: 4,
  //   title: "Girls jeans",
  //   img: image4,
  //   price: 650,
  //   //company: "htc",
  //   info:
  //     "denim light blue jeans for womens",
  //   inCart: false,
  //   count: 0,
  //   total: 0
  // },
  {
    id: 5,
    title: "Denim jacket",
    img: image5,
    price: 870,
    //company: "htc",
    info:
      "Denim light blue jeans for kids.",
    inCart: false,
    count: 0,
    total: 0
  },
  {
    id: 6,
    title: "Jacket",
    img: image6,
    price: 699,
    //company: "apple",
    info:
      "Brown colour winter jacket for mens",
    inCart: false,
    count: 0,
    total: 0
  },
  {
    id: 7,
    title: "Lehenga",
    img: image7,
    price: 4895,
    //company: "apple",
    info:
      "pink-orange lehenga for womens",
    inCart: false,
    count: 0,
    total: 0
  },
  {
    id: 8,
    title: "Skirt-top",
    img: image8,
    price: 450,
    //company: "apple",
    info:
"Red and white skirt-top for girls.",
    inCart: false,
    count: 0,
    total: 0
  }
];

export const detailProduct = {
  id: 1,
    title: "western dress",
    img: "src/images2.png",
    //img :<img src={images} width="10%" height="10%" alt="images"/>,
    price: 5000,
    //company: "GOOGLE",
    info:
      "A pink dress with frill",
    inCart: false,
    count: 0,
    total: 0,
    category: {id: 0}
};
