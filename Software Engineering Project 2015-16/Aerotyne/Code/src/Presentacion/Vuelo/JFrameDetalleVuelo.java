package Presentacion.Vuelo;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Negocio.Vuelo.imp.TransferVuelo;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.ControladorImp;

@SuppressWarnings("serial")
public class JFrameDetalleVuelo extends JFrame{
	JTextField id;
	JButton ok;
	JButton salir;
	JTextArea resultado;
	
	public JFrameDetalleVuelo() {
		super("Detalle Vuelo");
		this.setSize(500, 200);
		this.setLocation(500,200);
		this.setLayout(new GridLayout (2, 2, 5, 5));
		id = new JTextField();
		ok = new JButton("OK");
		resultado = new JTextArea();
		salir = new JButton("Salir");
		
		ok.addActionListener(new ActionListenerDetalleVuelo());
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				id.setText("");
				resultado.setText("");
				Controlador.getInstance().accion(ControladorImp.SALIR_OPERACIONES_VUELO, null);
				
			}
			
		});
		
		this.add(id);
		this.add(ok);
		this.add(resultado);
		this.add(salir);
	}

	public void update (Object datos) {
		resultado.setText("");
		TransferVuelo t = (TransferVuelo) datos;
		if (t == null) {
			resultado.append("No existe ese vuelo");
		}
		else {
			resultado.append(t.toString());
		}
	}
	
	public class ActionListenerDetalleVuelo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				if (id.getText().equals("")) {
					throw new Exception();
				}
				TransferVuelo t = new TransferVuelo();
				t.setId(Integer.parseInt(id.getText()));
				Controlador.getInstance().accion(ControladorImp.DETALLE_VUELO, t);
			}
			catch (Exception e) {
				resultado.setText("");
				resultado.append("Faltan datos o son incorrectos");
			}
		}
		
	}
}