<?php
    session_start();

    if(!$_SESSION['nome']){
        header('Location: ../login/index.php');
        exit();
    }
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
        <form class="form-inline" action="logout.php" method="POST">
        <a class="txt-sair"><button class="btn btn-sm btn-outline-danger" type="submit"><i class="fas fa-sign-out-alt"><span class="espaco">Sair</span></i></button></a>
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
                    <div class="vise_event">
                        <dl class="row">

                            <dt class="col-sm-3">Título do Evento</dt>
                            <dd class="col-sm-9" id="titulo"></dd>

                            <dt class="col-sm-3">Descrição</dt>
                            <dd class="col-sm-9" id="descricao"></dd>

                            <dt class="col-sm-3">Início do Evento</dt>
                            <dd class="col-sm-9" id="data_ini"></dd>

                            <dt class="col-sm-3">Fim do Evento</dt>
                            <dd class="col-sm-9" id="data_fim"></dd>
                            
                            <dt class="col-sm-3">Local</dt>
                            <dd class="col-sm-9" id="endereco"></dd>
                        </dl>
                        <button class="btn btn-warning btn-canc-vis">Editar</button>
                    </div>
                    <div class="formedit">
                        <form class="form-horizontal" method="POST" action="edit_evento.php">
                            <input type="text" name="codigo" id="codigo" hidden>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Título</label>
                                <div class="col-sm-10">
                                    <input type="text" name="titulo2" class="form-control" id="titulo" placeholder="Título do evento">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Localização</label>
                                <div class="col-sm-3">
                                    <input type="text" id="cep2" name="cep" placeholder="Digite o CEP" class="form-control">
                                </div>
                                <label class="col-sm-1 col-form-label">Endereço</label>
                                <div class="col-sm-6">
                                    <input type="text" id="endereco" name="endereco2" disabled class="form-control">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Descrição</label>
                                <div class="col-sm-10">
                                    <textarea class="form-control" name="descricao2" id="descricao" rows="3"></textarea>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Início do evento</label>
                                <div class="col-sm-10">
                                    <input type="text" name="start2" class="form-control" id="start" onkeypress="DataHora(event, this)">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Final do evento</label>
                                <div class="col-sm-10">
                                    <input type="text" name="end2" class="form-control" id="end"  onkeypress="DataHora(event, this)">
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="button" class="btn btn-primary btn-canc-edit">Cancelar</button>
                                    <button type="submit" class="btn btn-success">Atualizar</button>
                                </div>
                            </div>
                        </form>
                    </div>
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
                                <input type="text" name="titulo" class="form-control" id="titulo" placeholder="Título do evento">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Localização</label>
                            <div class="col-sm-3">
                                <input type="text" id="cep" name="cep" placeholder="Digite o CEP" class="form-control">
                            </div>
                            <label class="col-sm-1 col-form-label">Endereço</label>
                            <div class="col-sm-6">
                                <input type="text" id="endereco" name="endereco" disabled class="form-control">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Descrição</label>
                            <div class="col-sm-10">
                                <textarea class="form-control" name="descricao" id="descricao" rows="3"></textarea>
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

    <script type="text/javascript">
        $(document).ready(function(){
  
          // Função para resgatar o CEP (Cad)
          $("#cep").focusout(function(){
            var cep = $("#cep").val();
            cep = cep.replace("-", "");

            var urlStr = "https://viacep.com.br/ws/" + cep + "/json";
            $.ajax({
              url : urlStr,
              type : "get",
              dataType : "json",
              success : function(data){
                document.querySelector("[name='endereco']").value = data.logradouro + " - " + data.bairro + ", " + data.localidade;
              },
              error : function(erro){
                console.log(erro);
              }
            });

          });

          // Função para resgatar o CEP (Visualizar)
          $("#cep2").focusout(function(){
            var cep = $("#cep2").val();
            cep = cep.replace("-", "");

            var urlStr = "https://viacep.com.br/ws/" + cep + "/json";
            $.ajax({
              url : urlStr,
              type : "get",
              dataType : "json",
              success : function(data){
                document.querySelector("[name='endereco2']").value = data.logradouro + " - " + data.bairro + ", " + data.localidade;
              },
              error : function(erro){
                console.log(erro);
              }
            });

          });

          $(".btn-canc-vis").click(function(){
            $(".vise_event").slideToggle();
            $(".formedit").slideToggle();
          });

          $(".btn-canc-edit").click(function(){
            $(".formedit").slideToggle();
            $(".vise_event").slideToggle();
          });

        });
    </script>
</body>
</html>
