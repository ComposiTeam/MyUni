<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>GradPlanner X</title>
<!-- Bootstrap -->

<link href="css/bootstrap.css" rel="stylesheet" type="text/css">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-1.10.2.js"></script>
<script src="js/bootstrap.min.js"></script>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
<script src="js/classie.js"></script>
<script src="js/cbpAnimatedHeader.js"></script>
<script src="js/freelancer.js"></script>
<script src="jquery-2.1.1.min.js" type="text/javascript" charset="utf-8"></script>
<meta charset="UTF-8">
<style>
</style>
</head>
<body>
	<jsp:include page="../authentication/navbar-logged.jsp"></jsp:include>
	<section id="register">
		<br></br>
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2>Registro</h2>
				</div>
			</div>
			<div class="login_panel">
				<div class="container">
					<form action="registerstudent" method="POST">
						<table>
							<tr>
								<td><label for="username-text">Nome: </label></td>
								<td><input class="register-field" type="text"
									value="${student.name}" name="student.name" id="name"
									placeholder="Entre com o seu nome" /></td>

							</tr>
							<tr>
								<td><label for="email-text">Matrícula: </label></td>
								<td><input class="register-field" type="text"
									name="student.mwId" id="email" value="${student.mwId}"
									placeholder="Entre com o seu matricula web" /></td>

							</tr>
							<tr>
								<td><label for="password-text">Senha: </label></td>
								<td><input class="register-field" type="password"
									name="student.mwPassword" id="password"
									value="${student.mwPassword}"
									placeholder="Entre com a sua senha do mw" /></td>

							</tr>




							<tr>
								<td></td>
								<td><input class="register-button" type="submit"
									id="register-button" value="Registrar" /></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</section>
	<jsp:include page="../index/footer.jsp"></jsp:include>




</body>
</html>
