package presentacion.vistas.vistaDepartamento;

import presentacion.controlador.Contexto;

public abstract class VistaDepartamento 
{
	private static VistaDepartamento instance;

	public static synchronized VistaDepartamento getInstance() 
	{
		if (instance == null)
			instance = new VistaDepartamentoImp();
		return instance;
	}

	public abstract void update(Contexto contexto);
}