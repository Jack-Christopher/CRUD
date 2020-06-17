<%@page import="modeloDAO.ArticuloDAO"%>
<%@page import="modelo.Articulo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

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
		<table border="1">
			<thead>
				<tr>
					<th>ID</th>
					<th>Codigo</th>
					<th>Nombre</th>
					<th>Descripcion</th>
					<th>Existencia</th>
					<th>Precio</th>
					<th colspan=2>Acciones</th>
				</tr>
				
			</thead>
			<%
				ArticuloDAO dao=new ArticuloDAO();
				List<Articulo>list=dao.mostrar();
				Iterator<Articulo>iter=list.iterator();
				Articulo a1=null;
				while(iter.hasNext())
				{
					a1=iter.next();
			%>
			
			<tbody>
				<tr>
					<td><%= a1.getId() %></td>
					<td><%= a1.getCodigo() %></td>
					<td><%= a1.getNombre() %></td>
					<td><%= a1.getDescripcion() %></td>
					<td><%= a1.getExistencia() %></td>
					<td><%= a1.getPrecio() %></td>
					<td>
						<a href="ServletControlador?accion=editar&id=<%= a1.getId() %>">Editar</a>
						<a href="ServletControlador?accion=eliminar&id2=<%= a1.getId() %>">Eliminar</a>
					</td>
				</tr>
				<% } %>

			</tbody>
			
			
		</table>
		<a href="ServletControlador?accion=listar">Regresar</a>
				
	</div>

</body>
</html>