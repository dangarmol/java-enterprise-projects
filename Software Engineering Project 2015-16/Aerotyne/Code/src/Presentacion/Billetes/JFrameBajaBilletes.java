package Presentacion.Billetes;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Negocio.Compra.imp.TransferBilletes;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.ControladorImp;

@SuppressWarnings("serial")
public class JFrameBajaBilletes extends JFrame {
	
	JButton ok;
	JButton salir;
	JTextField id;
	JTextArea resultado;
	
	public JFrameBajaBilletes () {
		super ("Baja billetes");
		this.setLayout(new GridLayout (3, 2, 5, 5));
		this.setSize(550, 300);
		this.setLocation(500, 300);
		
		JLabel idEt = new JLabel ("ID billete");
		idEt.setHorizontalAlignment(SwingConstants.CENTER);
		id = new JTextField ();
		ok = new JButton ("OK");
		salir = new JButton ("Salir");
		resultado = new JTextArea();
		resultado.setEditable(false);
		
		ok.addActionListener(new ActionListenerBajaBilletes());
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				id.setText("");
				resultado.setText("");
				Controlador.getInstance().accion(ControladorImp.SALIR_OPERACIONES_BILLETE, null);
				
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
	
	public class ActionListenerBajaBilletes implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				if (id.getText().equals("")) {
					throw new Exception();
				}
				TransferBilletes t = new TransferBilletes();
				t.setId(Integer.parseInt(id.getText()));
				t.setActivo(false);
				Controlador.getInstance().accion(ControladorImp.ELIMINAR_BILLETE_BD, t);
			}
			catch (Exception e) {
				resultado.setText("");
				resultado.append("Faltan datos o los introducidos son incorrectos");
			}
		}
	}
}