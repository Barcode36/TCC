<?php

    class Conexao{
        //usando o singleton para que haja apenas uma instancia da classe (mais agilidade)
        private static $instancia;

        public static function getConn(){

            if(!isset(self::$instancia)):
                try{
                    self::$instancia = new PDO("mysql:host=143.106.241.3;dbname=cl18463", "cl18463", "cl*28031989");
                }catch(PDOException $ex){
                    echo 'Erro de conexão: '.$ex->getMessage();
                }
            endif;

            return self::$instancia;
        }
    }
?>