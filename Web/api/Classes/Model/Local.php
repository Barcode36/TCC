<?php

	class Local{

		private $codigo, $nome, $rua, $bairro, $cidade, $estado;
		
		//Construtor da Classe
		function __construct($nome, $rua, $bairro, $cidade, $estado){
			$this->setNome($nome);
			$this->setRua($rua);
			$this->setBairro($bairro);
			$this->setCidade($cidade);
			$this->setEstado($estado);
		}

		//Métodos Acessores e Modificadores
		public function getCodigo(){
			return $this->codigo;
		}

		public function setCodigo($valor){
			$this->codigo = $valor;
		}

		public function getNome(){
			return $this->nome;
		}

		public function setNome($valor){
			$this->nome = $valor;
		}

		public function getRua(){
			return $this->rua;
		}

		public function setRua($valor){
			$this->rua = $valor;
		}

		public function getBairro(){
			return $this->bairro;
		}

		public function setBairro($valor){
			$this->bairro = $valor;
		}

		public function getCidade(){
			return $this->cidade;
		}

		public function setCidade($valor){
			$this->cidade = $valor;
		}

		public function getEstado(){
			return $this->estado;
		}

		public function setEstado($valor){
			$this->estado = $valor;
		}
	}
?>