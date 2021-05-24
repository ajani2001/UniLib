import React from "react";
import Author from "./Author";
import AuthorCreate from "./AuthorCreate";

class AuthorList extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            loaded: false,
            authors: []
        }
    }

    componentDidMount() {
        fetch('/api/author/')
            .then(response => response.ok ?
                response.json() :
                new Promise((resolve, reject) => reject(response.error()))
            )
            .then(json => this.setState({
                    loaded: true,
                    authors: json
                }),
                error => alert("Error " + error));
    }

    onAuthorDeleted = (id) => {
        this.setState((oldState, props) => {
            return {
                authors: oldState.authors.filter((elem) => elem.id !== id)
            }
        })
    }

    onAuthorEdited = (editedAuthor) => {
        this.setState((prevState, props) => {
            return {
                authors: prevState.authors.map((elem) =>
                    elem.id === editedAuthor.id ?
                        editedAuthor :
                        elem
                )
            };
        });
    }

    onAuthorCreated = (createdAuthor) => {
        this.setState((prevState, props) => {
            return {
                authors: prevState.authors.concat([createdAuthor])
            }
        });
    }

    render() {
        if(this.state.loaded) {
            return (
                <div className="author-list">
                    {this.state.authors.map((author) =>
                        <Author key={author.id} onAuthorDeleted={this.onAuthorDeleted}
                                onAuthorEdited={this.onAuthorEdited} author={author}/>)}
                    <AuthorCreate onAuthorCreated={this.onAuthorCreated}/>
                </div>
            );
        } else {
            return(
                <div className="author-list">
                    <label>Loading...</label>
                </div>
            );
        }
    }
}

export default AuthorList;