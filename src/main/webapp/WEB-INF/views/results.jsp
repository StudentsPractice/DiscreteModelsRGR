<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Дискретні моделі в САПР</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
	
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/common.css"/>" >
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/results.css"/>">

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
    	<c:if test="${not empty error}">
        	<div class="block-container">
	        	<c:out value="${error }"/>
	        </div>
		</c:if>
		<c:if test="${empty error}">
			<div class="parent">
				<h3 class="">
					Результати обчислень
				</h3>
				<div class="block-container">
					<h4 class="title">Максимальний потік через мережу: ${maxFlow}</h4>
					<table class="table table-hover flow-table">
						<tr>
							<th>Ребро</th><th>Потік</th>
						</tr>
						<c:forEach var="item" items="${edgesFlow}">
							<tr>
								<td>
									<span class="">${item.key }</span>
								</td>
								<td>
									<span class="">${item.value }</span>
								</td>
							<tr>
						</c:forEach>
					</table>
				</div>
			</div>
			
			<div id="container">
				<button class="btn btn-success" onclick="editOn()">Переміщати вузли</button>
				<button class="btn btn-success" onclick="startLayout()">Авт. розміщення вузлів</button>
				<button class="btn btn-success" onclick="stopLayout()">Вимк. авт. розм. вузлів</button>
				
				<div id="graph-container"></div>
			</div>
		</c:if>
    </main>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
	<script src="<c:url value="/js/sigma/sigma.min.js"/>"></script>
	<script src="<c:url value="/js/sigma/plugins/sigma.parsers.json.min.js"/>"></script>
	<script src="<c:url value="/js/sigma/plugins/sigma.renderers.edgeLabels.min.js"/>"></script>
	<script src="<c:url value="/js/sigma/plugins/sigma.layout.forceAtlas2.min.js"/>"></script>
	<script src="<c:url value="/js/sigma/plugins/sigma.plugins.dragNodes.min.js"/>"></script>
	
	<script>
			
		var graphJson = ${json};
		
		var s = new sigma ({
			graph: graphJson,
			renderer: {                                                        
				container: 'graph-container',
				type: "canvas"                                                 
			},
		    settings: {
				edgeColor: "default",
				defaultEdgeColor: '#555',
				defaultNodeColor: '#ec5148',
				labelThreshold:0
		    }
		});
	
    	var i;
        var nodes = s.graph.nodes();
        var len = nodes.length;

        for (i = 0; i < len; i++) {
            nodes[i].x = Math.random();
            nodes[i].y = Math.random();
        }

        // Refresh the display:
        s.refresh();

       	function startLayout() {
       		s.startForceAtlas2();
       	}
       	function stopLayout() {
			 s.stopForceAtlas2();
       	}
		var editOn = function() {
			 sigma.plugins.dragNodes(s, s.renderers[0]);
			 s.stopForceAtlas2();
		};
		
	</script>
	
</body>
</html>
