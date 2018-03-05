package agencias

import grails.gorm.services.Service

@Service(MedioPago)
interface MedioPagoService {

    MedioPago get(Serializable id)

    List<MedioPago> list(Map args)

    Long count()

    void delete(Serializable id)

    MedioPago save(MedioPago medioPago)

}