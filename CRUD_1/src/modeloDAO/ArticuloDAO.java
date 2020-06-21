package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.Conexion;
import interfaces.CRUD;
import modelo.Articulo;

public class ArticuloDAO implements CRUD
{
	Conexion cn=new Conexion();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Articulo a=new Articulo();
	

	@Override
	public List<Articulo> mostrar() 
	{
		ArrayList<Articulo>list=new ArrayList<>();
		String sql="select * from articulo";
		try 
		{
			con=cn.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Articulo a1=new Articulo();
				a1.setId(rs.getInt("id"));
				a1.setCodigo(rs.getString("codigo"));
				a1.setNombre(rs.getString("nombre"));
				a1.setDescripcion(rs.getString("descripcion"));
				a1.setExistencia(rs.getDouble("existencia"));
				a1.setPrecio(rs.getDouble("precio"));
				list.add(a1);
			}
		}
		catch (Exception e) 
		{
			
		}
		
		return list;
	}

	@Override
	public Articulo list(int id) 
	{
		String sql="select * from articulo where id ="+id;
		try 
		{
			con=cn.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				a.setId(rs.getInt("id"));
				a.setCodigo(rs.getString("codigo"));
				a.setNombre(rs.getString("nombre"));
				a.setDescripcion(rs.getString("descripcion"));
				a.setExistencia(rs.getDouble("existencia"));
				a.setPrecio(rs.getDouble("precio"));
			}
		}
		catch (Exception e) 
		{
			
		}
		
		return a;
	}

	@Override
	public boolean registrar(Articulo a) {
		String tempCodigo='"'+a.getCodigo()+'"'+',';
		String tempNombre='"'+a.getNombre()+'"'+',';
		String tempDescripcion='"'+a.getDescripcion()+'"'+',';
		String tempExistencia='"'+Double.toString(a.getExistencia()) +'"'+',';
		String tempPrecio='"'+Double.toString(a.getPrecio())+'"'+')';
		
		String values=tempCodigo+tempNombre+tempDescripcion+tempExistencia+tempPrecio;
		String sql="insert into articulo(codigo,nombre,descripcion,existencia,precio)values("+values;
		
		try 
		{
			con=cn.getConnection();
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
			
		}
		catch (Exception e) 
		{
			
		}
		return false;
	}

	@Override
	public boolean editar(Articulo a) {
		String tempID= a.getId()+"";
		String tempCodigo="codigo="+'"'+a.getCodigo()+'"'+',';
		String tempNombre="nombre="+'"'+a.getNombre()+'"'+',';
		String tempDescripcion="descripcion="+'"'+a.getDescripcion()+'"'+',';
		String tempExistencia="existencia="+'"'+Double.toString(a.getExistencia()) +'"'+',';
		String tempPrecio="precio="+'"'+Double.toString(a.getPrecio())+'"';
		
		String values=tempCodigo+tempNombre+tempDescripcion+tempExistencia+tempPrecio;
		String sql="update articulo set "+values+" where id="+tempID;
		
		try 
		{
			con=cn.getConnection();
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
			
		}
		catch (Exception e) 
		{
			
		}
		return false;
	}

	@Override
	public boolean eliminar(int id) {
		String sql="delete from articulo where id="+id;
		try 
		{
			con=cn.getConnection();
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
			
		}
		catch (Exception e) 
		{
			
		}
		return false;
	}

}
