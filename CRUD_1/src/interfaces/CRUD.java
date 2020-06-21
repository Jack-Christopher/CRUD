package interfaces;

import modelo.Articulo;
import java.util.*;

public interface CRUD 
{
	public List<Articulo> mostrar();
	public Articulo list(int id);
	public boolean registrar(Articulo a1);
	public boolean editar(Articulo a1);
	public boolean eliminar(int id);

}
