
class Location {
    constructor(lat, lng, descripcion) {
        this.lat = lat;
        this.lng = lng;
        this.descripcion = descripcion;
    }
}

var locations = []

function createLocation(location, descripcion){
    var location = location.split(",");
    var l = new Location(Number(location[0]), Number(location[1]), descripcion);
    locations.push(l);
}

$( document ).ready(function() {
    $('#exampleModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) // Button that triggered the modal
        var agencia = button.data('agencia');
        var direccion = button.data('dir');
        var ciudad = button.data('ciudad');
        var pais = button.data('pais');
        var otraInfo = button.data('otraInfo');
        var estado = button.data('estado');
        var codigoPostal = button.data('codigoPostal');

        var modal = $(this);
        modal.find('.modal-title').text(agencia);
        $("#direccion-modal").text(direccion);
        $("#ciudad-modal").text(ciudad);
        $("#pais-modal").text(pais);
        $("#otra-info-modal").text(otraInfo);
        $("#estado-modal").text(estado);
        $("#codigo-postal-modal").text(codigoPostal);
    })
});