<?php

$inicial = $_POST['numero_inicial'] ?? 0;
$final = $_POST['numero_final'] ?? 0;

if($inicial > $final) {
    echo "Número final deve ser maior que o número inicial.";
    exit();
}

for ($i=$inicial; $i <= $final; $i++) { 
    echo "$i ";
}