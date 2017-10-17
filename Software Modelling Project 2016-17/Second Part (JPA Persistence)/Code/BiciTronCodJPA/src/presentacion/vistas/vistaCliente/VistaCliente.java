package presentacion.vistas.vistaCliente;

import presentacion.controlador.Contexto;

public abstract class VistaCliente 
{
	private static VistaCliente instance;

	public static synchronized VistaCliente getInstance() 
	{
		if (instance == null)
			instance = new VistaClienteImp();
		return instance;
	}

	public abstract void update(Contexto contexto);
}