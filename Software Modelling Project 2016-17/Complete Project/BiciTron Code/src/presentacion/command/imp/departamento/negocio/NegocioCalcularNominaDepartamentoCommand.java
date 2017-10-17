package presentacion.command.imp.departamento.negocio;

import negocio.factoria.FactoriaServicioAplicacion;
import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.controlador.Contexto;

public class NegocioCalcularNominaDepartamentoCommand implements Command
{
	@Override
	public Contexto execute(Object datos) 
	{
		double salario = FactoriaServicioAplicacion.getInstance().createSADepartamento().calcularNomina((int) datos);		
		return new Contexto(ListaComandos.MOSTRARCALCULARNOMINADEPARTAMENTO, salario);
	}

}
