package presentacion.vistas.vistaBicicleta;

import presentacion.controlador.Contexto;

public abstract class VistaBicicleta {
	private static VistaBicicleta instance;

	public static synchronized VistaBicicleta getInstance() {
		if (instance == null)
			instance = new VistaBicicletaImp();
		return instance;
	}

	public abstract void update(Contexto contexto);
}