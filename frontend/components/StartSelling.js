import React, { Component } from "react";
import { Redirect } from "react-router-dom";
import axios from "axios";


export default class StartSelling extends  React.Component {
    constructor(props) {
        super(props);
        this.state = {
            title: "",
            description: "",
            price: 0,
            type: "",
            image: ""
        };
        this.onChangeTitle = this.onChangeTitle.bind(this);
        this.onChangeDescription = this.onChangeDescription.bind(this);
        this.onChangePrice = this.onChangePrice.bind(this);
        this.onChangeType = this.onChangeType.bind(this);
        this.onImageChange = this.onImageChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
    }

    componentDidMount() {
        let role = localStorage.getItem("role");
        if (role === "USER" || role === "ANON") {
            window.location.href = "/notAuthorized";
        }
    }

    onChangeTitle(e) {
        this.setState({
            title: e.target.value
        });
    }

    onChangeDescription(e) {
        this.setState({
            description: e.target.value
        });
    }

    onChangePrice(e) {
        this.setState({
            price: e.target.value
        });
    }

    onChangeType(e) {
        this.setState({
            type: e.target.value
        })
    }

    onImageChange = event => {
        if (event.target.files && event.target.files[0]) {
          let img = event.target.files[0];
          this.setState({
            image: URL.createObjectURL(img)
          });
        }
    }

    onSubmit(e) {
        debugger
        alert('Product added');
        axios.post("http://localhost:8082/product/add", {
            title: this.state.title,
            description: this.state.description,
            price: this.state.price,
            image: this.state.image
        }
        )
    }

  render() {

    return (
        <form onSubmit={this.onSubmit}>

        <h3>Add Product Details</h3>
        <h5>Your Product: {this.state.title}</h5>
        <div className="form-group d-grid gap-2 col-6 mx-auto">
            <label>Title</label>
            <input value={this.state.title} onChange={this.onChangeTitle} id="username" type="text" className="form-control" placeholder="Product title" />
        </div>

        <div className="form-group d-grid gap-2 col-6 mx-auto">
            <label>Price</label>
            <input value={this.state.price} onChange={this.onChangePrice} id="email" type="number" className="form-control" placeholder="Product price" />
        </div>
        
        <div className="form-group d-grid gap-2 col-6 mx-auto">
            <label>Description</label>
            <input value={this.state.description} onChange={this.onChangeDescription} id="email" type="text" className="form-control" placeholder="Product description" />
        </div>

        <div class="form-group d-grid gap-2 col-6 mx-auto">
            <label for="exampleFormControlSelect2">Product Type</label>
            <select  onChange={this.onChangeType} multiple class="form-control" id="type">
                <option>Men</option>
                <option>Women</option>
                <option>Kids</option>
            </select>
        </div>

        <div className="form-group d-grid gap-2 col-6 mx-auto">
            <div>
                <img src={this.state.image} />
                <label>Select Image</label><br/>
                <input type="file" name="myImage" onChange={this.onImageChange} />
          </div><br/>
        

        <button type="submit" className="btn btn-dark d-grid gap-2 col-6 mx-auto">Add product</button>
        </div>
    </form>
);
}
};