<?php
	require_once('Conexao.php');
	
	class UserDAO{

		//Método para inserir novo usuário 
		public function inserir(User $user){

			$inseriu = false;


			$senha = md5($user->getSenha());
			$usuario = $user->getUsuario();
			$email = $user->getEmail();

			$query = "SELECT * FROM Amge_user WHERE usuario = '{$usuario}' OR email = '{$email}'";
			$result = Conexao::getConn()->prepare($query);
			$result->execute();

			if($result->rowCount() == 0){
				try{
					$sql = "INSERT INTO Amge_user (nome, usuario, email, senha, telefone) VALUES (?, ?, ?, '{$senha}', ?)";

					$stmt = Conexao::getConn()->prepare($sql);

					$stmt->bindValue(1, $user->getNome());
					$stmt->bindValue(2, $user->getUsuario());
					$stmt->bindValue(3, $user->getEmail());
					$stmt->bindValue(4, $user->getTelefone());

					$stmt->execute();

					$inseriu = true;

				}catch(PDOException $ex){
					echo 'Erro de conexão: '.$ex->getMessage();
				}
			}

			return $inseriu;
		}

		
		//validar Usuário e Senha
		public function buscarUser($user, $pass){
			$sql = "SELECT * FROM Amge_user WHERE usuario = '{$user}' AND senha = md5('{$pass}')";

			$stmt = Conexao::getConn()->prepare($sql);
			$stmt->execute();

			if($stmt->rowCount() >= 0){
				$listaUser = $stmt->fetchAll(PDO::FETCH_ASSOC); //retorna um array com todos os registros
				return $listaUser;
			}else{
				return []; //um array vazio
			}
		}

		//validar Usuário e Email
		public function validarUser($user, $email){
			$sql = "SELECT * FROM Amge_user WHERE usuario = '{$user}' AND email = '{$email}'";

			$stmt = Conexao::getConn()->prepare($sql);
			$stmt->execute();

			if($stmt->rowCount() > 0){
				$listaUser = $stmt->fetchAll(PDO::FETCH_ASSOC); //retorna um array com todos os registros
				return $listaUser;
			}else{
				return []; //um array vazio
			}
		}

		//buscar Email
		public function buscarEmail($email){
			$sql = "SELECT email FROM Amge_user WHERE email = '{$email}'";

			$stmt = Conexao::getConn()->prepare($sql);
			$stmt->execute();

			if($stmt->rowCount() > 0){
				$listaUser = $stmt->fetchAll(PDO::FETCH_ASSOC);
				return $listaUser;
			}else{
				return [];
			}
		}

		//Update Senha
		public function atualizarSenha($email, $senha){
			$inseriu = false;

			try{
				$sql = "UPDATE Amge_user SET senha = md5({$senha}) WHERE email = '{$email}'";
				$stmt = Conexao::getConn()->prepare($sql);
				$stmt->execute();

				$inseriu = true;
			}catch(PDOException $ex){
				echo 'Erro de conexão: '.$ex->getMessage();
			}
			
			return $inseriu;
		}
	}
?>