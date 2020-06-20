<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar elemento</title>
</head>
<body>
	<div>
	
		<h1>Editar elemento</h1>
		<form action="ServletControlador">
			Codigo: <br>
			<input type="text" name="txtCodigo" value="<c:out value="${bean.codigo}"/>"><br>
			Nombre: <br>
			<input type="text" name="txtNombre" value="<c:out value="${bean.nombre}"/>"><br>
			Descripcion: <br>
			<input type="text" name="txtDescripcion" value="<c:out value="${bean.descripcion}"/>"><br>
			Existencia: <br>
			<input type="text" name="txtExistencia" value="<c:out value="${bean.existencia}"/>"><br>
			Precio: <br>
			<input type="text" name="txtPrecio" value="<c:out value="${bean.precio}"/>"><br><br>
			
			<input type="hidden" name="txtId" value="${bean.id }">
			<input type="submit" name="accion" value="Actualizar"><br>
			<a href="ServletControlador?accion=mostrar">Regresar</a>
		</form>
	</div>

</body>
</html>