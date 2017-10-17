package presentacion.vistas.vistaBicicleta.bicicleta;

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
import negocio.bicicleta.imp.TransferBicicletaMontana;
import presentacion.ListaComandos;
import presentacion.controlador.Controlador;

public class JFrameAltaBicicletaMontana extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JTextField material;
	private JTextField marca;
	private JTextField precio;
	private JTextField amortiguacion;
	private JButton enviar;
	private JButton salir;

	public JFrameAltaBicicletaMontana() 
	{
		this.setTitle("Alta bicicleta montaña");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent evt) 
			{
				cerrar();
			}
		});

		JPanel buttonPanel = new JPanel(new GridLayout(6, 1));

		material = new JTextField("Nombre bicicleta");
		marca = new JTextField("Marca bicicleta");
		precio = new JTextField("Precio bicicleta");
		amortiguacion = new JTextField("Amortiguacion bicicleta");
		enviar = new JButton("Enviar");
		salir = new JButton("Salir");

		material.setPreferredSize(new Dimension(320, 35));

		enviar.addActionListener(new ActionListenerAltaBicicletaMontana());

		salir.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				cerrar();
			}
		});

		buttonPanel.add(material);
		buttonPanel.add(marca);
		buttonPanel.add(precio);
		buttonPanel.add(amortiguacion);
		buttonPanel.add(enviar);
		buttonPanel.add(salir);
		this.getContentPane().add(buttonPanel);
		this.pack();
	}

	public class ActionListenerAltaBicicletaMontana implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			try 
			{
				Controlador.getInstance().accion(ListaComandos.NEGOCIOALTABICICLETA, new TransferBicicletaMontana(material.getText(), marca.getText(), Double.parseDouble(precio.getText()), amortiguacion.getText(), true));
			}
			catch (NumberFormatException e) 
			{
				JOptionPane.showMessageDialog(null, "Formato bicicleta no correcto", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void cerrar() 
	{
		material.setText("Nombre bicicleta");
		marca.setText("Marca bicicleta");
		precio.setText("Precio bicicleta");
		amortiguacion.setText("Amortiguacion bicicleta");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANABOTONERABICICLETA, null);
	}
}