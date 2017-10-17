package presentacion.command.imp.departamento.negocio;

import negocio.departamento.imp.TransferDepartamento;
import negocio.factoria.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioAltaDepartamentoCommand implements Command
{
	@Override
	public Contexto execute(Object datos) 
	{
		int id = FactoriaServicioAplicacion.getInstance().createSADepartamento().altaDepartamento((TransferDepartamento) datos);
		return new Contexto(ListaComandos.MOSTRARALTADEPARTAMENTO, id);
	}
}
