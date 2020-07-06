import React, { Component } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

class Show extends Component {
    constructor(props) {
        super(props);
        this.state = {
            employee: {},
        };
    }

    componentDidMount() {
        axios.get("/users/" + this.props.match.params.id).then((res) => {
            this.setState({ employee: res.data });
            console.log(this.state.employee);
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
            h3 className = "panel-title" > Employee Details < /h3>{" "} <
            /div>{" "} <
            div className = "panel-body" >
            <
            h4 > { " " } <
            Link to = "/list" > { " " } <
            span className = "glyphicon glyphicon-th-list" > < /span> Employees
            List { " " } <
            /Link>{" "} <
            /h4>{" "} <
            dl >
            <
            dt > EMPLOYEE ID: < /dt> <dd> {this.state.employee.id} </dd > { " " } <
            dt > EMPLOYEE NAME: < /dt>{" "} <
            dd > { " " } {
                this.state.employee.first_name +
                    " " +
                    this.state.employee.last_name
            } { " " } <
            /dd>{" "} <
            dt > EMPLOYEE EMAIL: < /dt> <dd> {this.state.employee.email} </dd > { " " } <
            dt > MANAGER ID: < /dt>{" "} <
            dd > { this.state.employee.lineManager } < /dd>{" "} <
            /dl>{" "} <
            Link to = { `/apply/${this.state.employee.id}` }
            className = "btn btn-primary" >
            { " " }
            Apply Leave { " " } <
            /Link>{" "} <
            /div>{" "} <
            /div>{" "} <
            /div>
        );
    }
}
export default Show;