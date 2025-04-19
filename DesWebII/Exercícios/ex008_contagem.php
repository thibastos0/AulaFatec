<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style/estilos.css">
    <title>Contagem - PHP</title>
</head>
<body>
<div>
    <p>
    <h3>Contagem - PHP</h3>
    Escreva um código PHP que receba via $_POST um número inteiro maior que 0 e menor que 1000 e imprima a quantidade de centenas, dezenas e unidades do mesmo. Observando os termos no plural a colocação do "e", da vírgula entre outros.<br>
    <ul>Exemplo:
        <li>326 = 3 centenas, 2 dezenas e 6 unidades;</li>
        <li>12 = 1 dezena e 2 unidades.</li>
    </ul>
    </p>
</div>    
<div>
    <form method="post" action="ex008_contagem.php">
        <label for="numero">Informe um número entre 0 e 1000:</label>
        <input type="text" id="numero" name="numero">
        <button type="submit">enviar</button>
    </form>    
</div>
</body>
</html>

<?php

function contagem($numero){
    if (($numero < 1) || ($numero > 1000)){
        return "número inválido!";
    }
    $quantidade = [
        "centenas" => 0,
        "centena" => 0,
        "dezenas" => 0,
        "dezena" => 0,
        "unidades" => 0,
        "unidade" => 0
    ];
    
    $texto = [];

    $centena = intdiv($numero, 100);
    $numero %=100;
    $dezena = intdiv($numero, 10);
    $numero %= 10; //unidades

    if ($centena > 1){
        $quantidade["centenas"] = $centena;
    } else {
        $quantidade["centena"] = $centena;
    }

    if ($dezena > 1){
        $quantidade["dezenas"] = $dezena;
    } else {
        $quantidade["dezena"] = $dezena;
    }

    if ($numero > 1){
        $quantidade["unidades"] = $numero;
    } else {
        $quantidade["unidade"] = $numero;
    }

    foreach ($quantidade as $key => $value) {
        if ($value == 0) {
            unset($quantidade[$key]);
            continue;
        }
        $texto[] = $key;
    }
    $frase = "";
    switch (count($texto)) {
        case 1:
            $frase = "" .$quantidade[$texto[0]] ." " .$texto[0];
            break;
        case 2:
            $frase = "" .$quantidade[$texto[0]] ." " .$texto[0] ." e " .$quantidade[$texto[1]] ." " .$texto[1];
            break;
        default:
            $frase = "" .$quantidade[$texto[0]] ." " .$texto[0] .", " .$quantidade[$texto[1]] ." " .$texto[1] ." e " .$quantidade[$texto[2]] ." " .$texto[2];
            break;
    }

    return $frase; 
}

$num = filter_input(INPUT_POST, "numero", FILTER_VALIDATE_INT);
if(!isset($_POST["numero"])){
    die("Informe um número!");
}

echo "<hr>";
echo contagem($num);

?>