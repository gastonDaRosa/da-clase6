var urlIniciarVista = "modeloNumero/vistaConectada";

function mostrar_msgBnv(msgBnv) {
    document.getElementById("msgBnv").textContent = msgBnv;
}

function mostrar_msg(msg) {
    document.getElementById("msg").textContent = msg;
}
function mostrar_resultado(resultado) {
    if (!resultado || resultado.length == 0) {
        document.getElementById("resultado").innerHTML = "<p>No hay datos</p>";
        return;
    }

    const listaHTML = crearTablaDesdeJson(resultado, null);

    document.getElementById("resultado").innerHTML = listaHTML;
}

function mostrar_faltanIngresar(faltanIngresar) {
    document.getElementById("faltanIngresar").textContent = faltanIngresar;
}

function iniciar() {
    
    const cant = document.getElementById("numCantidad").value;

    // Armamos el string URL Encoded
    const data = "cant=" + encodeURIComponent(cant);

    if (cant != null) {
        submit("/modeloNumero/iniciar", data);
    }

}

function ingresar() {
    const num = document.getElementById("numAgregar").value;

    // Armamos el string URL Encoded
    const data = "numero=" + encodeURIComponent(num);

    if (num != null) {
        submit("/modeloNumero/ingresar", data);
    }

}
