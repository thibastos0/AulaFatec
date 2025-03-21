<?php
/*é possível executar servidor PHP, a partir do terminal do VSCode, com o comando: php -S localhost:8080*/
echo 'Olá Mundo!'; //usar aspas duplas qdo tiver variáveisno meio do texto

$nome = 'Thiago';
$numero = 101;

echo "<hr>";
echo "O nome é: $nome. "; //aspas duplas para interpolação de variáveis
echo "O número é: $numero. ";

echo "<hr>";
echo 'O nome é: $nome'; //aspas simples não interpola variáveis

echo "<hr>";
$numero1 = 10;
$numero2 = 2;

$multiplica = $numero1 * $numero2;
$divida = $numero1 / $numero2;
$soma = $numero1 + $numero2;
$subtrai = $numero1 - $numero2;

echo "resultados números $numero1 e $numero2: <br>";
echo "Multiplicação: $multiplica <br>";
echo "Divisão: $divida <br>";
echo "Soma: $soma <br>";
echo "Subtração: $subtrai <br>";

echo "<hr>";
$numero3 = "10";

if ($numero3 >= 10) {
    echo "É igual a 10";
} else {
    echo "Não é igual a 10";
}

echo "<hr>";
$numeroWhile = 1;

while ($numeroWhile <= 10) {
    echo $numeroWhile;
    $numeroWhile += 2;
}

echo "<hr>";

for ($i = 0; $i < 10; $i++) {
    echo "$i - ";
}

echo "<hr>";
function soma($a, $b) {
    return $a + $b; #outra opção para comentar
}

echo "15 + 20 = " . soma(15, 20) . ". ";
echo "<hr>";

// fechar tag qdo for misturar HTML com PHP ao longo do arquivo com ? >