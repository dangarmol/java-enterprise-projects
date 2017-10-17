package Presentacion.Vistas.vistaAvion;


public abstract class VistaAvion {
	private static VistaAvion instance;

	public static VistaAvion getInstance() {
		if(instance == null){
			instance = new VistaAvionImp();
		}
		return instance;
	}

	public abstract void update(int accion, Object datos);
	
	public abstract void createJFrameBotoneraAvion ();
	
	public abstract void createJFrameAltaAvion();

	public abstract void createJFrameBajaAvion();

	public abstract void createJFrameListaAvion();

	public abstract void createJFrameModificarAvion();

	public abstract void createJFrameDetalleAvion();
}