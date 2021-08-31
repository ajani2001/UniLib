import React from "react";
import SmartListElementView from "./SmartListElementView";
import SmartListElementEdit from "./SmartListElementEdit";

class SmartListElement extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            edit: false
        };
    }

    onCancel = () => {
        this.setState({
            edit: false
        });
    }

    onEdit = () => {
        this.setState({
            edit: true
        });
    }

    onSave = (data) => {
        this.props.onSave(data);
        this.setState({
            edit: false
        });
    }

    render() {
        if (this.state.edit) {
            return (
                <SmartListElementEdit data={this.props.data} config={this.props.config} onSave={this.onSave}
                                      onCancel={this.onCancel}/>
            );
        } else {
            return (
                <SmartListElementView data={this.props.data} config={this.props.config} onEdit={this.onEdit}
                                      onDelete={this.props.onDelete}/>
            );
        }
    }
}

export default SmartListElement;