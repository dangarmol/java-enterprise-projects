package Presentacion.Billetes;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.ControladorImp;

@SuppressWarnings("serial")
public class JFrameBotoneraBilletes extends JFrame {

	private JButton iniciarCompra;
	private JButton gestionBillete;
	private JButton detalleBillete;
	private JButton listaBillete;
	private JButton modificarBillete;
	private JButton salir;
	
	public JFrameBotoneraBilletes () {
		createVistaBotonera();
	}

	private void createVistaBotonera() {
		this.setSize(500, 300);

		iniciarCompra = new JButton("Iniciar compra");
		gestionBillete = new JButton ("Eliminar billete");
		detalleBillete = new JButton ("Detalle billete");
		listaBillete = new JButton ("Lista billetes");
		modificarBillete = new JButton ("Modificar billete");
		salir = new JButton ("Volver");
		
		iniciarCompra.addActionListener(new ActionListenerBotoneraAvion(ControladorImp.VISTA_INICIAR_COMPRA));
		gestionBillete.addActionListener(new ActionListenerBotoneraAvion(ControladorImp.VISTA_BAJA_BILLETE));
		detalleBillete.addActionListener(new ActionListenerBotoneraAvion(ControladorImp.VISTA_DETALLE_BILLETE));
		listaBillete.addActionListener(new ActionListenerBotoneraAvion(ControladorImp.VISTA_LISTA_BILLETES));
		modificarBillete.addActionListener(new ActionListenerBotoneraAvion(ControladorImp.VISTA_MODIFICAR_BILLETE));
		salir.addActionListener(new ActionListenerBotoneraAvion(ControladorImp.VOLVER_BILLETES));
		
		this.setLayout(new GridLayout(6, 1, 5, 5));
		this.add(iniciarCompra);
		this.add(gestionBillete);
		this.add(modificarBillete);
		this.add(detalleBillete);
		this.add(listaBillete);
		this.add(salir);
	}
	
	public class ActionListenerBotoneraAvion implements ActionListener {
		private int accion;
		public ActionListenerBotoneraAvion (int accion) {
			this.accion = accion;
		}
			
		@Override
		public void actionPerformed(ActionEvent e) {
			Controlador.getInstance().accion(this.accion, null);
			
		}
	}
}