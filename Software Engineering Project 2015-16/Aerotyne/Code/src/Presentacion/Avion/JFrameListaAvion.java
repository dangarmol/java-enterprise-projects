package Presentacion.Avion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Negocio.Avion.imp.TransferAvion;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.ControladorImp;

@SuppressWarnings("serial")
public class JFrameListaAvion extends JFrame {
	
	JButton ok;
	JButton salir;
	JTextArea resultado;
	
	public JFrameListaAvion () {
		super ("Lista Avion");
		this.setLayout(new GridLayout (3, 1, 5, 5));
		this.setSize(500, 300);
		
		ok = new JButton ("Mostrar");
		salir = new JButton ("Salir");
		resultado = new JTextArea();
		resultado.setEditable(false);
		JScrollPane scroll = new JScrollPane(resultado);
		
		ok.addActionListener(new ActionListenerListaAvion());
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				resultado.setText("");
				Controlador.getInstance().accion(ControladorImp.SALIR_OPERACIONES_AVION, null);
				
			}
			
		});
		
		this.add(scroll);
		this.add(ok);
		this.add(salir);
		
	}
	
	public void update (Object datos) {
		resultado.setText("");
		@SuppressWarnings("unchecked")
		ArrayList<TransferAvion> lista = (ArrayList<TransferAvion>) datos;
		if (lista == null) {
			resultado.append("No existen aviones");
		}
		else {
			for (TransferAvion t: lista) {
				resultado.append(t.toString() + System.getProperty("line.separator") + System.getProperty("line.separator"));
			}
		}
	}
	
	public class ActionListenerListaAvion implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Controlador.getInstance().accion(ControladorImp.LISTA_AVION, null);
		}
		
	}
}