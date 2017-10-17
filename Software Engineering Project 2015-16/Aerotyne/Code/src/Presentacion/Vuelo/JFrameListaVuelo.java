package Presentacion.Vuelo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Negocio.Vuelo.imp.TransferVuelo;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.ControladorImp;

@SuppressWarnings("serial")
public class JFrameListaVuelo extends JFrame {
	
	JButton ok;
	JButton salir;
	JTextArea resultado;
	
	public JFrameListaVuelo () {
		super ("Lista Vuelo");
		this.setLayout(new GridLayout (3, 1, 5, 5));
		this.setSize(500, 300);
		
		ok = new JButton ("Mostrar");
		salir = new JButton ("Salir");
		resultado = new JTextArea();
		resultado.setEditable(false);
		JScrollPane scroll = new JScrollPane(resultado);
		
		ok.addActionListener(new ActionListenerListaVuelo());
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				resultado.setText("");
				Controlador.getInstance().accion(ControladorImp.SALIR_OPERACIONES_VUELO, null);
				
			}
			
		});
		
		this.add(scroll);
		this.add(ok);
		this.add(salir);
		
	}
	
	public void update (Object datos) {
		resultado.setText("");
		@SuppressWarnings("unchecked")
		ArrayList<TransferVuelo> lista = (ArrayList<TransferVuelo>) datos;
		if (lista == null) {
			resultado.append("No existen vuelos");
		}
		else {
			for (TransferVuelo t: lista) {
				resultado.append(t.toString() + System.getProperty("line.separator") + System.getProperty("line.separator"));
			}
		}
	}
	
	public class ActionListenerListaVuelo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Controlador.getInstance().accion(ControladorImp.LISTA_VUELO, null);
		}
		
	}
}