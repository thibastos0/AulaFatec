<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style/estilos.css">
    <title>Caixa Eletrônico</title>
</head>
<body>
    <div>
        <p>
            <h2>Caixa Eletrônico - PHP</h2><br>
            Em determinado momento do dia, apenas notas de 10, 50 e 100 estão disponíveis em um terminal de caixa eletrônico. Elaborar uma função em PHP chamada sacar() que receba o valor de saque de um cliente, verifique sua validade (ou seja, se pode ser pago com as notas disponíveis) e informe o número mínimo de notas de 100, 50 e 10 necessárias para pagar esse saque.<br>
            <ul>Exemplos de uso:
            <li>echo sacar(380);  // ➞ "Notas de 100: 3, Notas de 50: 1, Notas de 10: 3"</li>
            <li>echo sacar(70);   // ➞ "Notas de 100: 0, Notas de 50: 1, Notas de 10: 2"</li>
            <li>echo sacar(125);  // ➞ "Valor inválido. Insira um valor múltiplo de 10."</li>
           </ul>
        </p>
    </div>
    <div>
        <form method="POST" action="ex007_caixaEletronico.php">
            <label for="caixa">Informe o valor para o saque:</label>
            <input type="text" id="caixa" name="caixa">
            <button type="submit">sacar</button>
        </form>
    </div>
</body>
</html>

<?php

if(!isset($_POST["caixa"])){
    die("Dados não informados.");
    //header("Location: ex007_caixaEletronico.php");
}   

function sacar($valor){
    if ($valor%10 != 0){
        return "Valor inválido. Insira um valor múltiplo de 10.";
    }
    $cem = intdiv($valor, 100);
    $valor %= 100;
    $cinq = intdiv($valor,50);
    $valor %= 50;
    $dez = intdiv($valor,10);
    
    return "Notas de 100: $cem, Notas de 50: $cinq, Notas de 10: $dez";
}

$num = filter_input(INPUT_POST, 'caixa', FILTER_VALIDATE_INT);
echo "<hr>";
echo sacar($num);

?>