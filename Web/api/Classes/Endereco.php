<?php
	require_once('Model/Local.php');
	require_once('Control/LocalDAO.php');

    //antiga Classe de Controle
	class Endereco{

    	public function inserir($nome, $rua, $bairro, $cidade, $estado){
    		$local = new Local($nome, $rua, $bairro, $cidade, $estado);
    		$localDAO = new localDAO();
    		$inseriu = $localDAO->inserir($local);
    		return $inseriu;
    	}

        public function buscar($cod_local){
            $localDAO = new localDAO();
            return ($localDAO->buscarEndereco($cod_local));
        }
	}
?>