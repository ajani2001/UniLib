import React from "react";
import SmartTextView from "./SmartTextView";
import SmartDateView from "./SmartDateView";
import Helper from "./Helper";

class SmartListElementView extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            sendDelete: false
        };
    }

    resolveViewClass = (type) => {
        switch (type) {
            case "String":
                return SmartTextView;
            case "Date":
                return SmartDateView;
            default:
                return null;
        }
    }

    onDeleteButtonClick = () => {
        this.setState((prevState, props) => {
            if (prevState.sentDelete)
                return {};

            return {
                sentDelete: true
            };
        });
    }

    componentDidUpdate(prevProps, prevState, snapshot) {
        if (!prevState.sentDelete && this.state.sentDelete) {
            Helper.fetchJson(this.props.config.controllerAddress + this.props.data.id, {method: 'DELETE'})
                .then(response => this.props.onDelete(this.props.data),
                    error => {
                        alert(error.message);
                        this.setState({sentDelete: false});
                    });
        }
    }

    render() {
        if (this.state.sentDelete) {
            return (<div className={this.props.config.className}>
                <label>Loading...</label>
            </div>);
        } else {
            return (
                <div className={this.props.config.className}>
                    {this.props.config.representationFields.map((viewFieldConfig, index) => {
                        const ViewComponent = this.resolveViewClass(viewFieldConfig.fieldType);
                        return (
                            <ViewComponent key={index} value={this.props.data[viewFieldConfig.fieldName]}
                                            config={viewFieldConfig}/>
                        );
                    })}
                    <button onClick={this.props.onEdit}>Edit</button>
                    <button onClick={this.onDeleteButtonClick}>Delete</button>
                </div>
            );
        }
    }
}

export default SmartListElementView;