package presentacion.vistas.vistaCompra;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import negocio.compra.imp.TransferCompra;
import presentacion.ListaComandos;
import presentacion.controlador.Contexto;
import presentacion.vistas.vistaCompra.compra.JFrameAgregarArticulo;
import presentacion.vistas.vistaCompra.compra.JFrameBotoneraCompra;
import presentacion.vistas.vistaCompra.compra.JFrameDetalleCompra;
import presentacion.vistas.vistaCompra.compra.JFrameDevolucionCompra;
import presentacion.vistas.vistaCompra.compra.JFrameEliminarArticulo;
import presentacion.vistas.vistaCompra.compra.JFrameGestionCarrito;
import presentacion.vistas.vistaCompra.compra.JFrameIniciarCompra;
import presentacion.vistas.vistaCompra.compra.JFrameListaCompra;

public class VistaCompraImp extends VistaCompra 
{
	private JFrameAgregarArticulo agregarArticulo;
	private JFrameBotoneraCompra botoneraCompra;
	private JFrameDetalleCompra detalleCompra;
	private JFrameDevolucionCompra devolucionCompra;
	private JFrameEliminarArticulo eliminarArticulo;
	private JFrameGestionCarrito gestionCarrito;
	private JFrameIniciarCompra iniciarCompra;
	private JFrameListaCompra listaCompra;

	public VistaCompraImp() 
	{
		createJFrameAgregarArticulo();
		createJFrameBotoneraCompra();
		createJFrameDetalleCompra();
		createJFrameDevolucionCompra();
		createJFrameEliminarArticulo();
		createJFrameGestionCarrito();
		createJFrameGestionCarrito();
		createJFrameIniciarCompra();
		createJFrameListaCompra();
	}

	public void createJFrameAgregarArticulo() 
	{
		if (agregarArticulo == null)
			agregarArticulo = new JFrameAgregarArticulo();
	}

	public void createJFrameBotoneraCompra() 
	{
		if (botoneraCompra == null)
			botoneraCompra = new JFrameBotoneraCompra();
	}

	public void createJFrameDetalleCompra() 
	{
		if (detalleCompra == null)
			detalleCompra = new JFrameDetalleCompra();
	}

	public void createJFrameDevolucionCompra() 
	{
		if (devolucionCompra == null)
			devolucionCompra = new JFrameDevolucionCompra();
	}

	public void createJFrameEliminarArticulo() 
	{
		if (eliminarArticulo == null)
			eliminarArticulo = new JFrameEliminarArticulo();
	}

	public void createJFrameGestionCarrito() 
	{
		if (gestionCarrito == null)
			gestionCarrito = new JFrameGestionCarrito();
	}

	public void createJFrameIniciarCompra() 
	{
		if (iniciarCompra == null)
			iniciarCompra = new JFrameIniciarCompra();
	}

	public void createJFrameListaCompra() 
	{
		if (listaCompra == null)
			listaCompra = new JFrameListaCompra();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Contexto contexto) 
	{
		switch (contexto.getEvent()) {
		case ListaComandos.VENTANAAGREGARARTICULOCOMPRA:
			agregarArticulo.setVisible(true);
			break;
		case ListaComandos.VENTANABOTONERACOMPRA:
			botoneraCompra.setVisible(true);
			break;

		case ListaComandos.VENTANADETALLECOMPRA:
			detalleCompra.setVisible(true);
			break;
		case ListaComandos.VENTANADEVOLUCIONCOMPRA:
			devolucionCompra.setVisible(true);
			break;
		case ListaComandos.VENTANAELIMINARARTICULOCOMPRA:
			eliminarArticulo.setVisible(true);
			eliminarArticulo.setTransferCompra((TransferCompra) contexto.getDatos());
			break;
		case ListaComandos.VENTANAGESTIONCARRITOCOMPRA:
			gestionCarrito.setVisible(true);
			break;
		case ListaComandos.VENTANAINICIARCOMPRA:
			iniciarCompra.setVisible(true);
			break;
		case ListaComandos.VENTANALISTACOMPRA:
			listaCompra.setVisible(true);
			break;

		// Mostrar

		case ListaComandos.MOSTRARGESTIONCARRITOCOMPRA:
			if (contexto.getDatos() != null)
			{
				gestionCarrito.setTransferCompra((TransferCompra) contexto.getDatos());
				gestionCarrito.setVisible(true);
				iniciarCompra.cerrarPorVista();
			} 
			else
				JOptionPane.showMessageDialog(null, "El cliente no existe o esta inactivo", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			break;
		case ListaComandos.MOSTRARAGREGARARTICULOCOMPRA:
			if (contexto.getDatos() != null)
			{
				gestionCarrito.setLineaCompra((Contexto) contexto.getDatos());
				agregarArticulo.cerrar();
			}
			else
				JOptionPane.showMessageDialog(null, "No existe el articulo o esta inactivo, pruebe de nuevo", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			break;
		case ListaComandos.MOSTRARELIMINARARTICULOCOMPRA:
			gestionCarrito.setTransferCompra((TransferCompra) contexto.getDatos());
			break;
		case ListaComandos.MOSTRARFINALIZARCOMPRA:
			if (contexto.getDatos() != null)
			{
				gestionCarrito.cerrarParaVistaPropia();
				JOptionPane.showMessageDialog(null, ((TransferCompra) contexto.getDatos()).getLog(), "Informacion", JOptionPane.INFORMATION_MESSAGE);
				botoneraCompra.setVisible(true);
			} 
			else
				JOptionPane.showMessageDialog(null, "No se ha podido finalizar la compra intentelo de nuevo", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			break;
		case ListaComandos.MOSTRARDEVOLUCIONARTICULOCOMPRA:
			String msgDevolucion = "";
			switch ((int) contexto.getDatos()) 
			{
				case -3:
					msgDevolucion = "Eliminada linea de compra totalmente";
					break;
				case -2:
					msgDevolucion = "Producto devuelto";
					break;
				case -1:
					msgDevolucion = "No se puede devolver el producto porque no existe esa linea de compra";
					break;
				case 0:
					msgDevolucion = "Devolucion no realizada, debido a un error con la BD";
					break;
			}

			JOptionPane.showMessageDialog(null, msgDevolucion, "Informacion", JOptionPane.INFORMATION_MESSAGE);
			break;
		case ListaComandos.MOSTRARDETALLECOMPRA:
			if (contexto.getDatos() != null)
				detalleCompra.setAreaDetalle((TransferCompra) contexto.getDatos());
			else
				JOptionPane.showMessageDialog(null, "No existe la compra introducida", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			break;
		case ListaComandos.MOSTRARLISTACOMPRA:
			if (((ArrayList<TransferCompra>) contexto.getDatos()).size() > 0)
				listaCompra.setAreaDetalle((ArrayList<TransferCompra>) contexto.getDatos());
			else
				JOptionPane.showMessageDialog(null, "No hay ninguna compra", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			break;
		}
	}
}