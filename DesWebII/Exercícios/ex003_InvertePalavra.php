<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style/estilos.css">
    <title>Inversor de Palavras</title>
</head>
<body>
    <div>
        <p>
        Inversor de Palavra<br>
        Crie uma função em PHP que receba uma palavra como parâmetro e retorne esta palavra invertida.<br>
        Por exemplo, se a função receber "teste", deve retornar "etset".<br>
        </p>
    </div>
    <div>
        <p>
            <h1>Inversor de Palavras</h1>
            <form method="post" action="ex003_InvertePalavra.php">
                <label for="palavra">Digite uma palavra:</label>
                <input type="text" name="palavra" id="palavra" minlength="2" maxlength="30" required autofocus>
                <button type="submit">Inverter</button>
            </form>
        </p>
    </div>
</body>
</html>

<?php
$palavra = $_POST['palavra'] ?? ''; // Se não houver valor, atribui ''
$palavraInvertida = '';
function invertePalavra($palavra){
    for($i = strlen($palavra) - 1; $i >= 0; $i--){
        $palavraInvertida .= $palavra[$i];
    }
    return $palavraInvertida;
}

if($palavra != ''){
    echo "A palavra $palavra invertida é: " .invertePalavra($palavra) . ".<br>";
    } else{
        echo "Digite uma palavra para inverter.";
}

?>