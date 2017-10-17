package presentacion.controlador;

public abstract class Controlador 
{
	private static Controlador instancia;

	public static synchronized Controlador getInstance() 
	{
		if (instancia == null)
			instancia = new ControladorImp();
		return instancia;
	}

	public abstract void accion(int event, Object datos);
}