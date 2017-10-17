package Presentacion.Billetes;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Negocio.Compra.imp.TransferBilletes;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.ControladorImp;

public class JFrameListaBilletes extends JFrame {
	
	private static final long serialVersionUID = 1L;
	JButton ok;
	JButton salir;
	JTextArea resultado;
	
	public JFrameListaBilletes () {
		super ("Lista Billetes");
		this.setLayout(new GridLayout (3, 1, 5, 5));
		this.setSize(500, 300);
		this.setLocation(500, 300);
		
		ok = new JButton ("Mostrar");
		salir = new JButton ("Salir");
		resultado = new JTextArea();
		resultado.setEditable(false);
		JScrollPane scroll = new JScrollPane(resultado);
		
		ok.addActionListener(new ActionListenerListaBilletes());
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				resultado.setText("");
				Controlador.getInstance().accion(ControladorImp.SALIR_OPERACIONES_BILLETE, null);
				
			}
			
		});
		this.add(scroll);
		this.add(ok);
		this.add(salir);
	}
	
	public void update (Object datos) {
		resultado.setText("");
		@SuppressWarnings("unchecked")
		ArrayList<TransferBilletes> lista = (ArrayList<TransferBilletes>) datos;
		if (lista == null) {
			resultado.append("No existen billetes");
		}
		else {
			for (TransferBilletes t: lista) {
				resultado.append(t.toString() + System.getProperty("line.separator") + System.getProperty("line.separator"));
			}
		}
	}
	
	public class ActionListenerListaBilletes implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Controlador.getInstance().accion(ControladorImp.LISTA_BILLETES, null);
		}
		
	}
}