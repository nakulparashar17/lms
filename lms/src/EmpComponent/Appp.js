import React, { Component } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

class Appp extends Component {
    constructor(props) {
        super(props);
        this.state = {
            employees: [],
        };
    }

    componentDidMount() {
        axios.get("/manager/" + this.props.match.params.id).then((res) => {
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
            h6 >
            <
            Link to = { `/show/${this.props.match.params.id}` } >
            <
            span className = "glyphicon glyphicon-plus-sign" > < /span> Home{" "} <
            /Link>{" "} <
            /h6>{" "} <
            /center>{" "} <
            /div>{" "} <
            div className = "panel-body" >
            <
            table className = "table table-stripe" >
            <
            thead >
            <
            tr >
            <
            th > EMPLOYEE ID < /th> <th>EMPLOYEE NAME </th > { " " } <
            th > EMPLOYEE EMAIL < /th> <th> MANAGER ID </th > { " " } <
            th > MANAGE LEAVES < /th>{" "} <
            /tr>{" "} <
            /thead>{" "} <
            tbody > { " " } {
                this.state.employees.map((c) => ( <
                    tr >
                    <
                    td > { c.id } < /td>{" "} <
                    td > { c.first_name + " " + c.last_name } < /td>{" "} <
                    td > { c.email } < /td> <td> {c.lineManager} </td > { " " } <
                    td >
                    <
                    Link to = { `/activeleavesemp/${c.id}` } > manage < /Link>{" "} <
                    /td>{" "} <
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