<?php

function tabuada($n){
    for($i = 1; $i <= 10; $i++){
        echo "$n x $i = " . $n * $i . ". <br>";
    }
}

$num = $_GET['num'];
echo "Imprimindo a tabuada do número $num: <br>";
echo "<hr>";
echo tabuada($num);

?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tabuada</title>
</head>
<body>
    <input type="number" name="num" id="num" placeholder="Digite um número">
    <button onclick="window.location.href='ex002_tabuada.php?num=' + document.getElementById('num').value">Gerar tabuada</button>
</body>
</html>