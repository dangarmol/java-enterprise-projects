package Presentacion.Aeropuerto;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import Negocio.Aeropuerto.imp.TransferAeropuertoSeguro;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.ControladorImp;

@SuppressWarnings("serial")
public class JFrameAltaAeropuertoSeguro extends JFrame {

	private JTextField nombre;
	private JTextField pais;
	private JTextField ciudad;
	private JTextField gradoSeguridad;
	private JTextArea resultado;
	private JButton ok;
	private JButton salir;
	
	public JFrameAltaAeropuertoSeguro () {
		super ("Alta Aeropuerto Seguro");
		this.setLayout(new GridLayout (6, 2, 5, 5));
		this.setSize(500, 300);
		
		JLabel nombreEt = new JLabel ("Nombre");
		JLabel paisEt = new JLabel ("Pais");
		JLabel ciudadEt = new JLabel ("Ciudad");
		JLabel gradoSeguridadEt = new JLabel ("Grado de Seguridad");
		nombre = new JTextField ();
		ciudad = new JTextField ();
		pais = new JTextField ();
		gradoSeguridad = new JTextField ();
		ok = new JButton ("OK");
		salir = new JButton ("Salir");
		resultado = new JTextArea();
		resultado.setEditable(false);
		
		ok.addActionListener(new ActionListenerAltaAeropuertoSeguro());
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				nombre.setText("");
				pais.setText("");
				gradoSeguridad.setText("");
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
		this.add(gradoSeguridadEt);
		this.add(gradoSeguridad);
		this.add(ok);
		this.add(resultado);
		this.add(salir);
		
	}
	
	public void update (Object datos) {
		resultado.setText("");
		resultado.append((String) datos);
	}
	
	public class ActionListenerAltaAeropuertoSeguro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				if (nombre.getText().equals("") || ciudad.getText().equals("") || pais.getText().equals("") || gradoSeguridad.getText().equals("")) {
					throw new Exception();
				}
				TransferAeropuertoSeguro t = new TransferAeropuertoSeguro();
				t.setId(-1);
				t.setNombre(nombre.getText());
				t.setCiudad(ciudad.getText());
				t.setActivo(true);
				t.setPais(pais.getText());
				t.setGradoSeguridad(Integer.parseInt(gradoSeguridad.getText()));
				Controlador.getInstance().accion(ControladorImp.ALTA_AEROPUERTO_SEGURO, t);
			}
			catch (Exception e) {
				resultado.setText("");
				resultado.append("Faltan datos o son incorrectos");
			}
		}
		
	}
}