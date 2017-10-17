package Presentacion.Vistas.vistaAvion;

import Presentacion.Avion.JFrameAltaAvion;
import Presentacion.Avion.JFrameBajaAvion;
import Presentacion.Avion.JFrameBotoneraAvion;
import Presentacion.Avion.JFrameDetalleAvion;
import Presentacion.Avion.JFrameListaAvion;
import Presentacion.Avion.JFrameModificarAvion;

public class VistaAvionImp extends VistaAvion {

	private JFrameBotoneraAvion botoneraAvion;
	private JFrameAltaAvion altaAvion;
	private JFrameBajaAvion bajaAvion;
	private JFrameModificarAvion modificarAvion;
	private JFrameDetalleAvion detalleAvion;
	private JFrameListaAvion listaAvion;
	
	public static final int ACTIVAR_BOTONERA = 1;
	public static final int DESACTIVAR_BOTONERA = 2;
	public static final int ACTIVAR_ALTA = 3;
	public static final int ACTIVAR_BAJA= 7;
	public static final int ACTIVAR_MODIFICAR= 9;
	public static final int ACTIVAR_DETALLE= 11;
	public static final int ACTIVAR_LISTA= 13;
	public static final int DESACTIVAR_VISTAS = 20;
	
	public static final int FIN_ALTA = 21;
	public static final int FIN_BAJA = 23;
	public static final int FIN_DETALLE = 24;
	public static final int FIN_MODIFICAR = 25;
	public static final int FIN_LISTA = 27;
	
	public void createJFrameBotoneraAvion () {
		if (this.botoneraAvion == null) {
			this.botoneraAvion = new JFrameBotoneraAvion();
		}
	}
	
	public void createJFrameAltaAvion() {
		if (this.altaAvion == null) {
			this.altaAvion = new JFrameAltaAvion();
		}
	}

	public void createJFrameBajaAvion() {
		if (this.bajaAvion == null) {
			this.bajaAvion = new JFrameBajaAvion();
		}
	}

	public void createJFrameListaAvion() {
		if (this.listaAvion == null) {
			this.listaAvion = new JFrameListaAvion();
		}
	}

	public void createJFrameModificarAvion() {
		if (this.modificarAvion == null) {
			this.modificarAvion = new JFrameModificarAvion();
		}
	}

	public void createJFrameDetalleAvion() {
		if (this.detalleAvion == null) {
			this.detalleAvion = new JFrameDetalleAvion();
		}
	}

	@Override
	public void update(int accion, Object datos) {
		switch (accion) {
		case ACTIVAR_BOTONERA:
			this.botoneraAvion.setVisible(true);
			break;
		case DESACTIVAR_BOTONERA:
			this.botoneraAvion.setVisible(false);
			break;
		case ACTIVAR_ALTA:
			this.altaAvion.setVisible(true);
			break;
		case ACTIVAR_BAJA:
			this.bajaAvion.setVisible(true);
			break;
		case ACTIVAR_MODIFICAR:
			this.modificarAvion.setVisible(true);
			break;
		case ACTIVAR_DETALLE:
			this.detalleAvion.setVisible(true);
			break;
		case ACTIVAR_LISTA:
			this.listaAvion.setVisible(true);
			break;
		case DESACTIVAR_VISTAS:
			if(altaAvion != null)
				this.altaAvion.setVisible(false);
			if(bajaAvion != null)
				this.bajaAvion.setVisible(false);
			if(modificarAvion != null)
				this.modificarAvion.setVisible(false);
			if(detalleAvion != null)
				this.detalleAvion.setVisible(false);
			if(listaAvion != null)
				this.listaAvion.setVisible(false);
			break;
		case FIN_ALTA:
			this.altaAvion.update(datos);
			break;
		case FIN_BAJA:
			this.bajaAvion.update(datos);
			break;
		case FIN_DETALLE:
			this.detalleAvion.update(datos);
			break;
		case FIN_LISTA:
			this.listaAvion.update(datos);
			break;
		case FIN_MODIFICAR:
			this.modificarAvion.update(datos);
			break;
		}
		
	}
}