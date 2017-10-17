package presentacion.dispatcher;

import presentacion.controlador.Contexto;

public abstract class Dispatcher 
{
	private static Dispatcher instancia;

	public static synchronized Dispatcher getInstance() 
	{
		if (instancia == null)
			instancia = new DispatcherImp();
		return instancia;
	}

	public abstract void accion(Contexto contexto);
}