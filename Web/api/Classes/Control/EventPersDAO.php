<?php
	require_once('Conexao.php');
	
	class EventPersDAO{

		//Método para inserir um novo evento 
		public function inserir(EventPess $eventPess){ //atributos da classe incluem codigos de usuario e local

			$inseriu = false;
			try{
				$sql = "INSERT INTO Amge_pers_event (titulo, data_ini, data_fim, descricao, cod_user, cod_local) VALUES (?, ?, ?, ?, ?, ?)";

				$stmt = Conexao::getConn()->prepare($sql);

				$stmt->bindValue(1, $eventPess->getTitulo());
				$stmt->bindValue(2, $eventPess->getData_ini());
				$stmt->bindValue(3, $eventPess->getData_fim());
				$stmt->bindValue(4, $eventPess->getDescricao());
				$stmt->bindValue(5, $eventPess->getCod_user());
				$stmt->bindValue(6, $eventPess->getCod_local());

				$stmt->execute();

				$inseriu = true;

			}catch(PDOException $ex){
				echo 'Erro de conexão: ' . $ex->getMessage();
			}

			return $inseriu;
		}

		//Método para listas todos os eventos pessoais
		public function buscar($cod_user){
			$sql = "SELECT * FROM Amge_pers_event WHERE cod_user = '{$cod_user}' ";

			$stmt = Conexao::getConn()->prepare($sql);

			$stmt->execute();

			if($stmt->rowCount() >= 0){
				$listaEvent = $stmt->fetchAll(PDO::FETCH_ASSOC); //retorna um array com todos os registros
				return $listaEvent;
			}else{
				return []; //um array vazio
			}
		}

		//Update Evento
		public function atualizarEvento($codigo, EventPess $eventPess){
			$atualizou = false;

			try{
				$sql = "UPDATE Amge_pers_event SET titulo = ?, data_ini = ?, data_fim = ?, descricao = ?, cod_user = ?, cod_local = ? WHERE codigo = '{$codigo}' ";

				$stmt = Conexao::getConn()->prepare($sql);

				$stmt->bindValue(1, $eventPess->getTitulo());
				$stmt->bindValue(2, $eventPess->getData_ini());
				$stmt->bindValue(3, $eventPess->getData_fim());
				$stmt->bindValue(4, $eventPess->getDescricao());
				$stmt->bindValue(5, $eventPess->getCod_user());
				$stmt->bindValue(6, $eventPess->getCod_local());

				$stmt->execute();

				$atualizou = true;
			}catch(PDOException $ex){
				echo 'Erro de conexão: '.$ex->getMessage();
			}
			
			return $atualizou;
		}
	}
?>