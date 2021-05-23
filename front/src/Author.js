import React from "react";

class Author extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            sentPut: false,
            sentDelete: false,
            edited: false,
            editedName: props.author.name
        }
    }

    onEditButtonClick = () => {
        this.setState({
            edited: true
        });
    }

    onDeleteButtonClick = () => {
        this.setState((prevState, props) => {
            if(prevState.sentPut || prevState.sentDelete)
                return {};

            return {
                sentDelete: true
            };
        });
    }

    onEditedNameChange = (event) => {
        this.setState({
            editedName: event.target.value
        });
    }

    onSaveButtonClick = () => {
        this.setState((prevState, props) => {
            if(prevState.sentPut || prevState.sentDelete)
                return {};

            return {
                sentPut: true
            };
        });
    }

    onCancelButtonClick = () => {
        this.setState({
            edited: false,
            editedName: this.props.author.name
        });
    }

    componentDidUpdate(prevProps, prevState, snapshot) {
        if (!prevState.sentDelete && this.state.sentDelete) {
            fetch('http://127.0.0.1:10004/api/author/' + this.props.author.id, {method: 'DELETE'})
                .then(response => new Promise(
                    (resolve, reject) => response.ok ?
                        resolve(this.props.onAuthorDeleted(this.props.author.id)) :
                        reject(response.error())))
                .catch(reason => {
                    alert(reason);
                    this.setState({
                        sentDelete: false
                    });
                });
        }
        if (!prevState.sentPut && this.state.sentPut) {
            fetch('http://127.0.0.1:10004/api/author/' + this.props.author.id, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json;charset=utf-8'
                },
                body: JSON.stringify({
                    id: this.props.author.id,
                    name: this.state.editedName
                })
            })
                .then(response => response.ok ?
                    response.json() :
                    new Promise((resolve, reject) => reject(response.status)))
                .then(json => {
                        this.props.onAuthorEdited(json);
                        this.setState({
                            sentPut: false,
                            edited: false
                        });
                    },
                    error => {
                        this.setState({
                            sentPut: false
                        });
                        alert("Error: " + error);
                    });
        }
    }

    render() {
        if(this.state.sentPut || this.state.sentDelete) {
            return (<div className="author">
                <label>Loading...</label>
            </div>);
        } else {
            return this.state.edited ?
                (<div className="author">
                    <input type="text" value={this.state.editedName} onChange={this.onEditedNameChange} />
                    <button onClick={this.onSaveButtonClick}>save</button>
                    <button onClick={this.onCancelButtonClick}>cancel</button>
                </div>) :
                (<div className="author">
                    <label>{this.props.author.name}</label>
                    <button onClick={this.onEditButtonClick}>edit</button>
                    <button onClick={this.onDeleteButtonClick}>delete</button>
                </div>);
        }
    }
}

export default Author