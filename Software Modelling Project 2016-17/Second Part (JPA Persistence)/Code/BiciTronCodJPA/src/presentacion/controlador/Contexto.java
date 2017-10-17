package presentacion.controlador;

public class Contexto 
{
	private int event;
	private Object datos;

	public Contexto(int event, Object datos) 
	{
		this.event = event;
		this.datos = datos;
	}

	public int getEvent() 
	{
		return event;
	}

	public Object getDatos() 
	{
		return datos;
	}
}