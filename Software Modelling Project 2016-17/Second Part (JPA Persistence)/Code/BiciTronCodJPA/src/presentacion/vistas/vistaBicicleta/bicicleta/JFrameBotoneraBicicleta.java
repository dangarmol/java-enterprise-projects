package presentacion.vistas.vistaBicicleta.bicicleta;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import presentacion.ListaComandos;
import presentacion.controlador.Controlador;

public class JFrameBotoneraBicicleta extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JButton altaBicicletaCarretera;
	private JButton altaBicicletaMontana;
	private JButton bajaBicicleta;
	private JButton detalleBicicleta;
	private JButton listaBicicleta;
	private JButton modificarBicicletaCarretera;
	private JButton modificarBicicletaMontana;
	private JButton cantidadBicicletas;
	private JButton salir;

	public JFrameBotoneraBicicleta() {
		this.setTitle("Botonera bicicleta");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				cerrarBotonera();
			}
		});

		JPanel buttonPanel = new JPanel(new GridLayout(9, 1));

		altaBicicletaCarretera = new JButton("Crear bicicleta carretera");
		altaBicicletaMontana = new JButton("Crear bicicleta montaña");
		bajaBicicleta = new JButton("Eliminar bicicleta");
		detalleBicicleta = new JButton("Detalle bicicleta");
		listaBicicleta = new JButton("Lista bicicleta");
		modificarBicicletaCarretera = new JButton(
				"Modificar bicicleta carretera");
		modificarBicicletaMontana = new JButton("Modificar bicicleta montaña");
		cantidadBicicletas = new JButton("Cantidad de bicicletas");
		salir = new JButton("Salir");

		altaBicicletaCarretera.setPreferredSize(new Dimension(320, 35));

		altaBicicletaCarretera
				.addActionListener(new ActionListenerBotoneraBicicleta(0));
		altaBicicletaMontana
				.addActionListener(new ActionListenerBotoneraBicicleta(1));
		bajaBicicleta.addActionListener(new ActionListenerBotoneraBicicleta(2));
		detalleBicicleta.addActionListener(new ActionListenerBotoneraBicicleta(
				3));
		listaBicicleta
				.addActionListener(new ActionListenerBotoneraBicicleta(4));
		modificarBicicletaCarretera
				.addActionListener(new ActionListenerBotoneraBicicleta(5));
		modificarBicicletaMontana
				.addActionListener(new ActionListenerBotoneraBicicleta(6));
		cantidadBicicletas
				.addActionListener(new ActionListenerBotoneraBicicleta(7));

		salir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cerrarBotonera();
			}
		});

		buttonPanel.add(altaBicicletaCarretera);
		buttonPanel.add(altaBicicletaMontana);
		buttonPanel.add(bajaBicicleta);
		buttonPanel.add(detalleBicicleta);
		buttonPanel.add(listaBicicleta);
		buttonPanel.add(modificarBicicletaCarretera);
		buttonPanel.add(modificarBicicletaMontana);
		buttonPanel.add(cantidadBicicletas);
		buttonPanel.add(salir);
		this.getContentPane().add(buttonPanel);
		this.pack();
	}

	public class ActionListenerBotoneraBicicleta implements ActionListener {
		private int event;

		public ActionListenerBotoneraBicicleta(int event) {
			this.event = event;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int comando = 0;

			switch (event) {
			case 0:
				comando = ListaComandos.VENTANAALTABICICLETACARRETERA;
				break;
			case 1:
				comando = ListaComandos.VENTANAALTABICICLETAMONTANA;
				break;
			case 2:
				comando = ListaComandos.VENTANABAJABICICLETA;
				break;
			case 3:
				comando = ListaComandos.VENTANADETALLEBICICLETA;
				break;
			case 4:
				comando = ListaComandos.VENTANALISTABICICLETA;
				break;
			case 5:
				comando = ListaComandos.VENTANAMODIFICARBICICLETACARRETERA;
				break;
			case 6:
				comando = ListaComandos.VENTANAMODIFICARBICICLETAMONTANA;
				break;
			case 7:
				comando = ListaComandos.VENTANACANTIDADBICICLETASQUERY;
				break;
			}

			cerrarParaVistaPropia();
			Controlador.getInstance().accion(comando, null);
		}
	}

	public void cerrarParaVistaPropia() {
		this.setVisible(false);
	}

	public void cerrarBotonera() {
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANAPRINCIPAL, null);
	}
}