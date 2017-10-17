package presentacion.vistas.vistaCliente;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import negocio.cliente.imp.TransferCliente;
import presentacion.ListaComandos;
import presentacion.controlador.Contexto;
import presentacion.vistas.vistaCliente.cliente.JFrameAltaCliente;
import presentacion.vistas.vistaCliente.cliente.JFrameBajaCliente;
import presentacion.vistas.vistaCliente.cliente.JFrameBotoneraCliente;
import presentacion.vistas.vistaCliente.cliente.JFrameDetalleCliente;
import presentacion.vistas.vistaCliente.cliente.JFrameListaCliente;
import presentacion.vistas.vistaCliente.cliente.JFrameModificarCliente;
import presentacion.vistas.vistaCliente.cliente.JFrameNumeroClientes;

public class VistaClienteImp extends VistaCliente 
{
	private JFrameAltaCliente altaCliente;
	private JFrameBajaCliente bajaCliente;
	private JFrameBotoneraCliente botoneraCliente;
	private JFrameDetalleCliente detalleCliente;
	private JFrameListaCliente listaCliente;
	private JFrameModificarCliente modificarCliente;
	private JFrameNumeroClientes numeroClientes;

	public VistaClienteImp() 
	{
		createJFrameAltaCliente();
		createJFrameBajaCliente();
		createJFrameBotoneraCliente();
		createJFrameDetalleCliente();
		createJFrameListaCliente();
		createJFrameModiciarClienteCarretera();
		createJFrameNumeroClientes();
	}

	public void createJFrameAltaCliente() 
	{
		if (altaCliente == null)
			altaCliente = new JFrameAltaCliente();
	}

	public void createJFrameBajaCliente() 
	{
		if (bajaCliente == null)
			bajaCliente = new JFrameBajaCliente();
	}

	public void createJFrameBotoneraCliente() 
	{
		if (botoneraCliente == null)
			botoneraCliente = new JFrameBotoneraCliente();
	}

	public void createJFrameDetalleCliente() 
	{
		if (detalleCliente == null)
			detalleCliente = new JFrameDetalleCliente();
	}

	public void createJFrameListaCliente()
	{
		if (listaCliente == null)
			listaCliente = new JFrameListaCliente();
	}

	public void createJFrameModiciarClienteCarretera() 
	{
		if (modificarCliente == null)
			modificarCliente = new JFrameModificarCliente();
	}

	public void createJFrameNumeroClientes()
	{
		if (numeroClientes == null)
			numeroClientes = new JFrameNumeroClientes();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Contexto contexto) 
	{
		switch (contexto.getEvent())
		{
			case ListaComandos.VENTANAALTACLIENTE:
				altaCliente.setVisible(true);
				break;
			case ListaComandos.VENTANABAJACLIENTE:
				bajaCliente.setVisible(true);
				break;
			case ListaComandos.VENTANABOTONERACLIENTE:
				botoneraCliente.setVisible(true);
				break;
			case ListaComandos.VENTANADETALLECLIENTE:
				detalleCliente.setVisible(true);
				break;
			case ListaComandos.VENTANALISTACLIENTE:
				listaCliente.setVisible(true);
				break;
			case ListaComandos.VENTANAMODIFICARCLIENTE:
				modificarCliente.setVisible(true);
				break;
			case ListaComandos.VENTANANUMEROCLIENTESQUERY:
				numeroClientes.setVisible(true);
				break;
	
			// Mostrar
	
			case ListaComandos.MOSTRARALTACLIENTE:
				String msgAlta = "";
				switch ((int) contexto.getDatos()) {
				case -2:
					msgAlta = "Cliente no activo, se ha vuelto a activar";
					break;
				case -1:
					msgAlta = "Cliente no guardado, es debido a que existe uno con la misma tarjeta de credito";
					break;
				case 0:
					msgAlta = "Cliente no guardado, debido a un error con la BD";
					break;
				default:
					msgAlta = "Operacion realizada con exito, cliente dado de alta con id: "
							+ contexto.getDatos();
				}
	
				JOptionPane.showMessageDialog(null, msgAlta, "Informacion",
						JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRARBAJACLIENTE:
				String msgBaja = "";
				switch ((int) contexto.getDatos()) {
				case -2:
					msgBaja = "Cliente no eliminado, no esta activo";
					break;
				case -1:
					msgBaja = "Cliente no eliminado, es debido a que no existe";
					break;
				case 0:
					msgBaja = "Cliente no eliminado, debido a un error con la BD";
					break;
				default:
					msgBaja = "Operacion realizada con exito, cliente dado de baja con id: "
							+ contexto.getDatos();
				}
	
				JOptionPane.showMessageDialog(null, msgBaja, "Informacion",
						JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRARMODIFICARCLIENTE:
				String msgModificar = "";
				switch ((int) contexto.getDatos()) {
				case -3:
					msgModificar = "Cliente no modificado, es debido a que ya existe un cliente con esa tarjeta de credito";
					break;
				case -2:
					msgModificar = "Cliente no modificado, es debido a que la bicicleta no esta activa";
					break;
				case -1:
					msgModificar = "Cliente no modificado, es debido a que no existe";
					break;
				case 0:
					msgModificar = "Cliente no modificado, debido a un error con la BD";
					break;
				default:
					msgModificar = "Operacion realizada con exito, cliente modificado con id: "
							+ contexto.getDatos();
				}
	
				JOptionPane.showMessageDialog(null, msgModificar, "Informacion",
						JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRARDETALLECLIENTE:
				if (contexto.getDatos() != null)
					detalleCliente.setAreaDetalle((TransferCliente) contexto
							.getDatos());
				else
					JOptionPane.showMessageDialog(null,
							"No existe el cliente introducido", "Informacion",
							JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRARLISTACLIENTE:
				if (((ArrayList<TransferCliente>) contexto.getDatos()).size() > 0)
					listaCliente
							.setAreaDetalle((ArrayList<TransferCliente>) contexto
									.getDatos());
				else
					JOptionPane.showMessageDialog(null, "No hay ningun cliente",
							"Informacion", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRARNUMEROCLIENTESQUERY:
	
				ArrayList<TransferCliente> cliente = (ArrayList<TransferCliente>) contexto
						.getDatos();
	
				if (((ArrayList<TransferCliente>) contexto.getDatos()).size() > 0) {
					String msgNumeroClientes = "";
	
					for (int k = 0; k < cliente.size(); ++k)
						msgNumeroClientes += cliente.get(k).toString() + "\n";
	
					JOptionPane.showMessageDialog(null, msgNumeroClientes,
							"Informacion", JOptionPane.INFORMATION_MESSAGE);
				} else
					JOptionPane.showMessageDialog(null, "No hay ningun cliente",
							"Informacion", JOptionPane.INFORMATION_MESSAGE);
				break;
		}
	}
}