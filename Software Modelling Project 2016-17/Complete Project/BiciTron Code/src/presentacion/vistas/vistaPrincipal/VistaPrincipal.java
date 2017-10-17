package presentacion.vistas.vistaPrincipal;

import presentacion.controlador.Contexto;

public abstract class VistaPrincipal 
{
	private static VistaPrincipal instance;

	public static synchronized VistaPrincipal getInstance() 
	{
		if (instance == null)
			instance = new VistaPrincipalImp();
		return instance;
	}

	public abstract void update(Contexto contexto);
}