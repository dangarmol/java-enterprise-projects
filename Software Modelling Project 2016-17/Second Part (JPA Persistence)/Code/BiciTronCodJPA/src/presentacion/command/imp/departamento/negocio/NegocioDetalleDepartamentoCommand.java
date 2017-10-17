package presentacion.command.imp.departamento.negocio;

import negocio.departamento.imp.TransferDepartamento;
import negocio.factoria.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioDetalleDepartamentoCommand implements Command
{
	@Override
	public Contexto execute(Object datos) 
	{
		TransferDepartamento t = FactoriaServicioAplicacion.getInstance().createSADepartamento().detalleDepartamento((int) datos);		
		return new Contexto(ListaComandos.MOSTRARDETALLEDEPARTAMENTO, t);
	}
}
