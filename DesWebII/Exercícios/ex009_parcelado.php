<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pagar Parcelado - PHP</title>
    <link rel="stylesheet" href="style/estilos.css">
</head>
<body>
    <div>
    <p><h3>Pagar parcelado - PHP</h3>
Descrição<br>
Uma loja vende seus produtos no sistema entrada mais duas prestações, sendo a entrada maior do que ou igual às duas prestações, as quais devem ser iguais, inteiras e as maiores possíveis. Por exemplo, se o valor da mercadoria for R$ 270,00, a entrada e as duas prestações são iguais a R$ 90,00; se o valor da mercadoria for R$ 302,75, a entrada é de R$ 102,75 e as duas prestações são a iguais a R$ 100,00.<br>
<br>
Escreva uma função com PHP que receba o valor da mercadoria e forneça o valor da entrada e das duas prestações, de acordo com as regras acima.
    </p>
    </div>
    <div>
        <form method="post" action="ex009_parcelado.php">
            <label for="numero">Informe o valor: R$ </label>
            <input type="text" name="numero" id="numero">
            <button type="submit">calcular</button>
        </form>
    </div>
</body>
</html>

<?php

function parcelar($val){

    if ($val<=0){
        return "Valor inválido!";
    }

    $demais_parcelas = intdiv($val,3);
    $primeira_parcela = $val - 2*$demais_parcelas;

    return "A entrada é de R$ " . number_format($primeira_parcela, 2, ',', '.') ." e as duas prestações são a iguais a R$ " . number_format($demais_parcelas, 2, ',', '.') .".";
/*
    $entrada = floor($val / 3);
    $prestacao = floor(($val - $entrada) / 2);

    if ($entrada >= $prestacao * 2) {
        return "A entrada é de R$ " . number_format($entrada, 2, ',', '.') . " e as duas prestações são iguais a R$ " . number_format($prestacao, 2, ',', '.') . ".";
    } else {
        return "Não é possível parcelar o valor da mercadoria de acordo com as regras estabelecidas.";
    }*/

}

if(!isset($_POST["numero"])){
    die("Entre com os dados para calcular o valor das 3 parcelas.");
}

// Pega o valor do POST
$valor_br = $_POST['numero']; // Ex: 1.234,56

// Converte para formato internacional
$valor_en = str_replace(['.', ','], ['', '.'], $valor_br);

$preco = filter_var($valor_en, FILTER_VALIDATE_FLOAT);



echo "<hr>";
echo parcelar($preco);

?>