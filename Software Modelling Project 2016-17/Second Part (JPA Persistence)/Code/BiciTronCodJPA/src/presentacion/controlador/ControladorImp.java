package presentacion.controlador;

import presentacion.command.Command;
import presentacion.command.factoria.FactoriaCommands;
import presentacion.dispatcher.Dispatcher;

public class ControladorImp extends Controlador 
{
	@Override
	public void accion(int event, Object datos) 
	{
		FactoriaCommands factoriaComandos = FactoriaCommands.getInstance();
		Command comando = factoriaComandos.getCommand(event);
		Contexto contexto = comando.execute(datos);
		Dispatcher dispatcher = Dispatcher.getInstance();
		dispatcher.accion(contexto);
	}
}