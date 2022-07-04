function validar_formulario(){
    var username = document.formRegistro.usuario;
    var email= document.formRegistro.Correo;
    var password=document.formRegistro.contrasena;

    var username_len = username.value.length;
    if (username_len==0 || username_len<8){
        alert("Debes ingresar mín 8 caracteres");
        return false;
    }else{
        alert("No llega");
        return false;
    }


}


function mostrarPassword(obj){
    var obj = document.getElementById("contrasena");
    obj.type = "text";
}


function ocultarPassword(obj){
    var obj = document.getElementById("contrasena");
    obj.type = "password";
}

function showForm(){
    document.getElementById("formRegistro").style.display = "block";
}


function hideForm(){
    document.getElementById("formRegistro").style.display = "none";
}