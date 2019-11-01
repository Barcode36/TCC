<?php
    session_start();

    if(empty($_POST['usuario']) || empty($_POST['senha'])){
        header('Location: index.php');
        exit();
    }

    $usuario = trim($_POST['usuario']);
    $senha = trim($_POST['senha']);

    $rest = 'http://143.106.241.1/cl18463/tcc/api/usuario/buscar/' . $usuario . '/' . $senha;

    $retorno = json_decode(file_get_contents($rest), 1);

    if(count($retorno['dados']) == 1){
        $_SESSION['nome'] = $retorno['dados']['0']['nome'];
        $_SESSION['codigo'] = $retorno['dados']['0']['codigo'];
        header('Location: ../agenda/index.php');
        exit();
    }else{
        $_SESSION['nao_autenticado'] = true;
        header('location: index.php');
        exit();
    }
?>