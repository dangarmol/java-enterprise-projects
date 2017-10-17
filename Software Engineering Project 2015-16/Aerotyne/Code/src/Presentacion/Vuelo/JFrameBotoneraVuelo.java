package Presentacion.Vuelo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.ControladorImp;

@SuppressWarnings("serial")
public class JFrameBotoneraVuelo extends JFrame {

	private JButton altaVuelo;
	private JButton bajaVuelo;
	private JButton modificarVuelo;
	private JButton detalleVuelo;
	private JButton listaVuelo;
	private JButton salir;
	
	public JFrameBotoneraVuelo () {
		createVistaBotonera();
	}

	private void createVistaBotonera() {
		this.setSize(500, 300);
		altaVuelo = new JButton("Alta vuelo");
		bajaVuelo = new JButton ("Baja vuelo");
		modificarVuelo = new JButton ("Modificar vuelo");
		detalleVuelo = new JButton ("Detalle vuelo");
		listaVuelo = new JButton ("Listado de vuelos");
		salir = new JButton ("Volver");
		
		altaVuelo.addActionListener(new ActionListenerBotoneraVuelo(ControladorImp.VISTA_ALTA_VUELO));
		
		bajaVuelo.addActionListener(new ActionListenerBotoneraVuelo(ControladorImp.VISTA_BAJA_VUELO));
		modificarVuelo.addActionListener(new ActionListenerBotoneraVuelo(ControladorImp.VISTA_MODIFICAR_VUELO));
		detalleVuelo.addActionListener(new ActionListenerBotoneraVuelo(ControladorImp.VISTA_DETALLE_VUELO));
		listaVuelo.addActionListener(new ActionListenerBotoneraVuelo(ControladorImp.VISTA_LISTA_VUELO));
		salir.addActionListener(new ActionListenerBotoneraVuelo(ControladorImp.VOLVER_VUELO));
		this.setLayout(new GridLayout(6, 1, 5, 5));
		this.add(altaVuelo);
		this.add(bajaVuelo);
		this.add(modificarVuelo);
		this.add(detalleVuelo);
		this.add(listaVuelo);
		this.add(salir);
	}
	
	public class ActionListenerBotoneraVuelo implements ActionListener {
		private int accion;
		public ActionListenerBotoneraVuelo (int accion) {
			this.accion = accion;
		}
			
		@Override
		public void actionPerformed(ActionEvent e) {
			Controlador.getInstance().accion(this.accion, null);
			
		}
	}
}