<?php
//POO
class Pessoa{
    public $nome;
    public $telefone;
    public $idade;
    private $cpf; # Atributo privado, só pode ser acessado dentro da classe
    //protected $cpf; # Pode ser acessado por classes filhas

    public function __construct($nome = null, $telefone = null, $idade = null, $cpf = null){
        $this->nome = $nome;
        $this->telefone = $telefone;
        $this->idade = $idade;
        $this->cpf = $cpf;
    }

    public function setCpf($cpf){
        if(!is_numeric($cpf) || strlen($cpf) != 11){
            echo "CPF inválido!<br>";
            return;
        }
        $this->cpf = $cpf;
    }
    public function getCpf(){
        return $this->cpf;
    }

    public function apresentar() : String{
        return "Meu nome é {$this->nome} e meu telefone é {$this->telefone}. 
        Minha idade é {$this->idade} anos.";
    }
}

$pessoa1 = new Pessoa();
$pessoa1->nome = "Thiago";
$pessoa1->telefone = "123456789";
$pessoa1->idade = 30;

//$pessoa1->setCpf("af"); # Erro, pois não é numérico
//$pessoa1->setCpf("1234567890"); # Erro, pois não tem 11 dígitos
//echo $pessoa1->cpf; # Erro, pois cpf é privado
$pessoa1->setCpf("12345678901");

echo $pessoa1->apresentar();
echo " - CPF: " .$pessoa1->getCpf() .". ";

echo "<br>";

$pessoa2 = new Pessoa("Maria", "987654321", 25, "10987654321");
echo $pessoa2->apresentar();
echo " - CPF: " .$pessoa2->getCpf() .". ";
echo "<br><hr>";

// Livro (titulo, autor) - detalhes() = Livro: $titulo | Autor: $autor
class Livro{
    public $titulo;
    public $autor;

    public function __construct($titulo = null, $autor = null){
        $this->titulo = $titulo;
        $this->autor = $autor;
        echo "Livro criado com sucesso!<br>";
    }

    public function detalhes() : String{
        return "Livro: {$this->titulo} | Autor: {$this->autor}";
    }
}

$livro1 = new Livro("Narnia", "C.S. Lewis");
$livro2 = new Livro("Harry Potter", "J.K. Rowling");
echo $livro1->detalhes();
echo "<br>";
echo $livro2->detalhes();
echo "<br><hr>";

class Veiculo{
    protected $marca;
    protected $modelo;

    public function __construct($marca, $modelo){
        $this->marca = $marca;
        $this->modelo = $modelo;    
    }

    public function exibirDetalhes(){
        return "Marca: {$this->marca} | Modelo: {$this->modelo}";
    }
}

class Carro extends Veiculo{
    public $numPortas;

    public function __construct($marca, $modelo, $numPortas){
        parent::__construct($marca, $modelo);
        $this->numPortas = $numPortas;
    }
    
    public function exibirDetalhes(){
        return parent::exibirDetalhes() . " | Números de portas: {$this->numPortas}";
    }
}


