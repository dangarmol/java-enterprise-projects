package Presentacion.InstanciadeVuelo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Negocio.InstanciaDeVuelo.imp.TransferInstanciaDeVuelo;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.ControladorImp;

@SuppressWarnings("serial")
public class JFrameAltaInstanciaDeVuelo extends JFrame {
	
	JButton ok;
	JButton salir;
	JTextField plazasLibres;
	JTextField fecha;
	JTextField idAvion;
	JTextField idVuelo;
	JTextArea resultado;
	
	public JFrameAltaInstanciaDeVuelo () {
		super ("Alta Instancia de Vuelo");
		this.setLayout(new GridLayout (6, 2, 5, 5));
		this.setSize(500, 300);
		
		JLabel plazasLibresEt = new JLabel ("Plazas Libres");
		JLabel fechaEt = new JLabel ("Fecha");
		JLabel avionEt = new JLabel ("Avion");
		JLabel vueloEt = new JLabel ("Vuelo");
		plazasLibres = new JTextField ();
		fecha = new JTextField ();
		idAvion = new JTextField ();
		idVuelo = new JTextField ();
		ok = new JButton ("OK");
		salir = new JButton ("Salir");
		resultado = new JTextArea();
		resultado.setEditable(false);
		
		ok.addActionListener(new ActionListenerAltaInstanciaDeVuelo());
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				plazasLibres.setText("");
				fecha.setText("");
				idAvion.setText("");
				idVuelo.setText("");
				resultado.setText("");
				Controlador.getInstance().accion(ControladorImp.SALIR_OPERACIONES_INSTANCIA_VUELO, null);
			}
			
		});
		
		this.add(avionEt);
		this.add(idAvion);
		this.add(vueloEt);
		this.add(idVuelo);
		this.add(fechaEt);
		this.add(fecha);
		this.add(plazasLibresEt);
		this.add(plazasLibres);
		this.add(ok);
		this.add(resultado);
		this.add(salir);
		
	}
	
	public void update (Object datos) {
		resultado.setText("");
		resultado.append((String) datos);
	}
	
	public class ActionListenerAltaInstanciaDeVuelo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				if (plazasLibres.getText().equals("") || fecha.getText().equals("") || idVuelo.getText().equals("") || idAvion.getText().equals("")) {
					throw new Exception();
				}
				TransferInstanciaDeVuelo t = new TransferInstanciaDeVuelo();
				t.setId(-1);
				t.setFecha(fecha.getText());
				t.setPlazasLibres(Integer.parseInt(plazasLibres.getText()));
				t.setActivo(true);
				t.setVuelo(Integer.parseInt(idVuelo.getText()));
				t.setAvion(Integer.parseInt(idAvion.getText()));
				Controlador.getInstance().accion(ControladorImp.ALTA_INSTANCIA_VUELO, t);
			}
			catch (Exception e) {
				resultado.setText("");
				resultado.append("Faltan datos o son incorrectos");
			}
		}
		
	}
}