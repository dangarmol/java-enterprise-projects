package presentacion.vistas.vistaCompra;

import presentacion.controlador.Contexto;

public abstract class VistaCompra
{
	private static VistaCompra instance;

	public static synchronized VistaCompra getInstance() 
	{
		if (instance == null)
			instance = new VistaCompraImp();
		return instance;
	}

	public abstract void update(Contexto contexto);
}