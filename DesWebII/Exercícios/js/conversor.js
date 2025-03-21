function convTemp() {
    //elemento celcius do HTML
    let celcius = document.getElementById("celsius")
    //valor do elemento celsius
    let c = celcius.value;
    
    // let celsius = parseFloat(document.getElementById('celsius').value); # -> outra forma de pegar o valor do input
    
    if (!isNaN(c)) {
        //fórmula para conversão
        let f = (c * 9 / 5) + 32;
        //insere valor encontrado no HTTML
        document.getElementById('fahrenheit').value = f.toFixed(1); //arredonda para uma casa decimal
        // document.getElementById("fahrenheit").innerText = f.toFixed(1); # -> outra forma de inserir o valor no input
    } else {
        alert('Por favor, insira um valor numérico válido.');
    }
}