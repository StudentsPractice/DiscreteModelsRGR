<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Дискретні моделі в САПР</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/common.css"/>">
    
</head>

<body>
	<header>
		<nav class="navbar navbar-inverse">
		    <div class="container-fluid">
		        <div class="navbar-header"> 
		        	<a class="navbar-brand" href="<c:url value="/"/>">Дискретні моделі в САПР</a> 
		        </div>
		    </div>
		</nav>
	</header>
	
	<main class="container-fluid">
	    <div class="form-container">
	    	<h1>Алгоритм Едмондса-Карпа</h1>
	        <form method="post" enctype="multipart/form-data" class="file-form">
	        	<div class="input-group">
		            <label class="btn btn-default" for="my-file-selector">
					    <input type="file" id="my-file-selector" name="inputFile" style="display:none" onchange="$('#upload-file-info').html(this.files[0].name)">
					    Виберіть файл
					</label>
					<span class='label label-default' id="upload-file-info"></span>
	            </div>
	            <div class="input-group">
	            	<button class="btn btn-success" type="submit">Надіслати</button>
	            </div>
	        </form>
		</div>
    </main>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>