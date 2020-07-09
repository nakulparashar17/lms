import React, { Component } from "react";
import axios from "axios";

class ShowLeave extends Component {
    constructor(props) {
        super(props);
        this.state = {
            leave: {
                type: {},
                users: {},
            },
            action1: "accept",
            action2: "reject",
        };
    }

    componentDidMount() {
        axios.get("/leaves/" + this.props.match.params.id).then((res) => {
            this.setState({ leave: res.data });
            console.log(this.state.leave);
        });
    }

    approved(id) {
        console.log(id);
        const { type, reason, fromDate, toDate, duration } = this.state.leave;
        axios
            .put("/leaves/" + id + "/acceptreject/" + this.state.action1, {
                type,
                reason,
                fromDate,
                toDate,
                duration,
            })
            .then((result) => {
                this.props.history.push(
                    "/activeleavesemp/" + this.state.leave.users.id
                );
            });
    }

    reject(id) {
        console.log(id);
        const { type, reason, fromDate, toDate, duration } = this.state.leave;
        axios
            .put("/leaves/" + id + "/acceptreject/" + this.state.action2, {
                type,
                reason,
                fromDate,
                toDate,
                duration,
            })
            .then((result) => {
                this.props.history.push(
                    "/activeleavesemp/" + this.state.leave.users.id
                );
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
            h2 className = "panel-title" > Leave Details < /h2>{" "} <
            /center>{" "} <
            /div>{" "} <
            div className = "panel-body" >
            <
            dl >
            <
            dt > LEAVE ID: < /dt> <dd> {this.state.leave.id} </dd > { " " } <
            dt > LEAVE TYPE: < /dt>{" "} <
            dd > { this.state.leave.type.leave_name } < /dd> <dt> REASON: </dt > { " " } <
            dd > { this.state.leave.reason } < /dd>{" "} <
            dt > FROM DATE(YY / MM / DD): < /dt>{" "} <
            dd > { this.state.leave.fromDate } < /dd>{" "} <
            dt > TO DATE(YY / MM / DD): < /dt>{" "} <
            dd > { this.state.leave.toDate } < /dd> <dt> DURATION: </dt > { " " } <
            dd > { this.state.leave.duration } < /dd> <dt> EMPLOYEE NAME: </dt > { " " } <
            dd > { " " } {
                this.state.leave.users.first_name +
                    " " +
                    this.state.leave.users.last_name
            } { " " } <
            /dd>{" "} <
            /dl>{" "} <
            button onClick = { this.approved.bind(this, this.state.leave.id) }
            className = "btn btn-success" >
            { " " }
            Approved { " " } <
            /button>{" "} <
            button onClick = { this.reject.bind(this, this.state.leave.id) }
            className = "btn btn-danger" >
            { " " }
            Rejected { " " } <
            /button>{" "} <
            /div>{" "} <
            /div>{" "} <
            /div>
        );
    }
}

export default ShowLeave;