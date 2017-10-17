package Presentacion.Aeropuerto;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Negocio.Aeropuerto.imp.TransferAeropuertoNoSeguro;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.ControladorImp;

@SuppressWarnings("serial")
public class JFrameModificarAeropuertoNoSeguro extends JFrame{
	
	JTextField id;
	JTextField nombre;
	JTextField ciudad;
	JTextField pais;
	JTextField descripcion;
	JTextArea resultado;
	JButton ok;
	JButton salir;
	
	public JFrameModificarAeropuertoNoSeguro() {
		super("Modificar Aeropuerto No Seguro");
		this.setSize(500, 400);
		this.setLocation(500,200);
		this.setLayout(new GridLayout (7, 2, 5, 5));
		JLabel idEt = new JLabel("ID Aeropuerto");
		idEt.setHorizontalAlignment(SwingConstants.CENTER);
		id = new JTextField();
		JLabel nombreEt = new JLabel("Nombre");
		nombreEt.setHorizontalAlignment(SwingConstants.CENTER);
		nombre = new JTextField();
		JLabel ciudadEt = new JLabel("Ciudad");
		ciudadEt.setHorizontalAlignment(SwingConstants.CENTER);
		ciudad = new JTextField();
		JLabel paisEt = new JLabel("País");
		paisEt.setHorizontalAlignment(SwingConstants.CENTER);
		pais = new JTextField();
		JLabel descripcionEt = new JLabel("Descripción");
		descripcionEt.setHorizontalAlignment(SwingConstants.CENTER);
		descripcion = new JTextField();
		resultado = new JTextArea();
		salir = new JButton ("Salir");
		ok = new JButton("OK");
		
		ok.addActionListener(new ActionListenerModificarAeropuertoNoSeguro());
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				id.setText("");
				nombre.setText("");
				pais.setText("");
				descripcion.setText("");
				ciudad.setText("");
				resultado.setText("");
				Controlador.getInstance().accion(ControladorImp.SALIR_OPERACIONES_AEROPUERTO, null);
				
			}
			
		});
		
		this.add(idEt);
		this.add(id);
		this.add(nombreEt);
		this.add(nombre);
		this.add(ciudadEt);
		this.add(ciudad);
		this.add(paisEt);
		this.add(pais);
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
	
	public class ActionListenerModificarAeropuertoNoSeguro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				if (id.getText().equals("") || (nombre.getText().equals("") && ciudad.getText().equals("") && pais.getText().equals("") && descripcion.getText().equals(""))) {
					throw new Exception();
				}
				TransferAeropuertoNoSeguro t = new TransferAeropuertoNoSeguro();
				t.setId(Integer.parseInt(id.getText()));
				if(nombre.getText().equals(""))
				{
					t.setNombre("_FILL_");
				} else {
					t.setNombre(nombre.getText());
				}
				if(ciudad.getText().equals(""))
				{
					t.setCiudad("_FILL_");
				} else {
					t.setCiudad(ciudad.getText());
				}
				if(pais.getText().equals(""))
				{
					t.setPais("_FILL_");
				} else {
					t.setPais(pais.getText());
				}
				if(descripcion.getText().equals(""))
				{
					t.setDescripcion("_FILL_");
				} else {
					t.setDescripcion(descripcion.getText());
				}
				Controlador.getInstance().accion(ControladorImp.MODIFICAR_AEROPUERTO_NO_SEGURO, t);
			}
			catch (Exception e) {
				resultado.setText("");
				resultado.append("Faltan datos o son incorrectos");
			}
		}
		
	}
}
