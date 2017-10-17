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

public class JFrameModificarBicicletaMontana extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JTextField id;
	private JTextField material;
	private JTextField marca;
	private JTextField precio;
	private JTextField amortiguacion;
	private JButton enviar;
	private JButton salir;

	public JFrameModificarBicicletaMontana()
	{
		this.setTitle("Modificar bicicleta montaña");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent evt) 
			{
				cerrar();
			}
		});

		JPanel buttonPanel = new JPanel(new GridLayout(7, 1));

		id = new JTextField("Id bicicleta");
		material = new JTextField("Nombre bicicleta");
		marca = new JTextField("Marca bicicleta");
		precio = new JTextField("Precio bicicleta");
		amortiguacion = new JTextField("Amortiguacion bicicleta");
		enviar = new JButton("Enviar");
		salir = new JButton("Salir");

		id.setPreferredSize(new Dimension(320, 35));

		enviar.addActionListener(new ActionListenerModificarBicicletaMontana());

		salir.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cerrar();
			}
		});

		buttonPanel.add(id);
		buttonPanel.add(material);
		buttonPanel.add(marca);
		buttonPanel.add(precio);
		buttonPanel.add(amortiguacion);
		buttonPanel.add(enviar);
		buttonPanel.add(salir);
		this.getContentPane().add(buttonPanel);
		this.pack();
	}

	public class ActionListenerModificarBicicletaMontana implements	ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			try
			{
				Controlador.getInstance().accion(ListaComandos.NEGOCIOMODIFICARBICICLETA, new TransferBicicletaMontana(Integer.parseInt(id.getText()), material.getText(), marca.getText(), Double.parseDouble(precio.getText()), amortiguacion.getText(), true));
			} 
			catch (NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Formato bicicleta no correcto", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public void cerrar() 
	{
		id.setText("Id bicicleta");
		material.setText("Material bicicleta");
		marca.setText("Marca bicicleta");
		precio.setText("Precio bicicleta");
		amortiguacion.setText("Amortiguacion bicicleta");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANABOTONERABICICLETA, null);
	}
}