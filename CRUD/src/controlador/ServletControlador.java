package controlador;

import java.io.IOException;

import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import modelo.Articulo;
import modeloDAO.ArticuloDAO;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String mostrar="Vistas/mostrar.jsp";
	String registrar="Vistas/registrar.jsp";
	String editar="Vistas/editar.jsp";
	String index="index.jsp";
	Articulo art=new Articulo();
	ArticuloDAO dao=new ArticuloDAO();
	List<Articulo> listaArticulos= dao.mostrar();
	
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String acceso="";
		String action=request.getParameter("accion");
		if (action.equalsIgnoreCase("mostrar"))
		{
			acceso=mostrar;
			request.setAttribute("listaDA", listaArticulos);
		}
		else if(action.equalsIgnoreCase("index"))
		{
			acceso= index;
		}
		else if(action.equalsIgnoreCase("registrar"))
		{
			acceso=registrar;
		}
		else if (action.equalsIgnoreCase("Agregar"))
		{
			String codigo=request.getParameter("txtCodigo");
			String nombre=request.getParameter("txtNombre");
			String descripcion=request.getParameter("txtDescripcion");
			double existencia=Double.parseDouble(request.getParameter("txtExistencia")) ;
			double precio=Double.parseDouble(request.getParameter("txtPrecio"));
			art.setCodigo(codigo);
			art.setNombre(nombre);
			art.setDescripcion(descripcion);
			art.setExistencia(existencia);
			art.setPrecio(precio);
			dao.registrar(art);
			acceso=mostrar;
		}
		else if(action.equalsIgnoreCase("editar"))
		{
			acceso=editar;
		}
		else if(action.equalsIgnoreCase("Actualizar"))
		{
			art.setId(Integer.parseInt(request.getParameter("txtId")));
			String codigo=request.getParameter("txtCodigo");
			String nombre=request.getParameter("txtNombre");
			String descripcion=request.getParameter("txtDescripcion");
			double existencia=Double.parseDouble(request.getParameter("txtExistencia")) ;
			double precio=Double.parseDouble(request.getParameter("txtPrecio"));
			art.setCodigo(codigo);
			art.setNombre(nombre);
			art.setDescripcion(descripcion);
			art.setExistencia(existencia);
			art.setPrecio(precio);
			dao.editar(art);
			acceso=mostrar; 
		}
		else if (action.equalsIgnoreCase("eliminar"))
		{
			art.setId(Integer.parseInt(request.getParameter("id")));
			dao.eliminar(art.getId());
			acceso=mostrar;
		}
		
		MyBean bean = new MyBean();
		bean.setId(art.getId());
		bean.setCodigo(art.getCodigo());
		bean.setDescripcion(art.getDescripcion());
		bean.setNombre(art.getNombre());
		bean.setExistencia(art.getExistencia());
		bean.setPrecio(art.getPrecio());
		
		
		request.setAttribute("bean", bean);
		
		RequestDispatcher vista=request.getRequestDispatcher(acceso);
		vista.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
