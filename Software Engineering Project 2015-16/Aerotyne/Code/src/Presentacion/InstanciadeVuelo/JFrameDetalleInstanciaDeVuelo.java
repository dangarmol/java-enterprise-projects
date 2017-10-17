package Presentacion.InstanciadeVuelo;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Negocio.InstanciaDeVuelo.imp.TransferInstanciaDeVuelo;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.ControladorImp;

@SuppressWarnings("serial")
public class JFrameDetalleInstanciaDeVuelo extends JFrame{
	JTextField id;
	JButton ok;
	JButton salir;
	JTextArea resultado;
	
	public JFrameDetalleInstanciaDeVuelo() {
		super("Detalle Instancia De Vuelo");
		this.setSize(500, 200);
		this.setLocation(500,200);
		this.setLayout(new GridLayout (2, 2, 5, 5));
		id = new JTextField();
		ok = new JButton("OK");
		resultado = new JTextArea();
		salir = new JButton("Salir");
		
		ok.addActionListener(new ActionListenerDetalleInstanciaDeVuelo());
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				id.setText("");
				resultado.setText("");
				Controlador.getInstance().accion(ControladorImp.SALIR_OPERACIONES_INSTANCIA_VUELO, null);
				
			}
			
		});
		
		this.add(id);
		this.add(ok);
		this.add(resultado);
		this.add(salir);
	}
	
	public void update (Object datos) {
		resultado.setText("");
		TransferInstanciaDeVuelo t = (TransferInstanciaDeVuelo) datos;
		if (t == null) {
			resultado.append("No existe esa instancia");
		}
		else {
			resultado.append(t.toString());
		}
	}
	
	public class ActionListenerDetalleInstanciaDeVuelo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				if (id.getText().equals("")) {
					throw new Exception();
				}
				TransferInstanciaDeVuelo t = new TransferInstanciaDeVuelo();
				t.setId(Integer.parseInt(id.getText()));
				Controlador.getInstance().accion(ControladorImp.DETALLE_INSTANCIA_VUELO, t);
			}
			catch (Exception e) {
				resultado.setText("");
				resultado.append("Faltan datos o son incorrectos");
			}
		}
		
	}
}