      var format = 'image/png';
      var bounds = [-81.7356205339999, -4.22593843899995,
                    -66.8568895799999, 13.3947277620001];
   
var vector = new ol.layer.Vector({
  source: new ol.source.Vector({
    format: new ol.format.GeoJSON(),
    url: function(extent) {
      return  'http://localhost:8081/geoserver/vias/wfs?' +
              'service=WFS&' +
              'version=1.0.0&request=GetFeature&typename=vias:geo_departamento&maxFeatures=50&'+
              'outputFormat=application/json';
    }
  })
});
	  
	  var raster = new ol.layer.Tile({
		source: new ol.source.OSM()
		});

      var projection = new ol.proj.Projection({
          code: 'EPSG:4686',
          units: 'degrees',
          axisOrientation: 'neu'

      });
      var map = new ol.Map({
        target: 'map',
        layers: [
         vector
        ],
        view: new ol.View({
           projection: projection
        })
      });
     
      map.getView().fit(bounds, map.getSize());