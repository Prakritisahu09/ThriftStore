import React, { Component } from "react";
import {Link} from "react-router-dom";
import { useEffect, useState } from "react";
import { Redirect } from "react-router-dom";
import sellerInstruction from "../sellingInstruction.jpg";


export default class Seller extends Component{
    Seller = () => {
        const [authenticated, setauthenticated] = useState(null);
        useEffect(() => {
        const loggedInUser = localStorage.getItem("authenticated");
        if (loggedInUser) {
            setauthenticated(loggedInUser);
        }
        }, []);

        if (!authenticated) {
            return <Redirect to="/login" state={{ from: Seller }} />
        } else {
        return (
        <div>
            <p>Welcome to your Dashboard</p>
        </div>
        );
    }
};

    render(){
    return(
        
    
    <div className="selling">
        <div class="position-absolute bottom-0 start-50 translate-middle-x">
            <h1 textAlign={"center"} style={{color: "red"}}>How to be a Seller?</h1>
        <img src= {sellerInstruction} alt="instruction" style={{ width: 1500, height: 500 }}/>
        <Link to ="/StartSelling">
            <button type="button" class="btn btn-dark btn-lg <br><br>position-absolute bottom-0 end-0">Start Selling</button>
        </Link>
        </div>
    </div>
    
    )
    }

}