<?php

require_once('Funcionario.php');

if (!isset($_POST["salario"])) {
    header("Location: salario.php");
    //die("Dados não informados.");
}

$salarioInicial = filter_input(INPUT_POST, 'salario', FILTER_VALIDATE_FLOAT);
$funcionario = new Funcionario($salarioInicial);

if (!empty($_POST['reajuste'])) {
    $reajuste = filter_input(INPUT_POST, 'reajuste', FILTER_VALIDATE_FLOAT);
    $funcionario->setReajuste($reajuste);
} else {
    $reajuste = $funcionario->getReajuste();
}

/*
echo "antigo " .$funcionario->imprimir();
echo "<br>";
echo "Reajuste: " . number_format($reajuste, 2, ',', '.') . "%";*/

$funcionario->calcularReajuste();

?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Novo Salário</title>
    <p>Novo salário</p>
    <p>
        <?php
            echo $funcionario->imprimir();
        ?>
    </p>
</head>
<body>
    
</body>
</html>