package Presentacion.Controlador;

public abstract class Controlador {

	protected static Controlador instancia;

	public static Controlador getInstance() {
		if (instancia == null) {
			instancia = new ControladorImp();
		}
		return instancia;
	}

	public abstract void accion(int evento, Object datos);
}