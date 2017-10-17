package Presentacion.Aeropuerto;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Negocio.Aeropuerto.imp.TransferAeropuertoNoSeguro;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.ControladorImp;

@SuppressWarnings("serial")
public class JFrameAltaAeropuertoNoSeguro extends JFrame {
	
	JButton ok;
	JButton salir;
	JTextField nombre;
	JTextField pais;
	JTextField ciudad;
	JTextField descripcion;
	JTextArea resultado;
	
	public JFrameAltaAeropuertoNoSeguro () {
		super("Alta Aeropuerto No Seguro");
		this.setLayout(new GridLayout (6, 2, 5, 5));
		this.setSize(500, 300);
		
		JLabel nombreEt = new JLabel ("Nombre");
		JLabel paisEt = new JLabel ("Pais");
		JLabel ciudadEt = new JLabel ("Ciudad");
		JLabel descripcionEt = new JLabel ("Descripcion");
		nombre = new JTextField ();
		ciudad = new JTextField ();
		pais = new JTextField ();
		descripcion = new JTextField ();
		ok = new JButton ("OK");
		salir = new JButton ("Salir");
		resultado = new JTextArea();
		resultado.setEditable(false);
		
		ok.addActionListener(new ActionListenerAltaAeropuertoNoSeguro());
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				nombre.setText("");
				pais.setText("");
				descripcion.setText("");
				ciudad.setText("");
				resultado.setText("");
				Controlador.getInstance().accion(ControladorImp.SALIR_OPERACIONES_AEROPUERTO, null);
				
			}
			
		});
		
		this.add(nombreEt);
		this.add(nombre);
		this.add(paisEt);
		this.add(pais);
		this.add(ciudadEt);
		this.add(ciudad);
		this.add(descripcionEt);
		this.add(descripcion);
		this.add(ok);
		this.add(resultado);
		this.add(salir);
		
	}
	
	public void update (Object datos) {
		resultado.setText("");
		resultado.append((String) datos);
	}
	
	public class ActionListenerAltaAeropuertoNoSeguro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				if (nombre.getText().equals("") || ciudad.getText().equals("") || pais.getText().equals("") || descripcion.getText().equals("")) {
					throw new Exception();
				}
				TransferAeropuertoNoSeguro t = new TransferAeropuertoNoSeguro();
				t.setId(-1);
				t.setNombre(nombre.getText());
				t.setCiudad(ciudad.getText());
				t.setActivo(true);
				t.setPais(pais.getText());
				t.setDescripcion(descripcion.getText());
				Controlador.getInstance().accion(ControladorImp.ALTA_AEROPUERTO_NO_SEGURO, t);
			}
			catch (Exception e) {
				resultado.setText("");
				resultado.append("Faltan datos o son incorrectos");
			}
		}
		
	}
}