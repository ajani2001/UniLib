import React from "react";
import SmartTextInput from "./SmartTextInput";
import SmartDateInput from "./SmartDateInput";
import SmartNumberInput from "./SmartNumberInput";

class SmartListControl extends React.Component {
    constructor(props) {
        super(props);

        this.state = {};
        for (const filterEntry of props.filter) {
            this.state[filterEntry.fieldConfig.fieldName] = null;
        }
    }

    onChangeCallback = (fieldName, newValue) => {
        this.setState({
            [fieldName]: newValue
        });
    }

    onApplyButtonClick = () => {
        const newFilter = this.props.filter.map(filterEntry=>({
            fieldConfig: filterEntry.fieldConfig,
            filter: this.state[filterEntry.fieldConfig.fieldName]
        }));
        this.props.changeFilter(newFilter);
    }

    render() {
        if (this.state.sent) {
            return (<div className={this.props.config.className}>
                <label>Loading...</label>
            </div>);
        } else {
            return (
                <div className="list-control">
                    {this.props.filter.map((filterEntry, index) => {
                        if (filterEntry.fieldConfig.fieldType === "String") {
                            return (
                                <div key={index} className="list-control-sub">
                                    <SmartTextInput key={index} value={this.state[filterEntry.fieldConfig.fieldName]}
                                                    onChange={this.onChangeCallback} config={filterEntry.fieldConfig}/>
                                    <input type="radio" onChange={(event) => this.props.changeSort({
                                        fieldName: filterEntry.fieldConfig.fieldName,
                                        ascending: true
                                    })} checked={filterEntry.fieldConfig.fieldName === this.props.sort.fieldName}/>
                                </div>);
                        } else if (filterEntry.fieldConfig.fieldType === "Date") {
                            return (
                                <div key={index} className="list-control-sub">
                                    <SmartDateInput key={index} value={this.state[filterEntry.fieldConfig.fieldName]}
                                                    onChange={this.onChangeCallback} config={filterEntry.fieldConfig}/>
                                    <input type="radio" onChange={(event) => this.props.changeSort({
                                        fieldName: filterEntry.fieldConfig.fieldName,
                                        ascending: true
                                    })} checked={filterEntry.fieldConfig.fieldName === this.props.sort.fieldName}/>
                                </div>);
                        } else if (filterEntry.fieldConfig.fieldType === "Number") {
                            return (
                                <div key={index} className="list-control-sub">
                                    <SmartNumberInput key={index} value={this.state[filterEntry.fieldConfig.fieldName]}
                                                      onChange={this.onChangeCallback} config={filterEntry.fieldConfig}/>
                                    <input type="radio" onChange={(event) => this.props.changeSort({
                                        fieldName: filterEntry.fieldConfig.fieldName,
                                        ascending: true
                                    })} checked={filterEntry.fieldConfig.fieldName === this.props.sort.fieldName}/>
                                </div>);
                        } else {
                            return (
                                <div key={index} className="list-control-sub">
                                    <label>type is not supported</label>
                                </div>
                            );
                        }
                    })}
                    <button onClick={this.onApplyButtonClick}>Apply</button>
                </div>
            );
        }
    }
}

export default SmartListControl;