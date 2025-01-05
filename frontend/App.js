import React, { Component } from 'react';
import {Switch, Route} from 'react-router-dom';
//import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

import Header from './components/Header';
import ProductList from './components/ProductList';
import Details from './components/Details';
import Cart from './components/Cart';
import Default from './components/Default';
import Modal from './components/Modal';
import Login from './components/Login';
import Register from './components/Register';
import MensSection from './components/MensSection';
import Seller from './components/Seller';
import StartSelling from './components/StartSelling';
import { Nav, PrivateRoute } from './components/PrivateRoute';
import { Redirect } from 'react-router-dom';

class App extends Component {
  render() {
    return (
      <React.Fragment>
        <Header />
        <Switch>
          <Route exact path="/" component={ProductList}></Route>
          <Route path="/details" component={Details}></Route>
          <Route path="/Seller" component={Seller}></Route>
          <Route path="/StartSelling" component={StartSelling}></Route>
          <Route path="/cart" component={Cart}></Route>
          <Route path="/login" component={Login}></Route>
          <Route path="/register" component={Register}></Route>
          <Route path="/MensSection" component ={MensSection}></Route>
          <Route component={Default}></Route>
                        <PrivateRoute exact path="/" component={ProductList} />
                        <Route path="/login" component={Login} />
                        <Redirect from="*" to="/" />
                    </Switch>
                
        <Modal />
      </React.Fragment>
    );
  }
}

export default App;
