package Presentacion.Aeropuerto;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Negocio.Aeropuerto.imp.TransferAeropuerto;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.ControladorImp;

@SuppressWarnings("serial")
public class JFrameBajaAeropuerto extends JFrame {
	
	JButton ok;
	JButton salir;
	JTextField id;
	JTextArea resultado;
	
	public JFrameBajaAeropuerto () {
		super ("Baja Aeropuerto");
		this.setLayout(new GridLayout (3, 2, 5, 5));
		this.setSize(500, 300);
		
		JLabel idEt = new JLabel ("ID Aeropuerto");
		id = new JTextField ();
		ok = new JButton ("OK");
		salir = new JButton ("Salir");
		resultado = new JTextArea();
		resultado.setEditable(false);
		
		ok.addActionListener(new ActionListenerBajaAeropuerto());
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				id.setText("");
				resultado.setText("");
				Controlador.getInstance().accion(ControladorImp.SALIR_OPERACIONES_AEROPUERTO, null);
				
			}
			
		});
		
		this.add(idEt);
		this.add(id);
		this.add(ok);
		this.add(resultado);
		this.add(salir);
	}
	
	public void update (Object datos) {
		resultado.setText("");
		resultado.append((String) datos);
	}
	
	public class ActionListenerBajaAeropuerto implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				if (id.getText().equals("")) {
					throw new Exception();
				}
				TransferAeropuerto t = new TransferAeropuerto();
				t.setId(Integer.parseInt(id.getText()));
				t.setActivo(false);
				Controlador.getInstance().accion(ControladorImp.BAJA_AEROPUERTO, t);
			}
			catch (Exception e) {
				resultado.setText("");
				resultado.append("Faltan datos o son incorrectos");
			}
		}
		
	}
	
	public static void main (String args []) {
		JFrameBajaAeropuerto c = new JFrameBajaAeropuerto();
		c.setVisible(true);
	}
}
