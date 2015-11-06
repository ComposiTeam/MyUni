<html>
<head>
<!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script src="js/classie.js"></script>
    <script src="js/cbpAnimatedHeader.js"></script>
    <script src="js/freelancer.js"></script>
    <script src="jquery-2.1.1.min.js" type="text/javascript" charset="utf-8"></script>
  <meta charset="UTF-8">
	<title>GradPlanner</title>
</head>
<body>
<br><br>
	<jsp:include page="../index/navbar.jsp"></jsp:include>
	<center><h1>Falha</h1></center>
	<div class="jumbotron">
		<label>O usuário ou senha informados estão incorretos. Por favor, tente novamente.</label>
		<form  name="login-form" action="login" method="POST">
	    <input class="input-text-login" type="text" name="user.username" required="required" id="username-inputType" placeholder="Username" ></input>
	    <input class="input-text-login" name="user.password" type="password" required="required" id="password-inputType" placeholder="Password"></input>
	    <input class="input-button-login" type="submit" id="login-inputButton" value="Login"></input>
	    </form>
    </div>
</body>
</html>