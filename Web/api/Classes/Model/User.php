<?php

	class User{

		private $codigo, $nome, $usuario, $email, $senha, $telefone, $foto;

		//Construtor da Classe
		public function __construct($nome, $usuario, $email, $senha, $telefone){
			$this->setNome($nome);
			$this->setUsuario($usuario);
			$this->setEmail($email);
			$this->setSenha($senha);
			$this->setTelefone($telefone);
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

		public function getUsuario(){
			return $this->usuario;
		}

		public function setUsuario($valor){
			$this->usuario = $valor;
		}

		public function getEmail(){
			return $this->email;
		}

		public function setEmail($valor){
			$emailLimpo = filter_var($valor, FILTER_SANITIZE_EMAIL);
			$this->email = $emailLimpo;
		}

		public function getSenha(){
			return $this->senha;
		}

		public function setSenha($valor){
			$this->senha = $valor;
		}

		public function getTelefone(){
			return $this->telefone;
		}

		public function setTelefone($valor){
			$this->telefone = $valor;
		}

		public function getFoto(){
			return $this->foto;
		}

		public function setFoto($valor){
			$this->foto = $valor;
		}
	}
?>