package presentacion.vistas.vistaCompra.compra;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import presentacion.ListaComandos;
import presentacion.controlador.Controlador;

public class JFrameIniciarCompra extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JTextField idCliente;
	private JButton enviar;
	private JButton salir;

	public JFrameIniciarCompra() 
	{
		this.setTitle("Iniciar Compra");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent evt) 
			{
				cerrar();
			}
		});

		JPanel buttonPanel = new JPanel(new GridLayout(3, 1));

		idCliente = new JTextField("Id cliente");
		enviar = new JButton("Enviar");
		salir = new JButton("Salir");

		idCliente.setPreferredSize(new Dimension(320, 35));

		enviar.addActionListener(new ActionListenerAltaCliente());

		salir.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				cerrar();
			}
		});

		buttonPanel.add(idCliente);
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
			try 
			{
				Controlador.getInstance().accion(ListaComandos.NEGOCIOGESTIONCARRITOCOMPRA, Integer.parseInt(idCliente.getText()));
			} 
			catch (NumberFormatException e) 
			{
				JOptionPane.showMessageDialog(null, "Formato cliente no correcto", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public void cerrarPorVista() 
	{
		idCliente.setText("Id cliente");
		this.setVisible(false);
	}

	public void cerrar() 
	{
		cerrarPorVista();
		Controlador.getInstance().accion(ListaComandos.VENTANABOTONERACOMPRA, null);
	}
}