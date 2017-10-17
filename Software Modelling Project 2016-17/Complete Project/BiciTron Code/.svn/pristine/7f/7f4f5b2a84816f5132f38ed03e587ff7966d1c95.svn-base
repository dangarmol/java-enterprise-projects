package presentacion.command.imp.cliente.negocio;

import java.util.ArrayList;
import negocio.cliente.imp.TransferCliente;
import negocio.factoria.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;
import presentacion.controlador.PareadoQuery;

public class NegocioNumeroClientesCommand implements Command 
{
	@Override
	public Contexto execute(Object datos) 
	{
		ArrayList<TransferCliente> lista = FactoriaServicioAplicacion.getInstance().createSACliente().numeroClientes((PareadoQuery) datos);
		return new Contexto(ListaComandos.MOSTRARNUMEROCLIENTESQUERY, lista);
	}
}
