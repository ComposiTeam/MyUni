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
								name="student.name" id="name" placeholder="Entre com o seu nome" /></td>

						</tr>
						<tr>
							<td><label for="email-text">Matrícula: </label></td>
							<td><input class="register-field" type="text"
								name="student.mwId" id="email"
								placeholder="Entre com o seu matricula web" /></td>

						</tr>
						<tr>
							<td><label for="password-text">Senha: </label></td>
							<td><input class="register-field" type="password"
								name="student.mwPassord" id="password"
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