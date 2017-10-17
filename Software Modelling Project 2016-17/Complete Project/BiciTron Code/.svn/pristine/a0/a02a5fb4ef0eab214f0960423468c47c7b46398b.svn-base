package negocio.factoria;

import negocio.bicicleta.ServicioAplicacionBicicleta;
import negocio.cliente.ServicioAplicacionCliente;
import negocio.compra.ServicioAplicacionCompra;
import negocio.departamento.ServicioAplicacionDepartamento;
import negocio.empleado.ServicioAplicacionEmpleado;
import negocio.tienda.ServicioAplicacionTienda;

public abstract class FactoriaServicioAplicacion 
{
	private static FactoriaServicioAplicacion factoriaSA;

	public static synchronized FactoriaServicioAplicacion getInstance()
	{
		if (factoriaSA == null)
			factoriaSA = new FactoriaServicioAplicacionImp();
		return factoriaSA;
	}

	public abstract ServicioAplicacionBicicleta createSABicicleta();
	public abstract ServicioAplicacionCliente createSACliente();
	public abstract ServicioAplicacionCompra createSACompra();
	public abstract ServicioAplicacionEmpleado createSAEmpleado();
	public abstract ServicioAplicacionDepartamento createSADepartamento();
	public abstract ServicioAplicacionTienda createSATienda();
}