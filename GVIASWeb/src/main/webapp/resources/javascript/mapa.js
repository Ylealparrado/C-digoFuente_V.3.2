var format = 'image/png';
var bounds = [-81.7356205339999, -4.22593843899995,
                    -66.8568895799999, 13.3947277620001];

var municipioSelected = 'ninguno';

var layerSwitcher;

//Proyección MAGNA-SIRGAS EPSG:4686
var projection = new ol.proj.Projection({
      code: 'EPSG:4686',
      units: 'degrees',
      axisOrientation: 'neu'
  });


//var container = document.getElementById('popup');
//var content = document.getElementById('popup-content');
//var closer = document.getElementById('popup-closer');
//alert (container);
//alert (content);
//alert (closer);

//var overlay = new ol.Overlay({
//  element: container,
//  autoPan: {
//    animation: {
//      duration: 250,
//    },
//  },
//});


//Capa municipio WFS
//var municipio_wfs = new ol.layer.Vector({
//  source: new ol.source.Vector({
//    format: new ol.format.GeoJSON(),
//    url: function(extent) {
//      return  'http://localhost:8080/geoserver/vias/ows?service=WFS&version=1.0.0&request=GetFeature&typename=vias:geo_municipio&outputFormat=application/json&CQL_FILTER=mpnombre=\''+municipioSelected+'\'';
//    }
//  })
//});

//Capa municipio WMS
var municipio_wms = new ol.layer.Tile({
	opacity: 0.5,
//	maxZoom: 5,
//	minZoom: 10,
	title: 'Municipios',
	visible: false,
    source: new ol.source.TileWMS({
      url: 'http://localhost:8080/geoserver/vias/wms',
      params: {'LAYERS': 'vias:geo_municipio', 'TILED': true},
      serverType: 'geoserver'
    })
});

//Capa departamento WMS
var departamento_wms = new ol.layer.Tile({
	opacity: 0.5,
	maxZoom: 10,
	title: 'Departamentos',
	visible: false,
    source: new ol.source.TileWMS({
      url: 'http://localhost:8080/geoserver/vias/wms',
      params: {'LAYERS': 'vias:geo_departamento', 'TILED': true},
      serverType: 'geoserver',
    })
});

//Capa vereda WMS
var vereda_wms = new ol.layer.Tile({
	opacity: 0.5,
//	maxZoom: 5,
	title: 'Vereda',
	visible: false,
    source: new ol.source.TileWMS({
      url: 'http://localhost:8080/geoserver/vias/wms',
      params: {'LAYERS': 'vias:geo_vereda', 'TILED': true},
      serverType: 'geoserver',
    })
});

//Capa geo_parque_wms WMS
var geo_parque_wms = new ol.layer.Tile({
	opacity: 0.5,
//	maxZoom: 5,
	title: 'Parque Natural',
	visible: false,
    source: new ol.source.TileWMS({
      url: 'http://localhost:8080/geoserver/vias/wms',
      params: {'LAYERS': 'vias:geo_ambiental_0_parque', 'TILED': true},
      serverType: 'geoserver',
    })
});

//Capa geo_zona_interes_wms WMS
var geo_zona_interes_wms = new ol.layer.Tile({
	opacity: 0.5,
//	maxZoom: 5,
	title: 'Zona Interés Natural',
	visible: false,
    source: new ol.source.TileWMS({
      url: 'http://localhost:8080/geoserver/vias/wms',
      params: {'LAYERS': 'vias:geo_ambiental_1_interes', 'TILED': true},
      serverType: 'geoserver',
    })
});

//Capa geo_bosque_wms WMS
var geo_bosque_wms = new ol.layer.Tile({
	opacity: 0.5,
//	maxZoom: 5,
	title: 'Bosque',
	visible: false,
    source: new ol.source.TileWMS({
      url: 'http://localhost:8080/geoserver/vias/wms',
      params: {'LAYERS': 'vias:geo_ambiental_2_bosque', 'TILED': true},
      serverType: 'geoserver',
    })
});

//Capa geo_zona_humeda_wms WMS
var geo_zona_humeda_wms = new ol.layer.Tile({
	opacity: 0.5,
//	maxZoom: 5,
	title: 'Zona Húmeda',
	visible: false,
    source: new ol.source.TileWMS({
      url: 'http://localhost:8080/geoserver/vias/wms',
      params: {'LAYERS': 'vias:geo_ambiental_3_humeda', 'TILED': true},
      serverType: 'geoserver',
    })
});

//Capa geo_corredor_wms WMS
var geo_corredor_wms = new ol.layer.Tile({
	opacity: 0.5,
//	maxZoom: 5,
	title: 'Corredor Natural',
	visible: false,
    source: new ol.source.TileWMS({
      url: 'http://localhost:8080/geoserver/vias/wms',
      params: {'LAYERS': 'vias:geo_ambiental_4_corredor', 'TILED': true},
      serverType: 'geoserver',
    })
});

//Capa geo_fauna_wms WMS
var geo_fauna_wms = new ol.layer.Tile({
	opacity: 0.5,
//	maxZoom: 5,
	title: 'Zona Fauna',
	visible: false,
    source: new ol.source.TileWMS({
      url: 'http://localhost:8080/geoserver/vias/wms',
      params: {'LAYERS': 'vias:geo_ambiental_5_fauna', 'TILED': true},
      serverType: 'geoserver',
    })
});


//Capa vias_inventario_wms WMS
var vias_inventario_wms = new ol.layer.Tile({
	title: 'Vías terciarias inventario',
    source: new ol.source.TileWMS({
      url: 'http://localhost:8080/geoserver/vias/wms',
      params: {'LAYERS': 'vias:geo_inv_tramovia', 'TILED': true},
      serverType: 'geoserver',
    })
});

//Capa vias_primarias_wms WMS
var vias_primarias_wms = new ol.layer.Tile({
	title: 'Vías primarias',
    source: new ol.source.TileWMS({
      url: 'http://localhost:8080/geoserver/vias/wms',
      params: {'LAYERS': 'vias:geo_via_primaria', 'TILED': true},
      serverType: 'geoserver',
    })
});

//Capa vias_secundarias_wms WMS
var vias_secundarias_wms = new ol.layer.Tile({
	title: 'Vías secundarias',
    source: new ol.source.TileWMS({
      url: 'http://localhost:8080/geoserver/vias/wms',
      params: {'LAYERS': 'vias:geo_via_secundaria', 'TILED': true},
      serverType: 'geoserver',
    })
});
	
//Capa centros_salud_wms WMS
var centros_salud_wms = new ol.layer.Tile({
	title: 'Centros de salud',
	visible: false,
    source: new ol.source.TileWMS({
      url: 'http://localhost:8080/geoserver/vias/wms',
      params: {'LAYERS': 'vias:geo_centro_sanitario', 'TILED': true},
      serverType: 'geoserver',
    })
});

//Capa centros_educacions_wms WMS
var centros_educacion_wms = new ol.layer.Tile({
	title: 'Centros educativos',
	visible: false,
    source: new ol.source.TileWMS({
      url: 'http://localhost:8080/geoserver/vias/wms',
      params: {'LAYERS': 'vias:geo_sede_educativa', 'TILED': true},
      serverType: 'geoserver',
    })
});

//Capa zona_pdet_wms WMS
var zona_pdet_wms = new ol.layer.Tile({
	title: 'Zona PDET',
	opacity: 0.5,
	visible: false,
    source: new ol.source.TileWMS({
      url: 'http://localhost:8080/geoserver/vias/wms',
      params: {'LAYERS': 'vias:geo_zona_pdet', 'TILED': true},
      serverType: 'geoserver',
    })
});

var vectorStyle = new ol.style.Style({
    stroke: new ol.style.Stroke({
      color: 'rgba(0, 0, 255, 1.0)',
      width: 2,
    }),
	text: new ol.style.Text({
      text: '',
   	  fill: new ol.style.Fill({color: 'rgba(0, 0, 255, 1.0)'}),
	  stroke: new ol.style.Stroke({
         color: 'white',
         width: 3,
    	}),
	  scale: 2,
	  offsetX: 50,
	  offsetY: 50
//      placement: 'line'
    }),
  });

//Capa para marcas
var vector = new ol.layer.Vector({
  source:  new ol.source.Vector(),
  title: 'Selección',
  style: vectorStyle,
});


//Capa OSM base
var capa_base = new ol.layer.Tile({
    source: new ol.source.OSM()
  });

var divisionesGroup = new ol.layer.Group({
        // A layer must have a title to appear in the layerswitcher
        title: 'División Administrativa',
        // Adding a 'fold' property set to either 'open' or 'close' makes the group layer
        // collapsible
//        fold: 'close',
        layers: [departamento_wms, municipio_wms, vereda_wms]
	 });

var ambientalGroup = new ol.layer.Group({
        // A layer must have a title to appear in the layerswitcher
        title: 'Zonas Ambientales',
        // Adding a 'fold' property set to either 'open' or 'close' makes the group layer
        // collapsible
//        fold: 'close',
        layers: [geo_fauna_wms, geo_corredor_wms, geo_zona_humeda_wms, geo_bosque_wms, geo_zona_interes_wms, geo_parque_wms]
	 });


var viasGroup = new ol.layer.Group({
        // A layer must have a title to appear in the layerswitcher
        title: 'Vías',
        // Adding a 'fold' property set to either 'open' or 'close' makes the group layer
        // collapsible
//        fold: 'close',
        layers: [vias_secundarias_wms, vias_primarias_wms, vias_inventario_wms]
	 });

//Mapa/View
var map = new ol.Map({
	controls: ol.control.defaults().extend([new ol.control.FullScreen()]),
    target: 'map',
    layers: [
	capa_base,
	divisionesGroup,
	ambientalGroup,
	zona_pdet_wms,
	viasGroup,
	centros_educacion_wms,
	centros_salud_wms,
	vector
    ],
//	overlays: [overlay],
    view: new ol.View({
       projection: 'EPSG:4326',
    	maxZoom: 17,
		minZoom: 5,
		zoom: 2
    })
  });


if(typeof layerSwitcher === 'undefined'){
  layerSwitcher = new ol.control.LayerSwitcher({
    tipLabel: 'Leyenda',
    groupSelectStyle: 'children',
	activationMode: 'click'
  });
} else {
  console.log("layerSwitcher ya está definido");
}

map.addControl(layerSwitcher);

//extent inicial
map.getView().fit(bounds, map.getSize());

//map.addControl(new ol.control.ZoomSlider());

capa_base.once('postrender', function(event) {
      const featureRequest = new ol.format.WFS().writeGetFeature({
	  srsName: 'EPSG:4686',
	  featureNS: 'vias',
	  featurePrefix: 'vias',
	  featureTypes: ['geo_municipio'],
	  outputFormat: 'application/json',
	  filter: new ol.format.filter.equalTo('mpnombre', municipioSelected)
	});
	
	// then post the request and add the received features to a layer
	fetch('http://localhost:8080/geoserver/wfs', {
	  method: 'POST',
	  body: new XMLSerializer().serializeToString(featureRequest),
	})
	  .then(function (response) {
	    return response.json();
	  })
	  .then(function (json) {
	    const features = new ol.format.GeoJSON().readFeatures(json);
	    vector.getSource().addFeatures(features);
	    map.getView().fit(vector.getSource().getExtent(), { duration: 1000 });
	  });
});


function setMunicipio(nombreMunicipio) {
	municipioSelected = nombreMunicipio;
}

function centrarVia(codVia) {
	const featureRequest = new ol.format.WFS().writeGetFeature({
	  srsName: 'EPSG:4686',
	  featureNS: 'vias',
	  featurePrefix: 'vias',
	  featureTypes: ['geo_inv_tramovia'],
	  outputFormat: 'application/json',
	  filter: new ol.format.filter.equalTo('codigovia', codVia)
	});
	
	// then post the request and add the received features to a layer
	fetch('http://localhost:8080/geoserver/wfs', {
	  method: 'POST',
	  body: new XMLSerializer().serializeToString(featureRequest),
	})
	  .then(function (response) {
	    return response.json();
	  })
	  .then(function (json) {
	    const features = new ol.format.GeoJSON().readFeatures(json);
		vector.getSource().clear();
	    vector.getSource().addFeatures(features);
		vector.getStyle().getText().setText(features[0].get("codigovia"));
	    map.getView().fit(vector.getSource().getExtent(), { duration: 1000 });
	  });
}

//closer.onclick = function () {
//  overlay.setPosition(undefined);
//  closer.blur();
//  return false;
//};

//map.on('singleclick', function (evt) {
//  var coordinate = evt.coordinate;
//  var hdms = ol.coordinate.toStringHDMS(ol.proj.toLonLat(coordinate));
//
//  content.innerHTML = '<p>You clicked here:</p><code>' + hdms + '</code>';
//  overlay.setPosition(coordinate);
//});