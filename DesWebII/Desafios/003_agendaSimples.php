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
        </form>
    </div>
    <div>
        <form method="post" action="003_agendaSimples.php">
            <h3>Remover Contato</h3>
            <laber for="remover">Remover</label>
            <input type="hidden" name="action" value="remover">
            <input type="text" name="remover" id="remover">
            <button type="submit">Remover</button>
        </form>
    </div>
</body>
</html>    

    <?php
    session_start();

    function adicionarContato() {
        // $nome = ucwords(strtolower(trim($_POST['nome']))); // Formata o nome
        $nome = ucfirst(strtolower($_POST['nome'])); // Formata o nome
        $telefone = $_POST['telefone'];
        $email = $_POST['email'];

        $_SESSION['contatos'][$nome] = ['telefone' => $telefone, 'email' => $email];
        echo "<hr>";
        echo "<p>Contato $nome adicionado com sucesso!</p>";
    }

    function listarContatos(){
        echo "<h4>Lista de contatos: </h4>";
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
        $nome = ucfirst(strtolower($_POST['buscar'])) ?? null;
        if ($nome) {
            if (isset($_SESSION['contatos'][$nome])) {
                $info = $_SESSION['contatos'][$nome];
                echo "<p>Contato encontrado: $nome => Telefone: {$info['telefone']} / Email: {$info['email']}</p>";
            } else {
                echo "<p>Contato '$nome' não encontrado.</p>";
            }
        } else {
            echo "<p>Nome não informado.</p>";
        }
    }

    function removerContato(){
        $nome = ucfirst(strtolower($_POST['remover'])) ?? null;
        if ($nome) {
            if (isset($_SESSION['contatos'][$nome])) {
                unset($_SESSION['contatos'][$nome]);
                echo "<p>Contato $nome removido com sucesso!</p>";
            } else {
                echo "<p>Contato '$nome' não encontrado.</p>";
            }
        } else {
            echo "<p>Nome não informado.</p>";
        }
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
                echo "<hr>";
                listarContatos();
                break;
            case 'buscar':
                clearstatcache();
                echo "<hr>";
                buscarContato();
                break;
            case 'remover':
                clearstatcache();
                echo "<hr>";
                removerContato();
                break;
            default:
                echo "Escolha uma opção. <br>";
        }
    }




    ?>
