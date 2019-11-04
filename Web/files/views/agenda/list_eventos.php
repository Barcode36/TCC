<?php
    session_start();

    $rest = 'http://143.106.241.1/cl18463/tcc/api/eventPers/buscar/'. $_SESSION['codigo'];
    $dados = json_decode(file_get_contents($rest), 1);
    $i = 1;
    $aux = 0;
    $eventos = [];


    while ($i <= count($dados['dados'])) {
        $restEndereco = 'http://localhost/TCC/api/endereco/buscar/' . $dados['dados'][$aux]['cod_local']; /*Alterar servidor */
        $local = json_decode(file_get_contents($restEndereco), 1);

        $eventos[] = [
            'id' => $dados['dados'][$aux]['codigo'],
            'title' => $dados['dados'][$aux]['titulo'],
            'start' => $dados['dados'][$aux]['data_ini'], 
            'end' => $dados['dados'][$aux]['data_fim'],
            'description' => $dados['dados'][$aux]['descricao'],
            'local' => $local['dados'][0]['rua'] . ', ' . $local['dados'][0]['bairro'] . ' - ' . $local['dados'][0]['cidade'] . ' / ' . $local['dados'][0]['estado'],
        ];
        $i++;
        $aux++;
    }

    echo json_encode($eventos);
?>