package Presentacion.Vistas.vistaPrincipal;

import Presentacion.Principal.JFramePrincipal;

public class VistaPrincipalImp extends VistaPrincipal {

	private JFramePrincipal principal;
	public static final int ACTIVAR = 1;
	public static final int DESACTIVAR = 2;

	public void createJFramePrincipal() {
		this.principal = new JFramePrincipal();
	}

	@Override
	public void update(int accion) {
		switch (accion) {
		case ACTIVAR:
			this.principal.setVisible(true);
			break;
		case DESACTIVAR:
			this.principal.setVisible(false);
			break;
		}
			
	}
}