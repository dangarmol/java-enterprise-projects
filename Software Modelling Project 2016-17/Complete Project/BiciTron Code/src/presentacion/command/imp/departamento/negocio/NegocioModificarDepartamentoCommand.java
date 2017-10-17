package presentacion.command.imp.departamento.negocio;

import negocio.departamento.imp.TransferDepartamento;
import negocio.factoria.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioModificarDepartamentoCommand implements Command
{
	@Override
	public Contexto execute(Object datos)
	{
		int id = FactoriaServicioAplicacion.getInstance().createSADepartamento().modificarDepartamento((TransferDepartamento)datos);		
		return new Contexto(ListaComandos.MOSTRARMODIFICARDEPARTAMENTO, id);
	}
}