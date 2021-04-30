$(function () {             //cuando carga toda la pagina le llama a la funcion declarada
    permisos();
});


function permisos() {
    var cant = 0;
    var codigoPerfil = $("#perfcod").val();
    var nombre = $("#nombrepersonal").val();
     //alert(codigoPerfil);
    if (codigoPerfil == "1" || codigoPerfil == "2") {
       alertify.alert("Bienvenido " + nombre);
    } else {
        cant++;
//        alertify.alert("Acceso denegado");
//        window.location="index.jsp";
    }
   if (codigoPerfil == "2") {
//        console.log("NO SE PUEDE ACCEDER");
        alertify.alert("Acceso denegado");
      $(".desplegarmenu").removeClass("dropdown");
       
    }
}
;
