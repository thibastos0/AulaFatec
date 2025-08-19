<?php

$salario = $_POST['salario'] ?? 0;
$aumento = $_POST['aumento'] / 100 ?? 0;

$novoSalario = $salario * (1 + $aumento);
$valorAumento = $salario * $aumento;

echo "O novo salário é: R$ " . number_format($novoSalario, 2, ',', '.');
echo "<br>";
echo "O aumento foi de R$ " . number_format($valorAumento, 2, ',', '.');