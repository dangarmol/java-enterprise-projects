package Presentacion.Vistas.vistaBillete;

public abstract class VistaBillete {
	private static VistaBillete instance;

	public static VistaBillete getInstance() {
		if(instance == null){
			instance = new VistaBilleteImp();
		}
		return instance;
	}

	public abstract void update(int accion, Object datos);
	
	public abstract void createJFrameBotoneraBilletes();
	
	public abstract void createJFrameBajaBilletes();

	public abstract void createJFrameDetalleBilletes();

	public abstract void createJFrameGestionarBilletes();

	public abstract void createJFrameIniciarCompra();

	public abstract void createJFrameListaBilletes();
	
	public abstract void createJFrameModificarBilletes();
}

