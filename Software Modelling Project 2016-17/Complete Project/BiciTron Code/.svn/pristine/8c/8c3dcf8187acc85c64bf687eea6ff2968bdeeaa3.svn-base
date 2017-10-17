package presentacion.vistas.vistaBicicleta;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import negocio.bicicleta.imp.TransferBicicleta;
import presentacion.ListaComandos;
import presentacion.controlador.Contexto;
import presentacion.vistas.vistaBicicleta.bicicleta.JFrameAltaBicicletaCarretera;
import presentacion.vistas.vistaBicicleta.bicicleta.JFrameAltaBicicletaMontana;
import presentacion.vistas.vistaBicicleta.bicicleta.JFrameBajaBicicleta;
import presentacion.vistas.vistaBicicleta.bicicleta.JFrameBotoneraBicicleta;
import presentacion.vistas.vistaBicicleta.bicicleta.JFrameCantidadBicicletas;
import presentacion.vistas.vistaBicicleta.bicicleta.JFrameDetalleBicicleta;
import presentacion.vistas.vistaBicicleta.bicicleta.JFrameListaBicicleta;
import presentacion.vistas.vistaBicicleta.bicicleta.JFrameModificarBicicletaCarretera;
import presentacion.vistas.vistaBicicleta.bicicleta.JFrameModificarBicicletaMontana;

public class VistaBicicletaImp extends VistaBicicleta {
	private JFrameAltaBicicletaCarretera altaBicicletaCarretera;

	private JFrameAltaBicicletaMontana altaBicicletaMontaña;
	private JFrameBajaBicicleta bajaBicicleta;
	private JFrameBotoneraBicicleta botoneraBicicleta;
	private JFrameDetalleBicicleta detalleBicicleta;
	private JFrameListaBicicleta listaBicicleta;
	private JFrameModificarBicicletaCarretera modificarBicicletaCarretera;
	private JFrameModificarBicicletaMontana modificarBicicletaMontaña;
	private JFrameCantidadBicicletas cantidadBicicletas;

	public VistaBicicletaImp() 
	{
		createJFrameAltaBicicletaCarretera();
		createJFrameAltaBicicletaMontana();
		createJFrameBajaBicicleta();
		createJFrameBotoneraBicicleta();
		createJFrameDetalleBicicleta();
		createJFrameListaBicicleta();
		createJFrameModiciarBicicletaCarretera();
		createJFrameModificarBicicletaMontana();
		createJFrameCantidadBicicletas();
	}

	public void createJFrameAltaBicicletaCarretera() 
	{
		if (altaBicicletaCarretera == null)
			altaBicicletaCarretera = new JFrameAltaBicicletaCarretera();
	}

	public void createJFrameAltaBicicletaMontana() 
	{
		if (altaBicicletaMontaña == null)
			altaBicicletaMontaña = new JFrameAltaBicicletaMontana();
	}

	public void createJFrameBajaBicicleta()
	{
		if (bajaBicicleta == null)
			bajaBicicleta = new JFrameBajaBicicleta();
	}

	public void createJFrameBotoneraBicicleta()
	{
		if (botoneraBicicleta == null)
			botoneraBicicleta = new JFrameBotoneraBicicleta();
	}

	public void createJFrameDetalleBicicleta()
	{
		if (detalleBicicleta == null)
			detalleBicicleta = new JFrameDetalleBicicleta();
	}

	public void createJFrameListaBicicleta() 
	{
		if (listaBicicleta == null)
			listaBicicleta = new JFrameListaBicicleta();
	}

	public void createJFrameModiciarBicicletaCarretera() 
	{
		if (modificarBicicletaCarretera == null)
			modificarBicicletaCarretera = new JFrameModificarBicicletaCarretera();
	}

	public void createJFrameModificarBicicletaMontana() 
	{
		if (modificarBicicletaMontaña == null)
			modificarBicicletaMontaña = new JFrameModificarBicicletaMontana();
	}

	public void createJFrameCantidadBicicletas() 
	{
		if (cantidadBicicletas == null)
			cantidadBicicletas = new JFrameCantidadBicicletas();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Contexto contexto) 
	{
		switch (contexto.getEvent()) 
		{
			// Ventana
	
			case ListaComandos.VENTANAALTABICICLETACARRETERA:
				altaBicicletaCarretera.setVisible(true);
				break;
			case ListaComandos.VENTANAALTABICICLETAMONTANA:
				altaBicicletaMontaña.setVisible(true);
				break;
			case ListaComandos.VENTANABAJABICICLETA:
				bajaBicicleta.setVisible(true);
				break;
			case ListaComandos.VENTANABOTONERABICICLETA:
				botoneraBicicleta.setVisible(true);
				break;
			case ListaComandos.VENTANADETALLEBICICLETA:
				detalleBicicleta.setVisible(true);
				break;
			case ListaComandos.VENTANALISTABICICLETA:
				listaBicicleta.setVisible(true);
				break;
			case ListaComandos.VENTANAMODIFICARBICICLETACARRETERA:
				modificarBicicletaCarretera.setVisible(true);
				break;
			case ListaComandos.VENTANAMODIFICARBICICLETAMONTANA:
				modificarBicicletaMontaña.setVisible(true);
				break;
			case ListaComandos.VENTANACANTIDADBICICLETASQUERY:
				cantidadBicicletas.setVisible(true);
				break;
	
			// Mostrar
	
			case ListaComandos.MOSTRARALTABICICLETA:
				String msgAlta = "";
				switch ((int) contexto.getDatos()) 
				{
					case -2:
						msgAlta = "Bicicleta no activa, se ha vuelto a activar";
						break;
					case -1:
						msgAlta = "Bicicleta no guardada, debido a que ya existe una bicicleta con esa marca";
						break;
					case 0:
						msgAlta = "Bicicleta no guardada, debido a un error con la Base de Datos";
						break;
					default:
						msgAlta = "Operacion realizada con exito, bicicleta dada de alta con id: " + contexto.getDatos();
				}
	
				JOptionPane.showMessageDialog(null, msgAlta, "Informacion", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRARBAJABICICLETA:
				String msgBaja = "";
				switch ((int) contexto.getDatos()) 
				{
					case -2:
						msgBaja = "La bicicleta ya está dada de baja";
						break;
					case -1:
						msgBaja = "La bicicleta introducida no existe";
						break;
					case 0:
						msgBaja = "Bicicleta no eliminada, debido a un error con la Base de Datos";
						break;
					default:
						msgBaja = "Operacion realizada con exito, bicicleta dada de baja con id: " + contexto.getDatos();
				}
	
				JOptionPane.showMessageDialog(null, msgBaja, "Informacion", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRARMODIFICARBICICLETA:
				String msgModificar = "";
				switch ((int) contexto.getDatos()) 
				{
					case -4:
						msgModificar = "Bicicleta no modificada, debido a que no es el tipo correcto";
						break;
					case -3:
						msgModificar = "Bicicleta no modificada, debido a que la marca introducida ya existe en la base de datos";
						break;
					case -2:
						msgModificar = "Bicicleta no modificada porque está desactivada";
						break;
					case -1:
						msgModificar = "No existe la bicicleta introducida, por lo que no se puede modificar";
						break;
					case 0:
						msgModificar = "Bicicleta no modificada, debido a un error con la BD";
						break;
					default:
						msgModificar = "Operacion realizada con exito, bicicleta modificada con id: " + contexto.getDatos();
				}
	
				JOptionPane.showMessageDialog(null, msgModificar, "Informacion", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRARDETALLEBICICLETA:
				if (contexto.getDatos() != null)
					detalleBicicleta.setAreaDetalle((TransferBicicleta) contexto.getDatos());
				else
					JOptionPane.showMessageDialog(null, "No existe la bicicleta introducida", "Informacion", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRARLISTABICICLETA:
				if (((ArrayList<TransferBicicleta>) contexto.getDatos()).size() > 0)
					listaBicicleta.setAreaDetalle((ArrayList<TransferBicicleta>) contexto.getDatos());
				else
					JOptionPane.showMessageDialog(null, "No hay ninguna bicicleta", "Informacion", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRARCANTIDADBICICLETASQUERY:
				String msgCantidadBicicletas = "";
				switch ((int) contexto.getDatos()) 
				{
					case -1:
						msgCantidadBicicletas = "El cliente no existe";
						break;
					case 0:
						msgCantidadBicicletas = "El cliente no ha comprado ninguna bicicleta de ese modelo";
						break;
					default:
						msgCantidadBicicletas = "El cliente ha comprado " + contexto.getDatos() + " bicicleta(s) de ese modelo";
				}
	
			JOptionPane.showMessageDialog(null, msgCantidadBicicletas, "Informacion", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}