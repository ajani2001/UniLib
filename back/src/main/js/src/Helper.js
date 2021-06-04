class Helper {
    static fetchJson() {
        return fetch(...arguments)
            .then(response => response.ok?
                response.json():
                Promise.reject(response.status));
    }

    static formatDate(date) {
        const offset = date.getTimezoneOffset();
        return new Date(date.getTime()-offset*60*1000).toISOString().slice(0,10);
    }
}

export default Helper;