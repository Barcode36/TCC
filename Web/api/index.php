<?php
	header('Content-Type: application/json; charset=utf-8');
	require_once('Classes/Usuario.php');
	require_once('Classes/Endereco.php');
	require_once('Classes/EventPers.php');
	
	class Rest{
		
		public static function open($requisicao){
			$url = explode('/', $requisicao['url']);

			$classe = ucfirst($url['0']);
			array_shift($url);

			$metodo = $url['0'];
			array_shift($url);

			$parametros = array();
			$parametros = $url;

			try{
				if(class_exists($classe)){
					if(method_exists($classe, $metodo)){
						$retorno = call_user_func_array(array(new $classe, $metodo), $parametros);
						
						return json_encode(array('status' => 'Sucesso', 'dados' => $retorno));
					}else{
						return json_encode(array('status' => 'Erro', 'dados' => 'Metodo inexistente'));
					}
				}else{
					return json_encode(array('status' => 'Erro', 'dados' => 'Classe inexistente'));
				}
			}catch (Exception $ex){
				return json_encode(array('status' => 'Erro', 'dados' => $ex->getMessage()));
			}
		}
	}

	if(isset($_REQUEST)){
		echo Rest::open($_REQUEST);
	}
?>