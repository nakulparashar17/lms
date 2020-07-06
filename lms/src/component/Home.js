import React, { Component } from "react";
import { Link } from "react-router-dom";
class Home extends Component {
    state = {};
    render() {
        return ( <
            div >
            <
            div className = "panel-heading" >
            <
            center >
            <
            h1 className = "panel-title" > Leave Management App < /h1>{" "} <
            /center>{" "} <
            /div>{" "} <
            ul className = "navbar-nav" >
            <
            li > { " " } <
            Link className = "nav-link"
            to = "/list" > { " " }
            Employees List { " " } <
            /Link>{" "} <
            /li>{" "} <
            /ul>{" "} <
            /div>
        );
    }
}

export default Home;