<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style/estilos.css">
    <title>FizzBuzz</title>
</head>
<body>
    <div>
        <p>    
        <h4>Fizzbuzz</h4>
        Escreva uma função no PHP chamada fizzbuzz que recebe um número inteiro positivo n como entrada e imprime os números de 1 a n, mas com as seguintes regras:<br>
        <ul>
            <li>Se o número for divisível por 3, imprima "Fizz" em vez do número.</li>
            <li>Se o número for divisível por 5, imprima "Buzz" em vez do número.</li>
            <li>Se o número for divisível por ambos 3 e 5, imprima "FizzBuzz".</li>
            <li>Caso contrário, imprima o próprio número.</li>
        </ul>
        </p>
    </div>
    <div>
        <form method="post" action="ex006_fizzbuzz.php">
        <label for="fizzbuzz">Informe um número:</label>
        <input type="number" name="fizzbuzz" id="fizzbuzz" min="1" required autofocus>
        <button type="submit">Enviar</button>
    </div>
</body>
</html>

<?php
$num = $_POST['fizzbuzz'] ?? 0;

function fizzbuzz($n){
    if (($n%3 == 0) && ($n%5 == 0)){
        return "FizzBuzz";
    }
    if ($n%3 == 0){
        return "Fizz";
    }
    if ($n%5 == 0){
        return "Buzz";
    }
    return $n;
}

for ($i=1; $i <= $num; $i++) {
    echo fizzBuzz($i);
    echo "<br>";
}
?>