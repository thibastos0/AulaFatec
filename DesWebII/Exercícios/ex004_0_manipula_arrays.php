<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style/estilos.css">
    <title>Document</title>
</head>
<body>
    <div>
        <p>
        <strong>Manipulando Arrays - PHP</strong><br>
        Crie um arquivo PHP e desenvolva uma função que recebe um array de números e retorna:<br>
        <ul>
            <li>A soma de todos os números</li>
            <li>A média dos números</li>
            <li>O maior número</li>
            <li>O menor número</li>
        </ul>
        </p>
</body>
</html>

<?php

function analisarNumeros($numeros){
    $soma = array_sum($numeros);
    $media = $soma / count($numeros);
    $maior = max($numeros);
    $menor = min($numeros);

    return "Array <br> 
    ( <br>
        [soma] => $soma " . "<br>
        [media] => $media " . "<br>
        [maior] => $maior " . "<br>
        [menor] => $menor " . "<br> 
    )";
}

$numeros = array(5, 8, 15, 70, 2, 9, 12, 3, 4, 6);
$resultado = analisarNumeros($numeros);
print_r($resultado);

?>