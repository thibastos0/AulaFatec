<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fora do array - PHP</title>
    <link rel="stylesheet" href="style/estilos.css">
</head>
<body>
    <div>
        <h3>Fora do array - PHP</h3>
        <p>Descrição
        <ul>Dado um array de números, você se move dentro do array pelo valor do elemento atual. Escreva uma função jump_out_of_array que retorne:
            <li>A quantidade de saltos até que você salte para fora do array.</li>
            <li>-1 quando você alcançar o final do array mas não conseguir sair dele.</li>
        </ul>
        <ul>Requisitos:
            <li>O tamanho do array é indefinido.</li>
            <li>elementos do array são números inteiros, positivos ou negativos.</li>
        </ul>
        <ul>Exemplo: Dado o array A = [2, 3, -1, 1, 6, 4]:
            <li>Salto 1: A[0] + 2 = A[2]</li>
            <li>Salto 2: A[2] + (-1) = A[1]</li>
            <li>Salto 3: A[1] + 3 = A[4]</li>
            <li>Salto 4: A[4] + 6 = fora do índice</li>
        </ul>
         Portanto, o resultado é 4, pois são necessários 4 saltos para sair do array.</p>
    </div>
    <hr>
    <div>
        <p>Informe os dados:
            <form method="POST" action="ex010_foraArray.php">
                <label for="quantidade">Quantidade de números para a array</label>
                <input type="text" id="quantidade" name="quantidade">
                <button type="submit">Enviar</button>
            </form>
        </p>
    </div>
</body>
</html>

<?php

function jump_out_of_array($A){
    $j = 0;
    $saltos = 0;
    while ($j < count($A)) {
        $proximo = $j + $A[$j];        
        echo "Salto " .$saltos+1 ." : A[$j] + " .$A[$j] ." = A[$proximo]";
        echo "<br>";
        if ($proximo == (count($A)-1)){
            $proximo -= 1;
        } elseif ($proximo < 0){
            $proximo *= -1;
        }
        $j = $proximo;
        $saltos += 1;
    }
    return "São necessário $saltos saltos para sair do array.";
}

if(!isset($_POST["quantidade"])){
    die("inserir valor.");
}

$qtdade = filter_input(INPUT_POST, 'quantidade', FILTER_VALIDATE_INT);
$vetor = [];

for ($i=0; $i < $qtdade; $i++) { 
    $vetor[$i] = rand(-5, $qtdade);
}
$vetor = array_unique($vetor); //removendo valores repetidos
//print_r($vetor);
var_dump($vetor);
echo "<hr>";
echo "<br>";
echo jump_out_of_array($vetor);
?>