initMap = function() {

    var latitudes = []
    var longitudes = []
    for (i = 0; i < locations.length; i++) {
        latitudes.push(locations[i].lat);
        longitudes.push(locations[i].lng);
    }
    var sumLat= latitudes.reduce(function(a, b) { return a + b; });
    var avgLat = sumLat / latitudes.length;
    var sumLng= longitudes.reduce(function(a, b) { return a + b; });
    var avgLong = sumLng / longitudes.length;

    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 13,
        center: new google.maps.LatLng(avgLat, avgLong),
        mapTypeId: google.maps.MapTypeId.ROADMAP
    });

    var infowindow = new google.maps.InfoWindow();
    var marker, i;

    for (i = 0; i < locations.length; i++) {
        marker = new google.maps.Marker({
            position: new google.maps.LatLng(locations[i].lat, locations[i].lng),
            map: map
        });

        google.maps.event.addListener(marker, 'click', (function(marker, i) {
            return function() {
                infowindow.setContent(locations[i].descripcion);
                infowindow.open(map, marker);
            }
        })(marker, i));
    }
}