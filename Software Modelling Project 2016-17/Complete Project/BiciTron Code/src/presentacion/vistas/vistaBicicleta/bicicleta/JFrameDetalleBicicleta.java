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
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import negocio.bicicleta.imp.TransferBicicleta;
import presentacion.ListaComandos;
import presentacion.controlador.Controlador;

public class JFrameDetalleBicicleta extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JTextField id;
	private JTextArea mostrar;
	private JButton enviar;
	private JButton salir;

	public JFrameDetalleBicicleta()
	{
		this.setTitle("Detalle bicicleta");
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

		id = new JTextField("Id bicicleta");
		mostrar = new JTextArea("Detalle bicicleta");
		enviar = new JButton("Enviar");
		salir = new JButton("Salir");

		mostrar.setWrapStyleWord(true);
		mostrar.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(mostrar);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		id.setPreferredSize(new Dimension(800, 35));

		enviar.addActionListener(new ActionListenerDetalleBicicleta());

		salir.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cerrar();
			}
		});

		buttonPanel.add(scrollPane);
		buttonPanel.add(id);
		buttonPanel.add(enviar);
		buttonPanel.add(salir);
		this.getContentPane().add(buttonPanel);
		this.pack();
	}

	public class ActionListenerDetalleBicicleta implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			try 
			{
				Controlador.getInstance().accion(ListaComandos.NEGOCIODETALLEBICICLETA, Integer.parseInt(id.getText()));
			}
			catch (NumberFormatException e) 
			{
				JOptionPane.showMessageDialog(null, "Formato bicicleta no correcto", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public void setAreaDetalle(TransferBicicleta bicicleta) 
	{
		mostrar.setText(bicicleta.toString());
	}

	public void cerrar() 
	{
		id.setText("Id bicicleta");
		mostrar.setText("Detalle bicicleta");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANABOTONERABICICLETA, null);
	}
}