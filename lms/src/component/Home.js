import React, { Component } from "react";
import { Link } from "react-router-dom";
class Home extends Component {
    constructor(props) {
        super(props);
        this.state = {
            id: this.props.match.params.id,
        };
    }
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
            to = { `/show/${this.state.id}` } >
            { " " }
            Employee Details { " " } <
            /Link>{" "} <
            /li>{" "} <
            /ul>{" "} <
            /div>
        );
    }
}

export default Home;