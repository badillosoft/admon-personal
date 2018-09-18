// Alan Badillo Salas (badillo.soft@hotmail.com)
// -- Crear una tabla dinámica basada en DataFrames

class Dashboard {
    
	constructor(el, title="Sin nombre", id=null) {
        this.el = el;
        this.id = id || Math.random().toString(16).slice(2);
        this.code = `
        <div id="dashboard-${this.id}" class="dashboard">
            <h1 id="dashboard-title-${this.id}">${title}</h1>
            <table id="dashboard-table-${this.id}">
                <thead id="dashboard-table-head-${this.id}"></thead>
                <tbody id="dashboard-table-body-${this.id}"></tbody>
            </table>
        </div>
        `;
        if (el) {
            this.mount(el);
        }
        this._mapping = {};
        this._hidden = [];
    }

    mount(el) {
        this.el = el;
        this.el.innerHTML += this.code;

        this.$dashboard = document.querySelector(`#dashboard-${this.id}`);
        this.$title = document.querySelector(`#dashboard-title-${this.id}`);
        this.$table = document.querySelector(`#dashboard-table-${this.id}`);
        this.$head = document.querySelector(`#dashboard-table-head-${this.id}`);
        this.$body = document.querySelector(`#dashboard-table-body-${this.id}`);
    }

    refresh(data) {
    	const mapping = this._mapping;
        const hidden = this._hidden;
        if (data.length > 0) {
            while (this.$head.firstChild) {
                this.$head.removeChild(this.$head.firstChild);
            }
            const tr_head = document.createElement("tr");
            const keys = Object.keys(data[0]);
            for (let key of keys) {
                if (hidden.indexOf(key) >= 0) {
                    continue;
                }
                let th = document.createElement("th");
                th.innerHTML = key.toUpperCase().replace("_", " ");
                tr_head.appendChild(th);
            }
            this.$head.appendChild(tr_head);
        } else {
            this.$dashboard.innerHTML += "<span>No hay registros que mostrar</span>";
        }

        while (this.$body.firstChild) {
            this.$body.removeChild(this.$body.firstChild);
        }
        for (let entity of data) {
            let tr = document.createElement("tr");
            for (let key in entity) {
                if (hidden.indexOf(key) >= 0) {
                    continue;
                }
                let td = document.createElement("td");
                let value = entity[key];
                if (mapping[key]) {
                    value = mapping[key](value);
                }
                td.innerHTML = value;
                tr.appendChild(td);
            }
            this.$body.appendChild(tr);
        }
    }

    mapping(mapping) {
        this._mapping = mapping;
    }

    ignore(hidden) {
        this._hidden = hidden;
    }
    
    async collect(url, map = (data) => data) {
        const response = await fetch(url);
        if (!response.ok) {
            this.$dashboard.innerHTML = "Error al obtener los datos";
            return;
        }
        const data = await response.json();
        this.refresh(map(data));
    }

};