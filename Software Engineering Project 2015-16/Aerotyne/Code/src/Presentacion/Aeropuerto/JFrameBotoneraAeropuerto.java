package Presentacion.Aeropuerto;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.ControladorImp;

@SuppressWarnings("serial")
public class JFrameBotoneraAeropuerto extends JFrame {
	
	private JButton altaAeropuertoSeguro;
	private JButton altaAeropuertoNoSeguro;
	private JButton bajaAeropuerto;
	private JButton detalleAeropuerto;
	private JButton listaAeropuerto;
	private JButton modificarAeropuertoSeguro;
	private JButton modificarAeropuertoNoSeguro;
	private JButton salir;
	
	public JFrameBotoneraAeropuerto () {
			createVistaBotonera();
	}
	
	private void createVistaBotonera() {
		this.setSize(500, 300);
		this.altaAeropuertoSeguro = new JButton("Alta aeropuerto seguro");
		this.altaAeropuertoNoSeguro = new JButton("Alta aeropuerto no seguro");
		this.bajaAeropuerto = new JButton ("Baja aeropuerto");
		this.modificarAeropuertoSeguro = new JButton ("Modificar aeropuerto seguro");
		this.modificarAeropuertoNoSeguro = new JButton ("Modificar aeropuerto no seguro");
		this.detalleAeropuerto = new JButton ("Detalle aeropuerto");
		this.listaAeropuerto = new JButton ("Listado de aeropuertos");
		this.salir = new JButton ("Volver");
		
		altaAeropuertoSeguro.addActionListener(new ActionListenerBotoneraAeropuerto(ControladorImp.VISTA_ALTA_AEROPUERTO_SEGURO));
		
		altaAeropuertoNoSeguro.addActionListener(new ActionListenerBotoneraAeropuerto(ControladorImp.VISTA_ALTA_AEROPUERTO_NO_SEGURO));
		bajaAeropuerto.addActionListener(new ActionListenerBotoneraAeropuerto(ControladorImp.VISTA_BAJA_AEROPUERTO));
		modificarAeropuertoSeguro.addActionListener(new ActionListenerBotoneraAeropuerto(ControladorImp.VISTA_MODIFICAR_AEROPUERTO_SEGURO));
		modificarAeropuertoNoSeguro.addActionListener(new ActionListenerBotoneraAeropuerto(ControladorImp.VISTA_MODIFICAR_AEROPUERTO_NO_SEGURO));
		detalleAeropuerto.addActionListener(new ActionListenerBotoneraAeropuerto(ControladorImp.VISTA_DETALLE_AEROPUERTO));
		listaAeropuerto.addActionListener(new ActionListenerBotoneraAeropuerto(ControladorImp.VISTA_LISTA_AEROPUERTO));
		salir.addActionListener(new ActionListenerBotoneraAeropuerto(ControladorImp.VOLVER_AEROPUERTO));
		this.setLayout(new GridLayout(8, 1, 5, 5));
		this.add(altaAeropuertoSeguro);
		this.add(altaAeropuertoNoSeguro);
		this.add(bajaAeropuerto);
		this.add(modificarAeropuertoSeguro);
		this.add(modificarAeropuertoNoSeguro);
		this.add(detalleAeropuerto);
		this.add(listaAeropuerto);
		this.add(salir);
	}
	
	public class ActionListenerBotoneraAeropuerto implements ActionListener {
		private int accion;
		public ActionListenerBotoneraAeropuerto (int accion) {
			this.accion = accion;
		}
			
		@Override
		public void actionPerformed(ActionEvent e) {
			Controlador.getInstance().accion(this.accion, null);
			
		}
	}
}