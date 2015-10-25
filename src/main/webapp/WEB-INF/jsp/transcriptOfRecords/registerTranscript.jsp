<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registro do Histórico Escolar</title>
</head>
<body>

<div class="container-fluid">      
	<div class="row">
    	<div class="col-lg-12">
		<h1 class="page-header">Registro do Histórico Escolar <small></small></h1>
        	<ol class="breadcrumb">
        		<li class="active">
                	<i class="fa fa-dashboard"></i> Registre os resultados de cada disciplina que realizou até o momento. 
                </li>
            </ol>
     </div>
</div>
                
<div class="dropdown">
	<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Selecione o número de semestres que deseja registrar
 		<span class="caret"></span></button>
  				<select id="numberOfSemesters" onchange="changeFormType()">
			<ul class="dropdown-menu">	
					<a href="#"></a><option value="1">1</option></a>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="5">6</option>
					<option value="5">7</option>
					<option value="5">8</option>
					<option value="5">9</option>
					<option value="5">10</option>
					<option value="5">11</option>
					<option value="5">12</option>
					<option value="5">13</option>
					<option value="5">14</option>
					<option value="5">15</option>
					<option value="5">16</option>					
					<a href="#"><option value="feature">Feature</option>
			</ul>
	</select>
</div>

<div class="dropdown">
	<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Informe o ano de ínicio do seu curso
 		<span class="caret"></span></button>
  				<select id="numberOfSemesters" onchange="changeFormType()">
			<ul class="dropdown-menu">	
					<a href="#"></a><option value="1">1</option></a>
					<option value="2">2008</option>
					<option value="3">2009</option>
					<option value="4">2010</option>
					<option value="5">2011</option>
					<option value="5">2012</option>
					<option value="5">2013</option>
					<option value="5">2014</option>
					<option value="5">2015</option>				
			</ul>
	</select>

</body>
</html>