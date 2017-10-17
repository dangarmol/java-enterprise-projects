package Presentacion.Vistas.vistaVuelo;

import Presentacion.Vuelo.JFrameAltaVuelo;
import Presentacion.Vuelo.JFrameBajaVuelo;
import Presentacion.Vuelo.JFrameBotoneraVuelo;
import Presentacion.Vuelo.JFrameDetalleVuelo;
import Presentacion.Vuelo.JFrameListaVuelo;
import Presentacion.Vuelo.JFrameModificarVuelo;

public class VistaVueloImp extends VistaVuelo {

	private JFrameBotoneraVuelo botoneraVuelo;
	private JFrameAltaVuelo altaVuelo;
	private JFrameBajaVuelo bajaVuelo;
	private JFrameModificarVuelo modificarVuelo;
	private JFrameDetalleVuelo detalleVuelo;
	private JFrameListaVuelo listaVuelo;
	
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

	public void createJFrameBotoneraVuelo() {
		if (this.botoneraVuelo == null) {
			this.botoneraVuelo = new JFrameBotoneraVuelo ();
		}
	}

	public void createJFrameAltaVuelo() {
		if (this.altaVuelo == null) {
			this.altaVuelo = new JFrameAltaVuelo();
		}
	}

	public void createJFrameBajaVuelo() {
		if (this.bajaVuelo == null) {
			this.bajaVuelo = new JFrameBajaVuelo();
		}
	}

	public void createJFrameListaVuelo() {
		if (this.listaVuelo == null) {
			this.listaVuelo = new JFrameListaVuelo();
		}
	}

	public void createJFrameDetalleVuelo() {
		if (this.detalleVuelo == null) {
			this.detalleVuelo = new JFrameDetalleVuelo();
		}
	}

	public void createJFrameModificarVuelo() {
		if (this.modificarVuelo == null) {
			this.modificarVuelo = new JFrameModificarVuelo();
		}
	}

	@Override
	public void update(int accion, Object datos) {
		switch (accion) {
		case ACTIVAR_BOTONERA:
			this.botoneraVuelo.setVisible(true);
			break;
		case DESACTIVAR_BOTONERA:
			this.botoneraVuelo.setVisible(false);
			break;
		case ACTIVAR_ALTA:
			this.altaVuelo.setVisible(true);
			break;
		case ACTIVAR_BAJA:
			this.bajaVuelo.setVisible(true);
			break;
		case ACTIVAR_MODIFICAR:
			this.modificarVuelo.setVisible(true);
			break;
		case ACTIVAR_DETALLE:
			this.detalleVuelo.setVisible(true);
			break;
		case ACTIVAR_LISTA:
			this.listaVuelo.setVisible(true);
			break;
		case DESACTIVAR_VISTAS:
			if(altaVuelo != null)
				this.altaVuelo.setVisible(false);
			if(bajaVuelo != null)
				this.bajaVuelo.setVisible(false);
			if(modificarVuelo != null)
				this.modificarVuelo.setVisible(false);
			if(detalleVuelo != null)
				this.detalleVuelo.setVisible(false);
			if(listaVuelo != null)
				this.listaVuelo.setVisible(false);
			break;
		case FIN_ALTA:
			this.altaVuelo.update(datos);
			break;
		case FIN_BAJA:
			this.bajaVuelo.update(datos);
			break;
		case FIN_DETALLE:
			this.detalleVuelo.update(datos);
			break;
		case FIN_LISTA:
			this.listaVuelo.update(datos);
			break;
		case FIN_MODIFICAR:
			this.modificarVuelo.update(datos);
			break;
		}
		
	}
}