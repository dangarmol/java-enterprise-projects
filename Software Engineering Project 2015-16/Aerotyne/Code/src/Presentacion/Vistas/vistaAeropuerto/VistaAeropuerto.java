package Presentacion.Vistas.vistaAeropuerto;

public abstract class VistaAeropuerto {
	private static VistaAeropuerto instance;
	
	public static VistaAeropuerto getInstance() {
		if(instance == null){
			instance = new VistaAeropuertoImp();
		}
		return instance;
	}
	
	public abstract void update(int accion, Object datos);
	
	public abstract void createJFrameBotoneraAeropuerto();

	public abstract void createJFrameAltaAeropuertoSeguro();

	public abstract void createJFrameAltaAeropuertoNoSeguro();

	public abstract void createJFrameBajaAeropuerto();


	public abstract void createJFrameListaAeropuerto();


	public abstract void createJFrameDetalleAeropuerto();

	public abstract void createJFrameModificarAeropuertoSeguro();

	public abstract void createJFrameModificarAeropuertoNoSeguro();
}