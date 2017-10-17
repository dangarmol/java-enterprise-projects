package presentacion.command.imp.compra.negocio;

import java.util.ArrayList;
import negocio.compra.imp.TransferCompra;
import negocio.factoria.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioListaCompraCommand implements Command 
{
	@Override
	public Contexto execute(Object datos) 
	{
		ArrayList<TransferCompra> lista = FactoriaServicioAplicacion.getInstance().createSACompra().listaCompra();
		return new Contexto(ListaComandos.MOSTRARLISTACOMPRA, lista);
	}
}
