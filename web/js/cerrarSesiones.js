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
        $.post('cerrar_sesion');
        window.location = 'index.jsp'; // Redirect to "session expired" page. 
    }
}

function cerrarSesion() {
    var codigo = $('#perfcod').val();
    var alias = $('#nombrepersonal').val();
    var estado = $('#estadoSesion').val();
    if (estado == null || alias == null || codigo == null) {
        $.post('cerrar_sesion');
    } else {
        $.post('SesionActiva');
    }
}

