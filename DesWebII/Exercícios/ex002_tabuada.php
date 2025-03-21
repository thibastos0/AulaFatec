<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style/estilos.css">
    <title>Tabuada</title>
</head>
<body>
    <div>
        <h1>Tabuada</h1>
        <p>
            Faça um código que vai ter uma variável chamada $numero, em seguida imprima a tabuada desse número de 1 a 10.<br>
            Exemplo de saída esperado.<br>
            <br>
            Imprimindo a tabuada do número 5:<br>
            <br>
            1 x 5 = 5<br>
            2 x 5 = 10<br>
            3 x 5 = 15<br>
            4 x 5 = 20<br>
            5 x 5 = 25<br>
            6 x 5 = 30<br>
            7 x 5 = 35<br>
            8 x 5 = 40<br>
            9 x 5 = 45<br>
            10 x 5 = 50<br>
            <br>
        </p>
    </div>
    <div>
        <label for="num">Digite um número: </label>
        <input type="number" name="num" id="num" placeholder="número" autofocus>
        <button onclick="window.location.href='ex002_tabuada.php?num=' + document.getElementById('num').value">Gerar tabuada</button>
        <br><br>
    </div>
</body>
</html>


<?php
//
// Exemplo de saída esperado.

function tabuada($n){
    for($i = 1; $i <= 10; $i++){
        echo "$n x $i = " . $n * $i . ". <br>";
    }
}

$num = $_GET['num'] ?? null;
echo "Imprimindo a tabuada do número $num: <br>";
echo "<hr>";
switch ($num) {
    case null:
        echo tabuada(0);
        break;
    default:
        echo tabuada($num);
        break;
}
echo "<hr>";
?>
