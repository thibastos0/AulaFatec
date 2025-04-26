<?php
class Funcionario{
    public $salario;
    private $reajuste;

    public function __construct($salario, $reajuste = 2){
        $this->salario = $salario;
        $this->reajuste = $reajuste;
    }

    public function imprimir(){
        $salarioformatado = number_format($this->salario, 2, ',', '.');
        return "Salário: R$ {$salarioformatado}";
        
    }

    public function calcularReajuste(){
        $this->salario += $this->salario * ($this->reajuste/100);
    }

    public function setReajuste($reajuste){
        $this->reajuste = $reajuste;
    }
    public function getReajuste(){
        return $this->reajuste;
    }

}
?>