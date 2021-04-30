
$(function () {
    permisoRoles();
   
});

function permisoRoles() {
    var codigoPerfil = $('#codigoPerfil').val();
//    alert(codigoPerfil);
    if (codigoPerfil != '1') {
        $('#menuReferenciales').addClass('hidden');
    }
}

function cerrarSesion() {
    var codigo = $('#codigoPerfil').val();
    var alias = $('#nombreUsuario').val();
    var estado = $('#estadoSesion').val();
    if (estado == null || alias == null || codigo == null) {
        $.post('CerrarSesionServlet');
    } else {
        $.post('SesionActiva');
    }

}

$(document).ready(function () {
    $.active = false;
    $('body').bind('click keypress', function () {
        $.active = true;
    });
    comprobarActividad(60000, 60000, 0);// interval = 1 minute. 
});

function comprobarActividad(timeout, interval, elapsed) {
    if ($.active) {
        elapsed = 0;
        $.active = false;
        $.post('SesionActiva');
    }
    if (elapsed < timeout) {
        elapsed += interval;
        setTimeout(function () {
            comprobarActividad(timeout, interval, elapsed);
        }, interval);
    } else {
        $.post('CerrarSesionServlet');
        window.location = 'index.jsp'; // Redirect to "session expired" page. 
    }
}