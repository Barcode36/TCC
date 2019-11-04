<?php
	require_once('Model/User.php');
	require_once('Control/UserDAO.php');

    //antiga Classe de Controle
	class Usuario{

    	public function inserir($nome, $usuario, $email, $senha, $telefone = null){
    		$user = new User($nome, $usuario, $email, $senha, $telefone);
    		$userDAO = new UserDAO();
    		$inseriu = $userDAO->inserir($user);
    		return $inseriu;
    	}

        public function buscar($user, $pass){
            $userDAO = new UserDAO();
            return ($userDAO->buscarUser($user, $pass));
        }

        public function validar($user, $email){
            $userDAO = new UserDAO();
            return ($userDAO->validarUser($user, $email));
        }

        public function buscarEmail($email){
            $userDAO = new UserDAO();
            return ($userDAO->buscarEmail($email));
        }

        public function redefinir($email, $senha){
            $userDAO = new UserDAO();
            $inseriu = $userDAO->atualizarSenha($email, $senha);
            return $inseriu;
        }
	}
?>