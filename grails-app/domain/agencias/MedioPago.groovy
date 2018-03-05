package agencias

class MedioPago {

    String nombre
    String payment_method_id

    static constraints = {
        nombre blank: false, nullable: false
        payment_method_id blank: false, nullable: false
    }
}
