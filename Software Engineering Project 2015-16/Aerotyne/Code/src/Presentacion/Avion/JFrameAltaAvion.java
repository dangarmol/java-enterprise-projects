package Presentacion.Avion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Negocio.Avion.imp.TransferAvion;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.ControladorImp;

@SuppressWarnings("serial")
public class JFrameAltaAvion extends JFrame {
	
	JButton ok;
	JButton salir;
	JTextField modelo;
	JTextField matricula;
	JTextField numPlazas;
	JTextArea resultado;
	
	public JFrameAltaAvion () {
		super ("Alta Avion");
		this.setLayout(new GridLayout (5, 2, 5, 5));
		this.setSize(500, 300);
		
		JLabel modeloEt = new JLabel ("Modelo");
		JLabel matriculaEt = new JLabel ("Matricula");
		JLabel numPlazasEt = new JLabel ("Numero de Plazas");
		modelo = new JTextField ();
		matricula = new JTextField ();
		numPlazas = new JTextField ();
		ok = new JButton ("OK");
		salir = new JButton ("Salir");
		resultado = new JTextArea();
		resultado.setEditable(false);
		
		ok.addActionListener(new ActionListenerAltaAvion());
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				modelo.setText("");
				matricula.setText("");
				numPlazas.setText("");
				resultado.setText("");
				Controlador.getInstance().accion(ControladorImp.SALIR_OPERACIONES_AVION, null);
				
			}
			
		});
		
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
	
	public class ActionListenerAltaAvion implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				if (modelo.getText().equals("") || matricula.getText().equals("") || numPlazas.getText().equals("")) {
					throw new Exception();
				}
				TransferAvion t = new TransferAvion();
				t.setId(-1);
				t.setModelo(modelo.getText());
				t.setMatricula(matricula.getText());
				t.setActivo(true);
				t.setNumPlazas(Integer.parseInt(numPlazas.getText()));
				Controlador.getInstance().accion(ControladorImp.ALTA_AVION, t);
			}
			catch (Exception e) {
				resultado.setText("");
				resultado.append("Faltan datos o son incorrectos");
			}
		}
		
	}
}