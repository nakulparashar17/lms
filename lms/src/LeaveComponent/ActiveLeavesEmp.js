import React, { Component } from "react";
import { Link } from "react-router-dom";
import axios from "axios";

class ActiveLeavesEmp extends Component {
    constructor(props) {
        super(props);
        this.state = {
            leaves: [],
        };
    }
    componentDidMount() {
        axios
            .get("/users/" + this.props.match.params.id + "/leaves/active")
            .then((res) => {
                this.setState({ leaves: res.data });
                console.log(this.state.leaves);
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
            center > { " " } <
            h2 className = "panel-title" > Active leaves < /h2>{" "} <
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
            th > LEAVE ID < /th> <th>LEAVE TYPE </th > < th > REASON < /th>{" "} <
            th > FROM DATE(YY / MM / DD) < /th>{" "} <
            th > TO DATE(YY / MM / DD) < /th> <th> DURATION </th > { " " } <
            th > EMPLOYEE NAME < /th>{" "} <
            /tr>{" "} <
            /thead>{" "} <
            tbody > { " " } {
                this.state.leaves.map((c) => ( <
                    tr >
                    <
                    td > { c.id } < /td>{" "} <
                    td > { " " } <
                    Link to = { `/showleave/${c.id}` } > { " " } { c.type.leave_name } { " " } <
                    /Link>{" "} <
                    /td>{" "} <
                    td > { c.reason } < /td> <td> {c.fromDate} </td > { " " } <
                    td > { c.toDate } < /td> <td> {c.duration} </td > { " " } <
                    td > { c.users.first_name + " " + c.users.last_name } < /td>{" "} <
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

export default ActiveLeavesEmp;