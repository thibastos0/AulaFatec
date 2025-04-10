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
    private $limite = 0;

    public function __construct($titular, $endereco, $cep, $cpf, $numAgencia, $numConta, $saldoInicial = 0){
        parent::__construct($titular, $endereco, $cep, $cpf);
        $this->numAgencia = $numAgencia;
        $this->numConta = $numConta;
        $this->saldo = $saldoInicial;
        $this->tipo = self::TIPO_CORRENTE;
    }

    public function depositar($valor){
        if($valor > 0){
            $this->saldo += $valor;
            return "Depósito de R$ {$valor} realizado com sucesso. Saldo atual: R$ {$this->saldo}.";
        } else {
            throw new Exception("Valor de depósito inválido.");
        }
    }
    public function sacar($valor){
        if($valor > 0 && $valor <= $this->saldo + $this->limite){
            $this->saldo -= $valor;
            return "Saque de R$ {$valor} realizado com sucesso. Saldo atual: R$ {$this->saldo}.";
        } else {
            throw new Exception("Saldo insuficiente.");
        }
    }
    public function transferir($valor, $contaDestino){
        if($valor > 0 && $valor <= $this->saldo + $this->limite){
            $this->sacar($valor);
            $contaDestino->depositar($valor);
            return "Transferência de R$ {$valor} realizada com sucesso para a conta de {$contaDestino->titular}.";
        } else {
            throw new Exception("Saldo insuficiente para transferência.");
        }
    }
    public function VerSaldo(){
        return " Titular: {$this->titular}. | Número da agência: {$this->numAgencia}. | Número da conta: {$this->numConta}. | Saldo: R$ {$this->saldo}.";
    }

    public function setLimite($limite){
        if($limite >= 0){
            $this->limite = $limite;
        } else {
            throw new Exception("Limite não pode ser negativo.");
        }
    }
    public function getLimite(){
        return $this->limite;
    }

}

class ContaPoupanca extends ContaBancaria{
    private $numAgencia;
    private $numConta;
    private $saldo;
    private $limite = 0;
    private $juros = 0;
    private $dataAniversario;

    public function __construct($titular, $endereco, $cep, $cpf, $numAgencia, $numConta, $saldoInicial = 0){
        parent::__construct($titular, $endereco, $cep, $cpf);
        $this->numAgencia = $numAgencia;
        $this->numConta = $numConta;
        $this->saldo = $saldoInicial;
        $this->tipo = self::TIPO_POUPANCA;
    }

    public function depositar($valor){
        if($valor > 0){
            $this->saldo += $valor;
            return "Depósito de R$ {$valor} realizado com sucesso. Saldo atual: R$ {$this->saldo}.";
        } else {
            throw new Exception("Valor de depósito inválido.");
        }
    }

    public function sacar($valor){
        if($valor > 0 && $valor <= $this->saldo + $this->limite){
            $this->saldo -= $valor;
            return "Saque de R$ {$valor} realizado com sucesso. Saldo atual: R$ {$this->saldo}.";
        } else {
            throw new Exception("Saldo insuficiente.");
        } 
    }

    public function transferir($valor, $contaDestino){
        if($valor > 0 && $valor <= $this->saldo + $this->limite){
            $this->sacar($valor);
            $contaDestino->depositar($valor);
            return "Transferência de R$ {$valor} realizada com sucesso para a conta de {$contaDestino->titular}.";
        } else {
            throw new Exception("Saldo insuficiente para transferência.");
        }
    }

    public function verSaldo(){
        return " Titular: {$this->titular}. | Número da agência: {$this->numAgencia}. | Número da conta: {$this->numConta}. | Saldo: R$ {$this->saldo}.";
    }

    public function setLimite($limite){
        if($limite >= 0){
            $this->limite = $limite;
        } else {
            throw new Exception("Limite não pode ser negativo.");
        }
    }

    public function getLimite(){
        return $this->limite;
    }

    private function calcularJuros($juros){
        if($juros > 0){
            $this->saldo += $this->saldo * ($juros / 100);
            return "Juros de {$juros}% aplicados. Saldo atual: R$ {$this->saldo}.";
        } else {
            throw new Exception("Valor de juros inválido.");
        }
    }
    public function setDataAniversario($data){
        $this->dataAniversario = $data;
    }
    public function getDataAniversario(){
        return $this->dataAniversario;
    }
    public function aplicarJurosAniversario(){
        $dataAtual = date("d/m");
        if($this->dataAniversario == $dataAtual){
            return $this->calcularJuros($this->juros);
        } else {
            return "Hoje não é o dia do aniversário da conta.";
        }
    }
    public function setJuros($juros){
        if($juros > 0){
            $this->juros = $juros;
        } else {
            throw new Exception("Valor de juros inválido.");
        }
    }
    public function getJuros(){
        return $this->juros;
    }

}

$cliente1 = new ContaCorrente("Thiago", ["Rua"=>"Dos Bancários", "Numero"=>"1000", "Cidade"=>"Indaiatuba", "Estado"=>"SP"], "12345000", "09876543211", "1234", "56789", 1000);
$cliente2 = new ContaPoupanca("Ana", ["Rua"=>"Das Flores", "Numero"=>"2000", "Cidade"=>"Campinas", "Estado"=>"SP"], "12345000", "12345678900", "4321", "98765");
echo $cliente2->setDataAniversario("09/04");
echo "<br>";


echo $cliente1->exibirDados();
echo "<br>";
echo "<hr>";
echo $cliente2->exibirDados();
echo "<br>";
echo "<hr>";
echo $cliente1->VerSaldo();
echo "<br>";
echo $cliente1->depositar(500);
echo "<br>";
echo $cliente1->sacar(200);
echo "<br>";
echo $cliente1->VerSaldo();
echo "<br>";
echo $cliente1->transferir(300, $cliente2);
echo "<br>";
echo $cliente1->VerSaldo();
echo "<br>";
echo $cliente2->VerSaldo();
echo "<br>";
echo "<hr>";
echo "Definindo novo juros em 0.5%... ";
echo "<br>";
echo $cliente2->setJuros(0.5);
echo "<br>";
echo $cliente2->aplicarJurosAniversario();
echo "<br>";
echo $cliente2->VerSaldo();
echo "<br>";
?>