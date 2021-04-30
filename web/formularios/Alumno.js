function agregar() {
    $("#txtdescripcion").removeAttr("disabled");
    $("#txtnombre").removeAttr("disabled");
    $("#txtapellido").removeAttr("disabled");
    $("#txtndoc").removeAttr("disabled");
    $("#cbocarrera").removeAttr("disabled").trigger("chosen:updated");
    $("#btnGrabar").removeAttr("disabled");
    $("#btnAgregarCarrera").removeAttr("disabled");
    $("#btnGrabar").removeAttr("disabled");
    $("#btnCancelar").removeAttr("disabled");
    $("#btncarrera").removeAttr("disabled");
    $("#btnAgregar").attr("disabled", "true");
    $("#btnModificar").attr("disabled", "true");
    $("#btnBorrar").attr("disabled", "true");
    $("#btnSalir").attr("disabled", "true");
   
    $("#panel").removeClass("hidden");
    $("#operacion").val("1");
    $.post("../ultimo_codigo", {campo: "id_alumnos", tabla: "alumnos"})
            .done(function (data) {
                $("#txtcodigo").val(data);
            });
}
function modificar() {
    $("#panel").removeClass("hidden");
    $("#txtnombre").removeAttr("disabled");
    $("#txtapellido").removeAttr("disabled");
    $("#txtndoc").removeAttr("disabled");
    $("#btnGrabar").removeAttr("disabled");
    $("#btnCancelar").removeAttr("disabled");
    $("#btnAgregar").attr("disabled", "true");
    $("#btnModificar").attr("disabled", "true");
    $("#btnBorrar").attr("disabled", "true");
    $("#btnSalir").attr("disabled", "true");
    $("#operacion").val("2");
    $("#txtdescripcion").select();
}
function borrar() {
    $("#panel").removeClass("hidden");
    $("#btnGrabar").removeAttr("disabled");
    $("#btnCancelar").removeAttr("disabled");
    $("#btnAgregar").attr("disabled", "true");
    $("#btnModificar").attr("disabled", "true");
    $("#btnBorrar").attr("disabled", "true");
    $("#btnSalir").attr("disabled", "true");
    $("#operacion").val("3");
    grabar();
}

function cancelar() {
    $("#txtcodigo").val("");
    $("#txtnombre").val("");
    $("#txtapellido").val("");
    $("#txtndoc").val("");
    $("#txtnombre").attr("disabled", "true");
    $("#txtapellido").attr("disabled", "true");
    $("#txtndoc").attr("disabled", "true");
    $("#cbocarrera").attr("disabled", "true").trigger("chosen:updated");
    $("#btnGrabar").attr("disabled", "true");
    $("#btnCancelar").attr("disabled", "true");
    $("#btnAgregar").removeAttr("disabled");
    $("#btnModificar").removeAttr("disabled");
    $("#btnBorrar").removeAttr("disabled");
    $("#panel").addClass("hidden");
    $("#btnSalir").removeAttr("disabled");
    get_datos("");
}
function grabar() {
    var d = $.trim($("#txtnombre").val());

    if (d === "") {
        alertify.alert('DEBES LLENAR TODOS LOS CAMPOS');
    } else {
        var sql = "";
        var men = "";
        var conf = "";
        if ($("#operacion").val() === "1") {
            sql = "insert into alumnos values(" + $("#txtcodigo").val() + ",upper('" + $("#txtnombre").val().replace("'", "''") + "'), '" + $("#txtapellido").val() + "', '" + $("#txtndoc").val() + "', '" + $("#cbocarrera").val() + "','ACTIVO')";
            conf = "¿DESEA GRABAR EL NUEVO ALUMNO?";
            men = "EL NUEVO ALUMNO FUE REGISTRADO CON EXITO";
        }
        if ($("#operacion").val() === "2") {
            sql = "update alumnos set nombre = '" + $("#txtnombre").val() + "', apellido= '" + $("#txtapellido").val() + "', nro_doc= '" + $("#txtndoc").val() + "', id_carrera= " + $("#cbocarrera").val() + " where id_alumnos = " + $("#txtcodigo").val();
            conf = "¿DESEA MODIFICAR ESTE ALUMNO?";
            men = "EL ALUMNO FUE MODIFICADO CON ÉXITO";
        }
        if ($("#operacion").val() === "3") {
            sql = "update alumnos set estado_alumno = 'INACTIVO' where id_alumnos = " + $("#txtcodigo").val();
            conf = "¿DESEA BORRAR ESTE ALUMNO?";
            men = "EL ALUMNO FUE BORRADO CON EXITO";

        }
        alertify.confirm(conf, function (e) {
            if (e) {
                $.post("../operaciones_bd", {sql: sql, men: men})
                        .done(function (data) {
                            alertify.alert(data);
                            cancelar();
                        });
            }
        });
    }
}
function get_datos(filtro) {
    var sql = "select * from v_alumno where nombre ilike '%" + filtro + "%' and estado_alumno= 'ACTIVO' order by nombre";
    $.post("../GetAlumnos", {sql: sql})
            .done(function (data) {
                $("#grilla tbody").html(data);
            });
}

function seleccion(parent) {
    parent.find("td").each(function (index) {
        if (index === 0) {
            $("#txtcodigo").val($(this).text());
        }
        if (index === 1) {
            $("#txtnombre").val($(this).text());
        }
        if (index === 2) {
            $("#txtapellido").val($(this).text());
        }
        if (index === 3) {
            $("#txtndoc").val($(this).text());
        }
        if (index === 4) {
            $("#cbocarrera").val(parseInt($(this).text())).trigger("chosen:updated");
        }


    });
}

$(function () {
    get_datos("");
    $(".chosen-select").chosen({width: "100%"});
});