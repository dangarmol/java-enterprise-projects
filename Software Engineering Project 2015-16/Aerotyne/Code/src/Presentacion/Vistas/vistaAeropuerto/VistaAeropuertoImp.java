package Presentacion.Vistas.vistaAeropuerto;

import Presentacion.Aeropuerto.JFrameAltaAeropuertoNoSeguro;
import Presentacion.Aeropuerto.JFrameAltaAeropuertoSeguro;
import Presentacion.Aeropuerto.JFrameBajaAeropuerto;
import Presentacion.Aeropuerto.JFrameBotoneraAeropuerto;
import Presentacion.Aeropuerto.JFrameDetalleAeropuerto;
import Presentacion.Aeropuerto.JFrameListaAeropuerto;
import Presentacion.Aeropuerto.JFrameModificarAeropuertoNoSeguro;
import Presentacion.Aeropuerto.JFrameModificarAeropuertoSeguro;

public class VistaAeropuertoImp extends VistaAeropuerto {

	private JFrameBotoneraAeropuerto botoneraAeropuerto;
	private JFrameAltaAeropuertoSeguro altaAeropuertoSeguro;
	private JFrameAltaAeropuertoNoSeguro altaAeropuertoNoSeguro;
	private JFrameBajaAeropuerto bajaAeropuerto;
	private JFrameModificarAeropuertoSeguro modificarAeropuertoSeguro;
	private JFrameModificarAeropuertoNoSeguro modificarAeropuertoNoSeguro;
	private JFrameDetalleAeropuerto detalleAeropuerto;
	private JFrameListaAeropuerto listaAeropuerto;
	
	public static final int ACTIVAR_BOTONERA = 1;
	public static final int DESACTIVAR_BOTONERA = 2;
	public static final int ACTIVAR_ALTA_SEGURO = 3;
	public static final int ACTIVAR_ALTA_NO_SEGURO = 5;
	public static final int ACTIVAR_BAJA= 7;
	public static final int ACTIVAR_MODIFICAR_SEGURO = 9;
	public static final int ACTIVAR_MODIFICAR_NO_SEGURO = 15;
	public static final int ACTIVAR_DETALLE= 11;
	public static final int ACTIVAR_LISTA= 13;
	public static final int DESACTIVAR_VISTAS = 20;
	public static final int FIN_ALTA_SEGURO = 21;
	public static final int FIN_ALTA_NO_SEGURO = 22;
	public static final int FIN_BAJA = 23;
	public static final int FIN_DETALLE = 24;
	public static final int FIN_MODIFICAR_NO_SEGURO = 25;
	public static final int FIN_MODIFICAR_SEGURO = 26;
	public static final int FIN_LISTA = 27;

	public void createJFrameBotoneraAeropuerto() {
		if (this.botoneraAeropuerto == null) {
			this.botoneraAeropuerto = new JFrameBotoneraAeropuerto();
		}
	}

	public void createJFrameAltaAeropuertoSeguro() {
		if (this.altaAeropuertoSeguro == null) {
			this.altaAeropuertoSeguro = new JFrameAltaAeropuertoSeguro();
		}
	}

	public void createJFrameAltaAeropuertoNoSeguro() {
		if (this.altaAeropuertoNoSeguro == null) {
			this.altaAeropuertoNoSeguro = new JFrameAltaAeropuertoNoSeguro();
		}
	}

	public void createJFrameBajaAeropuerto() {
		if (this.bajaAeropuerto == null) {
			this.bajaAeropuerto = new JFrameBajaAeropuerto();
		}
	}


	public void createJFrameListaAeropuerto() {
		if (this.listaAeropuerto == null) {
			this.listaAeropuerto = new JFrameListaAeropuerto();
		}
	}


	public void createJFrameDetalleAeropuerto() {
		if (this.detalleAeropuerto == null) {
			this.detalleAeropuerto = new JFrameDetalleAeropuerto();
		}
	}

	public void createJFrameModificarAeropuertoSeguro() {
		if (this.modificarAeropuertoSeguro == null) {
			this.modificarAeropuertoSeguro = new JFrameModificarAeropuertoSeguro();
		}
	}

	public void createJFrameModificarAeropuertoNoSeguro() {
		if (this.modificarAeropuertoNoSeguro == null) {
			this.modificarAeropuertoNoSeguro = new JFrameModificarAeropuertoNoSeguro();
		}
	}

	@Override
	public void update(int accion, Object datos) {
		switch (accion) {
		case ACTIVAR_BOTONERA:
			this.botoneraAeropuerto.setVisible(true);
			break;
		case DESACTIVAR_BOTONERA:
			this.botoneraAeropuerto.setVisible(false);
			break;
		case ACTIVAR_ALTA_SEGURO:
			this.altaAeropuertoSeguro.setVisible(true);
			break;
		case ACTIVAR_ALTA_NO_SEGURO:
			this.altaAeropuertoNoSeguro.setVisible(true);
			break;
		case ACTIVAR_BAJA:
			this.bajaAeropuerto.setVisible(true);
			break;
		case ACTIVAR_MODIFICAR_SEGURO:
			this.modificarAeropuertoSeguro.setVisible(true);
			break;
		case ACTIVAR_MODIFICAR_NO_SEGURO:
			this.modificarAeropuertoNoSeguro.setVisible(true);
			break;
		case ACTIVAR_DETALLE:
			this.detalleAeropuerto.setVisible(true);
			break;
		case ACTIVAR_LISTA:
			this.listaAeropuerto.setVisible(true);
			break;
		case DESACTIVAR_VISTAS:
			if (modificarAeropuertoNoSeguro != null)
				this.modificarAeropuertoNoSeguro.setVisible(false);
			if (modificarAeropuertoSeguro != null)
				this.modificarAeropuertoSeguro.setVisible(false);
			if (altaAeropuertoNoSeguro != null)
				this.altaAeropuertoNoSeguro.setVisible(false);
			if (altaAeropuertoSeguro != null)
				this.altaAeropuertoSeguro.setVisible(false);
			if (bajaAeropuerto != null)
				this.bajaAeropuerto.setVisible(false);
			if (detalleAeropuerto != null)
				this.detalleAeropuerto.setVisible(false);
			if (listaAeropuerto != null)
				this.listaAeropuerto.setVisible(false);
			break;
		case FIN_ALTA_SEGURO:
			this.altaAeropuertoSeguro.update(datos);
			break;
		case FIN_ALTA_NO_SEGURO:
			this.altaAeropuertoNoSeguro.update(datos);
			break;
		case FIN_BAJA:
			this.bajaAeropuerto.update(datos);
			break;
		case FIN_DETALLE:
			this.detalleAeropuerto.update(datos);
			break;
		case FIN_MODIFICAR_NO_SEGURO:
			this.modificarAeropuertoNoSeguro.update(datos);
			break;
		case FIN_MODIFICAR_SEGURO:
			this.modificarAeropuertoSeguro.update(datos);
			break;
		case FIN_LISTA:
			this.listaAeropuerto.update(datos);
			break;
		}
		
			
	}
}