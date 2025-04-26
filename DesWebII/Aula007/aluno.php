<?php

class Aluno{
    public $nome;
    public $ra;
    private $cpf;

    public function __construct($nome, $ra, $cpf){
        $this->nome = $nome;
        $this->ra = $ra;
        $this->cpf = $cpf;
    }

    public function getCpf(){
        return $this->cpf;
    }

    public function setCpf($cpf){
        $this->cpf = $cpf;
    }

    public function imprimir(){
        return "<b>{$this->nome}</b> --> RA: {$this->ra} | CPF: {$this->cpf}";
    }

}