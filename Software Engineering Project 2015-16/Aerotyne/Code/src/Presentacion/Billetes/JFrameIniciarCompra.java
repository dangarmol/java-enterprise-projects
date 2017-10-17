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

import Negocio.Compra.imp.TransferCompra;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.ControladorImp;

@SuppressWarnings("serial")
public class JFrameIniciarCompra extends JFrame {
	private JTextField nombreComprador;
	private JTextField dniComprador;
	private JTextField tarjetaCredito;
	private JButton ok;
	private JButton salir;
	JTextArea resultado;
	
	public JFrameIniciarCompra() {
		super("Iniciar Compra");
		this.setSize(500, 400);
		this.setLocation(500,200);
		this.setLayout(new GridLayout (5, 2, 5, 5));
		JLabel nombreEt = new JLabel("Nombre comprador");
		nombreEt.setHorizontalAlignment(SwingConstants.CENTER);
		nombreComprador = new JTextField();
		JLabel dniEt = new JLabel("DNI Comprador");
		dniEt.setHorizontalAlignment(SwingConstants.CENTER);
		dniComprador = new JTextField();
		JLabel tarjetaEt = new JLabel("Tarjeta de crédito");
		tarjetaEt.setHorizontalAlignment(SwingConstants.CENTER);
		tarjetaCredito = new JTextField();
		salir = new JButton ("Salir");
		ok = new JButton("OK");
		resultado = new JTextArea();
		resultado.setEditable(false);
		
		ok.addActionListener(new ActionListenerIniciarCompra());
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				nombreComprador.setText("");
				dniComprador.setText("");
				tarjetaCredito.setText("");
				resultado.setText("");
				Controlador.getInstance().accion(ControladorImp.SALIR_OPERACIONES_BILLETE, null);
			}
			
		});
		
		this.add(nombreEt);
		this.add(nombreComprador);
		this.add(dniEt);
		this.add(dniComprador);
		this.add(tarjetaEt);
		this.add(tarjetaCredito);
		this.add(ok);
		this.add(resultado);
		this.add(salir);
	}
	
	public void update (Object datos) {
		resultado.setText("");
		resultado.append((String) datos);
	}
	
	public class ActionListenerIniciarCompra implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				if (nombreComprador.getText().equals("") || dniComprador.getText().equals("") || tarjetaCredito.getText().equals("")) {
					throw new Exception();
				}
				TransferCompra t = new TransferCompra();
				t.setId(-1);
				t.setDni(dniComprador.getText());
				t.setNombre(nombreComprador.getText());
				t.setActivo(true);
				t.setTarjetaDeCredito(Integer.parseInt(tarjetaCredito.getText()));
				Controlador.getInstance().accion(ControladorImp.INICIAR_COMPRA, t);
				nombreComprador.setText("");
				dniComprador.setText("");
				tarjetaCredito.setText("");
				resultado.setText("");
			}
			catch (Exception e) {
				resultado.setText("");
				resultado.append("Faltan datos o son incorrectos");
			}
		}
		
	}
}