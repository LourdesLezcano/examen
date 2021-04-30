<%-- 
    Document   : Alumno
    Created on : 30/04/2021, 01:35:16 PM
    Author     : Lourdes Lezcano
--%>
<%@page import="clases.Sesion"%>
<%@page import="clases.Conexion"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ABM ALUMNOS</title>
        <meta name="viewport" content="width=device-width, initial-scale=1"> <%-- se encarga de hacer que sea adaptable a cualquier dispositivo--%>
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../css/alertify.core.css">
        <link href="../css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="../css/alertify.default.css">
        <link rel="stylesheet" type="text/css" href="../css/menuresponsive.css"/>
        <link rel="stylesheet" type="text/css" href="../css/chosenselect.css">

    </head>
    <body>

        <br>
        <br>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-primary ">
                        <div class="panel-heading" style="text-align: center;font-size: 25px">
                            ALUMNOS
                        </div>
                        <br> 

                        <div class="row">
                            <div class="col-md-12">

                                <form id="formulario" class="form-horizontal" role="form">
                                    <div class="form-group">
                                        <div class="col-md-3"></div>
                                        <div class="col-md-2">
                                            <label class="control-label" for="codigo" style= "color:#063847">Código</label> 
                                        </div>
                                        <div class="col-md-2">
                                            <input type="text" name="txtcodigo" id="txtcodigo" class="form-control" placeholder="Autoincrementable" disabled/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-md-3"></div>
                                        <div class="col-md-2">
                                            <label class="control-label" for="codigo" style= "color:#063847">Nombres</label> 
                                        </div>
                                        <div class="col-md-4">
                                            <input type="text" name="txtnombre" id="txtnombre" class="form-control" placeholder="Ingrese Nombre" disabled=""/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-3"></div>
                                        <div class="col-md-2">
                                            <label class="control-label" for="codigo" style= "color:#063847">Apellidos</label> 
                                        </div>
                                        <div class="col-md-4">
                                            <input type="text" name="txtapellido" id="txtapellido" class="form-control" placeholder="Ingrese Apellido" disabled=""/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-3"></div>
                                        <div class="col-md-2">
                                            <label class="control-label" for="codigo" style= "color:#063847">Nº Documento</label> 
                                        </div>
                                        <div class="col-md-4">
                                            <input type="text" name="txtndoc" id="txtndoc" class="form-control" placeholder="Ingrese numero de CI" disabled=""/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-3"></div>
                                        <div class="col-md-2">
                                            <label class="control-label" for="carrera"style= "color:#000">Carrera</label> 
                                        </div>
                                        <div class="col-md-2">
                                            <select class="form-control chosen-select" name="cbocarrera" id="cbocarrera">
                                                <option value="0">--- Seleccione carrera ---</option>
                                                <%
                                                    Conexion cn = new Conexion();
                                                    cn.conectar();
                                                    ResultSet rsalumnos = cn.consultar("select * from carreras order by id_carrera");
                                                    while (rsalumnos.next()) {
                                                %>
                                                <option value="<%= rsalumnos.getString("id_carrera")%>"> <%= rsalumnos.getString("descripcion")%></option>
                                                <%

                                                    }
                                                %>
                                            </select>
                                        </div>
                                        <div class="col-md-2">
                                            <strong><a href="./carreras.jsp" style="text-decoration: none"><input id="btnAgregarCarrera" type="button" class="form-control btn-primary" value="Agregar Carrera" title="SALIR"></a></strong>

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

                                    <div class="form-group" id="panel">
                                        <div class="col-md-3"></div>
                                        <div class="col-md-6">
                                            <table class="table table-hover" id="grilla">
                                                <thead>
                                                    <tr>
                                                        <th class="primary"style= "color:#063847">Código</th>
                                                        <th class="primary"style= "color:#063847">Nombres</th>
                                                        <th class="primary"style= "color:#063847">Apellidos</th>
                                                        <th class="primary"style= "color:#063847">N° Documento</th>
                                                        <th class="hidden">Id Carrera</th>
                                                        <th class="primary"style>Carrera</th>

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
        <script src="../js/chosenselect.js"></script> 
        <script src="Alumno.js"></script> 
    </body>
</html>
