package Presentacion.Avion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Negocio.Avion.imp.TransferAvion;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.ControladorImp;

@SuppressWarnings("serial")
public class JFrameBajaAvion extends JFrame {
	
	JButton ok;
	JButton salir;
	JTextField id;
	JTextArea resultado;
	
	public JFrameBajaAvion () {
		super ("Baja Avion");
		this.setLayout(new GridLayout (3, 2, 5, 5));
		this.setSize(500, 300);
		
		JLabel idEt = new JLabel ("ID Avion");
		id = new JTextField ();
		ok = new JButton ("OK");
		salir = new JButton ("Salir");
		resultado = new JTextArea();
		resultado.setEditable(false);
		
		ok.addActionListener(new ActionListenerBajaAvion());
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				id.setText("");
				resultado.setText("");
				Controlador.getInstance().accion(ControladorImp.SALIR_OPERACIONES_AVION, null);
				
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
	
	public class ActionListenerBajaAvion implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				if (id.getText().equals("")) {
					throw new Exception();
				}
				TransferAvion t = new TransferAvion();
				t.setId(Integer.parseInt(id.getText()));
				t.setActivo(false);
				Controlador.getInstance().accion(ControladorImp.BAJA_AVION, t);
			}
			catch (Exception e) {
				resultado.setText("");
				resultado.append("Faltan datos o son incorrectos");
			}
		}
		
	}
}