package Presentacion.Avion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.ControladorImp;

@SuppressWarnings("serial")
public class JFrameBotoneraAvion extends JFrame {

	private JButton altaAvion;
	private JButton bajaAvion;
	private JButton modificarAvion;
	private JButton detalleAvion;
	private JButton listaAvion;
	private JButton salir;
	
	public JFrameBotoneraAvion () {
		createVistaBotonera();
	}

	private void createVistaBotonera() {
		this.setSize(500, 300);
		altaAvion = new JButton("Alta avión");
		bajaAvion = new JButton ("Baja avión");
		modificarAvion = new JButton ("Modificar avión");
		detalleAvion = new JButton ("Detalle avión");
		listaAvion = new JButton ("Listado de aviones");
		salir = new JButton ("Volver");
		
		altaAvion.addActionListener(new ActionListenerBotoneraAvion(ControladorImp.VISTA_ALTA_AVION));
		
		bajaAvion.addActionListener(new ActionListenerBotoneraAvion(ControladorImp.VISTA_BAJA_AVION));
		modificarAvion.addActionListener(new ActionListenerBotoneraAvion(ControladorImp.VISTA_MODIFICAR_AVION));
		detalleAvion.addActionListener(new ActionListenerBotoneraAvion(ControladorImp.VISTA_DETALLE_AVION));
		listaAvion.addActionListener(new ActionListenerBotoneraAvion(ControladorImp.VISTA_LISTA_AVION));
		salir.addActionListener(new ActionListenerBotoneraAvion(ControladorImp.VOLVER_AVION));
		
		this.setLayout(new GridLayout(6, 1, 5, 5));
		this.add(altaAvion);
		this.add(bajaAvion);
		this.add(modificarAvion);
		this.add(detalleAvion);
		this.add(listaAvion);
		this.add(salir);
	}
	
	public class ActionListenerBotoneraAvion implements ActionListener {
		private int accion;
		public ActionListenerBotoneraAvion (int accion) {
			this.accion = accion;
		}
			
		@Override
		public void actionPerformed(ActionEvent e) {
			Controlador.getInstance().accion(this.accion, null);
			
		}
	}
}
