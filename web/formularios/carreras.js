function agregar() {
    $("#txtdescripcion").removeAttr("disabled");
    $("#btnGrabar").removeAttr("disabled");
    $("#btnCancelar").removeAttr("disabled");
    $("#btnAgregar").attr("disabled", "true");
    $("#btnModificar").attr("disabled", "true");
    $("#btnBorrar").attr("disabled", "true");
    $("#btnSalir").attr("disabled", "true");
     $("#panel").removeClass("hidden");
    $("#operacion").val("1");
    $.post("../ultimo_codigo", {campo: "id_carrera", tabla: "carreras"})
            .done(function (data) {
                $("#txtcodigo").val(data);
            });
}
function modificar() {
    $("#panel").removeClass("hidden");
    $("#txtdescripcion").removeAttr("disabled");
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
    $("#txtdescripcion").val("");
    $("#txtdescripcion").attr("disabled", "true");
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
    var d = $.trim($("#txtdescripcion").val());

    if (d === "") {
        alertify.alert('DEBES LLENAR TODOS LOS CAMPOS');
    } else {
        var sql = "";
        var men = "";
        var conf = "";
        if ($("#operacion").val() === "1") {
            sql = "insert into carreras values(" + $("#txtcodigo").val() + ",'" + $("#txtdescripcion").val() + "','ACTIVO')";
            conf = "¿DESEA GRABAR LA NUEVA CARRERA?";
            men = "LA NUEVA CARRERA FUE REGISTRADA CON ÉXITO";
        }
        if ($("#operacion").val() === "2") {
            sql = "update carreras set descripcion = '" + $("#txtdescripcion").val() + "' where id_carrera = " + $("#txtcodigo").val();
            conf = "¿DESEA MODIFICAR ESTA CARRERA?";
            men = "LA CARRERA FUE MODIFICADA CON EXITO";
        }
         if ($("#operacion").val() === "3") {
            sql = "update carreras set estado_carrera = 'INACTIVO' where id_carrera = " + $("#txtcodigo").val();
            conf = "¿DESEA BORRAR ESTA CARRERA?";
            men = "LA CARRERA FUE BORRADA CON EXITO";
        
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
    var sql = "select * from carreras where descripcion ilike '%"+filtro+"%' and estado_carrera= 'ACTIVO' order by descripcion";
    $.post("../GetCarreras", {sql: sql})
            .done(function (data) {
                $("#grilla tbody").html(data);
            });
}

function seleccion(parent) {
    parent.find("td").each(function(index){
                if(index === 0){
                    $("#txtcodigo").val($(this).text());
                }
                if(index === 1){
                    $("#txtdescripcion").val($(this).text());
                }
            });
}

$(function () {
    get_datos("");
    $(".chosen-select").chosen({width: "100%"});
});