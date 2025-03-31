<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="estilos/estilos.css">
    <title>Agenda Simples</title>
</head>
<body>
    <div>
        <p>
        <strong>Agenda Simples - PHP</strong><br>
        Crie um arquivo PHP que implemente uma agenda simples que permita:<br>
        <ul>
            <li>Adicionar contatos (nome, telefone, email)</li>
            <li>Listar todos os contatos</li>
            <li>Buscar um contato pelo nome</li>
            <li>Remover um contato pelo nome</li>
        </ul>
        </p>
    </div>
    <div>
        <h3>Adicionar Contato</h3>
        <p>Preencha os campos abaixo para adicionar um novo contato:</p>
        <form method="post" action="003_agendaSimples.php">
            <input type="hidden" name="action" value="adicionar">
            <label for="nome">Nome:</label>
            <input type="text" name="nome" id="nome" required>
            <label for="telefone">Telefone:</label>
            <input type="text" name="telefone" id="telefone" required>
            <label for="email">Email:</label>
            <input type="email" name="email" id="email" required>
            <button type="submit">Adicionar Contato</button>
        </form>
    </div>
    <div>
        <form method="post" action="003_agendaSimples.php">
            <input type="hidden" name="action" value="listar">
            <button type="submit">Listar Contatos</button>
        </form>
    </div>
    <div>
        <form method="post" action="003_agendaSimples.php">
            <h3>Buscar Contato</h3>
            <label for="buscar">Nome:</label>
            <input type="hidden" name="action" value="buscar">
            <input type="text" name="buscar" id="buscar">
            <button type="submit">Buscar</button>
    </div>

    <?php
    session_start();

    function adicionarContato() {
        $nome = $_POST['nome'];
        $telefone = $_POST['telefone'];
        $email = $_POST['email'];

        $_SESSION['contatos'][$nome] = ['telefone' => $telefone, 'email' => $email];
        echo "<p>Contato $nome adicionado com sucesso!</p>";
    }

    function listarContatos(){
        echo "<h4>Contatos</h4>";
        if (empty($_SESSION['contatos'])) {
            echo "<p>Nenhum contato cadastrado.</p>";
        } else {
            echo "<ul>";
            foreach ($_SESSION['contatos'] as $nome => $info) {
                echo "<li>$nome => Telefone: {$info['telefone']} / Email: {$info['email']} </li>";
            }
            echo "</ul>";
        }
    }

    function buscarContato() {
        echo "entrou na função buscarContato() <br>";
    }
    

    if (!isset($_SESSION['contatos'])) {
        $_SESSION['contatos'] = [];
    }

    if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['action'])) {
        switch ($_POST['action']) {
            case 'adicionar':
                adicionarContato();
                break;
            case 'listar':
                listarContatos();
                break;
            case 'buscar':
                clearstatcache();
                buscarContato();
                break;
        }
    }




    ?>
</body>
</html>