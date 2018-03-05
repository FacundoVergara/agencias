<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>
        <meta name="layout" content="main"/>
    </head>
    <body>
    <div class="container">
        <br>
        <g:if test="${flash.error}">
            <div class="alert alert-danger" style="display: block">${flash.error}</div>
        </g:if>
        <g:if test="${flash.success}">
            <div class="alert alert-success" style="display: block">${flash.success}</div>
        </g:if>


        <g:form action="agencias">
            <div class="form-group row">
                <label for="direccion" class="col-sm-2 col-form-label"
                       align="center" style="padding-right: 0;">Direccion:</label>
                <div class="col-sm-7">
                    <input type="text" id="direccion" name="direccion" class="form-control" value="Lima 78, Córdoba">
                </div>
            </div>
            <br>
            <div class="form-group row">
                <label for="medioPago" class="col-sm-2 col-form-label"
                       align="center" style="padding-right: 0;">Medio de pago:</label>
                <div class="col-sm-7">
                    <select name="medioPago" id="medioPago" class="form-control">
                        <g:each in="${listaPaymentMethods}" var="metodo" value="pagofacil">
                            <option value="${metodo?.id}">${metodo?.name}</option>
                        </g:each>
                    </select>
                </div>
            </div>
            <br>
            <div class="form-group row">
                <label for="radio" class="col-sm-2 col-form-label"
                       align="center" style="padding-right: 0;">Radio:</label>
                <div class="col-sm-7">
                    <input type="number" id="radio" name="radio" value="1000" class="form-control">
                </div>
            </div>
            <br>
            <div class="row" align="center">
                <g:submitButton name="submit" class="btn btn-success" value="Buscar"/>
            </div>
        </g:form>

    </body>
</html>