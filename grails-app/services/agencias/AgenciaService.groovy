package agencias

import grails.gorm.services.Service

@Service(Agencia)
interface AgenciaService {

    Agencia get(Serializable id)

    List<Agencia> list(Map args)

    Long count()

    void delete(Serializable id)

    Agencia save(Agencia agencia)

}