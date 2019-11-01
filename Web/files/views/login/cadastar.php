<?php
    session_start();

    $nome = trim($_POST['nome']);
    $usuario = trim($_POST['usuario']);
    $email = trim($_POST['email']);
    $senha = trim($_POST['senha']);
    $telefone = trim($_POST['telefone']);

    $restValidar = 'http://143.106.241.1/cl18463/tcc/api/usuario/validar/' . $usuario . '/' . $email;

    $validar = json_decode(file_get_contents($restValidar), 1);
    
    if($validar['dados']){
        $_SESSION['usuario_existe'] = true;
        header('Location: cadastro.php');
        exit;
    }

    $user = str_replace(" ", "%20", $nome); //para evitar o maldito Bad Request

    $restInserir = 'http://143.106.241.1/cl18463/tcc/api/usuario/inserir/' . $user . '/' . $usuario . '/' . $email . '/' . $senha . '/' . $telefone;

    $retornoInserir = file_get_contents($restInserir, 1);

    if($retornoInserir){
        $_SESSION['status_cadastro'] = true;
    }

    header('Location: cadastro.php');
    exit;
?>