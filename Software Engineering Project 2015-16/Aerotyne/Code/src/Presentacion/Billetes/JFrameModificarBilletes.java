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

public class JFrameModificarBilletes extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JTextField id;
	JTextField instancia;
	JTextField nombre;
	JTextField dni;
	JTextArea resultado;
	JButton ok;
	JButton salir;
	
	public JFrameModificarBilletes() {
		super("Modificar Billete");
		this.setSize(500, 400);
		this.setLocation(500,200);
		this.setLayout(new GridLayout (6, 2, 5, 5));
		JLabel idEt = new JLabel("ID del billete");
		idEt.setHorizontalAlignment(SwingConstants.CENTER);
		id = new JTextField();
		JLabel instanciaEt = new JLabel("Instancia de vuelo");
		instanciaEt.setHorizontalAlignment(SwingConstants.CENTER);
		instancia = new JTextField();
		JLabel nombreEt = new JLabel("Nombre");
		nombreEt.setHorizontalAlignment(SwingConstants.CENTER);
		nombre = new JTextField();
		JLabel dniEt = new JLabel("DNI");
		dniEt.setHorizontalAlignment(SwingConstants.CENTER);
		dni = new JTextField();
		resultado = new JTextArea();
		salir = new JButton ("Salir");
		ok = new JButton("OK");
		
		ok.addActionListener(new ActionListenerModificarAeropuertoSeguro());
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				id.setText("");
				instancia.setText("");
				nombre.setText("");
				dni.setText("");
				resultado.setText("");
				Controlador.getInstance().accion(ControladorImp.SALIR_OPERACIONES_BILLETE, null);
			}
		});
		
		this.add(idEt);
		this.add(id);
		this.add(instanciaEt);
		this.add(instancia);
		this.add(nombreEt);
		this.add(nombre);
		this.add(dniEt);
		this.add(dni);
		this.add(ok);
		this.add(resultado);
		this.add(salir);
	}
	
	public void update (Object datos) {
		resultado.setText("");
		resultado.append((String) datos);
	}
	
	public class ActionListenerModificarAeropuertoSeguro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				if (id.getText().equals("") || (nombre.getText().equals("") && instancia.getText().equals("") && dni.getText().equals(""))) {
					throw new Exception();
				}
				TransferBilletes t = new TransferBilletes();
				t.setId(Integer.parseInt(id.getText()));
				if(instancia.getText().equals("")) {
					t.setInstanciaDeVuelo(-2);
				} 
				else {
					t.setInstanciaDeVuelo(Integer.parseInt(instancia.getText()));
				}
				if(nombre.getText().equals("")) {
					t.setNombre("_FILL_");
				} 
				else {
					t.setNombre(nombre.getText());
				}
				
				if(dni.getText().equals("")) {
					t.setDni("_FILL_");
				} 
				else {
					t.setDni(dni.getText());
				}
				
				Controlador.getInstance().accion(ControladorImp.MODIFICAR_BILLETE, t);
			}
			catch (Exception e) {
				resultado.setText("");
				resultado.append("Faltan datos o son incorrectos");
			}
		}
	}
}