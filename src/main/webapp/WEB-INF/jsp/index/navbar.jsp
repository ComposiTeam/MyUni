<head>
<title>Gradplanner</title>
<link href="<c:url value='/css/stylesheet.css'/>" rel="stylesheet">

<!-- jQuery -->
<script src="<c:url value='/js/jquery.js'/>"></script>

<!-- Bootstrap Core -->
<script src="<c:url value='/js/bootstrap.min.js'/>"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
</head>
<body id="page-top" class="index">
    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#page-top">GradPlanner</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                     <li class="page-scroll">
                        <a href="#home">Home</a>
                    </li>
                    <li class="page-scroll">
                        <a href="#register">Registre-se</a>
                    </li>
                    <li class="page-scroll">
                        <a href="unbExtractData/extractData">Extrair dados</a>
                    </li>
                    <li>
	                    <div class="form-group row login-form">
	                    	<form name="login-form" action="login" method="POST">
		                    	<div class="col-md-4">
			                        <input class="form-control" type="text" name="user.username" 
			                        	required="required" id="username-inputType" placeholder="Username"/>
		                        </div>
		                        <div class="col-md-4">
		                        <input class="form-control" name="user.password" type="password" 
		                        	required="required" id="password-inputType" placeholder="Password"/>
		                        </div>
		                        <div class="col-md-2">
		                        	<input class="form-control" type="submit" id="login-inputButton" value="Login"/>
		                        </div>
	                    	</form>
	                    </div>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
