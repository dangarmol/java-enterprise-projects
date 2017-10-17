package presentacion.command.imp.tienda.negocio;

import negocio.factoria.FactoriaServicioAplicacion;
import negocio.tienda.imp.TransferPresupuesto;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioAsignarDepartamentoTiendaCommand implements Command
{
	@Override
	public Contexto execute(Object datos)
	{
		int id = FactoriaServicioAplicacion.getInstance().createSATienda().asignarDepartamento((TransferPresupuesto)datos);		
		return new Contexto(ListaComandos.MOSTRARASIGNARDEPARTAMENTOTIENDA, id);
	}
}
