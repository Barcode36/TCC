<?php
    session_start();
?>
<!DOCTYPE html>
<html lang="PT-BR">
<head>
    <title>Cadastre-se</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
    
    <!-- Fontawesome -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous"/>

	<!-- Bootstrap -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"/>

	<!-- CSS -->
	<link rel="stylesheet" href="../../css/login.css" />
  
</head>

<body class="is-loading">

   	<!-- Wrapper -->
       <div id="wrapper">

            <!-- Main -->
                <section id="main">
                    <header>
                        <span class="avatar"><div class="avatarImg"><img src="../../img/logo.png"></div></span>
                        
                        <!-- Cadastro Realizado com Sucesso -->
                        <?php
                            if(isset($_SESSION['status_cadastro'])):
                        ?>
                        <div class="alert alert-success" role="alert">
                            Cadastro efetuado com sucesso!<br>
                            Faça login informando o seu usuário e senha <a href="index.php">aqui</a>
                        </div>
                        <?php
                            endif;
                            unset($_SESSION['status_cadastro']);
                        ?>

                        <!-- Usuário já existente -->
                        <?php
                            if(isset($_SESSION['usuario_existe'])):
                        ?>
                        <div class="alert alert-danger" role="alert">
                            Usuário escolhido já existe. Informe outro e tente novamente!
                        </div>
                        <?php
                            endif;
                            unset($_SESSION['usuario_existe']);
                        ?>

                        <!-- Formulário de cadastro -->
                        <form action="cadastar.php" method="POST">
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label for="inputNome">Nome</label>
                                    <input type="text" name="nome" class="form-control" id="inputNome" placeholder="Nome Completo">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label for="inputEmail">E-mail</label>
                                    <input name="email" type="email" class="form-control" id="inputEmail" placeholder="e-mail">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label for="inputUser">Usuário</label>
                                    <input name="usuario" type="text" class="form-control" id="inputUser" placeholder="Usuário">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                  <label for="inputPass">Digite a Senha</label>
                                  <input name="senha" type="password" class="form-control" id="inputPass">
                                </div>
                                <div class="form-group col-md-6">
                                  <label for="inputPass">Confirme a Senha</label>
                                  <input type="password" class="form-control" id="inputPass">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label for="inputTel">Telefone</label>
                                    <input name="telefone" type="number" class="form-control" id="inputTel">
                                </div>
                                  
                            </div>
                                <div class="form-group">
                                  <div class="form-check">
                                    <input class="form-check-input" type="checkbox" id="gridCheck">
                                    <label class="form-check-label" for="gridCheck">
                                      <a href="#">Concordo com os termos de uso</a>
                                    </label>
                                  </div>
                                </div>
                                <button type="submit" class="btn btn-outline-info btn-lg">Cadastrar</button>
                              </form>
                    </header>

                    <footer>
                        <span></span>
                    </footer>
                </section>

            <!-- Footer -->
                <footer id="footer">
                    <ul class="copyright">
                        <li>&copy; COTIL / UNICAMP</li><li> 2019</li>
                    </ul>
                </footer>

        </div>

    <!-- Scripts -->
        <script>
            if ('addEventListener' in window) {
                window.addEventListener('load', function() { document.body.className = document.body.className.replace(/\bis-loading\b/, ''); });
                document.body.className += (navigator.userAgent.match(/(MSIE|rv:11\.0)/) ? ' is-ie' : '');
            }
        </script>

    <!-- JS, Pooper-->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>