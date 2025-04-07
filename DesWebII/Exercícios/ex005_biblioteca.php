<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style/estilos.css">
    <title>Biblioteca</title>
</head>
<body>
    <div>
        <p>Crie um arquivo php e implemente um sistema simples de biblioteca que:<br>
        <ol>
            <li>Tenha uma classe Livro com propriedades como título, autor e disponibilidade</li>
            <li>Tenha métodos para emprestar e devolver livros</li>
            <li>Utilize encapsulamento adequado (private/protected/public)</li>
            <li>Use construtores para inicializar objetos</li>
        </ol>
        </p>
        <hr>
    </div>
</body>
</html>

<?php

class Livro{
    public $titulo;
    public $autor;
    private $disponibilidade;

    public function __construct($titulo, $autor, $disponibilidade = true){
        $this->titulo = $titulo;
        $this->autor = $autor;
        $this->disponibilidade = $disponibilidade;
        //echo $disponibilidade;
    }

    public function exibirDetalhes(){
        return "O livro {$this->titulo} do autor {$this->autor} encontra-se " . ($this->disponibilidade ? "disponível." : "indisponível.");
    }

    public function emprestarLivro(){
        if (!$this->disponibilidade) {
            return "O livro {$this->titulo} encontra-se indisponível.";
        }
        $this->disponibilidade = false;
        return "Livro {$this->titulo} está disponível. Boa leitura!";
    }

    public function devolverLivro(){
        $this->disponibilidade = true;
        return "Livro {$this->titulo} devolvido. Obrigado!";
    }

}

$livro1 = new Livro("Narnia", "C. S. Lewis");
echo $livro1->exibirDetalhes();
echo "<br>";
echo $livro1->emprestarLivro();
echo "<br>";
echo $livro1->emprestarLivro();
echo "<br>";
echo $livro1->devolverLivro();
echo "<br>";
echo $livro1->emprestarLivro();

?>