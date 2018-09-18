async function load_config(filename, config = {}) {
	const response = await fetch(`config/${filename}.json`);
	
	if (response.ok) {
		let data = await response.json();
		for (let key in data) {
			config[key] = data[key];
		}
	} else {
		console.log("Error al cargar la configuración", filename);
	}
	
	return config;
}