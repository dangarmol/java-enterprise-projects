/**
 * 
 */
package Presentacion.Vistas.vistaPrincipal;

public abstract class VistaPrincipal {

	private static VistaPrincipalImp instance;

	public static VistaPrincipalImp getInstance() {
		if(instance == null){
			instance = new VistaPrincipalImp();
		}
		return instance;
	}

	public abstract void update(int accion);
}