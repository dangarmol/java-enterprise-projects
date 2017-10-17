package presentacion.command.imp.cliente.negocio;

import java.util.ArrayList;
import negocio.cliente.imp.TransferCliente;
import negocio.factoria.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioListaClienteCommand implements Command 
{
	@Override
	public Contexto execute(Object datos)
	{
		ArrayList<TransferCliente> lista = FactoriaServicioAplicacion.getInstance().createSACliente().listaCliente();
		return new Contexto(ListaComandos.MOSTRARLISTACLIENTE, lista);
	}
}
