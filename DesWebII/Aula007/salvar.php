<?php
//include "aluno.php"; #quando o código pode executar mesmo caso não consiga carregar o arquivo
require_once("aluno.php"); #quando o código não pode executar caso não consiga carregar o arquivo

//Verifica se os dados foram enviados via post
if(!isset($_POST["nome"]) || !isset($_POST["ra"]) || !isset($_POST["cpf"])){
    //die("Dados não informados.");
    header("Location: index.php");
}

$nome = filter_input(INPUT_POST, 'nome', FILTER_SANITIZE_FULL_SPECIAL_CHARS); # $_POST["nome"];
$ra = filter_input(INPUT_POST, 'ra', FILTER_VALIDATE_INT); //$_POST["ra"];
$cpf = filter_input(INPUT_POST, 'cpf', FILTER_VALIDATE_INT); // $_POST["cpf"];
$aluno = new Aluno($nome, $ra, $cpf);

?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../Exercícios/style/estilos.css">
    <title>Detalhes - Aluno</title>
</head>
<body>
    <p>Aluno cadastrado com sucesso!</p>
    <p>
        <?php echo $aluno->imprimir();
        // <?= $aluno->imprimir(); # para echo é uma opção
        ?>
    </p>
</body>
</html>