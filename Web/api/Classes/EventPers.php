<?php
	require_once('Model/EventPess.php');
	require_once('Control/EventPersDAO.php');

    //antiga Classe de Controle
	class EventPers{

    	public function inserir($titulo, $data_ini, $data_fim, $descricao, $cod_user, $cod_local){
    		$event = new EventPess($titulo, $data_ini, $data_fim, $descricao, $cod_user, $cod_local);
    		$eventDAO = new EventPersDAO();
    		$inseriu = $eventDAO->inserir($event);
    		return $inseriu;
    	}

        public function buscar($cod_user){
            $eventDAO = new EventPersDAO();
            return ($eventDAO->buscar($cod_user));
        }

        public function atualizar($codigo, $titulo, $data_ini, $data_fim, $descricao, $cod_user, $cod_local){
            $event = new EventPess($titulo, $data_ini, $data_fim, $descricao, $cod_user, $cod_local);
            $eventDAO = new EventPersDAO();
            $atualizou = $eventDAO->atualizarEvento($codigo, $event);
            return $atualizou;
        }
	}
?>