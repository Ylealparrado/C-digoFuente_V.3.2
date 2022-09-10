/**
 * 
 */

var map = L.map('map').setView([3.154377, -73.168945], 5);

var tiles = L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw', {
	maxZoom: 18,
	attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, ' +
		'Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
	id: 'mapbox/streets-v11',
	tileSize: 512,
	zoomOffset: -1
}).addTo(map);


//Departamentos
var ly_departamentos = new L.TileLayer.WMS('http://localhost:8081/geoserver/vias/wms', {
	layers: 'vias:geo_departamento',
	format: 'image/png',
	transparent: true,
	opacity: '0.7',
	version: '1.3.0',
//	minZoom: 6,
//	maxZoom: 9,
	crs: L.CRS.EPSG4686,
	name: 'Departamentos'
});

//Municipios
var ly_municipios = new L.TileLayer.WMS('http://localhost:8081/geoserver/vias/wms', {
	layers: 'vias:geo_municipio',
	format: 'image/png',
	transparent: true,
	opacity: '0.7',
//	minZoom: 9,
	version: '1.3.0',
	crs: L.CRS.EPSG4686,
	name: 'Municipios'
});

//Vias Inventario
var ly_vias_inventario = new L.tileLayer('http://localhost:8081/geoserver/vias/wms', {
	layers: 'vias:geo_inv_tramovia',
	format: 'image/png',
	transparent: true,
	version: '1.3.0',
//	minZoom: 12,
	crs: L.CRS.EPSG4686,
	name: 'Vías'
});

ly_departamentos.addTo(map);
//ly_municipios.addTo(map);

//var popup = L.popup();
//
//function onMapClick(e) {
//		
//	popup
//		.setLatLng(e.latlng)
//		.setContent('You clicked the map at ' + e.latlng.toString())
//		.openOn(map);
//}
//
//map.on('click', onMapClick);


	
//	markersById = [];
//
	var owsrootUrl = 'http://localhost:8081/geoserver/vias/ows';

	var defaultParameters = {
			service : 'WFS',
			version : '2.0',
			request : 'GetFeature',
			typeName : 'vias:geo_inv_tramovia',
			outputFormat : 'application/json',
//			featureid : ['PLAN01'],
			format_options : 'callback:getJson',
			SrsName : 'EPSG:4686'
	};

	var parameters = L.Util.extend(defaultParameters);
	var URL = owsrootUrl + L.Util.getParamString(parameters);

	$.ajax({
        url: URL,
        success: function (data) {
		var geojson = new L.geoJson(data, {
			style: {"color":"#2ECCFA","weight":2},
			onEachFeature: function(feature, layer){
				alert(feature.id);
				layer.bindPopup("Has hecho click en " + feature.codigovia);
			}}
		).addTo(map);
	}
	});
