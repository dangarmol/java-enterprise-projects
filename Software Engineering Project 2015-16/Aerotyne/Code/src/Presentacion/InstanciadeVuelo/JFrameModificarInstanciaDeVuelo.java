 package Presentacion.InstanciadeVuelo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Negocio.InstanciaDeVuelo.imp.TransferInstanciaDeVuelo;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.ControladorImp;

@SuppressWarnings("serial")
public class JFrameModificarInstanciaDeVuelo extends JFrame{
	JTextField id;
	JButton ok;
	JTextField fecha;
	JTextField idVuelo;
	JTextField plazasLibres;
	JTextField idAvion;
	JTextArea resultado;
	JButton salir;
	
	public JFrameModificarInstanciaDeVuelo() {
		super("Modificar Instancia de Vuelo");
		this.setSize(500, 400);
		this.setLocation(500,200);
		this.setLayout(new GridLayout (7, 2, 5, 5));
		JLabel idEt = new JLabel("ID de la instancia de vuelo");
		idEt.setHorizontalAlignment(SwingConstants.CENTER);
		id = new JTextField();
		JLabel fechaEt = new JLabel("Fecha");
		fechaEt.setHorizontalAlignment(SwingConstants.CENTER);
		fecha = new JTextField();
		JLabel vueloEt = new JLabel("Vuelo");
		vueloEt.setHorizontalAlignment(SwingConstants.CENTER);
		idVuelo = new JTextField();
		JLabel plazasLibresEt = new JLabel("Número de plazas libres");
		plazasLibresEt.setHorizontalAlignment(SwingConstants.CENTER);
		plazasLibres = new JTextField();
		JLabel avionEt = new JLabel("Avión");
		avionEt.setHorizontalAlignment(SwingConstants.CENTER);
		idAvion = new JTextField();
		ok = new JButton("OK");
		resultado = new JTextArea();
		salir = new JButton ("Salir");
		
		ok.addActionListener(new ActionListenerModificarInstanciaDeVuelo());
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				id.setText("");
				plazasLibres.setText("");
				fecha.setText("");
				idAvion.setText("");
				idVuelo.setText("");
				resultado.setText("");
				Controlador.getInstance().accion(ControladorImp.SALIR_OPERACIONES_INSTANCIA_VUELO, null);
			}
			
		});

		this.add(idEt);
		this.add(id);
		this.add(fechaEt);
		this.add(fecha);
		this.add(vueloEt);
		this.add(idVuelo);
		this.add(plazasLibresEt);
		this.add(plazasLibres);
		this.add(avionEt);
		this.add(idAvion);
		this.add(ok);
		this.add(resultado);
		this.add(salir);
	}
	
	public void update (Object datos) {
		resultado.setText("");
		resultado.append((String) datos);
	}
	
	public class ActionListenerModificarInstanciaDeVuelo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				if (id.getText().equals("") || (fecha.getText().equals("") && idAvion.getText().equals("") && idVuelo.getText().equals("") && plazasLibres.getText().equals(""))) {
					throw new Exception();
				}
				TransferInstanciaDeVuelo t = new TransferInstanciaDeVuelo();
				t.setId(Integer.parseInt(id.getText()));
				if(fecha.getText().equals(""))
				{
					t.setFecha("_FILL_");
				} else {
					t.setFecha(fecha.getText());
				}
				if(idAvion.getText().equals(""))
				{
					t.setAvion(-2);
				} else {
					t.setAvion(Integer.parseInt(idAvion.getText()));
				}
				if(idVuelo.getText().equals(""))
				{
					t.setVuelo(-2);
				} else {
					t.setVuelo(Integer.parseInt(idVuelo.getText()));
				}
				if(plazasLibres.getText().equals(""))
				{
					t.setPlazasLibres(-2);
				} else {
					t.setPlazasLibres(Integer.parseInt(plazasLibres.getText()));
				}
				Controlador.getInstance().accion(ControladorImp.MODIFICAR_INSTANCIA_VUELO, t);
			}
			catch (Exception e) {
				resultado.setText("");
				resultado.append("Faltan datos o son incorrectos");
			}
		}
		
	}

}