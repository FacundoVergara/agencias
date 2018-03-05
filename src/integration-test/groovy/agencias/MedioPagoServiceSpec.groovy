package agencias

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MedioPagoServiceSpec extends Specification {

    MedioPagoService medioPagoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new MedioPago(...).save(flush: true, failOnError: true)
        //new MedioPago(...).save(flush: true, failOnError: true)
        //MedioPago medioPago = new MedioPago(...).save(flush: true, failOnError: true)
        //new MedioPago(...).save(flush: true, failOnError: true)
        //new MedioPago(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //medioPago.id
    }

    void "test get"() {
        setupData()

        expect:
        medioPagoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<MedioPago> medioPagoList = medioPagoService.list(max: 2, offset: 2)

        then:
        medioPagoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        medioPagoService.count() == 5
    }

    void "test delete"() {
        Long medioPagoId = setupData()

        expect:
        medioPagoService.count() == 5

        when:
        medioPagoService.delete(medioPagoId)
        sessionFactory.currentSession.flush()

        then:
        medioPagoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        MedioPago medioPago = new MedioPago()
        medioPagoService.save(medioPago)

        then:
        medioPago.id != null
    }
}
