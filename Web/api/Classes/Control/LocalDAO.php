<?php
	require_once('Conexao.php');

	class localDAO{

		//Método para inserir novo local 
		public function inserir(Local $local){

			$inseriu = false;

			try{
				$sql = "INSERT INTO Amge_local (nome, rua, bairro, cidade, estado) VALUES (?, ?, ?, ?, ?)";

				$stmt = Conexao::getConn()->prepare($sql);

				$stmt->bindValue(1, $local->getNome());
				$stmt->bindValue(2, $local->getRua());
				$stmt->bindValue(3, $local->getBairro());
				$stmt->bindValue(4, $local->getCidade());
				$stmt->bindValue(5, $local->getEstado());

				$stmt->execute();

				$inseriu = true;

			}catch(PDOException $ex){
				echo 'Erro de conexão: '.$ex->getMessage();
			}

			return $inseriu;
		}

		//buscar endereco
		public function buscarEndereco($cod_local){
			$sql = "SELECT * FROM Amge_local WHERE codigo = '{$cod_local}'";

			$stmt = Conexao::getConn()->prepare($sql);
			$stmt->execute();

			if($stmt->rowCount() > 0){
				$listaUser = $stmt->fetchAll(PDO::FETCH_ASSOC);
				return $listaUser;
			}else{
				return [];
			}
		}
	}
?>