<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tudo igual? - PHP</title>
    <link rel="stylesheet" href="style/estilos.css">
</head>
<body>
    <div>
        <p>
        <h3>Tudo igual? - PHP</h3>
        Descrição<br>
        Desenvolver uma função em PHP que verifique se uma string é um palíndromo, aplicando conceitos de manipulação de strings e lógica de programação.
        O que é um Palíndromo?
        Um palíndromo é uma palavra, frase, número ou qualquer outra sequência de caracteres que se lê da mesma forma de trás para frente, ignorando espaços, pontuação e diferenciação entre maiúsculas e minúsculas.
        <ul>Exemplos de palíndromos:
            <li>"Ana" → é igual lido de trás para frente</li>
            <li>"Socorram-me, subi no ônibus em Marrocos" → sem espaços e acentos, lê-se igual de trás para frente</li>
            <li> "A man, a plan, a canal: Panama" → ignorando espaços e pontuação</li>
        </ul>
        <ul>Requisitos da Função
            <li>Deve receber uma string como parâmetro</li>
            <li>Deve ignorar espaços, pontuação e diferenciação entre maiúsculas e minúsculas</li>
            <li>Deve retornar true se a string for um palíndromo e false caso contrário</li>
            <li>Deve utilizar conceitos de PHP para tipagem adequada</li>
        </ul>
        </p>
    </div>
    <div>
        <p>Informe a palavra ou frase:
            <form method="POST" action="ex012_palindromo.php">
                <label for="palindromo">Digite:</label>
                <input type="text" id="palindromo" name="palindromo" style="width:400px;" required>
                <button type="submit">Verificar</button>
            </form>
        </p>
    </div>
</body>
</html>
<?php


function verificaPalindromo(String $frase):bool{
    //$acentos = 'áàâãäéèêëíìîïóòôõöúùûüçÁÀÂÃÄÉÈÊËÍÌÎÏÓÒÔÕÖÚÙÛÜÇ';
    //$sem_acentos = 'aaaaaeeeeiiiiooooouuuucAAAAAEEEEIIIIOOOOOUUUUC';
    //$frase = strtr($frase, $acentos, $sem_acentos); //não funciona
    //$frase = str_replace(str_split($acentos), str_split($sem_acentos), $frase); //não funciona
    $frase = iconv('UTF-8', "ASCII//TRANSLIT", $frase);
    // OU, para remover apenas os acentos (mais específico):
    //$frase = preg_replace('/[\x{0300}-\x{036F}]/u', '', $frase); // Remove caracteres de combinação

    $frase = strtolower($frase);
    $frase = preg_replace("/[^a-zA-Z0-9]/", "", $frase);
    echo $frase;
    echo "<br>";
    return $frase === strrev($frase);
}
echo "<hr>";
if(!isset($_POST['palindromo'])){
    die("Preencha o campo acima!");
}

$texto = filter_input(INPUT_POST, "palindromo", FILTER_SANITIZE_SPECIAL_CHARS);
//$texto = filter_var($texto, FILTER_SANITIZE);

if (verificaPalindromo($texto)) {
    echo "É palíndromo!";
} else {
    echo "Não é palíndromo!";
}

?>