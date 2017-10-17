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
import negocio.bicicleta.imp.TransferBicicletaCarretera;
import presentacion.ListaComandos;
import presentacion.controlador.Controlador;

public class JFrameAltaBicicletaCarretera extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField material;
	private JTextField marca;
	private JTextField precio;
	private JTextField velocidadMaxima;
	private JButton enviar;
	private JButton salir;

	public JFrameAltaBicicletaCarretera() 
	{
		this.setTitle("Alta bicicleta carretera");
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

		material = new JTextField("Material bicicleta");
		marca = new JTextField("Marca bicicleta");
		precio = new JTextField("Precio bicicleta");
		velocidadMaxima = new JTextField("Velocidad maxima bicicleta");
		enviar = new JButton("Enviar");
		salir = new JButton("Salir");

		material.setPreferredSize(new Dimension(320, 35));

		enviar.addActionListener(new ActionListenerAltaBicicletaCarretera());

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
		buttonPanel.add(velocidadMaxima);
		buttonPanel.add(enviar);
		buttonPanel.add(salir);
		this.getContentPane().add(buttonPanel);
		this.pack();
	}

	public class ActionListenerAltaBicicletaCarretera implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			try {
				Controlador.getInstance().accion(
						ListaComandos.NEGOCIOALTABICICLETA,
						new TransferBicicletaCarretera(material.getText(),
								marca.getText(), Double.parseDouble(precio
										.getText()), Integer
										.parseInt(velocidadMaxima.getText()),
								true));
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,
						"Formato bicicleta no correcto", "Informacion",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public void cerrar() {
		material.setText("Nombre bicicleta");
		marca.setText("Marca bicicleta");
		precio.setText("Precio bicicleta");
		velocidadMaxima.setText("Velocidad maxima bicicleta");
		this.setVisible(false);
		Controlador.getInstance().accion(
				ListaComandos.VENTANABOTONERABICICLETA, null);
	}
}