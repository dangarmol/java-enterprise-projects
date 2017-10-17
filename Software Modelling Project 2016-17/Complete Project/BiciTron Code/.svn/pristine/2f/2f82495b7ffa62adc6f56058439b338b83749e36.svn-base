package presentacion.command.factoria;

import presentacion.ListaComandos;
import presentacion.command.Command;
import presentacion.command.imp.bicicleta.negocio.NegocioAltaBicicletaCommand;
import presentacion.command.imp.bicicleta.negocio.NegocioBajaBicicletaCommand;
import presentacion.command.imp.bicicleta.negocio.NegocioCantidadBicicletasCommand;
import presentacion.command.imp.bicicleta.negocio.NegocioDetalleBicicletaCommand;
import presentacion.command.imp.bicicleta.negocio.NegocioListaBicicletaCommand;
import presentacion.command.imp.bicicleta.negocio.NegocioModificarBicicletaCommand;
import presentacion.command.imp.bicicleta.vista.VistaAltaBicicletaCarreteraCommand;
import presentacion.command.imp.bicicleta.vista.VistaAltaBicicletaMontanaCommand;
import presentacion.command.imp.bicicleta.vista.VistaBajaBicicletaCommand;
import presentacion.command.imp.bicicleta.vista.VistaBotoneraBicicletaCommand;
import presentacion.command.imp.bicicleta.vista.VistaCantidadBicicletasQueryCommand;
import presentacion.command.imp.bicicleta.vista.VistaDetalleBicicletaCommand;
import presentacion.command.imp.bicicleta.vista.VistaListaBicicletaCommand;
import presentacion.command.imp.bicicleta.vista.VistaModificarBicicletaCarreteraCommand;
import presentacion.command.imp.bicicleta.vista.VistaModificarBicicletaMontanaCommand;
import presentacion.command.imp.cliente.negocio.NegocioAltaClienteCommand;
import presentacion.command.imp.cliente.negocio.NegocioBajaClienteCommand;
import presentacion.command.imp.cliente.negocio.NegocioDetalleClienteCommand;
import presentacion.command.imp.cliente.negocio.NegocioListaClienteCommand;
import presentacion.command.imp.cliente.negocio.NegocioModificarClienteCommand;
import presentacion.command.imp.cliente.negocio.NegocioNumeroClientesCommand;
import presentacion.command.imp.cliente.vista.VistaAltaClienteCommand;
import presentacion.command.imp.cliente.vista.VistaBajaClienteCommand;
import presentacion.command.imp.cliente.vista.VistaBotoneraClienteCommand;
import presentacion.command.imp.cliente.vista.VistaDetalleClienteCommand;
import presentacion.command.imp.cliente.vista.VistaListaClienteCommand;
import presentacion.command.imp.cliente.vista.VistaModificarClienteCommand;
import presentacion.command.imp.cliente.vista.VistaNumeroClientesQueryCommand;
import presentacion.command.imp.compra.negocio.NegocioAgregarArticuloCompraCommand;
import presentacion.command.imp.compra.negocio.NegocioDetalleCompraCommand;
import presentacion.command.imp.compra.negocio.NegocioDevolucionCompraCommand;
import presentacion.command.imp.compra.negocio.NegocioEliminarArticuloCompraCommand;
import presentacion.command.imp.compra.negocio.NegocioFinalizarCompraCommand;
import presentacion.command.imp.compra.negocio.NegocioGestionCarritoCompraCommand;
import presentacion.command.imp.compra.negocio.NegocioListaCompraCommand;
import presentacion.command.imp.compra.vista.VistaAgregarArticuloCompraCommand;
import presentacion.command.imp.compra.vista.VistaBotoneraCompraCommand;
import presentacion.command.imp.compra.vista.VistaDetalleCompraCommand;
import presentacion.command.imp.compra.vista.VistaDevolucionCompraCommand;
import presentacion.command.imp.compra.vista.VistaEliminarArticuloCompraCommand;
import presentacion.command.imp.compra.vista.VistaGestionCarritoCompraCommand;
import presentacion.command.imp.compra.vista.VistaIniciarCompraCommand;
import presentacion.command.imp.compra.vista.VistaListaCompraCommand;
import presentacion.command.imp.departamento.negocio.NegocioAltaDepartamentoCommand;
import presentacion.command.imp.departamento.negocio.NegocioBajaDepartamentoCommand;
import presentacion.command.imp.departamento.negocio.NegocioCalcularNominaDepartamentoCommand;
import presentacion.command.imp.departamento.negocio.NegocioDetalleDepartamentoCommand;
import presentacion.command.imp.departamento.negocio.NegocioListaDepartamentoCommand;
import presentacion.command.imp.departamento.negocio.NegocioModificarDepartamentoCommand;
import presentacion.command.imp.departamento.vista.VistaAltaDepartamentoCommand;
import presentacion.command.imp.departamento.vista.VistaBajaDepartamentoCommand;
import presentacion.command.imp.departamento.vista.VistaBotoneraDepartamentoCommand;
import presentacion.command.imp.departamento.vista.VistaCalcularNominaDepartamentoCommand;
import presentacion.command.imp.departamento.vista.VistaDetalleDepartamentoCommand;
import presentacion.command.imp.departamento.vista.VistaListaDepartamentoCommand;
import presentacion.command.imp.departamento.vista.VistaModificarDepartamentoCommand;
import presentacion.command.imp.empleado.negocio.NegocioAltaEmpleadoCommand;
import presentacion.command.imp.empleado.negocio.NegocioBajaEmpleadoCommand;
import presentacion.command.imp.empleado.negocio.NegocioDetalleEmpleadoCommand;
import presentacion.command.imp.empleado.negocio.NegocioListaEmpleadoCommand;
import presentacion.command.imp.empleado.negocio.NegocioModificarEmpleadoCommand;
import presentacion.command.imp.empleado.vista.VistaAltaEmpleadoCommand;
import presentacion.command.imp.empleado.vista.VistaBajaEmpleadoCommand;
import presentacion.command.imp.empleado.vista.VistaBotoneraEmpleadoCommand;
import presentacion.command.imp.empleado.vista.VistaDetalleEmpleadoCommand;
import presentacion.command.imp.empleado.vista.VistaListaEmpleadoCommand;
import presentacion.command.imp.empleado.vista.VistaModificarEmpleadoCommand;
import presentacion.command.imp.principal.vista.VistaBotoneraPrincipalCommand;
import presentacion.command.imp.tienda.negocio.NegocioAltaTiendaCommand;
import presentacion.command.imp.tienda.negocio.NegocioAsignarDepartamentoTiendaCommand;
import presentacion.command.imp.tienda.negocio.NegocioAsignarPresupuestoTiendaCommand;
import presentacion.command.imp.tienda.negocio.NegocioBajaTiendaCommand;
import presentacion.command.imp.tienda.negocio.NegocioDesasignarDepartamentoTiendaCommand;
import presentacion.command.imp.tienda.negocio.NegocioDetallePresupuestoTiendaCommand;
import presentacion.command.imp.tienda.negocio.NegocioDetalleTiendaCommand;
import presentacion.command.imp.tienda.negocio.NegocioListaPresupuestoTiendaCommand;
import presentacion.command.imp.tienda.negocio.NegocioListaTiendaCommand;
import presentacion.command.imp.tienda.negocio.NegocioModificarTiendaCommand;
import presentacion.command.imp.tienda.vista.VistaAltaTiendaCommand;
import presentacion.command.imp.tienda.vista.VistaAsignarDepartamentoTiendaCommand;
import presentacion.command.imp.tienda.vista.VistaAsignarPresupuestoTiendaCommand;
import presentacion.command.imp.tienda.vista.VistaBajaTiendaCommand;
import presentacion.command.imp.tienda.vista.VistaBotoneraTiendaCommand;
import presentacion.command.imp.tienda.vista.VistaDesasignarDepartamentoTiendaCommand;
import presentacion.command.imp.tienda.vista.VistaDetallePresupuestoTiendaCommand;
import presentacion.command.imp.tienda.vista.VistaDetalleTiendaCommand;
import presentacion.command.imp.tienda.vista.VistaListaPresupuestoTiendaCommand;
import presentacion.command.imp.tienda.vista.VistaListaTiendaCommand;
import presentacion.command.imp.tienda.vista.VistaModificarTiendaCommand;

public class FactoriaCommandsImp extends FactoriaCommands 
{
	@Override
	public Command getCommand(int event) 
	{
		Command comando = null;
		switch (event) 
		{
			// Principal
	
			case ListaComandos.VENTANAPRINCIPAL:
				comando = new VistaBotoneraPrincipalCommand();
				break;
	
			// Vistas Bicicleta	
	
			case ListaComandos.VENTANAALTABICICLETACARRETERA:
				comando = new VistaAltaBicicletaCarreteraCommand();
				break;
			case ListaComandos.VENTANAALTABICICLETAMONTANA:
				comando = new VistaAltaBicicletaMontanaCommand();
				break;
			case ListaComandos.VENTANABAJABICICLETA:
				comando = new VistaBajaBicicletaCommand();
				break;
			case ListaComandos.VENTANABOTONERABICICLETA:
				comando = new VistaBotoneraBicicletaCommand();
				break;
			case ListaComandos.VENTANADETALLEBICICLETA:
				comando = new VistaDetalleBicicletaCommand();
				break;
			case ListaComandos.VENTANALISTABICICLETA:
				comando = new VistaListaBicicletaCommand();
				break;
			case ListaComandos.VENTANAMODIFICARBICICLETACARRETERA:
				comando = new VistaModificarBicicletaCarreteraCommand();
				break;
			case ListaComandos.VENTANAMODIFICARBICICLETAMONTANA:
				comando = new VistaModificarBicicletaMontanaCommand();
				break;
			case ListaComandos.VENTANACANTIDADBICICLETASQUERY:
				comando = new VistaCantidadBicicletasQueryCommand();
				break;
	
			// Vistas Cliente	
	
			case ListaComandos.VENTANAALTACLIENTE:
				comando = new VistaAltaClienteCommand();
				break;
			case ListaComandos.VENTANABAJACLIENTE:
				comando = new VistaBajaClienteCommand();
				break;
			case ListaComandos.VENTANABOTONERACLIENTE:
				comando = new VistaBotoneraClienteCommand();
				break;
			case ListaComandos.VENTANADETALLECLIENTE:
				comando = new VistaDetalleClienteCommand();
				break;
			case ListaComandos.VENTANALISTACLIENTE:
				comando = new VistaListaClienteCommand();
				break;
			case ListaComandos.VENTANAMODIFICARCLIENTE:
				comando = new VistaModificarClienteCommand();
				break;
			case ListaComandos.VENTANANUMEROCLIENTESQUERY:
				comando = new VistaNumeroClientesQueryCommand();
				break;
	
			// Vistas Compra	
	
			case ListaComandos.VENTANAAGREGARARTICULOCOMPRA:
				comando = new VistaAgregarArticuloCompraCommand();
				break;
			case ListaComandos.VENTANABOTONERACOMPRA:
				comando = new VistaBotoneraCompraCommand();
				break;
			case ListaComandos.VENTANADETALLECOMPRA:
				comando = new VistaDetalleCompraCommand();
				break;
			case ListaComandos.VENTANADEVOLUCIONCOMPRA:
				comando = new VistaDevolucionCompraCommand();
				break;
			case ListaComandos.VENTANAELIMINARARTICULOCOMPRA:
				comando = new VistaEliminarArticuloCompraCommand();
				break;
			case ListaComandos.VENTANAGESTIONCARRITOCOMPRA:
				comando = new VistaGestionCarritoCompraCommand();
				break;
			case ListaComandos.VENTANAINICIARCOMPRA:
				comando = new VistaIniciarCompraCommand();
				break;
			case ListaComandos.VENTANALISTACOMPRA:
				comando = new VistaListaCompraCommand();
				break;
				
			// Vistas Departamento
	
			case ListaComandos.VENTANAALTADEPARTAMENTO:
				comando = new VistaAltaDepartamentoCommand();
				break;
			case ListaComandos.VENTANABAJADEPARTAMENTO:
				comando = new VistaBajaDepartamentoCommand();
				break;
			case ListaComandos.VENTANABOTONERADEPARTAMENTO:
				comando = new VistaBotoneraDepartamentoCommand();
				break;
			case ListaComandos.VENTANADETALLEDEPARTAMENTO:
				comando = new VistaDetalleDepartamentoCommand();
				break;
			case ListaComandos.VENTANALISTADEPARTAMENTO:
				comando = new VistaListaDepartamentoCommand();
				break;
			case ListaComandos.VENTANAMODIFICARDEPARTAMENTO:
				comando = new VistaModificarDepartamentoCommand();
				break;
			case ListaComandos.VENTANACALCULARNOMINADEPARTAMENTO:
				comando = new VistaCalcularNominaDepartamentoCommand();
				break;
	
			// Vistas Empleado
				
			case ListaComandos.VENTANAALTAEMPLEADO:
				comando = new VistaAltaEmpleadoCommand();
				break;
			case ListaComandos.VENTANABAJAEMPLEADO:
				comando = new VistaBajaEmpleadoCommand();
				break;
			case ListaComandos.VENTANABOTONERAEMPLEADO:
				comando = new VistaBotoneraEmpleadoCommand();
				break;
			case ListaComandos.VENTANADETALLEEMPLEADO:
				comando = new VistaDetalleEmpleadoCommand();
				break;
			case ListaComandos.VENTANALISTAEMPLEADO:
				comando = new VistaListaEmpleadoCommand();
				break;
			case ListaComandos.VENTANAMODIFICAREMPLEADO:
				comando = new VistaModificarEmpleadoCommand();
				break;
				
			// Vistas Tienda
	
			case ListaComandos.VENTANAALTATIENDA:
				comando = new VistaAltaTiendaCommand();
				break;
			case ListaComandos.VENTANABAJATIENDA:
				comando = new VistaBajaTiendaCommand();
				break;
			case ListaComandos.VENTANABOTONERATIENDA:
				comando = new VistaBotoneraTiendaCommand();
				break;
			case ListaComandos.VENTANADETALLETIENDA:
				comando = new VistaDetalleTiendaCommand();
				break;
			case ListaComandos.VENTANALISTATIENDA:
				comando = new VistaListaTiendaCommand();
				break;
			case ListaComandos.VENTANAMODIFICARTIENDA:
				comando = new VistaModificarTiendaCommand();
				break;
			case ListaComandos.VENTANAASIGNARDEPARTAMENTOTIENDA:
				comando = new VistaAsignarDepartamentoTiendaCommand();
				break;
			case ListaComandos.VENTANADESASIGNARDEPARTAMENTOTIENDA:
				comando = new VistaDesasignarDepartamentoTiendaCommand();
				break;
			case ListaComandos.VENTANAASIGNARPRESUPUESTOTIENDA:
				comando = new VistaAsignarPresupuestoTiendaCommand();
				break;
			case ListaComandos.VENTANADETALLEPRESUPUESTOTIENDA:
				comando = new VistaDetallePresupuestoTiendaCommand();
				break;
			case ListaComandos.VENTANALISTAPRESUPUESTOTIENDA:
				comando = new VistaListaPresupuestoTiendaCommand();
				break;
				
			// Negocio	Bicicleta
	
			case ListaComandos.NEGOCIOALTABICICLETA:
				comando = new NegocioAltaBicicletaCommand();
				break;
			case ListaComandos.NEGOCIOBAJABICICLETA:
				comando = new NegocioBajaBicicletaCommand();
				break;
			case ListaComandos.NEGOCIODETALLEBICICLETA:
				comando = new NegocioDetalleBicicletaCommand();
				break;
			case ListaComandos.NEGOCIOLISTABICICLETA:
				comando = new NegocioListaBicicletaCommand();
				break;
			case ListaComandos.NEGOCIOMODIFICARBICICLETA:
				comando = new NegocioModificarBicicletaCommand();
				break;
			case ListaComandos.NEGOCIOCANTIDADBICICLETASQUERY:
				comando = new NegocioCantidadBicicletasCommand();
				break;
	
			// Negocio	Cliente
	
			case ListaComandos.NEGOCIOALTACLIENTE:
				comando = new NegocioAltaClienteCommand();
				break;
			case ListaComandos.NEGOCIOBAJACLIENTE:
				comando = new NegocioBajaClienteCommand();
				break;
			case ListaComandos.NEGOCIODETALLECLIENTE:
				comando = new NegocioDetalleClienteCommand();
				break;
			case ListaComandos.NEGOCIOLISTACLIENTE:
				comando = new NegocioListaClienteCommand();
				break;
			case ListaComandos.NEGOCIOMODIFICARCLIENTE:
				comando = new NegocioModificarClienteCommand();
				break;
			case ListaComandos.NEGOCIONUMEROCLIENTESQUERY:
				comando = new NegocioNumeroClientesCommand();
				break;
	
			// Negocio	Compra
	
			case ListaComandos.NEGOCIOGESTIONCARRITOCOMPRA:
				comando = new NegocioGestionCarritoCompraCommand();
				break;
			case ListaComandos.NEGOCIOAGREGARARTICULOCOMPRA:
				comando = new NegocioAgregarArticuloCompraCommand();
				break;
			case ListaComandos.NEGOCIOELIMINARARTICULOCOMPRA:
				comando = new NegocioEliminarArticuloCompraCommand();
				break;
			case ListaComandos.NEGOCIOFINALIZARCOMPRA:
				comando = new NegocioFinalizarCompraCommand();
				break;
			case ListaComandos.NEGOCIODEVOLUCIONCOMPRA:
				comando = new NegocioDevolucionCompraCommand();
				break;
			case ListaComandos.NEGOCIODETALLECOMPRA:
				comando = new NegocioDetalleCompraCommand();
				break;
			case ListaComandos.NEGOCIOLISTACOMPRA:
				comando = new NegocioListaCompraCommand();
				break;
			
			// Negocio	Departamento
	
			case ListaComandos.NEGOCIOALTADEPARTAMENTO:
				comando = new NegocioAltaDepartamentoCommand();
				break;
			case ListaComandos.NEGOCIOBAJADEPARTAMENTO:
				comando = new NegocioBajaDepartamentoCommand();
				break;
			case ListaComandos.NEGOCIODETALLEDEPARTAMENTO:
				comando = new NegocioDetalleDepartamentoCommand();
				break;
			case ListaComandos.NEGOCIOLISTADEPARTAMENTO:
				comando = new NegocioListaDepartamentoCommand();
				break;
			case ListaComandos.NEGOCIOMODIFICARDEPARTAMENTO:
				comando = new NegocioModificarDepartamentoCommand();
				break;
			case ListaComandos.NEGOCIOCALCULARNOMINADEPARTAMENTO:
				comando = new NegocioCalcularNominaDepartamentoCommand();
				break;
				
			// Negocio	Empleado
		
			case ListaComandos.NEGOCIOALTAEMPLEADO:
				comando = new NegocioAltaEmpleadoCommand();
				break;
			case ListaComandos.NEGOCIOBAJAEMPLEADO:
				comando = new NegocioBajaEmpleadoCommand();
				break;
			case ListaComandos.NEGOCIODETALLEEMPLEADO:
				comando = new NegocioDetalleEmpleadoCommand();
				break;
			case ListaComandos.NEGOCIOLISTAEMPLEADO:
				comando = new NegocioListaEmpleadoCommand();
				break;
			case ListaComandos.NEGOCIOMODIFICAREMPLEADO:
				comando = new NegocioModificarEmpleadoCommand();
				break;
				
			// Negocio	Tienda
			
			case ListaComandos.NEGOCIOALTATIENDA:
				comando = new NegocioAltaTiendaCommand();
				break;
			case ListaComandos.NEGOCIOBAJATIENDA:
				comando = new NegocioBajaTiendaCommand();
				break;
			case ListaComandos.NEGOCIODETALLETIENDA:
				comando = new NegocioDetalleTiendaCommand();
				break;
			case ListaComandos.NEGOCIOLISTATIENDA:
				comando = new NegocioListaTiendaCommand();
				break;
			case ListaComandos.NEGOCIOMODIFICARTIENDA:
				comando = new NegocioModificarTiendaCommand();
				break;
			case ListaComandos.NEGOCIOASIGNARDEPARTAMENTOTIENDA:
				comando = new NegocioAsignarDepartamentoTiendaCommand();
				break;
			case ListaComandos.NEGOCIODESASIGNARDEPARTAMENTOTIENDA:
				comando = new NegocioDesasignarDepartamentoTiendaCommand();
				break;
			case ListaComandos.NEGOCIOASIGNARPRESUPUESTOTIENDA:
				comando = new NegocioAsignarPresupuestoTiendaCommand();
				break;
			case ListaComandos.NEGOCIODETALLEPRESUPUESTOTIENDA:
				comando = new NegocioDetallePresupuestoTiendaCommand();
				break;
			case ListaComandos.NEGOCIOLISTAPRESUPUESTOTIENDA:
				comando = new NegocioListaPresupuestoTiendaCommand();
				break;
		}
		
		return comando;
	}
}
