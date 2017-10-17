package Presentacion.Vistas.vistaBillete;

import Presentacion.Billetes.JFrameBotoneraBilletes;
import Presentacion.Billetes.JFrameGestionarBilletes;
import Presentacion.Billetes.JFrameBajaBilletes;
import Presentacion.Billetes.JFrameIniciarCompra;
import Presentacion.Billetes.JFrameListaBilletes;
import Presentacion.Billetes.JFrameDetalleBilletes;
import Presentacion.Billetes.JFrameModificarBilletes;

public class VistaBilleteImp extends VistaBillete {

	private JFrameIniciarCompra iniciarCompra;
	private JFrameGestionarBilletes gestionarBilletes;
	private JFrameBajaBilletes bajaBilletes;
	private JFrameDetalleBilletes detalleBillete;
	private JFrameListaBilletes listaBillete;
	private JFrameModificarBilletes modificarBillete;
	private JFrameBotoneraBilletes botoneraBillete;
	
	public static final int ACTIVAR_BOTONERA = 1;
	public static final int DESACTIVAR_BOTONERA = 2;
	public static final int ACTIVAR_INICIAR_COMPRA = 3;
	public static final int ACTIVAR_ELIMINAR_BILLETES = 7;
	public static final int ACTIVAR_GESTIONAR_BILLETES = 8;
	
	public static final int ACTIVAR_BAJA_BILLETES = 9;
	public static final int ACTIVAR_DETALLE_BILLETE = 11;
	public static final int ACTIVAR_LISTA_BILLETES = 13;
	public static final int ACTIVAR_MODIFICAR_BILLETE = 200;
	public static final int DESACTIVAR_VISTAS = 20;
	
	public static final int FIN_INICIAR_COMPRA = 21;
	public static final int MOSTRAR_FINAL_COMPRA = 40;
	public static final int FIN_ELIMINAR_BILLETES = 23;
	public static final int FIN_BAJA_BILLETES = 24;
	public static final int FIN_DETALLE_BILLETES = 25;
	public static final int FIN_LISTA_BILLETES = 27;
	public static final int FIN_MODIFICAR_BILLETES = 500;
	
	@Override
	public void createJFrameBotoneraBilletes() {
		if(this.botoneraBillete == null) {
			this.botoneraBillete = new JFrameBotoneraBilletes();
		}
	}
	@Override
	public void createJFrameBajaBilletes() {
		if (this.bajaBilletes== null) {
			this.bajaBilletes = new JFrameBajaBilletes();
		}
	}
	@Override
	public void createJFrameDetalleBilletes() {
		if (this.detalleBillete == null) {
			this.detalleBillete = new JFrameDetalleBilletes();
		}
	}
	@Override
	public void createJFrameGestionarBilletes() {
		if (this.gestionarBilletes == null) {
			this.gestionarBilletes = new JFrameGestionarBilletes();
		}
	}
	@Override
	public void createJFrameIniciarCompra() {
		if (this.iniciarCompra == null) {
			this.iniciarCompra = new JFrameIniciarCompra();
		}
	}
	@Override
	public void createJFrameListaBilletes() {
		if (this.listaBillete == null) {
			this.listaBillete = new JFrameListaBilletes();
		}
	}
	@Override
	public void createJFrameModificarBilletes() {
		if (this.modificarBillete == null) {
			this.modificarBillete = new JFrameModificarBilletes();
		}
	}
	
	@Override
	public void update(int accion, Object datos) {
		switch (accion) {
		case ACTIVAR_BOTONERA:
			this.botoneraBillete.setVisible(true);
			break;
		case DESACTIVAR_BOTONERA:
			this.botoneraBillete.setVisible(false);
			break;
		case ACTIVAR_BAJA_BILLETES:
			this.bajaBilletes.setVisible(true);
			break;
		case ACTIVAR_INICIAR_COMPRA:
			this.iniciarCompra.setVisible(true);
			break;
		case ACTIVAR_ELIMINAR_BILLETES:
			this.gestionarBilletes.setVisible(true);
			break;
		case ACTIVAR_DETALLE_BILLETE:
			this.detalleBillete.setVisible(true);
			break;
		case ACTIVAR_LISTA_BILLETES:
			this.listaBillete.setVisible(true);
			break;
		case ACTIVAR_MODIFICAR_BILLETE:
			this.modificarBillete.setVisible(true);
			break;
		case DESACTIVAR_VISTAS:
			if(bajaBilletes != null)
				this.bajaBilletes.setVisible(false);
			if(iniciarCompra != null)
				this.iniciarCompra.setVisible(false);
			if(gestionarBilletes != null)
				this.gestionarBilletes.setVisible(false);
			if(detalleBillete != null)
				this.detalleBillete.setVisible(false);
			if(listaBillete != null)
				this.listaBillete.setVisible(false);
			if(modificarBillete != null)
				this.modificarBillete.setVisible(false);
			break;
		case ACTIVAR_GESTIONAR_BILLETES:
			this.gestionarBilletes.update(datos);
			this.gestionarBilletes.setVisible(true);
			break;
		case FIN_INICIAR_COMPRA:
			//this.iniciarCompra.update(datos);
			break;
		case FIN_ELIMINAR_BILLETES:
			//this.eliminarBilletes.update(datos);
			break;
		case FIN_BAJA_BILLETES:
			this.bajaBilletes.update(datos);
			break;
		case FIN_DETALLE_BILLETES:
			this.detalleBillete.update(datos);
			break;
		case FIN_LISTA_BILLETES:
			this.listaBillete.update(datos);
			break;
		case FIN_MODIFICAR_BILLETES:
			this.modificarBillete.update(datos);
			break;
		case MOSTRAR_FINAL_COMPRA:
			this.gestionarBilletes.mostrarMensaje(datos);
			break;
		}
	}	
}