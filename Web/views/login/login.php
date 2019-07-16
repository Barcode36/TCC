<?php
    session_start();
    include_once('conexao.php');
    if(empty($_POST['usuario']) || empty($_POST['senha'])){
        header('Location: index.php');
        exit();
    }

    $usuario = mysqli_real_escape_string($conexao, $_POST['usuario']);
    $senha = mysqli_real_escape_string($conexao, $_POST['senha']);

    $query = "SELECT nome FROM usuario WHERE usuario = '{$usuario}' AND senha = md5('{$senha}')";

    $result = mysqli_query($conexao, $query);

    $row = mysqli_num_rows($result); //quantidade de linhas retornadas pela query result

    if($row == 1){
        $usuario_bd = mysqli_fetch_assoc($result);
        $_SESSION['nome'] = $usuario_bd['nome'];
        header('Location: ../agenda/index.php');
        exit();
    }else{
        $_SESSION['nao_autenticado'] = true;
        header('location: index.php');
        exit();
    }
?>