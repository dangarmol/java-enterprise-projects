package Presentacion.Principal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Presentacion.Controlador.Controlador;

public class ActionListenerPrincipal implements ActionListener {

	private int accion;
	
	public ActionListenerPrincipal (int accion) {
		this.accion = accion;
	}
	public void actionPerformed(ActionEvent evento) {
		Controlador.getInstance().accion(this.accion, null);
	}
}