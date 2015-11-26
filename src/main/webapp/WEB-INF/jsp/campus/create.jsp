<%@ include file="/WEB-INF/layouts/base.jspf" %>
	<div class="container">
		<h2>Campus</h2>
		<form action="create" method="POST">
			<table>
				<tr>
					<td><label for="username-text">Nome: </label></td>
					<td><input id="name" class="register-field" type="text"
						name="campus.name" /></td>
				</tr>
				<tr>
					<td><input id="submit" type="submit" value="Salvar" /></td>
					<td><input id="clean" type="button" value="Limpar" /></td>
				</tr>
			</table>
		</form>
	</div>
<%@ include file="/WEB-INF/layouts/footer.jspf" %>