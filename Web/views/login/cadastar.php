<?php
    session_start();
    include_once('conexao.php');

    $nome = mysqli_real_escape_string($conexao, trim($_POST['nome']));
    $email = mysqli_real_escape_string($conexao, trim($_POST['email']));
    $usuario = mysqli_real_escape_string($conexao, trim($_POST['usuario']));
    $senha = mysqli_real_escape_string($conexao, trim(md5($_POST['senha'])));
    $telefone = mysqli_real_escape_string($conexao, trim($_POST['telefone']));

    $sql = "SELECT COUNT(*) AS Total FROM usuario WHERE usuario = '{$nome}'";
    $result = mysqli_query($conexao, $sql);
    $row = mysqli_fetch_assoc($result);

    if($row['Total'] >= 1){
        $_SESSION['usuario_existe'] = true;
        header('Location: cadastro.php');
        exit;
    }

    $sql = "INSERT INTO usuario (nome, email, usuario, senha, telefone, data_cadastro) VALUES ('{$nome}', '{$email}', '{$usuario}', '{$senha}', '{$telefone}', NOW())";
    if($conexao->query($sql) === true ){
        $_SESSION['status_cadastro'] = true;
    }

    $conexao->close();

    header('Location: cadastro.php');
    exit;
?>