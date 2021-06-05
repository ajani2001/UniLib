import React from "react";
import Helper from "./Helper";
import SmartList from "./SmartList";

class CRUDForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {prevConfig: props.config, loaded: false, data: []};
    }

    componentDidMount() {
        Helper.fetchJson(this.props.config.controllerAddress + "all").then(json=>this.setState({loaded: true, data: json}), error=>alert(error.message));
    }

    static getDerivedStateFromProps(props, state){
        if(props.config !== state.prevConfig) {
            Helper.fetchJson(props.config.controllerAddress + "all").then(json=>this.setState({loaded: true, data: json}), error=>alert(error.message));
            return {prevConfig: props.config, loaded: false, data:[]}
        }
    }

    componentDidUpdate(prevProps, prevState, snapshot) {
        if(prevState.loaded === true && this.state.loaded === false) {
            Helper.fetchJson(this.props.config.controllerAddress + "all").then(json=>this.setState({loaded: true, data: json}), error=>alert(error.message));
        }
    }

    onSave = (newEntry) => {
        this.setState((prevState, props)=> {
            let modified = false;
            let newData = prevState.data.map((element) => {
                if (element.id === newEntry.id) {
                    modified = true;
                    return newEntry;
                }
                return element;
            });
            return {data: modified ? newData : prevState.data.concat([newEntry])};
        });
    }

    onDelete = (id) => {
        this.setState((prevState, props) => ({
            data: prevState.data.filter(entry => entry.id !== id)
        }));
    }

    render() {
        return (
            this.state.loaded ?
                <SmartList data={this.state.data} config={this.props.config} onSave={this.onSave}
                           onDelete={this.onDelete}/> :
                <h2>Loading...</h2>
        );
    }
}

export default CRUDForm