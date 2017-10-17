package Presentacion.Avion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Negocio.Avion.imp.TransferAvion;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.ControladorImp;

@SuppressWarnings("serial")
public class JFrameModificarAvion extends JFrame{
	JTextField id;
	JTextField modelo;
	JTextField matricula;
	JTextField numPlazas;
	JTextArea resultado;
	JButton ok;
	JButton salir;
	
	public JFrameModificarAvion() {
		super("Modificar Avión");
		this.setSize(500, 400);
		this.setLocation(500,200);
		this.setLayout(new GridLayout (6, 2, 5, 5));
		JLabel idEt = new JLabel("ID del avión");
		idEt.setHorizontalAlignment(SwingConstants.CENTER);
		id = new JTextField();
		JLabel modeloEt = new JLabel("Modelo");
		modeloEt.setHorizontalAlignment(SwingConstants.CENTER);
		modelo = new JTextField();
		JLabel matriculaEt = new JLabel("Matrícula");
		matriculaEt.setHorizontalAlignment(SwingConstants.CENTER);
		matricula = new JTextField();
		JLabel numPlazasEt = new JLabel("Número de plazas");
		numPlazasEt.setHorizontalAlignment(SwingConstants.CENTER);
		numPlazas = new JTextField();
		resultado = new JTextArea();
		salir = new JButton ("Salir");
		ok = new JButton("OK");
		
		ok.addActionListener(new ActionListenerModificarAvion());
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				id.setText("");
				modelo.setText("");
				matricula.setText("");
				numPlazas.setText("");
				resultado.setText("");
				Controlador.getInstance().accion(ControladorImp.SALIR_OPERACIONES_AVION, null);
			}
			
		});
		
		this.add(idEt);
		this.add(id);
		this.add(modeloEt);
		this.add(modelo);
		this.add(matriculaEt);
		this.add(matricula);
		this.add(numPlazasEt);
		this.add(numPlazas);
		this.add(ok);
		this.add(resultado);
		this.add(salir);
	}
	
	public void update (Object datos) {
		resultado.setText("");
		resultado.append((String) datos);
	}
	
	public class ActionListenerModificarAvion implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				if (id.getText().equals("") || (modelo.getText().equals("") && matricula.getText().equals("") && numPlazas.getText().equals(""))) {
					throw new Exception();
				}
				TransferAvion t = new TransferAvion();
				t.setId(Integer.parseInt(id.getText()));
				if(modelo.getText().equals(""))
				{
					t.setModelo("_FILL_");
				} else {
					t.setModelo(modelo.getText());
				}
				if(matricula.getText().equals(""))
				{
					t.setMatricula("_FILL_");
				} else {
					t.setMatricula(matricula.getText());
				}
				if(numPlazas.getText().equals(""))
				{
					t.setNumPlazas(-2);
				} else {
					t.setNumPlazas(Integer.parseInt(numPlazas.getText()));
				}
				Controlador.getInstance().accion(ControladorImp.MODIFICAR_AVION, t);
			}
			catch (Exception e) {
				resultado.setText("");
				resultado.append("Faltan datos o son incorrectos");
			}
		}
		
	}
}