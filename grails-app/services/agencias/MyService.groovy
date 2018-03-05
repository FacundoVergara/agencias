package agencias

import exceptions.IncompleteFieldException
import grails.gorm.transactions.Transactional
import groovy.json.JsonSlurper

@Transactional
class MyService {

    def getPaymentMethods() {
        def url = new URL('https://api.mercadolibre.com/sites/MLA/payment_methods')
        def connection = (HttpURLConnection)url.openConnection()
        connection.setRequestMethod("GET")
        connection.setRequestProperty("Accept", "application/json")
        connection.setRequestProperty("User-Agent", "Mozilla/5.0")
        JsonSlurper json = new JsonSlurper()
        List paymentMethods = json.parse(connection.getInputStream())
        return paymentMethods
    }

    def getDirection(direccion) {
        validarCampo(direccion, "dirección")
        String d = direccion;
        def url = new URL("https://maps.googleapis.com/maps/api/geocode/json?address=${URLEncoder.encode(d, "UTF-8")}&key=AIzaSyDtGX-dCr_9oXN4_DOJZMm3AnGrfKaL67A")
        def connection = (HttpURLConnection)url.openConnection()
        connection.setRequestMethod("GET")
        connection.setRequestProperty("Accept", "application/json")
        connection.setRequestProperty("User-Agent", "Mozilla/5.0")
        JsonSlurper json = new JsonSlurper()
        def dir = json.parse(connection.getInputStream())
        def lat = dir.results.geometry.location.lat
        def lng = dir.results.geometry.location.lng
        def latLng = [lat[0], lng[0]]
        return latLng
    }

    def getAgencias(medioPago, lat, lng, radio) {
        validarCampo(medioPago, "medio de pago")
        validarCampo(lat, "lat")
        validarCampo(lng, "lng")
        validarCampo(radio, "radio")

        def url = new URL("https://api.mercadolibre.com/sites/MLA/payment_methods/${medioPago}/agencies?near_to=${lat},${lng},${radio}&limit=10")
        def connection = (HttpURLConnection)url.openConnection()
        connection.setRequestMethod("GET")
        connection.setRequestProperty("Accept", "application/json")
        connection.setRequestProperty("User-Agent", "Mozilla/5.0")
        JsonSlurper json = new JsonSlurper()
        def agencias = json.parse(connection.getInputStream())
        return agencias.results
    }

    def validarCampo(campo, nombre) {
        if(campo == null || campo == "") {
            throw new IncompleteFieldException("Campo ${nombre} incompleto")
        }
    }

}
