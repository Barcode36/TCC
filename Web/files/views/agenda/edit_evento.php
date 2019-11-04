<?php
    session_start(); //inicia a utilização de variáveis globais


    //Recebendo os dados do formulário
    $titulo = filter_input(INPUT_POST, 'titulo2', FILTER_SANITIZE_STRING);
    $endereco = filter_input(INPUT_POST, 'endereco2', FILTER_SANITIZE_STRING);
    $descricao = filter_input(INPUT_POST, 'descricao2', FILTER_SANITIZE_STRING);
    $start = filter_input(INPUT_POST, 'start2', FILTER_SANITIZE_STRING);
    $end = filter_input(INPUT_POST, 'end2', FILTER_SANITIZE_STRING);

    $id = filter_input(INPUT_POST, 'codigo');


    if(!empty($titulo) && !empty($descricao) && !empty($start) && !empty($end)){

        //Converter data e hora do formato brasileiro para o formato do Banco de Dados
        //Data Inicial
        $data = explode(" ", $start);
        list($data, $hora) = $data;
        $data_sem_barra = array_reverse(explode("/", $data));
        $data_sem_barra = implode("-", $data_sem_barra);
        $start_sem_barra = $data_sem_barra . "%20" . $hora;

        //Data Final
        $data = explode(" ", $end);
        list($data, $hora) = $data;
        $data_sem_barra = array_reverse(explode("/", $data));
        $data_sem_barra = implode("-", $data_sem_barra);
        $end_sem_barra = $data_sem_barra . "%20" . $hora;

        //Para que não haja problemas com a api
        $titulo2 = str_replace(" ", "%20", $titulo);
        $descricao2 = str_replace(" ", "%20", $descricao);

        //Atualizando as informações no Banco de Dados ****LocalHost*****
        $rest = 'http://localhost/TCC/api/eventPers/atualizar/' . '/' . $id . '/' . $titulo2 . '/' . $start_sem_barra . '/' . $end_sem_barra . '/' . $descricao2 . '/' . $_SESSION['codigo'] . '/' . 1;
        $dados = json_decode(file_get_contents($rest), 1);

        
        //Verificar se salvou no BD
        if($dados['dados']){
            $_SESSION['msg'] = '<div class="alert alert-success" role="alert">Evento atualizado com sucesso!
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
        $_SESSION['msg'] = '<div class="alert alert-danger" role="alert">Informe todos os dados para cadastrar evento!
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>';
        header("Location: index.php");
    }
?>