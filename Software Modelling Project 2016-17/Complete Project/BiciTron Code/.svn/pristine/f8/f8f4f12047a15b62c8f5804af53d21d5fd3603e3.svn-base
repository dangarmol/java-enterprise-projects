package presentacion.vistas.vistaDepartamento.departamento;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import negocio.departamento.imp.TransferDepartamento;
import presentacion.ListaComandos;
import presentacion.controlador.Controlador;

public class JFrameAltaDepartamento extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JTextField nombre;
	private JTextField descripcion;
	private JButton enviar;
	private JButton salir;
	
	public JFrameAltaDepartamento() 
	{
		this.setTitle("Alta departamento");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent evt) 
			{
				cerrar();
			}
		});

		JPanel buttonPanel = new JPanel(new GridLayout(4, 1));

		nombre = new JTextField("Nombre");
		descripcion = new JTextField("Descripcion");
		enviar = new JButton("Enviar");
		salir = new JButton("Salir");

		nombre.setPreferredSize(new Dimension(320, 35));

		enviar.addActionListener(new ActionListenerAltaCliente());

		salir.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				cerrar();
			}
		});

		buttonPanel.add(nombre);
		buttonPanel.add(descripcion);
		buttonPanel.add(enviar);
		buttonPanel.add(salir);
		this.getContentPane().add(buttonPanel);
		this.pack();
	}

	public class ActionListenerAltaCliente implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			Controlador.getInstance().accion(ListaComandos.NEGOCIOALTADEPARTAMENTO, new TransferDepartamento(nombre.getText(), descripcion.getText(), true));
		}
	}

	public void cerrar() 
	{
		nombre.setText("Nombre");
		descripcion.setText("Descripcion");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANABOTONERADEPARTAMENTO, null);
	}
}