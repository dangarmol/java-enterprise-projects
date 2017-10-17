package presentacion.dispatcher;

import presentacion.ListaComandos;
import presentacion.controlador.Contexto;
import presentacion.vistas.vistaBicicleta.VistaBicicleta;
import presentacion.vistas.vistaCliente.VistaCliente;
import presentacion.vistas.vistaCompra.VistaCompra;
import presentacion.vistas.vistaDepartamento.VistaDepartamento;
import presentacion.vistas.vistaEmpleado.VistaEmpleado;
import presentacion.vistas.vistaPrincipal.VistaPrincipal;
import presentacion.vistas.vistaTienda.VistaTienda;

public class DispatcherImp extends Dispatcher 
{
	@Override
	public void accion(Contexto contexto) 
	{
		switch (contexto.getEvent()) 
		{
			// Vista Principal
	
			case ListaComandos.VENTANAPRINCIPAL:
				VistaPrincipal.getInstance().update(contexto);
				break;
	
			// Vista Bicicleta
	
			case ListaComandos.VENTANAALTABICICLETACARRETERA:
			case ListaComandos.VENTANAALTABICICLETAMONTANA:
			case ListaComandos.VENTANABAJABICICLETA:
			case ListaComandos.VENTANABOTONERABICICLETA:
			case ListaComandos.VENTANADETALLEBICICLETA:
			case ListaComandos.VENTANALISTABICICLETA:
			case ListaComandos.VENTANAMODIFICARBICICLETACARRETERA:
			case ListaComandos.VENTANAMODIFICARBICICLETAMONTANA:
			case ListaComandos.VENTANACANTIDADBICICLETASQUERY:
			case ListaComandos.MOSTRARALTABICICLETA:
			case ListaComandos.MOSTRARBAJABICICLETA:
			case ListaComandos.MOSTRARDETALLEBICICLETA:
			case ListaComandos.MOSTRARLISTABICICLETA:
			case ListaComandos.MOSTRARMODIFICARBICICLETA:
			case ListaComandos.MOSTRARCANTIDADBICICLETASQUERY:
				VistaBicicleta.getInstance().update(contexto);
				break;
	
			// Vista Cliente
	
			case ListaComandos.VENTANAALTACLIENTE:
			case ListaComandos.VENTANABAJACLIENTE:
			case ListaComandos.VENTANABOTONERACLIENTE:
			case ListaComandos.VENTANADETALLECLIENTE:
			case ListaComandos.VENTANALISTACLIENTE:
			case ListaComandos.VENTANAMODIFICARCLIENTE:
			case ListaComandos.VENTANANUMEROCLIENTESQUERY:
			case ListaComandos.MOSTRARALTACLIENTE:
			case ListaComandos.MOSTRARBAJACLIENTE:
			case ListaComandos.MOSTRARDETALLECLIENTE:
			case ListaComandos.MOSTRARLISTACLIENTE:
			case ListaComandos.MOSTRARMODIFICARCLIENTE:
			case ListaComandos.MOSTRARNUMEROCLIENTESQUERY:
				VistaCliente.getInstance().update(contexto);
				break;
	
			// Vista Bicicleta
	
			case ListaComandos.VENTANAAGREGARARTICULOCOMPRA:
			case ListaComandos.VENTANABOTONERACOMPRA:
			case ListaComandos.VENTANADETALLECOMPRA:
			case ListaComandos.VENTANADEVOLUCIONCOMPRA:
			case ListaComandos.VENTANAELIMINARARTICULOCOMPRA:
			case ListaComandos.VENTANAGESTIONCARRITOCOMPRA:
			case ListaComandos.VENTANAINICIARCOMPRA:
			case ListaComandos.VENTANALISTACOMPRA:
			case ListaComandos.MOSTRARGESTIONCARRITOCOMPRA:
			case ListaComandos.MOSTRARAGREGARARTICULOCOMPRA:
			case ListaComandos.MOSTRARELIMINARARTICULOCOMPRA:
			case ListaComandos.MOSTRARDEVOLUCIONARTICULOCOMPRA:
			case ListaComandos.MOSTRARDETALLECOMPRA:
			case ListaComandos.MOSTRARLISTACOMPRA:
			case ListaComandos.MOSTRARFINALIZARCOMPRA:
				VistaCompra.getInstance().update(contexto);
				break;
				
			// Vista Departamento
				
			case ListaComandos.VENTANAALTADEPARTAMENTO:
			case ListaComandos.VENTANABAJADEPARTAMENTO:
			case ListaComandos.VENTANABOTONERADEPARTAMENTO:
			case ListaComandos.VENTANADETALLEDEPARTAMENTO:
			case ListaComandos.VENTANALISTADEPARTAMENTO:
			case ListaComandos.VENTANAMODIFICARDEPARTAMENTO:
			case ListaComandos.VENTANACALCULARNOMINADEPARTAMENTO:
			case ListaComandos.MOSTRARALTADEPARTAMENTO:
			case ListaComandos.MOSTRARBAJADEPARTAMENTO:
			case ListaComandos.MOSTRARDETALLEDEPARTAMENTO:
			case ListaComandos.MOSTRARLISTADEPARTAMENTO:
			case ListaComandos.MOSTRARMODIFICARDEPARTAMENTO:
			case ListaComandos.MOSTRARCALCULARNOMINADEPARTAMENTO:
				VistaDepartamento.getInstance().update(contexto);
				break;
				
			// Vista Empleado
			
			case ListaComandos.VENTANAALTAEMPLEADO:
			case ListaComandos.VENTANABAJAEMPLEADO:
			case ListaComandos.VENTANABOTONERAEMPLEADO:
			case ListaComandos.VENTANADETALLEEMPLEADO:
			case ListaComandos.VENTANALISTAEMPLEADO:
			case ListaComandos.VENTANAMODIFICAREMPLEADO:
			case ListaComandos.MOSTRARALTAEMPLEADO:
			case ListaComandos.MOSTRARBAJAEMPLEADO:
			case ListaComandos.MOSTRARDETALLEEMPLEADO:
			case ListaComandos.MOSTRARLISTAEMPLEADO:
			case ListaComandos.MOSTRARMODIFICAREMPLEADO:
				VistaEmpleado.getInstance().update(contexto);
				break;
				
			// Vista Tienda
			
			case ListaComandos.VENTANAALTATIENDA:
			case ListaComandos.VENTANABAJATIENDA:
			case ListaComandos.VENTANABOTONERATIENDA:
			case ListaComandos.VENTANADETALLETIENDA:
			case ListaComandos.VENTANALISTATIENDA:
			case ListaComandos.VENTANAMODIFICARTIENDA:
			case ListaComandos.VENTANAASIGNARDEPARTAMENTOTIENDA:
			case ListaComandos.VENTANADESASIGNARDEPARTAMENTOTIENDA:
			case ListaComandos.VENTANAASIGNARPRESUPUESTOTIENDA:
			case ListaComandos.VENTANADETALLEPRESUPUESTOTIENDA:
			case ListaComandos.VENTANALISTAPRESUPUESTOTIENDA:
			case ListaComandos.MOSTRARALTATIENDA:
			case ListaComandos.MOSTRARBAJATIENDA:
			case ListaComandos.MOSTRARDETALLETIENDA:
			case ListaComandos.MOSTRARLISTATIENDA:
			case ListaComandos.MOSTRARMODIFICARTIENDA:
			case ListaComandos.MOSTRARASIGNARTIENDA:
			case ListaComandos.MOSTRARDESASIGNARTIENDA:
			case ListaComandos.MOSTRARASIGNARDEPARTAMENTOTIENDA:
			case ListaComandos.MOSTRARDESASIGNARDEPARTAMENTOTIENDA:
			case ListaComandos.MOSTRARASIGNARPRESUPUESTOTIENDA:
			case ListaComandos.MOSTRARDETALLEPRESUPUESTOTIENDA:
			case ListaComandos.MOSTRARLISTAPRESUPUESTOTIENDA:
				VistaTienda.getInstance().update(contexto);
				break; 
		}
	}
}