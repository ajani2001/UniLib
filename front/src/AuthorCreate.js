import React from 'react';

class AuthorCreate extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            name: "",
            activated: false,
            sent: false
        }
    }

    onCreateButtonClick = () => {
        this.setState((prevState, props) => {
            if(prevState.sent) {
                return {};
            } else {
                return {
                    activated: true
                }
            }
        });
    }

    onCancelButtonClick = () => {
        this.setState((prevState, props) => {
            if(prevState.sent) {
                return {};
            } else {
                return {
                    name: "",
                    activated: false
                }
            }
        })
    }

    onSaveButtonClick = () => {
        this.setState((prevState, props) => {
            if(prevState.sent)
                return {};

            return {
                sent: true
            };
        });
    }

    onNameFieldEdit = (event) => {
        this.setState((prevState, props) => {
            if(prevState.sent) {
                return {};
            } else {
                return {
                    name: event.target.value
                }
            }
        });
    }

    componentDidUpdate(prevProps, prevState, snapshot) {
        if(!prevState.sent && this.state.sent) {
            fetch('http://127.0.0.1:10004/api/author/', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json;charset=utf-8'
                },
                body: JSON.stringify({
                    name: prevState.name
                })
            })
                .then(response => response.ok ?
                    response.json() :
                    new Promise((resolve, reject) => reject(response.error()))
                )
                .then(json => {
                        this.props.onAuthorCreated(json);
                        this.setState({
                            sent: false,
                            activated: false,
                            name: ""
                        });
                    },
                    error => {
                        this.setState({
                            sent: false
                        });
                        alert("Error: " + error);
                    });
        }
    }

    render() {
        if(this.state.activated) {
            return this.state.sent ?
                (<div className="author-create">
                    <label>Sending...</label>
                </div>) :
                (<div className="author-create">
                        <input type="text" value={this.state.name} onChange={this.onNameFieldEdit} />
                        <button onClick={this.onSaveButtonClick}>save</button>
                        <button onClick={this.onCancelButtonClick}>cancel</button>
                </div>);
        } else {
            return (
                <div className="author-create">
                    <button onClick={this.onCreateButtonClick}>create</button>
                </div>
            );
        }
    }
}

export default AuthorCreate;