<?php
    session_start();
    include_once('conexao.php');
    if(!$_SESSION['nome']){
        header('Location: ../login/index.php');
        exit();
    }

    $result_events = "SELECT title, start, end FROM events";
    $resultado = $conn->prepare($result_events);
    $resultado->execute();

    $date = new DateTime();
    $atual = $date->format('Y-m-d H:i:s');
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset='utf-8' />
    <link href='https://use.fontawesome.com/releases/v5.0.6/css/all.css' rel='stylesheet'>
    <link href='packages/core/main.css' rel='stylesheet' />
    <link href='packages/timegrid/main.css' rel='stylesheet' />
    <link href='packages/daygrid/main.css' rel='stylesheet' />
    <link href='packages/list/main.css' rel='stylesheet' />
    <script src='packages/core/main.js'></script>
    <script src='packages/interaction/main.js'></script>
    <script src='packages/daygrid/main.js'></script>
    <script src='packages/timegrid/main.js'></script>
    <script src='packages/list/main.js'></script>
    <script src='packages/core/locales/pt-br.js'></script>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
    <!-- Arquivo JS próprio -->
    <script src="js/main.js"></script>
    <!-- Arquivo CSS próprio -->
    <link href="css/style.css" rel="stylesheet">

</head>
<body>

    <!-- Barra de Identificação e Logout -->
    <nav class="navbar fixed-top navbar-light bg-light menu-superior">
        <div class="perfil-inline">    
            <div class="img-perfil"></div>
            <span class="navbar-text">Olá, <b><?php echo $_SESSION['nome'];?></b></span>
        </div>
        <form class="form-inline">
        <a href="logout.php" class="txt-sair"><button class="btn btn-sm btn-outline-danger" type="submit"><i class="fas fa-sign-out-alt"><span class="espaco">Sair</span></i></button></a>
        </form>
    </nav>
    
    <br><br>

    <!-- Corpo do site -->
    <div id="wrap">
        <?php
            if(isset($_SESSION['msg'])){
                echo $_SESSION['msg'];
                unset($_SESSION['msg']);
            }
        ?>
        <div id='external-events'>
            <h4>Próximos Eventos</h4>
            <?php while($row = $resultado->fetch(PDO::FETCH_ASSOC)){ if($row['end'] < $atual) continue; ?>
            <div id='external-events-list'>
                <div class='dado'><?php echo $row['title'] . ' - ' . date('d/m', strtotime($row['start'])); ?></div>
            </div>
            <?php }; ?>
            <p>
                <input type='checkbox' checked/>
                <label>Exluir após o término</label>
            </p>
        </div>
        <div id='calendar'></div>
    </div>
    
    <!-- Efeito Parallax -->
    <section class="content-site"></section>
    <section class="img-site"></section>
    <!-- Footer -->
    <footer id="footer">
		<ul class="copyright">
			<li>&copy; COTIL / UNICAMP</li><li> 2019</li>
		</ul>
	</footer>

    <!-- Modal Eventos Cadastrados -->
    <div class="modal fade" id="visualizar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Detalhes do Evento</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <dl class="row">
                        <dt class="col-sm-3">ID do Evento</dt>
                        <dd class="col-sm-9" id="id"></dd>

                        <dt class="col-sm-3">Título do Evento</dt>
                        <dd class="col-sm-9" id="title"></dd>

                        <dt class="col-sm-3">Início do Evento</dt>
                        <dd class="col-sm-9" id="start"></dd>

                        <dt class="col-sm-3">Fim do Evento</dt>
                        <dd class="col-sm-9" id="end"></dd>
                    </dl>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal Cadastar Eventos -->
    <div class="modal fade" id="cadastrar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Cadastrar Evento</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" method="POST" action="proc_cad_evento.php">
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Título</label>
                            <div class="col-sm-10">
                                <input type="text" name="title" class="form-control" id="title" placeholder="Título do evento">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Cor da marcação</label>
                            <div class="col-sm-10">
                                <select name="color" class="form-control" id="color">
                                    <option value="">Selecione</option>			
                                    <option style="color:#FFD700;" value="#FFD700">Amarelo</option>
                                    <option style="color:#0071c5;" value="#0071c5">Azul Turquesa</option>
                                    <option style="color:#FF4500;" value="#FF4500">Laranja</option>
                                    <option style="color:#8B4513;" value="#8B4513">Marrom</option>	
                                    <option style="color:#1C1C1C;" value="#1C1C1C">Preto</option>
                                    <option style="color:#436EEE;" value="#436EEE">Royal Blue</option>
                                    <option style="color:#A020F0;" value="#A020F0">Roxo</option>
                                    <option style="color:#40E0D0;" value="#40E0D0">Turquesa</option>
                                    <option style="color:#228B22;" value="#228B22">Verde</option>
                                    <option style="color:#8B0000;" value="#8B0000">Vermelho</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Início do evento</label>
                            <div class="col-sm-10">
                                <input type="text" name="start" class="form-control" id="start" onkeypress="DataHora(event, this)">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Final do evento</label>
                            <div class="col-sm-10">
                                <input type="text" name="end" class="form-control" id="end"  onkeypress="DataHora(event, this)">
                            </div>
                        </div>

                        <div class="form-group row">
                            <div class="col-sm-offset-2 col-sm-10">
							    <button type="submit" class="btn btn-success">Cadastrar</button>
							</div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- JQuery, Js, Popper -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
