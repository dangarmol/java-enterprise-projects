package presentacion.command.imp.cliente.negocio;

import negocio.cliente.imp.TransferCliente;
import negocio.factoria.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioDetalleClienteCommand implements Command 
{
	@Override
	public Contexto execute(Object datos) 
	{
		TransferCliente id = FactoriaServicioAplicacion.getInstance().createSACliente().detalleCliente((int) datos);
		return new Contexto(ListaComandos.MOSTRARDETALLECLIENTE, id);
	}
}
