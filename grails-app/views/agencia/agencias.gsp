<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <asset:javascript src="my.js"/>

    </head>
    <body>
        <div class="container" align="center">
            <table class="table table-striped custab">
                <thead>
                    <tr>
                        <th>Descripción</th>
                        <th>Distancia</th>
                        <th class="text-center">Action</th>
                    </tr>
                </thead>
                <g:each in="${agencias}" var="agencia">
                    <tr>
                        <td>${agencia?.description}</td>
                        <td>${agencia?.distance}</td>
                        <td class="text-center">
                            <button type="button" class="btn btn-primary btn-xs" data-toggle="modal"
                                    data-target="#exampleModal" data-whatever="@mdo"
                                    data-agencia = "${agencia?.description}"
                                    data-dir = "${agencia?.address?.address_line}"
                                    data-ciudad="${agencia?.address?.city}"
                                    data-pais="${agencia?.address?.country}"
                                    data-otraInfo="${agencia?.address?.other_info}"
                                    data-estado="${agencia?.address?.state}"
                                    data-codigoPostal="${agencia?.address?.zip_code}">
                                <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> Mas info
                            </button>
                        </td>
                    </tr>
                    <script>
                        createLocation("${agencia?.address?.location}", "${agencia?.description}");
                    </script>
                </g:each>
            </table>
        </div>


        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">New message</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div>
                            <b>Dirección:</b>
                            <label id="direccion-modal"></label>
                        </div>
                        <div>
                            <b>Ciudad:</b>
                            <label id="ciudad-modal"></label>
                        </div>
                        <div>
                            <b>País:</b>
                            <label id="pais-modal"></label>
                        </div>
                        <div>
                            <b>Otra Info:</b>
                            <label id="otra-info-modal"></label>
                        </div>
                        <div>
                            <b>Estado:</b>
                            <label id="estado-modal"></label>
                        </div>
                        <div>
                            <b>Código postal:</b>
                            <label id="codigo-postal-modal"></label>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="container" align="center">
            <div id="map" style="width: 800px; height: 400px;"></div>
            <asset:javascript src="maps.js"/>
        </div>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDtGX-dCr_9oXN4_DOJZMm3AnGrfKaL67A&callback=initMap"
                async defer></script>
    </body>
</html>