package presentacion.command;

import presentacion.controlador.Contexto;

public interface Command 
{
	public abstract Contexto execute(Object datos);
}