package presentacion.command.imp.departamento.negocio;

import negocio.factoria.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioBajaDepartamentoCommand implements Command
{
	@Override
	public Contexto execute(Object datos) 
	{
		int id = FactoriaServicioAplicacion.getInstance().createSADepartamento().bajaDepartamento((int)datos);
		return new Contexto(ListaComandos.MOSTRARBAJADEPARTAMENTO, id);
	}
}
