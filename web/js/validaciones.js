function validar() {

    var nombre = $("#descripcion").val();

    if (nombre === "") {
        alert("DEBE CARGAR UNA DESCRIPCION");
    } else {
        $("#formulario").submit();
    }
}

function seleccion(obj) {
    obj.find("td").each(function (i) {
        if (i === 1) {
            $("#descripcion").val($(this).html());
        }
    });
}


