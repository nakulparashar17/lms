import React, { Component } from "react";
import { Link } from "react-router-dom";
import axios from "axios";

class Appp extends Component {
    constructor(props) {
        super(props);
        this.state = {
            employees: [],
        };
    }

    componentDidMount() {
        axios.get("/users").then((res) => {
            this.setState({ employees: res.data });
            console.log(this.state.employees);
        });
    }

    render() {
        return ( <
            div className = "container" >
            <
            div className = "panel panel-default" >
            <
            div className = "panel-heading" >
            <
            center >
            <
            h2 className = "panel-title" > EMPLOYEES LIST < /h2>{" "} <
            /center>{" "} <
            /div>{" "} <
            div className = "panel-body" >
            <
            ul className = "navbar-nav" >
            <
            li >
            <
            Link to = "/activeleaves" >
            <
            span className = "glyphicon glyphicon-plus-sign" > < /span>{" "}
            Active Leaves { " " } <
            /Link>{" "} <
            /li>{" "} <
            /ul>{" "} <
            table className = "table table-stripe" >
            <
            thead >
            <
            tr >
            <
            th > EMPLOYEE ID < /th> <th>EMPLOYEE NAME </th > { " " } <
            th > EMPLOYEE EMAIL < /th> <th> MANAGER ID </th > { " " } <
            /tr>{" "} <
            /thead>{" "} <
            tbody > { " " } {
                this.state.employees.map((c) => ( <
                    tr >
                    <
                    td > { c.id } < /td>{" "} <
                    td >
                    <
                    Link to = { `/show/${c.id}` } > { " " } { c.first_name + " " + c.last_name } { " " } <
                    /Link>{" "} <
                    /td>{" "} <
                    td > { c.email } < /td> <td> {c.lineManager} </td > { " " } <
                    /tr>
                ))
            } { " " } <
            /tbody>{" "} <
            /table>{" "} <
            /div>{" "} <
            /div>{" "} <
            /div>
        );
    }
}

export default Appp;