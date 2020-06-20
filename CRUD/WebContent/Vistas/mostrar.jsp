
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar elementos</title>
</head>
<body>
	
	<div>
		<h1>Elementos</h1>
		<a href="ServletControlador?accion=registrar">Agregar nuevo</a>
		
		<table border="1" >
		<tr>
		 <td> ID</td>
		 <td> CODIGO</td>
		 <td> NOMBRE</td>
		 <td>DESCRPICION</td>
		 <td>EXISTENCIA</td>
		 <td>PRECIO</td>
		 <td colspan=2>ACCIONES</td>
		</tr>
		<c:forEach var="articulo" items="${listaDA}">
			<tr>
				<td><c:out value="${articulo.id}"/></td>
				<td><c:out value="${articulo.codigo}"/></td>
				<td><c:out value="${articulo.nombre}"/></td>
				<td><c:out value="${articulo.descripcion}"/></td>
				<td><c:out value="${articulo.existencia}"/></td>
				<td><c:out value="${articulo.precio}"/></td>
				<td><a href="ServletControlador?accion=editar&id=<c:out value="${articulo.id}" />">Editar</a></td>
				<td><a href="ServletControlador?accion=eliminar&id=<c:out value="${articulo.id}"/>">Eliminar</a> </td>				
			</tr>
		</c:forEach>
	</table>
		
		<a href="ServletControlador?accion=index">Regresar</a>
				
	</div>

</body>
</html>