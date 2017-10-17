package Presentacion.Billetes;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Negocio.Compra.imp.TransferBilletes;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.ControladorImp;

public class JFrameDetalleBilletes extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JTextField id;
	JButton ok;
	JButton salir;
	JTextArea resultado;
	
	public JFrameDetalleBilletes() {
		super("Detalle Billetes");
		this.setSize(500, 200);
		this.setLocation(500,300);
		this.setLayout(new GridLayout (2, 2, 5, 5));
		id = new JTextField("Introducir ID");
		ok = new JButton("OK");
		resultado = new JTextArea();
		salir = new JButton("Salir");
		
		ok.addActionListener(new ActionListenerDetalleAeropuerto());
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				id.setText("");
				resultado.setText("");
				Controlador.getInstance().accion(ControladorImp.SALIR_OPERACIONES_BILLETE, null);
				
			}
		});
		this.add(id);
		this.add(ok);
		this.add(resultado);
		this.add(salir);
	}
	
	public void update (Object datos) {
		resultado.setText("");
		TransferBilletes t = (TransferBilletes) datos;
		if (t == null) {
			resultado.append("El billete buscado no existe");
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
				TransferBilletes t = new TransferBilletes();
				t.setId(Integer.parseInt(id.getText()));
				Controlador.getInstance().accion(ControladorImp.DETALLE_BILLETE, t);
			}
			catch (Exception e) {
				resultado.setText("");
				resultado.append("Faltan datos o son incorrectos");
			}
		}
		
	}
}