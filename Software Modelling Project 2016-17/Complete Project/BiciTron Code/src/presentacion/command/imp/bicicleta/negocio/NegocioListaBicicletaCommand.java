package presentacion.command.imp.bicicleta.negocio;

import java.util.ArrayList;
import negocio.bicicleta.imp.TransferBicicleta;
import negocio.factoria.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioListaBicicletaCommand implements Command {
	@Override
	public Contexto execute(Object datos) {
		ArrayList<TransferBicicleta> lista = FactoriaServicioAplicacion
				.getInstance().createSABicicleta().listaBicicleta();
		return new Contexto(ListaComandos.MOSTRARLISTABICICLETA, lista);
	}
}
