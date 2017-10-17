package presentacion.command.imp.cliente.negocio;

import negocio.cliente.imp.TransferCliente;
import negocio.factoria.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioModificarClienteCommand implements Command
{
	@Override
	public Contexto execute(Object datos) 
	{
		int id = FactoriaServicioAplicacion.getInstance().createSACliente().modificarCliente((TransferCliente) datos);
		return new Contexto(ListaComandos.MOSTRARMODIFICARCLIENTE, id);
	}
}
