package presentacion.command.factoria;

import presentacion.command.Command;

public abstract class FactoriaCommands 
{
	private static FactoriaCommands instancia;

	public static synchronized FactoriaCommands getInstance() 
	{
		if (instancia == null) 
			instancia = new FactoriaCommandsImp();
		return instancia;
	}

	public abstract Command getCommand(int event);
}