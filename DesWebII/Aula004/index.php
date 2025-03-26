<?php

function somar(int $a, int $b): int{
    $total = $a + $b;
    return $total;
}

function imprimir(){
    echo "Olá";
}

$teste = somar(10, 20);
echo somar(50, 25);
echo "<br>";
echo "<hr>";
$teste = "teste";
echo strlen($teste);
echo "<br>";
echo "<hr>";
$listaNumeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
$listaNumeros2 = array(1, 2, 3, 4, 5);
echo $listaNumeros[4];
$listaNumeros[4] = 50;
echo $listaNumeros[4];
echo "<br>";
echo count($listaNumeros);
echo "<br>";
echo "<hr>";

$pessoa = [
    'nome' => 'João',
    'idade' => 25,
    'cidade' => 'São Paulo',
    'estado' => 'SP',
    'sexo' => 'M',
    'peso' => 70.5,
    'altura' => 1.75
];

echo $pessoa["nome"];
echo "<br>";
print_r($pessoa);
echo "<br>";
echo "<hr>";

foreach($listaNumeros2 as $chave => $valor){
    echo "Chave: $chave, Valor: $valor<br>";
}
echo "<br>";
echo "<hr>";

foreach($pessoa as $key => $value){
    echo "$key: $value<br>";
}
echo "<br>";
echo "<hr>"; 

foreach(array_keys($pessoa) as $key){
    echo "$key: $pessoa[$key]<br>";
}