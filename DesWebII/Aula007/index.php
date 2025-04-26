<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../Exercícios/style/estilos.css">
    <title>Cadastro de Aluno</title>
</head>
<body>
    <form method="POST" action="salvar.php">
        <div>
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" required><br>
        </div>
        <div>
            <label for="ra">RA:</label>
            <input type="text" id="ra" name="ra" required><br>
        </div>
        <div>
            <label for="cpf">CPF:</label>
            <input type="text" id="cpf" name="cpf" required><br>
        </div>
        
        <button type="submit">Cadastrar</button>
    </form>        
</body>
</html>