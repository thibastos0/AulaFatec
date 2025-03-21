<?php
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calcula Salário</title>
    <link rel="stylesheet" href="estilos\estilos.css">
</head>
<body>
    <div>
        <p>
            <h1>Calcula Salário</h1>
            Queremos criar uma calculadora para verificar quanto de imposto alguém vai ter descontado do seu salário dependendo do valor que ele recebeu, para isso, crie um arquivo .php e construa um formulário que vai ter um campo para inserir o salário e um botão para enviar o formulário, em seguida, faça um código que vai receber o valor do salário e calcular o imposto de acordo com a tabela abaixo:<br>
           <ul>
                <li>Salário até R$ 1.903,98: Isento</li>
                <li>Salário de R$ 1.903,99 até R$ 2.826,65: 7,5%</li>
                <li>Salário de R$ 2.826,66 até R$ 3.751,05: 15%</li>
                <li>Salário de R$ 3.751,06 até R$ 4.664,68: 22,5%</li>
                <li>Salário acima de R$ 4.664,68: 27,5%</li>
            </ul>
            <br>
            Exemplo de saída esperado:<br>
            <br>    Salário: R$ 2.000,00<br>
            Imposto: R$ 150,00
        </p>
    </div>
    <hr>
    <div>
    <form method="post" action="002_calcSalario.php" autofocus>
        <label for="salario">Salário em R$: </label>
        <input type="number" name="salario" id="salario" step="0.01" min="0" placeholder="insira o valor" required>
        <button type="submit">Calcular</button>
    </form>
    </div>
</body>
</html>

<?php
$num = $_POST['salario'] ?? 0; // Se não houver valor, atribui 0
$imposto = 0;
$salario = 0;

function calculaSalario($num, $imposto){
    return $num - $imposto;
}

switch ($num) {
    case ($num > 4664.68):
        $imposto = $num*0.275;
        $salario = calculaSalario($num, $imposto);
        echo "Salário: R$ " .number_format($salario, 2, ',', '.') ."<br>";
        echo "Imposto: R$ " .number_format($imposto, 2, ',', '.') ."<br>";
        break;
    case ($num >= 3751.06 && $num <= 4664.68):
        $imposto = $num*0.225;
        $salario = calculaSalario($num, $imposto);
        echo "Salário: R$ " .number_format($salario, 2, ',', '.') ."<br>";
        echo "Imposto: R$ " .number_format($imposto, 2, ',', '.') ."<br>";
        break;
    case ($num >= 2826.66 && $num <= 3751.05):
        $imposto = $num*0.15;
        $salario = calculaSalario($num, $imposto);
        echo "Salário: R$ " .number_format($salario, 2, ',', '.') ."<br>";
        echo "Imposto: R$ " .number_format($imposto, 2, ',', '.') ."<br>";
        break;
    case ($num >= 1903.99 && $num <= 2826.65):
        $imposto = $num*0.075;
        $salario = calculaSalario($num, $imposto);
        echo "Salário: R$ " .number_format($salario, 2, ',', '.') ."<br>";
        echo "Imposto: R$ " .number_format($imposto, 2, ',', '.') ."<br>";
        break;
    case ($num <= 1903.98):
        echo "Salário: R$ " .number_format($num, 2, ',', '.') ."<br>";
        echo "Imposto: Isento<br>";
        break;
    default:
        echo "Informe o valor para cálculo do salário! <br>";
        break;
}
/* number_format($num, 2, ',', '.'); # Formata o número com 2 casas decimais, separador de milhar '.' e separador de decimal ',' */
?>