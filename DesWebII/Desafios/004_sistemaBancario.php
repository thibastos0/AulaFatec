<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="estilos/estilos.css">
    <title>Sistema Bancário</title>
</head>
<body>
    <div>
        <p>Crie um pequeno sistema bancário orientado a objetos em PHP que:<br>
        <ol>
            <li>Tenha uma classe base <u>ContaBancaria</u> com métodos comuns</li>
            <li>Tenha classes derivadas como <u>ContaCorrente</u> e <u>ContaPoupanca</u> com comportamentos específicos</li>
            <li>Implemente operações como depósito, saque e transferência entre contas</li>
            <li>Use tratamento de exceções para situações como saldo insuficiente</li>
            <li>Aplique encapsulamento para proteger os dados das contas</li>
        </ol>
        </p>
    </div>
    <hr>
</body>
</html>

<?php
class ContaBancaria{
    protected $titular;
    protected $endereco;
    protected $cep;
    private $cpf;
    protected $tipo;
    const TIPO_CORRENTE = "Corrente";
    const TIPO_POUPANCA = "Poupança";

    public function __construct($titular, $endereco = [
        "Rua" => "",
        "Numero" => "",
        "Cidade" => "",
        "Estado" => "",
                        ], $cep, $cpf) {
        $this->titular = $titular;
        $this->endereco = $endereco;
        $this->cep = $cep;
        $this->cpf = $cpf;
    }

    public function exibirDados(){
        return "Seguem informações pessoais do titular '{$this->titular}': <br>Endereço: Rua {$this->endereco['Rua']}, número {$this->endereco['Numero']}, {$this->endereco['Cidade']}/{$this->endereco['Estado']}. | CEP: {$this->cep}. | CPF: {$this->cpf}. | Tipo de conta: {$this->tipo}.";
    }
    
}

class ContaCorrente extends ContaBancaria{
    private $numAgencia;
    private $numConta;
    private $saldo;

    public function __construct($titular, $endereco, $cep, $cpf, $numAgencia, $numConta, $saldoInicial = 0){
        parent::__construct($titular, $endereco, $cep, $cpf);
        $this->numAgencia = $numAgencia;
        $this->numConta = $numConta;
        $this->saldo = $saldoInicial;
        $this->tipo = self::TIPO_CORRENTE;
    }

}

class ContaPoupanca extends ContaBancaria{
    private $numAgencia;
    private $numConta;
    private $saldo;

    public function __construct($titular, $endereco, $cep, $cpf, $numAgencia, $numConta, $saldoInicial = 0){
        parent::__construct($titular, $endereco, $cep, $cpf);
        $this->numAgencia = $numAgencia;
        $this->numConta = $numConta;
        $this->saldo = $saldoInicial;
        $this->tipo = self::TIPO_POUPANCA;
    }
}

$cliente1 = new ContaCorrente("Thiago", ["Rua"=>"Dos Bancários", "Numero"=>"1000", "Cidade"=>"Indaiatuba", "Estado"=>"SP"], "12345000", "09876543211", "1234", "56789", 1000);
$cliente2 = new ContaPoupanca("Ana", ["Rua"=>"Das Flores", "Numero"=>"2000", "Cidade"=>"Campinas", "Estado"=>"SP"], "12345000", "12345678900", "4321", "98765");

echo $cliente1->exibirDados();
echo "<br>";
echo "<hr>";
echo $cliente2->exibirDados();
echo "<br>";

?>