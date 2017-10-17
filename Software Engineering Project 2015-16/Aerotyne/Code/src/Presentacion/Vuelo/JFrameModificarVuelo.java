package Presentacion.Vuelo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Negocio.Vuelo.imp.TransferVuelo;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.ControladorImp;

@SuppressWarnings("serial")
public class JFrameModificarVuelo extends JFrame{
	JTextField id;
	JButton ok;
	JTextField aeropuertoOrigen;
	JTextField aeropuertoDestino;
	JTextField diaSemana;
	JTextField hora;
	JButton salir;
	JTextArea resultado;
	
	public JFrameModificarVuelo() {
		super("Modificar Vuelo");
		this.setSize(500, 400);
		this.setLocation(500,200);
		this.setLayout(new GridLayout (7, 2, 5, 5));
		JLabel idEt = new JLabel("ID del vuelo");
		idEt.setHorizontalAlignment(SwingConstants.CENTER);
		id = new JTextField();
		JLabel aeropuertoOrigenEt = new JLabel("Aeropuerto Origen");
		aeropuertoOrigenEt.setHorizontalAlignment(SwingConstants.CENTER);
		aeropuertoOrigen = new JTextField();
		JLabel aeropuertoDestinoEt = new JLabel("Aeropuerto destino");
		aeropuertoDestinoEt.setHorizontalAlignment(SwingConstants.CENTER);
		aeropuertoDestino = new JTextField();
		JLabel diaSemanaEt = new JLabel("Día de la semana");
		diaSemanaEt.setHorizontalAlignment(SwingConstants.CENTER);
		diaSemana = new JTextField();
		JLabel horaEt = new JLabel("Hora");
		horaEt.setHorizontalAlignment(SwingConstants.CENTER);
		hora = new JTextField();
		salir = new JButton ("Salir");
		ok = new JButton("OK");
		
		ok.addActionListener(new ActionListenerModificarVuelo());
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				id.setText("");
				aeropuertoOrigen.setText("");
				aeropuertoDestino.setText("");
				diaSemana.setText("");
				hora.setText("");
				resultado.setText("");
				Controlador.getInstance().accion(ControladorImp.SALIR_OPERACIONES_VUELO, null);
			}
			
		});
		
		resultado = new JTextArea();
		this.add(idEt);
		this.add(id);
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
	
	public class ActionListenerModificarVuelo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				if (id.getText().equals("") || (aeropuertoOrigen.getText().equals("") && hora.getText().equals("") && aeropuertoDestino.getText().equals("") && diaSemana.getText().equals(""))) {
					throw new Exception();
				}
				TransferVuelo t = new TransferVuelo();
				t.setId(Integer.parseInt(id.getText()));
				if(hora.getText().equals(""))
				{
					t.setHora("_FILL_");
				} else {
					t.setHora(hora.getText());
				}
				if(diaSemana.getText().equals(""))
				{
					t.setDiaSemana("_FILL_");
				} else {
					t.setDiaSemana(diaSemana.getText());
				}
				if(aeropuertoOrigen.getText().equals(""))
				{
					t.setOrigen(-2);
				} else {
					t.setOrigen(Integer.parseInt(aeropuertoOrigen.getText()));
				}
				if(aeropuertoDestino.getText().equals(""))
				{
					t.setDestino(-2);
				} else {
					t.setDestino(Integer.parseInt(aeropuertoDestino.getText()));
				}
				Controlador.getInstance().accion(ControladorImp.MODIFICAR_VUELO, t);
			}
			catch (Exception e) {
				resultado.setText("");
				resultado.append("Faltan datos o son incorrectos");
			}
		}
		
	}

}