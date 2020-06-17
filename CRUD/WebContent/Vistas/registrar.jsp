<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar elemento</title>
</head>
<body>
	<div>
		<h1>Agregar elemento</h1>
		<form action="ServletControlador">
			Codigo: <br>
			<input type="text" name="txtCodigo"><br>
			Nombre: <br>
			<input type="text" name="txtNombre"><br>
			Descripcion: <br>
			<input type="text" name="txtDescripcion"><br>
			Existencia: <br>
			<input type="text" name="txtExistencia"><br>
			Precio: <br>
			<input type="text" name="txtPrecio"><br><br>
			
			<input type="submit" name="accion" value=Agregar><br>
		</form>
		<a href="ServletControlador?accion=listar">Regresar</a>
	</div>
</body>
</html>