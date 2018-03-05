package agencias

class Agencia {

    String siteID
    String nombre
    String descripcion
    String distancia

    static constraints = {
        siteID blank: false, nullable: false
        nombre blank: false, nullable: false
        descripcion blank: false, nullable: false
    }
}
