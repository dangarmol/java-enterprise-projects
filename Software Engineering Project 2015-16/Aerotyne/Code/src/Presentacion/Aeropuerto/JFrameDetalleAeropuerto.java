package Presentacion.Aeropuerto;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Negocio.Aeropuerto.imp.TransferAeropuerto;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.ControladorImp;

@SuppressWarnings("serial")
public class JFrameDetalleAeropuerto extends JFrame{
	JTextField id;
	JButton ok;
	JButton salir;
	JTextArea resultado;
	
	public JFrameDetalleAeropuerto() {
		super("Detalle Aeropuerto");
		this.setSize(500, 200);
		this.setLocation(500,200);
		this.setLayout(new GridLayout (2, 2, 5, 5));
		id = new JTextField();
		ok = new JButton("OK");
		resultado = new JTextArea();
		salir = new JButton("Salir");
		
		ok.addActionListener(new ActionListenerDetalleAeropuerto());
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				id.setText("");
				resultado.setText("");
				Controlador.getInstance().accion(ControladorImp.SALIR_OPERACIONES_AEROPUERTO, null);
				
			}
			
		});
		this.add(id);
		this.add(ok);
		this.add(resultado);
		this.add(salir);
	}
	
	public void update (Object datos) {
		resultado.setText("");
		TransferAeropuerto t = (TransferAeropuerto) datos;
		if (t == null) {
			resultado.append("No existe ese aeropuerto");
		}
		else {
			resultado.append(t.toString());
		}
	}
	
	public class ActionListenerDetalleAeropuerto implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				if (id.getText().equals("")) {
					throw new Exception();
				}
				TransferAeropuerto t = new TransferAeropuerto();
				t.setId(Integer.parseInt(id.getText()));
				Controlador.getInstance().accion(ControladorImp.DETALLE_AEROPUERTO, t);
			}
			catch (Exception e) {
				resultado.setText("");
				resultado.append("Faltan datos o son incorrectos");
			}
		}
		
	}
	public static void main(String[] args) {
		JFrameDetalleAeropuerto a = new JFrameDetalleAeropuerto();
		a.setVisible(true);
	}
}