package presentacion.command.imp.compra.negocio;

import negocio.compra.imp.TransferCompra;
import negocio.factoria.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioGestionCarritoCompraCommand implements Command {
	@Override
	public Contexto execute(Object datos) {
		TransferCompra t = FactoriaServicioAplicacion.getInstance()
				.createSACompra().iniciarCompra((int) datos);
		return new Contexto(ListaComandos.MOSTRARGESTIONCARRITOCOMPRA, t);
	}
}
