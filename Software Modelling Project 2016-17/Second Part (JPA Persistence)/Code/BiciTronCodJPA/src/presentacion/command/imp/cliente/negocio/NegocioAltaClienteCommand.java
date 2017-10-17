package presentacion.command.imp.cliente.negocio;

import negocio.cliente.imp.TransferCliente;
import negocio.factoria.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioAltaClienteCommand implements Command 
{
	@Override
	public Contexto execute(Object datos) 
	{
		int id = FactoriaServicioAplicacion.getInstance().createSACliente().altaCliente((TransferCliente) datos);
		return new Contexto(ListaComandos.MOSTRARALTACLIENTE, id);
	}
}
