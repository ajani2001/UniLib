import React from "react";
import SmartTextView from "./view_component/SmartTextView";
import SmartDateView from "./view_component/SmartDateView";
import Helper from "../Helper";
import SmartBooleanView from "./view_component/SmartBooleanView";

class SmartListElementView extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            sendDelete: false
        };
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
            Helper.fetchText(this.props.config.controllerAddress + this.props.data.id, {method: 'DELETE'})
                .then(response => this.props.onDelete(this.props.data.id),
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
            if(this.props.data.id === null || this.props.data.id === undefined) {
                return <button onClick={this.props.onEdit}>Create</button>;
            } else {
                return (
                    <div className={this.props.config.className}>
                        {this.props.config.representationFields.map((viewFieldConfig, index) => {
                            if (viewFieldConfig.fieldType === "Date") {
                                return <SmartDateView key={index} value={this.props.data[viewFieldConfig.fieldName]}
                                                      config={viewFieldConfig}/>
                            } else if (viewFieldConfig.fieldType === "Boolean") {
                                return <SmartBooleanView key={index} value={this.props.data[viewFieldConfig.fieldName]}
                                                         config={viewFieldConfig}/>
                            } else {
                                return <SmartTextView key={index} value={this.props.data[viewFieldConfig.fieldName]}
                                                      config={viewFieldConfig}/>
                            }
                        })}
                        <button onClick={this.props.onEdit}>Edit</button>
                        <button onClick={this.onDeleteButtonClick}>Delete</button>
                    </div>
                );
            }
        }
    }
}

export default SmartListElementView;