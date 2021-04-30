<%-- 
    Document   : carreras
    Created on : 30/04/2021, 02:51:41 PM
    Author     : Lourdes Lezcano
--%>

<%@page import="clases.Sesion"%>
<%@page import="clases.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CARRERAS</title>
        <meta name="viewport" content="width=device-width, initial-scale=1"> 
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../css/alertify.core.css">
        <link href="../css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="../css/alertify.default.css">
        <link rel="stylesheet" type="text/css" href="../css/menuresponsive.css"/>
    </head>
    <body>
              <br> 
        <br>
        <br>

        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-primary ">
                        <div class="panel-heading" style="text-align: center;font-size: 25px">
                           ABM CARRERAS
                        </div>
                        <br> 

                        <div class="row">
                            <div class="col-md-12">

                                <form id="formulario" class="form-horizontal" role="form">
                                    <div class="form-group">
                                        <div class="col-md-3"></div>
                                        <div class="col-md-2">
                                            <label class="control-label" for="codigo">Código</label> 
                                        </div>
                                        <div class="col-md-2">
                                            <input type="text" name="txtcodigo" id="txtcodigo" class="form-control" placeholder="Autoincrementable" disabled/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-3"></div>
                                        <div class="col-md-2">
                                            <label class="control-label" for="codigo" >Descripción</label> 
                                        </div>
                                        <div class="col-md-4">
                                            <input type="text" name="txtdescripcion" id="txtdescripcion" class="form-control" placeholder="Ingrese descripción" disabled=""/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-3"></div>

                                        <div class="col-md-2">
                                            <input id="btnAgregar" type="button" class="form-control btn-primary" value="Agregar" onclick="agregar();"/>
                                        </div>
                                        <div class="col-md-2">
                                            <input id="btnModificar" type="button" class="form-control btn-primary" value="Modificar" onclick="modificar();"/>
                                        </div>
                                        <div class="col-md-2">
                                            <input id="btnBorrar" type="button" class="form-control btn-primary" value="Borrar" onclick="borrar();"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-3"></div>
                                        <div class="col-md-2">
                                            <input id="btnCancelar" type="button" class="form-control btn-primary" value="Cancelar" disabled="" onclick="cancelar();"/>
                                        </div>
                                        <div class="col-md-2">
                                            <input id="btnGrabar" type="button" class="form-control btn-primary" value="Grabar" disabled="" onclick="grabar();"/>
                                        </div> 
                                    </div>
                                    <div class="form-group hidden" id="panel">
                                        <div class="col-md-3"></div>
                                        <div class="col-md-6">
                                            <table class="table table-hover" id="grilla">
                                                <thead>
                                                    <tr>
                                                        <th class="primary">Código</th>
                                                        <th class="primary">Descripción</th>
                                                    </tr>
                                                </thead>
                                                <tbody>

                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <input type="hidden" id="operacion"/>


                    </div>
                </div>
            </div>
        </div>
        <script src="../js/jquery-1.12.2.min.js"></script> 
        <script src="../js/bootstrap.min.js"></script> 
        <script src="../js/alertify.js"></script> 
        <script src="carreras.js"></script> 

        
    </body>
</html>
