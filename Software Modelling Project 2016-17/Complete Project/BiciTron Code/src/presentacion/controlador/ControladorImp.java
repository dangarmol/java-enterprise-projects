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
		Command comando = factoriaComandos.getCommand(event); //Devuelve un objeto que se puede ejecutar dados un evento.
		Contexto contexto = comando.execute(datos); //Devuelve un Contexto, formado por un evento y unos datos
		Dispatcher dispatcher = Dispatcher.getInstance(); 
		dispatcher.accion(contexto);
	}
}