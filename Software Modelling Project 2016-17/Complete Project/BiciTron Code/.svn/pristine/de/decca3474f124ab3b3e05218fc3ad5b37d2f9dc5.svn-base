package negocio.factoria;

import negocio.bicicleta.ServicioAplicacionBicicleta;
import negocio.bicicleta.imp.ServicioAplicacionBicicletaImp;
import negocio.cliente.ServicioAplicacionCliente;
import negocio.cliente.imp.ServicioAplicacionClienteImp;
import negocio.compra.ServicioAplicacionCompra;
import negocio.compra.imp.ServicioAplicacionCompraImp;
import negocio.departamento.ServicioAplicacionDepartamento;
import negocio.departamento.imp.ServicioAplicacionDepartamentoImp;
import negocio.empleado.ServicioAplicacionEmpleado;
import negocio.empleado.imp.ServicioAplicacionEmpleadoImp;
import negocio.tienda.ServicioAplicacionTienda;
import negocio.tienda.imp.ServicioAplicacionTiendaImp;

public class FactoriaServicioAplicacionImp extends FactoriaServicioAplicacion
{
	@Override
	public ServicioAplicacionBicicleta createSABicicleta()
	{
		return new ServicioAplicacionBicicletaImp();
	}

	@Override
	public ServicioAplicacionCliente createSACliente() 
	{
		return new ServicioAplicacionClienteImp();
	}

	@Override
	public ServicioAplicacionCompra createSACompra() 
	{
		return new ServicioAplicacionCompraImp();
	}

	@Override
	public ServicioAplicacionDepartamento createSADepartamento() 
	{
		return new ServicioAplicacionDepartamentoImp();
	}
	
	@Override
	public ServicioAplicacionEmpleado createSAEmpleado() 
	{
		return new ServicioAplicacionEmpleadoImp();
	}

	@Override
	public ServicioAplicacionTienda createSATienda()
	{
		return new ServicioAplicacionTiendaImp();
	}
}