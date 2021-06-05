import React from "react";
import SmartTextInput from "./SmartTextInput";
import SmartDateInput from "./SmartDateInput";
import Helper from "./Helper";
import SmartForeignKeyInput from "./SmartForeignKeyInput";
import SmartNumberInput from "./SmartNumberInput";
import config from "./Config";

class SmartListElementEdit extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            sent: false,
            unloaded: 0,
            id: props.data.id !== undefined ? props.data.id : null
        };

        this.foreignEntities = {};

        for (const entityFieldConfig of props.config.entityFields) {
            this.state[entityFieldConfig.fieldName] = props.data[entityFieldConfig.fieldName] ? props.data[entityFieldConfig.fieldName] : null;
            if (entityFieldConfig.fieldType === "Key" && this.foreignEntities[config[entityFieldConfig.configName].controllerAddress] === undefined) {
                this.state.unloaded += 1;
                this.foreignEntities[config[entityFieldConfig.configName].controllerAddress] = null;
            }
        }
    }

    componentDidMount() {
        for (const foreignEntitiesKey in this.foreignEntities) {
            Helper.fetchJson(foreignEntitiesKey + "all").then(json => {
                this.foreignEntities[foreignEntitiesKey] = json;
                this.setState((prevState, props) => ({unloaded: prevState.unloaded - 1}));
            }, error => {
                alert(error.message);
                this.setState((prevState, props) => ({unloaded: prevState.unloaded - 1}));
            });
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
        if (this.state.sent || this.state.unloaded !== 0) {
            return (<div className={this.props.config.className}>
                <label>Loading...</label>
            </div>);
        } else {
            return (
                <div className={this.props.config.className}>
                    {this.props.config.entityFields.map((entityFieldConfig, index) => {
                        if(entityFieldConfig.fieldType === "String") {
                            return <SmartTextInput key={index} value={this.state[entityFieldConfig.fieldName]}
                                                   onChange={this.onChangeCallback} config={entityFieldConfig} />;
                        } else if(entityFieldConfig.fieldType === "Date") {
                            return <SmartDateInput key={index} value={this.state[entityFieldConfig.fieldName]}
                                                   onChange={this.onChangeCallback} config={entityFieldConfig} />;
                        } else if(entityFieldConfig.fieldType === "Number") {
                            return <SmartNumberInput key={index} value={this.state[entityFieldConfig.fieldName]}
                                                   onChange={this.onChangeCallback} config={entityFieldConfig} />;
                        } else if(entityFieldConfig.fieldType === "Key") {
                            return <SmartForeignKeyInput key={index} value={this.state[entityFieldConfig.fieldName]}
                                                   onChange={this.onChangeCallback} config={entityFieldConfig}
                                                   pickedEntities={this.foreignEntities[config[entityFieldConfig.configName].controllerAddress].map(entity=>({id: entity.id, verbosed: JSON.stringify(entity)}))} />;
                        } else {
                            return <label>type is not supported</label>
                        }
                    })}
                    <button onClick={this.onSaveButtonClick}>Save</button>
                    <button onClick={this.props.onCancel}>Cancel</button>
                </div>
            );
        }
    }
}

export default SmartListElementEdit;