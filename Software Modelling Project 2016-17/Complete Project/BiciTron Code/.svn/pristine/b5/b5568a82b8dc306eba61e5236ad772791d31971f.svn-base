package presentacion.command.imp.compra.negocio;

import negocio.factoria.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioAgregarArticuloCompraCommand implements Command 
{
	@Override
	public Contexto execute(Object datos) 
	{
		datos = FactoriaServicioAplicacion.getInstance().createSACompra().agregarArticulo((Contexto) datos);
		return new Contexto(ListaComandos.MOSTRARAGREGARARTICULOCOMPRA, datos);
	}
}
