package agencias

class Direccion {

    String pais
    String ciudad
    String descripcion
    String latitud
    String longitud
    String otraInfo
    String estado
    String codigoPostal
    static belongsTo = [agencia:Agencia]

    static constraints = {
        pais blank: false, nullable: false
        ciudad blank: false, nullable: false
        descripcion blank: false, nullable: false
        latitud blank: false, nullable: false
        longitud blank: false, nullable: false
        otraInfo blank: false, nullable: false
        pais blank: false, nullable: false
        estado blank: false, nullable: false
        codigoPostal blank: false, nullable: false
    }
}
