<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Revisão 2</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        form {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"] {
            width: 200px;
            padding: 5px;
            margin-bottom: 10px;
        }
        button {
            padding: 5px 10px;
        }
    </style>
</head>
<body>
    <form action="calcular.php" method="post">
        <label for="calculo" >Calcular aumento de salário</label><br>
        <input type="text" name="salario" id="salario" placeholder="Valor do salário" required><br>
        <input type="text" name="aumento" id="aumento" placeholder="Valor do aumento"><br>
        <button type="submit">Calcular</button>
    </form>
    <hr>
    <form action="entrenumeros.php" method="post">
        <label for="numeros">Exibir números entre dois valores</label><br>
        <input type="text" name="numero_inicial" placeholder="Número inicial" required><br>
        <input type="text" name="numero_final" placeholder="Número final" required><br>
        <button type="submit">Exibir números</button>
    </form>
    <hr>
    <form action="tabuada.php" method="post">
        <label for="tabuada">Informe o número para exibir a tabuada</label><br>
        <input type="text" name="numero" placeholder="Digite o valor"><br>
        <button type="submit">Exibir</button>
    </form>
</body>
</html>