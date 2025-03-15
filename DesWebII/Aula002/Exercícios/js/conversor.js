function convTemp() {
    //elemento celcius do HTML
    let celcius = document.getElementById("celsius")
    //valor do elemento celsius
    let c = celcius.value;
    //fórmula para conversão
    let f = (c*9/5) + 32;
    //insere valor encontrado no HTTML
    document.getElementById("fahrenheit").innerText = f;
}