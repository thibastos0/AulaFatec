<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style/estilos.css">
    <title>Qual o Mais Próximo - PHP</title>
</head>
<body>
    <h1>Qual o Mais Próximo? - PHP </h1>
    <p>Descrição<br>
    Dado um array de números, escreva uma função com PHP que responda de forma eficiente a consultas do tipo: "Qual é o valor mais próximo e maior do que o número na posição i?", onde a proximidade é medida pela diferença nos índices do array. Por exemplo, no array [1, 4, 3, 2, 5, 7], o valor mais próximo e maior do que 4 é 5.Após um pré-processamento em tempo linear, seu programa deve ser capaz de responder às consultas em tempo constante.
    </p><br>
    <form method="post">
        <label for="target">Posição Alvo:</label>
        <input type="text" name="target" id="target" required>
        <br>
        <button type="submit">Enviar</button>
    </form>
    <hr>   
</body>
</html>
<?php


if (!isset($_POST['target'])) {
    exit;
}
$target = filter_input(INPUT_POST, 'target', FILTER_SANITIZE_NUMBER_INT);
$lista = [1, 4, 3, 2, 5, 7];
if ($target < 0 || $target >= count($lista)){
    echo "Índice inválido!";
    exit;
}
$valor_buscado = $lista[$target];

$lista_maiores = array_filter($lista, function($value) use($valor_buscado){return $value > $valor_buscado;});

echo "<h2>Resultado:</h2><br>";
if (count($lista_maiores) == 0) {
    echo "Não há valor maior que $valor_buscado na lista.";
    exit;
}

echo var_dump($lista_maiores);
echo "<br>";
// Calcula a diferença de índice entre o target e os índices dos maiores
$diferenca = [];
foreach (array_keys($lista_maiores) as $k) {
    $diferenca[$k] = abs($target - $k);
}

// Encontra o índice do valor mais próximo
$indice_mais_proximo = array_keys($diferenca, min($diferenca))[0];

// Exibe o resultado
echo "O valor maior e mais próximo de $valor_buscado é " . $lista[$indice_mais_proximo] . " (posição $indice_mais_proximo)";

?>