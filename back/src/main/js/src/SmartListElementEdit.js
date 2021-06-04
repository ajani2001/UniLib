import React from "react";
import SmartTextInput from "./SmartTextInput";
import SmartDateInput from "./SmartDateInput";
import Helper from "./Helper";

class SmartListElementEdit extends React.Component {
    constructor(props) {
        super(props);

        this.state = { sent: false };
        this.state.id = props.data.id ? props.data.id : null;
        for (const entityFieldConfig of props.config.entityFields) {
            this.state[entityFieldConfig.fieldName] = props.data[entityFieldConfig.fieldName] ? props.data[entityFieldConfig.fieldName] : null;
        }
    }

    resolveInputClass = (type) => {
        switch (type) {
            case "String":
                return SmartTextInput;
            case "Date":
                return SmartDateInput;
            default:
                return null;
        }
    }

    onChangeCallback = (fieldName, newValue) => {
        this.setState({
            [fieldName]: newValue
        });
    }

    onSaveButtonClick = () => {
        this.setState((prevState, props) => {
            if (prevState.sent)
                return {};

            return {
                sent: true
            };
        });
    }

    componentDidUpdate(prevProps, prevState, snapshot) {
        if (!prevState.sent && this.state.sent) {
            let entity = {
                id: this.state.id
            };
            for (const entityFieldConfig of this.props.config.entityFields) {
                entity[entityFieldConfig.fieldName] = this.state[entityFieldConfig.fieldName];
            }
            Helper.fetchJson(this.props.config.controllerAddress, {
                method: this.state.id == null ? 'POST' : 'PUT',
                headers: {
                    'Content-Type': 'application/json;charset=utf-8'
                },
                body: JSON.stringify(entity)
            })
                .then(json => {
                        this.props.onSave(json);
                        this.setState({
                            sent: false
                        });
                    },
                    error => {
                        this.setState({
                            sent: false
                        });
                        alert(error.message);
                    });
        }
    }

    render() {
        if (this.state.sent) {
            return (<div className={this.props.config.className}>
                <label>Loading...</label>
            </div>);
        } else {
            return (
                <div className={this.props.config.className}>
                    {this.props.config.entityFields.map((entityFieldConfig, index) => {
                        const InputComponent = this.resolveInputClass(entityFieldConfig.fieldType);
                        return (
                            <InputComponent key={index} value={this.state[entityFieldConfig.fieldName]}
                                            onChange={this.onChangeCallback} config={entityFieldConfig}/>
                        );
                    })}
                    <button onClick={this.onSaveButtonClick}>Save</button>
                    <button onClick={this.props.onCancel}>Cancel</button>
                </div>
            );
        }
    }
}

export default SmartListElementEdit;