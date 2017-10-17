package Presentacion.Avion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Negocio.Avion.imp.TransferAvion;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.ControladorImp;

@SuppressWarnings("serial")
public class JFrameDetalleAvion extends JFrame{
	JTextField id;
	JButton ok;
	JButton salir;
	JTextArea resultado;
	
	public JFrameDetalleAvion() {
		super("Detalle Avión");
		this.setSize(500, 200);
		this.setLocation(500,200);
		this.setLayout(new GridLayout (2, 2, 5, 5));
		id = new JTextField();
		ok = new JButton("OK");
		resultado = new JTextArea();
		salir = new JButton("Salir");
		
		ok.addActionListener(new ActionListenerDetalleAvion());
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				id.setText("");
				Controlador.getInstance().accion(ControladorImp.SALIR_OPERACIONES_AVION, null);
				
			}
			
		});
		
		this.add(id);
		this.add(ok);
		this.add(resultado);
		this.add(salir);
	}
	
	public void update (Object datos) {
		resultado.setText("");
		TransferAvion t = (TransferAvion) datos;
		if (t == null) {
			resultado.append("No existe ese avion");
		}
		else {
			resultado.append(t.toString());
		}
	}
	
	public class ActionListenerDetalleAvion implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				if (id.getText().equals("")) {
					throw new Exception();
				}
				TransferAvion t = new TransferAvion();
				t.setId(Integer.parseInt(id.getText()));
				Controlador.getInstance().accion(ControladorImp.DETALLE_AVION, t);
			}
			catch (Exception e) {
				resultado.setText("");
				resultado.append("Faltan datos o son incorrectos");
			}
		}
		
	}
}