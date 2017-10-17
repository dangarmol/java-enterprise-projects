package presentacion.command.imp.departamento.negocio;

import java.util.ArrayList;
import negocio.departamento.imp.TransferDepartamento;
import negocio.factoria.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioListaDepartamentoCommand implements Command
{
	@Override
	public Contexto execute(Object datos) 
	{
		ArrayList<TransferDepartamento> lista = FactoriaServicioAplicacion.getInstance().createSADepartamento().listaDepartamento();		
		return new Contexto(ListaComandos.MOSTRARLISTADEPARTAMENTO, lista);
	}
}
