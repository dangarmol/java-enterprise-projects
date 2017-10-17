package Presentacion.Vistas.vistaVuelo;


public abstract class VistaVuelo {
	private static VistaVuelo instance;
	
	public static VistaVuelo getInstance() {
		if(instance == null){
			instance = new VistaVueloImp();
		}
		return instance;
	}

	public abstract void update(int accion, Object datos);
	
	public abstract void createJFrameBotoneraVuelo();

	public abstract void createJFrameAltaVuelo();

	public abstract void createJFrameBajaVuelo();

	public abstract void createJFrameListaVuelo();

	public abstract void createJFrameDetalleVuelo();

	public abstract void createJFrameModificarVuelo();
}