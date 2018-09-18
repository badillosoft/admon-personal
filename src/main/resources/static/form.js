class Form {
	
	constructor(parent, options = {}) {
		options.method = options.method || "post";
		this.options = options;
		this.$parent = parent || null;
		this.id = options.id || Math.random().toString(16).slice(2);
		
		this.$main = document.createElement("div");
		this.$main.className = "form";
		if (this.$parent) {
			this.$parent.appendChild(this.$main);
		}
		
		this.$title = document.createElement("h1");
		this.$title.innerHTML = `${options.title}`;
		this.$main.appendChild(this.$title);
		
		this.$form = document.createElement("form");
		this.$form.id = `form-${this.id}`;
		this.$form.name = `form-${this.id}`;
		this.$form.action = options.url;
		this.$form.method = options.method;
		window.onsubmit = (e) => {
			e.preventDefault();
			if (e.target.name === this.$form.name) {
				this.submit(e.target);
			}
		};
		this.$main.appendChild(this.$form);
		for (let field of (options.fields || [])) {
			let $field = document.createElement("input");
			$field.id = field.id || field.name || Math.random().toString(16).slice(2);
			$field.name = $field.id;
			for (let key in field) {
				$field[key] = field[key];
			}
			this.$form.appendChild($field);
		}
	}
	
	async submit(form) {
		const elements = [];
		for (let el of form.elements) {
			elements.push(el);
		}
		const data = elements.map(el => {
			let value = el.value;
			if (el.type === "date") {
				try {
					value = new Date(value).toISOString()
						.replace("T", " ").replace("Z", "");
				} catch(e) {
					console.log("fecha inválida");
				}
			}
			return el.name ? { [el.name]: value } : {};
		}).reduce((p, c) => {
			return Object.assign(p, c);
		}, {});
		
		console.log(data);
		
		if (this.options.mapData) {
			for (let key in this.options.mapData) {
				data[key] = this.options.mapData[key](data[key], data);
			}
		}
		const query = [];
		const formData = new FormData();
		for (let key in data) {
			formData.append(key, data[key]);
			query.push(`${key}=${data[key]}`);
		}
		const options = {
			method: form.method
		}
		let url = form.action;
		if (form.method !== "get") {
			options.body = formData;
		} else {
			url += `?${query.join("&")}`
		}
		const response = await fetch(url, options);
		const result = await response.json();
		console.log(result);
		if (!response.ok) {
			if (this.options.error) {
				this.options.error(result);
			}
			return;
		}
		if (this.options.success) {
			this.options.success(result);
		}
	};
	
}