<?php

	class EventPess{

		private $codigo, $titulo, $data_ini, $data_fim, $descricao, $cod_user, $cod_local;

		//Construtor da Classe
		public function __construct($titulo, $data_ini, $data_fim, $descricao, $cod_user, $cod_local){
			$this->setTitulo($titulo);
			$this->setData_ini($data_ini);
			$this->setData_fim($data_fim);
			$this->setDescricao($descricao);
			$this->setCod_user($cod_user);
			$this->setCod_local($cod_local);
		}

		//Métodos Acessores e Modificadores
		public function getCodigo(){
			return $this->codigo;
		}

		public function setCodigo($valor){
			$this->codigo = $valor;
		}

		public function getTitulo(){
			return $this->titulo;
		}

		public function setTitulo($valor){
			$this->titulo = $valor;
		}

		public function getData_ini(){
			return $this->data_ini;
		}

		public function setData_ini($valor){
			$this->data_ini = $valor;
		}

		public function getData_fim(){
			return $this->data_fim;
		}

		public function setData_fim($valor){
			$this->data_fim = $valor;
		}

		public function getDescricao(){
			return $this->descricao;
		}

		public function setDescricao($valor){
			$this->descricao = $valor;
		}

		public function getCod_user(){
			return $this->cod_user;
		}

		public function setCod_user($valor){
			$this->cod_user = $valor;
		}

		public function getCod_local(){
			return $this->cod_local;
		}

		public function setCod_local($valor){
			$this->cod_local = $valor;
		}
	}
?>