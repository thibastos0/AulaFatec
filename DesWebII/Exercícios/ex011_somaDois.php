<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Soma Dois - PHP</title>
    <link rel="stylesheet" href="style/estilos.css">
</head>
<body>
    <div>
        <h3>Soma Dois - PHP</h3>
        <p>Descrição: Dado um array de números inteiros nums e um número inteiro target, retorne os índices de dois números do array cuja soma seja igual ao target.
            <ul></ul>
                <li>Você pode assumir que cada entrada terá exatamente uma solução, e você não pode usar o mesmo elemento duas vezes.</li>
                <li>pode retornar a resposta em qualquer ordem.</li>
            </ul>
            <ul>Exemplos:
                <li>Exemplo 1: Entrada: nums = [2, 7, 11, 15], target = 9</li>
                <li>Saída: [0, 1]</li>
                <li>Explicação: Como nums[0] + nums[1] == 9, retornamos [0, 1].</li>
                <li>Exemplo 2: Entrada: nums = [3, 2, 4], target = 6</li>
                <li>Saída: [1, 2]</li>
                <li>Exemplo 3: Entrada: nums = [3, 3], target = 6</li>
                <li>Saída: [0, 1]</li>
        </p>
    </div>
    <hr>
    <div>
        <p>Informe o target:
            <form method="POST" action="ex011_somaDois.php">
                <label for="soma">Quantidade de números para a array</label>
                <input type="text" id="soma" name="soma">
                <button type="submit">somar</button>
            </form>
        </p>
    </div>
</body>
</html>

<?php

// Exemplo de array
$nums = array(2, 7, 11, 15);
var_dump($nums);
echo "<hr>";

if(!isset($_POST["soma"])){
    die("Entre com o valor do target, que se enquadre nas condições informadas, dada a array acima.");
}

$target = filter_input(INPUT_POST, 'soma', FILTER_VALIDATE_INT);
/*
$resultado = array_map(function($k, $n) use ($nums, $target) {
    // Verifica se a soma dos dois números é igual ao target
    $indice = $k;
    $k++;
    while(($k) < count($nums)){
        if($n + $nums[$k] == $target){
            echo "soma: " . ($n + $nums[$k]) . "<br>";
            echo "Índices: [" . ($indice) . ", " . $k . "]<br>";
            return;
        }
        $k++;
    }
}, array_keys($nums), $nums);*/

$mensagem = "Target não encontrado com a array atual.";

foreach ($nums as $i => $num) {
    // Calcula o complemento necessário para atingir o target
    $complemento = $target - $num;

    // Procura o complemento no array
    $j = array_search($complemento, $nums);

    // Verifica se o complemento foi encontrado e se não é o mesmo índice
    if ($j !== false && $j != $i) {
        echo "Soma: " . ($nums[$i] + $nums[$j]) . "<br>";
        echo "Índices: [$i, $j]<br>";
        $mensagem = "Target encontrado com a array atual.";
        break; // Encerra o loop após encontrar a solução
    }
}
echo "<hr>";
echo $mensagem;
echo "<hr>";

?>