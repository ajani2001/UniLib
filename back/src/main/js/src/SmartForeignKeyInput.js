import React from "react";

class SmartForeignKeyInput extends React.Component {
    render() {
        return (
            <div className="key-input">
                <h2>{this.props.config.label}</h2>
                <select value={this.props.value}
                        onChange={(event) =>
                            isNaN(Number.parseInt(event.target.value)) ?
                                this.props.onChange(this.props.config.fieldName, null) :
                                this.props.onChange(this.props.config.fieldName, Number.parseInt(event.target.value)
                                )}>
                    <option value="null">--</option>
                    {this.props.pickedEntities.map((entity, index) => (
                        <option key={index} value={entity.id}>{entity.verbosed}</option>
                    ))}
                </select>
            </div>
        );
    }
}

export default SmartForeignKeyInput;