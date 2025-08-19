<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Triângulo de Pascal</title>
    <link rel="stylesheet" href="style/estilos.css">
</head>
<body>
    <div>
        <h3>Triângulo de Pascal - PHP</h3>
        Descrição<br>
        <p>Dado um número inteiro n, sua tarefa é gerar as n primeiras linhas do Triângulo de Pascal.<br>
        O Triângulo de Pascal é uma estrutura em forma de triângulo onde cada número representa um coeficiente binomial. Ele começa com o número 1 no topo, e cada número nas linhas seguintes é a soma dos dois números diretamente acima dele. 
        </p>
        <ul>Exemplos:
            <li>n =1</li>
            [1]
        
            <li>n = 4</li>
            [1]<br>
            [1, 1]<br>
            [1, 2, 1]<br>
            [1, 3, 3, 1]
        </ul>
        <ol>Dicas:
            <li>A primeira e a última posição de cada linha sempre têm valor 1.</li>
            <li>Os valores intermediários podem ser calculados como a soma dos dois elementos acima da linha anterior.</li>
        </ol>
        <p>Objetivo:<br>
        Escreva uma função com PHP que receba n como parâmetro e retorne uma lista (ou array) com as n primeiras linhas do Triângulo de Pascal.</p>
        <form method="post">
            <label for="linha">Digite o número de linhas do Triângulo de Pascal:</label>
            <input type="text" id="linha" name="linha" min="1" required>
            <button type="submit">Gerar Triângulo</button>
        </form>
    </div>
</body>
</html>

<?php

function trianguloPascal($n){
    $triangulo = []; // Inicializa o array do triângulo
    $triangulo[] = [1]; // A primeira linha do triângulo é sempre [1]
    if ($n == 1) {
        return $triangulo; // Retorna apenas a primeira linha se n for 1
    }
    // Gera as linhas restantes do triângulo
    for ($i = 1; $i < $n; $i++) {        
        $linha = array_fill(0, $i + 1, 1); // Inicia a linha com 1s
        for ($j = 1; $j < $i; $j++) {
            // Calcula os valores intermediários
            $linha[$j] = $triangulo[$i - 1][$j - 1] + $triangulo[$i - 1][$j];
        }
        $triangulo[] = $linha; // Adiciona a linha ao triângulo
    }
    return $triangulo;
}

if (!isset($_POST["linha"])) {
    die("Por favor, informe o número de linhas do Triângulo de Pascal.");
}
$num = filter_input(INPUT_POST, 'linha', FILTER_VALIDATE_INT);
echo "<hr>";
if ($num < 1) {
    die("O número de linhas deve ser pelo menos 1.");
}

$resultado = trianguloPascal($num);
echo "<h3>Triângulo de Pascal com $num linha(s):</h3>";
foreach ($resultado as $linha) {
    echo "[" . implode(", ", $linha) . "]<br>";
}

?>