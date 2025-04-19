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
    <form method="post" action="ex008_contagem2.php">
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
        "centena" => 0,
        "dezena" => 0,
        "unidade" => 0
    ];
    

    $quantidade["centena"] = intdiv($numero, 100);
    $numero %=100;
    $quantidade["dezena"] = intdiv($numero, 10);
    $numero %= 10; //unidades
    $quantidade["unidade"] = $numero;

    $texto = [];

    foreach ($quantidade as $key => $value) {
        if ($value == 0) {
            unset($quantidade[$key]);
            continue;
        }
        if ($value > 1) {
            $key .= "s";
        }
        $texto[] = "{$value} {$key}"; // Adiciona o valor e a chave ao texto
    }

    // Monta a frase final
    $frase = "";
    switch (count($texto)) {
        case 1:
            $frase = $texto[0];
            break;
        case 2:
            $frase = "{$texto[0]} e {$texto[1]}";
            break;
        default:
            $frase = "{$texto[0]}, {$texto[1]} e {$texto[2]}";
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