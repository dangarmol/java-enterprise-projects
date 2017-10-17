package presentacion.command.imp.compra.negocio;


import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioEliminarArticuloCompraCommand implements Command
{
	@Override
	public Contexto execute(Object datos)
	{
		return new Contexto (ListaComandos.MOSTRARELIMINARARTICULOCOMPRA, datos);
	}
}
