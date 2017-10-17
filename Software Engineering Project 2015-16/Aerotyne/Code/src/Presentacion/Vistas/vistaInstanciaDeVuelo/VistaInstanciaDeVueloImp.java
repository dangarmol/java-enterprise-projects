package Presentacion.Vistas.vistaInstanciaDeVuelo;

import Presentacion.InstanciadeVuelo.JFrameAltaInstanciaDeVuelo;
import Presentacion.InstanciadeVuelo.JFrameBajaInstanciaDeVuelo;
import Presentacion.InstanciadeVuelo.JFrameBotoneraInstanciaDeVuelo;
import Presentacion.InstanciadeVuelo.JFrameDetalleInstanciaDeVuelo;
import Presentacion.InstanciadeVuelo.JFrameListaInstanciaDeVuelo;
import Presentacion.InstanciadeVuelo.JFrameModificarInstanciaDeVuelo;

public class VistaInstanciaDeVueloImp extends VistaInstanciaDeVuelo {

	private JFrameBotoneraInstanciaDeVuelo botoneraInstanciaDeVuelo;
	private JFrameAltaInstanciaDeVuelo altaInstanciaDeVuelo;
	private JFrameBajaInstanciaDeVuelo bajaInstanciaDeVuelo;
	private JFrameModificarInstanciaDeVuelo modificarInstanciaDeVuelo;
	private JFrameDetalleInstanciaDeVuelo detalleInstanciaDeVuelo;
	private JFrameListaInstanciaDeVuelo listaInstanciaDeVuelo;
	
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

	public void createJFrameBotoneraInstanciaDeVuelo() {
		if (this.botoneraInstanciaDeVuelo == null) {
			this.botoneraInstanciaDeVuelo = new JFrameBotoneraInstanciaDeVuelo ();
		}
	}

	public void createJFrameAltaInstanciaDeVuelo() {
		if (this.altaInstanciaDeVuelo == null) {
			this.altaInstanciaDeVuelo = new JFrameAltaInstanciaDeVuelo();
		}
	}

	public void createJFrameBajaInstanciaDeVuelo() {
		if (this.bajaInstanciaDeVuelo == null) {
			this.bajaInstanciaDeVuelo = new JFrameBajaInstanciaDeVuelo();
		}
	}

	public void createJFrameModificarInstanciaDeVuelo() {
		if (this.modificarInstanciaDeVuelo == null) {
			this.modificarInstanciaDeVuelo = new JFrameModificarInstanciaDeVuelo();
		}
	}

	public void createJFrameDetalleInstanciaDeVuelo() {
		if (this.detalleInstanciaDeVuelo == null) {
			this.detalleInstanciaDeVuelo = new JFrameDetalleInstanciaDeVuelo();
		}
	}

	public void createJFrameListaInstanciaDeVuelo() {
		if (this.listaInstanciaDeVuelo == null) {
			this.listaInstanciaDeVuelo = new JFrameListaInstanciaDeVuelo();
		}
	}

	@Override
	public void update(int accion, Object datos) {
		switch (accion) {
		case ACTIVAR_BOTONERA:
			this.botoneraInstanciaDeVuelo.setVisible(true);
			break;
		case DESACTIVAR_BOTONERA:
			this.botoneraInstanciaDeVuelo.setVisible(false);
			break;
		case ACTIVAR_ALTA:
			this.altaInstanciaDeVuelo.setVisible(true);
			break;
		case ACTIVAR_BAJA:
			this.bajaInstanciaDeVuelo.setVisible(true);
			break;
		case ACTIVAR_MODIFICAR:
			this.modificarInstanciaDeVuelo.setVisible(true);
			break;
		case ACTIVAR_DETALLE:
			this.detalleInstanciaDeVuelo.setVisible(true);
			break;
		case ACTIVAR_LISTA:
			this.listaInstanciaDeVuelo.setVisible(true);
			break;
		case DESACTIVAR_VISTAS:
			if(altaInstanciaDeVuelo != null)
				this.altaInstanciaDeVuelo.setVisible(false);
			if(bajaInstanciaDeVuelo != null)
				this.bajaInstanciaDeVuelo.setVisible(false);
			if(modificarInstanciaDeVuelo != null)
				this.modificarInstanciaDeVuelo.setVisible(false);
			if(detalleInstanciaDeVuelo != null)
				this.detalleInstanciaDeVuelo.setVisible(false);
			if(listaInstanciaDeVuelo != null)
				this.listaInstanciaDeVuelo.setVisible(false);
			break;
		case FIN_ALTA:
			this.altaInstanciaDeVuelo.update(datos);
			break;
		case FIN_BAJA:
			this.bajaInstanciaDeVuelo.update(datos);
			break;
		case FIN_DETALLE:
			this.detalleInstanciaDeVuelo.update(datos);
			break;
		case FIN_LISTA:
			this.listaInstanciaDeVuelo.update(datos);
			break;
		case FIN_MODIFICAR:
			this.modificarInstanciaDeVuelo.update(datos);
			break;
		}
		
	}
}