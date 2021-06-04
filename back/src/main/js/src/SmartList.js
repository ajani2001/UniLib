import React from "react";
import SmartListControl from "./SmartListControl";
import SmartListElement from "./SmartListElement";

class SmartList extends React.Component {
    constructor(props) {
        super(props);

        const filter = props.config.representationFields.map((fieldConfig) => ({
            fieldConfig: fieldConfig,
            filter: null
        }));
        const sort = {
            fieldName: props.config.representationFields[0].fieldName,
            ascending: true
        };

        this.state = {
            filter: filter,
            sort: sort,
            showPositions: 2
        };
    }

    changeFilter = (newFilter) => {
        this.setState({
            filter: newFilter
        });
    }

    changeSort = (newSort) => {
        this.setState({
            sort: newSort
        });
    }

    onMoreButtonClick = () => {
        this.setState((prevState, props) => ({
            showPositions: prevState.showPositions + 2
        }));
    }

    render() {
        const filteredAndSorted = this.props.data.filter(entry => {
            for (const filterElement of this.state.filter) {
                if (filterElement.filter !== null && entry[filterElement.fieldConfig.fieldName] !== filterElement.filter)
                    return false;
            }
            return true;
        }).sort((a, b) => (a[this.state.sort.fieldName] < b[this.state.sort.fieldName]) === this.state.sort.ascending ? -1 : 1);
        return (
            <div className="smart-list">
                <SmartListControl filter={this.state.filter} sort={this.state.sort} changeFilter={this.changeFilter}
                                  changeSort={this.changeSort}/>
                {filteredAndSorted.slice(0, this.state.showPositions).map(entry => <SmartListElement key={entry.id}
                                                                                                     data={entry}
                                                                                                     config={this.props.config}
                                                                                                     onSave={this.props.onSave}
                                                                                                     onDelete={this.props.onDelete}/>)}
                {this.state.showPositions < filteredAndSorted.length ?
                    <button onClick={this.onMoreButtonClick}>More</button> : ""}
            </div>
        );
    }
}

export default SmartList;