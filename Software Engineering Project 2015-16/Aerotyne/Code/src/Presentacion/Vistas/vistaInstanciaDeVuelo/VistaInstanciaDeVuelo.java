package Presentacion.Vistas.vistaInstanciaDeVuelo;

public abstract class VistaInstanciaDeVuelo {
	private static VistaInstanciaDeVuelo instance;
	
	public static VistaInstanciaDeVuelo getInstance() {
		if(instance == null){
			instance = new VistaInstanciaDeVueloImp();
		}
		return instance;
	}

	public abstract void update(int accion, Object datos);
	
	public abstract void createJFrameBotoneraInstanciaDeVuelo();

	public abstract void createJFrameAltaInstanciaDeVuelo();

	public abstract void createJFrameBajaInstanciaDeVuelo();

	public abstract void createJFrameModificarInstanciaDeVuelo();

	public abstract void createJFrameDetalleInstanciaDeVuelo();

	public abstract void createJFrameListaInstanciaDeVuelo();
}