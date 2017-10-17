package Presentacion.Principal;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Presentacion.Controlador.ControladorImp;

public class JFramePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JButton aeropuerto;
	private JButton avion;
	private JButton billetes;
	private JButton instanciadevuelo;
	private JButton vuelo;
	private JButton salir;
	
	public JFramePrincipal() {
		super("Aerotyne");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 400);
		this.setLocation(500, 300);
		this.aeropuerto = new JButton("Aeropuertos");
		this.avion = new JButton("Aviones");
		this.billetes = new JButton("Billetes");
		this.instanciadevuelo = new JButton("Instancias De Vuelo");
		this.vuelo = new JButton("Vuelos");
		this.salir = new JButton("Salir");
		
		this.aeropuerto.addActionListener(new ActionListenerPrincipal(ControladorImp.VISTA_AEROPUERTOS));
		this.avion.addActionListener(new ActionListenerPrincipal(ControladorImp.VISTA_AVIONES));
		this.instanciadevuelo.addActionListener(new ActionListenerPrincipal(ControladorImp.VISTA_INSTANCIA_VUELOS));
		this.vuelo.addActionListener(new ActionListenerPrincipal(ControladorImp.VISTA_VUELOS));
		this.billetes.addActionListener(new ActionListenerPrincipal(ControladorImp.VISTA_BILLETES));
		this.salir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showOptionDialog(new JFrame(), "¿Estás seguro de que quieres salir? ", "AVISO", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
				if (n == 0) {
					dispose();
					System.exit(0);
				}
			}
			
		});
		
		
		this.setLayout(new GridLayout(6, 1, 5, 5));
		this.add(aeropuerto);
		this.add(avion);
		this.add(billetes);
		this.add(instanciadevuelo);
		this.add(vuelo);
		this.add(salir);
		
	}
}