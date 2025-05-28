<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quadrado Perfeito - PHP</title>
    <link rel="stylesheet" href="style/estilos.css">
</head>
<body>
    <div>
        <p>
            <h3>Quadrado Perfeito - PHP</h3>
            Descrição<br>
            Utilizando PHP escreva uma função para imprimir os vinte primeiros quadrados perfeitos.
            Os quadrados perfeitos podem ser encontrados multiplicando cada número natural por ele mesmo.
            <ul>Os primeiros quadrados perfeitos são:
                <li>1 × 1 = 1</li>
                <li>2 × 2 = 4</li>
                <li>3 × 3 = 9</li>
            </ul>
            Por exemplo, 12 não é um quadrado perfeito, pois não existe um número natural m tal que m × m = 12.
        </p>
    </div>
</body>
</html>

<?php
$quadrado_perfeito = array();
$num = 1;
function verifica_quadrado_perfeito(int $num): bool {
    if (sqrt($num) == floor(sqrt($num))) {
        return true; // É um quadrado perfeito
    }
    return false; // Não é um quadrado perfeito
}


while (count($quadrado_perfeito) < 20) {
    if (verifica_quadrado_perfeito($num)) {
        $quadrado_perfeito[] = $num;
    }
    $num++;
}
echo "<hr>";
echo "<h3>Os primeiros 20 quadrados perfeitos são:</h3>";
echo "<ul>";
foreach ($quadrado_perfeito as $key => $value) {
    echo "<li>" . $value . " = " . sqrt($value) . " × " . sqrt($value) . "</li>";
}
echo "</ul>";
echo "<hr>";