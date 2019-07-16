<?php
    session_start(); //inicia a utilização de variáveis globais

    //Inclui a conexão com o Bando de Dados
    include_once("conexao.php");

    //Recebendo os dados do formulário
    $title = filter_input(INPUT_POST, 'title', FILTER_SANITIZE_STRING);
    $color = filter_input(INPUT_POST, 'color', FILTER_SANITIZE_STRING);
    $start = filter_input(INPUT_POST, 'start', FILTER_SANITIZE_STRING);
    $end = filter_input(INPUT_POST, 'end', FILTER_SANITIZE_STRING);

    if(!empty($title) && !empty($color) && !empty($start) && !empty($end)){
        //Converter data e hora do formato brasileiro para o formato do Banco de Dados
        //Data Inicial
        $data = explode(" ", $start);
        list($data, $hora) = $data;
        $data_sem_barra = array_reverse(explode("/", $data));
        $data_sem_barra = implode("-", $data_sem_barra);
        $start_sem_barra = $data_sem_barra . " " . $hora;

        //Data Final
        $data = explode(" ", $end);
        list($data, $hora) = $data;
        $data_sem_barra = array_reverse(explode("/", $data));
        $data_sem_barra = implode("-", $data_sem_barra);
        $end_sem_barra = $data_sem_barra . " " . $hora;

        //Inserindo as informações no Banco de Dados
        $result_events = "INSERT INTO events (title, color, start, end) VALUES ('$title', '$color', '$start_sem_barra', '$end_sem_barra')";
        $resultado_eventos = $conn->prepare($result_events);
        $resultado_eventos->execute();

        //Verificar se salvou no BD
        if($resultado_eventos->rowCount() > 0){
            $_SESSION['msg'] = '<div class="alert alert-success" role="alert">Evento cadastrado com sucesso!
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>';
        header("Location: index.php");
        }else{
            $_SESSION['msg'] = '<div class="alert alert-danger" role="alert">Erro ao cadastrar evento!
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>';
        header("Location: index.php");
        }
    }else{
        $_SESSION['msg'] = '<div class="alert alert-danger" role="alert">Erro ao cadastrar evento!
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>';
        header("Location: index.php");
    }
?>