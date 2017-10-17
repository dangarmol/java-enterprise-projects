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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.departamento.imp.TransferDepartamento;
import presentacion.ListaComandos;
import presentacion.controlador.Controlador;

public class JFrameModificarDepartamento extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JTextField id;
	private JTextField nombre;
	private JTextField descripcion;
	private JButton enviar;
	private JButton salir;
	
	public JFrameModificarDepartamento() 
	{
		this.setTitle("Modificar departamento");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent evt) 
			{
				cerrar();
			}
		});

		JPanel buttonPanel = new JPanel(new GridLayout(5, 1));

		id = new JTextField("Id");
		nombre = new JTextField("Nombre");
		descripcion = new JTextField("Descripcion");
		enviar = new JButton("Enviar");
		salir = new JButton("Salir");

		id.setPreferredSize(new Dimension(320, 35));

		enviar.addActionListener(new ActionListenerModificarCliente());

		salir.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				cerrar();
			}
		});

		buttonPanel.add(id);
		buttonPanel.add(nombre);
		buttonPanel.add(descripcion);
		buttonPanel.add(enviar);
		buttonPanel.add(salir);
		this.getContentPane().add(buttonPanel);
		this.pack();
	}

	public class ActionListenerModificarCliente implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			try 
			{
				Controlador.getInstance().accion(ListaComandos.NEGOCIOMODIFICARDEPARTAMENTO, new TransferDepartamento(Integer.parseInt(id.getText()), nombre.getText(), descripcion.getText(), true));
			} 
			catch (NumberFormatException e) 
			{
				JOptionPane.showMessageDialog(null, "Formato departamento no correcto", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public void cerrar()
	{
		id.setText("Id");
		nombre.setText("Nombre");
		descripcion.setText("Descripcion");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANABOTONERADEPARTAMENTO, null);
	}
}