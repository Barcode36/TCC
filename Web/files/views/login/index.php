<?php
	session_start();
?>

<!DOCTYPE HTML>
<html lang="PT-BR">
	<head>
		<title>Login</title>
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
							<?php
								if(isset($_SESSION['nao_autenticado'])):
							?>
							<div class="alert alert-danger" role="alert">
  								<b>Usuário</b> ou <b>Senha</b> inválido!
							</div>
							<?php
								endif;
								unset($_SESSION['nao-autenticado']);
							?>
							<form action="login.php" method="POST">
							  <div class="form-group">
							    <label for=" ">Usuario</label>
							    <input type="text" name="usuario" class="form-control" id=" " aria-describedby="emailHelp" placeholder="Usuário" required>
							    <small id="usuariolHelp" class="form-text text-muted">Insira o seu usuario.</small>
							  </div>
							  <div class="form-group">
							    <label for=" ">Senha</label>
							    <input type="password" name="senha" class="form-control" id="" placeholder="Senha" required>
							  </div>
							  <div class="form-group form-check">
							    <input type="radio" class="form-check-input" id=" ">
							    <label class="form-check-label" for=" ">Lembrar de mim</label>
							  </div>				  
							 							  
							  <button type="submit" class="btn btn-outline-info btn-lg mt-4">Entrar</button>
							  <br>
							  <div class="float-right">
							  	<a href="cadastro.php">Cadastar</a>
							  <div>
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

	</body>
</html>