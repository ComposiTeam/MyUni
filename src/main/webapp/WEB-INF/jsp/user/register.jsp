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
            	<form action="register" method="POST">
            		<table>
	    				<tr>
	    					<td><label for="username-text">Usuário: </label></td>
	    					<td><input class="register-field" type="text" name="user.username" id="username" required="required" placeholder="Escolha um nome de usuário"/></td>
	    					
	    				</tr>
	    				<tr>
	    					<td><label for="password-text">Senha: </label></td>
	    					<td><input class="register-field" type="password" name="user.password" id="password" required="required" placeholder="Escolha uma senha"/></td>
	    					
	    				</tr>
	    				
	    				<tr>
		    				<td><label for="email-text">Email: </label></td>
		    				<td><input class="email-field" type="email" name="user.email" id="email" required="required" placeholder="Entre com o email"/></td>
		    				
	    				</tr>
	    				
	    				<tr>
		    				<td><input type="checkbox" name="termsOfService" value="terms">Concordo com os termos de serviço.</td>
		    				
		    			</tr>
		    			<tr>
		    				<td></td>
		    				<td><input class="register-button" type="submit" id="register-button" value="Registrar" /></td>
	    				</tr>
    				</table>
    			</form>
    			</div>
            </div>
        </div>
    </section>