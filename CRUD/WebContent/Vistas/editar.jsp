<%@page import="modelo.Articulo"%>
<%@page import="modeloDAO.ArticuloDAO"%>
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
	<%
		ArticuloDAO dao=new ArticuloDAO();
		int id=Integer.parseInt((String)request.getAttribute("Id_a"));
		Articulo a=(Articulo)dao.list(id);
		
	%>
		<h1>Editar elemento</h1>
		<form action="ServletControlador">
			Codigo: <br>
			<input type="text" name="txtCodigo" value="<%= a.getCodigo() %>"><br>
			Nombre: <br>
			<input type="text" name="txtNombre" value="<%= a.getNombre() %>"><br>
			Descripcion: <br>
			<input type="text" name="txtDescripcion" value="<%= a.getDescripcion() %>"><br>
			Existencia: <br>
			<input type="text" name="txtExistencia" value="<%= a.getExistencia() %>"><br>
			Precio: <br>
			<input type="text" name="txtPrecio" value="<%= a.getPrecio() %>"><br><br>
			
			<input type="hidden" name="txtId" value="<%= a.getId() %>">
			<input type="submit" name="accion" value="Actualizar"><br>
			<a href="ServletControlador?accion=listar">Regresar</a>
		</form>
	</div>

</body>
</html>