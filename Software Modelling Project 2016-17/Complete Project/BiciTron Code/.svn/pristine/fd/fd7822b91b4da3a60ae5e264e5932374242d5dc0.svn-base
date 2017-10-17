package presentacion.command.imp.cliente.negocio;

import negocio.factoria.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioBajaClienteCommand implements Command
{
	@Override
	public Contexto execute(Object datos) 
	{
		int id = FactoriaServicioAplicacion.getInstance().createSACliente().bajaCliente((int) datos);
		return new Contexto(ListaComandos.MOSTRARBAJACLIENTE, id);
	}
}
