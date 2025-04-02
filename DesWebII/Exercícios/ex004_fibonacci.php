<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style/estilos.css"> 
    <title>Fibonacci - PHP</title>
</head>
<body>
    <div>
        <p>
        <strong>Fibonacci - PHP</strong><br>
        Por definição, os dois primeiros números na sequência de Fibonacci são 0 e 1, e cada número subsequente é a soma dos dois anteriores.<br>
        Por exemplo, os primeiros dez números de Fibonacci são: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34.<br>
        Escreva uma função em PHP que aceite um número e retorne o número naquela posição na sequência de Fibonacci.<br>
        Exemplos de saída:<br>
        echo fibonacci(3); // Saída: 2 echo fibonacci(7); // Saída: 13 echo fibonacci(9); // Saída: 34
        </p>
    </div>
    <div>
        <form method="post" action="ex004_fibonacci.php">
            <label for="numero">Digite um número:</label>
            <input type="number" name="numero" id="numero" min="0"  max="50" required autofocus>
            <button type="submit">Calcular Fibonacci</button>
        </form>
    </div>
</body>
</html>

<?php

function fibonacci2($n){
    return $n <= 1 ? $n : fibonacci2($n-1) + fibonacci2($n-2);
} # Fibonacci recursivo que retorna somente o número na posição $n

function fibonacci($n){
    $f = array(0, 1);
    for ($i=2; $i <= $n ; $i++) { 
        $f[$i] = $f[$i-1] + $f[$i-2];
    }
    return $f;
}

$posicao = $_POST["numero"] ?? 0; // Se não houver valor, atribui 0
$fibo = array(0);

if($posicao != 0){
    $fibo = array_replace($fibo, fibonacci($posicao));
    //$fibo = array_merge($fibo, array(fibonacci2($posicao))); # Fibonacci recursivo e uso do array_merge
    //array_push($fibo, fibonacci2($posicao)); # Fibonacci recursivo e uso do array_push
}

echo "<hr>";
echo "O número na posição $posicao na sequência de Fibonacci é: " .$fibo[$posicao] ."<br>";
echo' <hr>';
echo "Os números de Fibonacci até a posição $posicao são:<br>";
foreach($fibo as $key => $value){
    echo "Fibonacci[$key] = $value<br>";
}
echo "<hr>";

?>