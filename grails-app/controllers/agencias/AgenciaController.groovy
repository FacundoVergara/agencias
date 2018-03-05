package agencias

import exceptions.IncompleteFieldException
import grails.validation.ValidationException
import groovy.json.JsonSlurper

import static org.springframework.http.HttpStatus.*

class AgenciaController {

    MyService myService

    def index() {
        try {
            def mediosDePago = myService.getPaymentMethods()
            [listaPaymentMethods: mediosDePago]
        } catch (Exception e) {
            e.printStackTrace()
            flash.error = e.getMessage()
            redirect action: 'index'
        }
    }

    def agencias() {
        try {
            def dir = myService.getDirection(params.direccion)
            def latitud = dir[0]
            def longitud = dir[1]
            def agencias = myService.getAgencias(params.medioPago, latitud, longitud, params.radio)
            [agencias: agencias]
        } catch (IncompleteFieldException ex) {
            ex.printStackTrace()
            flash.error = ex.getMessage()
            redirect action: 'index'
        } catch (Exception e) {
            e.printStackTrace()
            flash.error = e.getMessage()
            render(view: 'index')
        }
    }

}
