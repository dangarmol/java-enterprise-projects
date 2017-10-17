package Presentacion.InstanciadeVuelo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.ControladorImp;

@SuppressWarnings("serial")
public class JFrameBotoneraInstanciaDeVuelo extends JFrame {

	private JButton altaInstanciaDeVuelo;
	private JButton bajaInstanciaDeVuelo;
	private JButton modificarInstanciaDeVuelo;
	private JButton detalleInstanciaDeVuelo;
	private JButton listaInstanciaDeVuelo;
	private JButton salir;
	
	public JFrameBotoneraInstanciaDeVuelo() {
		createVistaBotonera();
	}

	private void createVistaBotonera() {
		this.setSize(500, 300);
		altaInstanciaDeVuelo = new JButton("Alta instancia de vuelo");
		bajaInstanciaDeVuelo = new JButton ("Baja instancia de vuelo");
		modificarInstanciaDeVuelo = new JButton ("Modificar instancia de vuelo");
		detalleInstanciaDeVuelo = new JButton ("Detalle instancia de vuelo");
		listaInstanciaDeVuelo = new JButton ("Listado instancias de vuelo");
		salir = new JButton ("Volver");
		
		altaInstanciaDeVuelo.addActionListener(new ActionListenerBotoneraInstanciaDeVuelo(ControladorImp.VISTA_ALTA_INSTANCIA_VUELO));
		
		bajaInstanciaDeVuelo.addActionListener(new ActionListenerBotoneraInstanciaDeVuelo(ControladorImp.VISTA_BAJA_INSTANCIA_VUELO));
		modificarInstanciaDeVuelo.addActionListener(new ActionListenerBotoneraInstanciaDeVuelo(ControladorImp.VISTA_MODIFICAR_INSTANCIA_VUELO));
		
		detalleInstanciaDeVuelo.addActionListener(new ActionListenerBotoneraInstanciaDeVuelo(ControladorImp.VISTA_DETALLE_INSTANCIA_VUELO));
		listaInstanciaDeVuelo.addActionListener(new ActionListenerBotoneraInstanciaDeVuelo(ControladorImp.VISTA_LISTA_INSTANCIA_VUELO));
		salir.addActionListener(new ActionListenerBotoneraInstanciaDeVuelo(ControladorImp.VOLVER_INSTANCIA_VUELO));
		this.setLayout(new GridLayout(6, 1, 5, 5));
		this.add(altaInstanciaDeVuelo);
		this.add(bajaInstanciaDeVuelo);
		this.add(modificarInstanciaDeVuelo);
		this.add(detalleInstanciaDeVuelo);
		this.add(listaInstanciaDeVuelo);
		this.add(salir);
	}
	
	public class ActionListenerBotoneraInstanciaDeVuelo implements ActionListener {
		private int accion;
		public ActionListenerBotoneraInstanciaDeVuelo (int accion) {
			this.accion = accion;
		}
			
		@Override
		public void actionPerformed(ActionEvent e) {
			Controlador.getInstance().accion(this.accion, null);
			
		}
	}
}