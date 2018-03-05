package agencias

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.*

class AgenciaControllerSpec extends Specification implements ControllerUnitTest<AgenciaController>{

    def setup() {
    }

    def cleanup() {
    }


    void "Test the index view"() {
        given:
            MyService myService = Mock()
            controller.myService = myService
        when:
            controller.index()
        then:
            view == '/agencia/index.gsp'
    }

    void "Test the agencias view"() {
        given:
            MyService myService = Stub(MyService) {
                getDirection(_) >> ["-31", "61"]
            }
            controller.myService = myService
        when:
            controller.agencias()
        then:
            view == '/agencia/agencias.gsp'
    }

    void "Test the model index"() {
        given:
            MyService myService = Stub(MyService) {
                getPaymentMethods() >> ["rapipago", "pagofacil"]
            }
            controller.myService = myService
        when:
            def model = controller.index()
        then:
            model.listaPaymentMethods.size() == 2
    }

}






