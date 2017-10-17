package Presentacion.Vuelo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Negocio.Vuelo.imp.TransferVuelo;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.ControladorImp;

@SuppressWarnings("serial")
public class JFrameAltaVuelo extends JFrame {
	
	JButton ok;
	JButton salir;
	JTextField aeropuertoOrigen;
	JTextField aeropuertoDestino;
	JTextField diaSemana;
	JTextField hora;
	JTextArea resultado;
	
	public JFrameAltaVuelo () {
		super ("Alta Vuelo");
		this.setLayout(new GridLayout (6, 2, 5, 5));
		this.setSize(500, 300);
		
		JLabel aeropuertoDestinoEt = new JLabel ("Aeropuerto Destino");
		JLabel aeropuertoOrigenEt = new JLabel ("Aeropuerto Origen");
		JLabel diaSemanaEt = new JLabel ("Dia Semana");
		JLabel horaEt = new JLabel ("Hora");
		aeropuertoOrigen = new JTextField ();
		aeropuertoDestino = new JTextField ();
		diaSemana = new JTextField ();
		hora = new JTextField ();
		ok = new JButton ("OK");
		salir = new JButton ("Salir");
		resultado = new JTextArea();
		resultado.setEditable(false);
		
		ok.addActionListener(new ActionListenerAltaVuelo());
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				aeropuertoOrigen.setText("");
				aeropuertoDestino.setText("");
				diaSemana.setText("");
				hora.setText("");
				resultado.setText("");
				Controlador.getInstance().accion(ControladorImp.SALIR_OPERACIONES_VUELO, null);
				
			}
			
		});
		
		this.add(aeropuertoOrigenEt);
		this.add(aeropuertoOrigen);
		this.add(aeropuertoDestinoEt);
		this.add(aeropuertoDestino);
		this.add(diaSemanaEt);
		this.add(diaSemana);
		this.add(horaEt);
		this.add(hora);
		this.add(ok);
		this.add(resultado);
		this.add(salir);
		
	}
	
	public void update (Object datos) {
		resultado.setText("");
		resultado.append((String) datos);
	}
	
	public class ActionListenerAltaVuelo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				if (aeropuertoOrigen.getText().equals("") || hora.getText().equals("") || aeropuertoDestino.getText().equals("") || diaSemana.getText().equals("")) {
					throw new Exception();
				}
				TransferVuelo t = new TransferVuelo();
				t.setId(-1);
				t.setOrigen(Integer.parseInt(aeropuertoOrigen.getText()));
				t.setDestino(Integer.parseInt(aeropuertoDestino.getText()));
				t.setActivo(true);
				t.setDiaSemana(diaSemana.getText());
				t.setHora(hora.getText());
				Controlador.getInstance().accion(ControladorImp.ALTA_VUELO, t);
			}
			catch (Exception e) {
				resultado.setText("");
				resultado.append("Faltan datos o son incorrectos");
			}
		}
		
	}
}