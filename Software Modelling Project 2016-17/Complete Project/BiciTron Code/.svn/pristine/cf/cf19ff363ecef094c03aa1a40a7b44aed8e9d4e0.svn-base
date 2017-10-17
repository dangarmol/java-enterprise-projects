package presentacion.vistas.vistaCompra.compra;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import negocio.compra.imp.TransferCompra;
import presentacion.ListaComandos;
import presentacion.controlador.Controlador;

public class JFrameDetalleCompra extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JTextArea mostrar;
	private JTextField id;
	private JButton enviar;
	private JButton salir;

	public JFrameDetalleCompra()
	{
		this.setTitle("Detalle Compra");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent evt)
			{
				cerrar();
			}
		});

		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));

		JPanel buttonPanel = new JPanel(new GridLayout(3, 1));

		mostrar = new JTextArea("Detalle compra");
		id = new JTextField("Id compra");
		enviar = new JButton("Enviar");
		salir = new JButton("Salir");

		mostrar.setRows(4);
		mostrar.setEditable(false);

		mostrar.setWrapStyleWord(true);
		mostrar.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(mostrar);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		enviar.setPreferredSize(new Dimension(800, 35));

		enviar.addActionListener(new ActionListenerDetalleCompra());

		salir.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cerrar();
			}
		});

		buttonPanel.add(id);
		buttonPanel.add(enviar);
		buttonPanel.add(salir);
		panelPrincipal.add(scrollPane);
		panelPrincipal.add(buttonPanel);
		this.getContentPane().add(panelPrincipal);
		this.pack();
	}

	public class ActionListenerDetalleCompra implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			try 
			{
				Controlador.getInstance().accion(ListaComandos.NEGOCIODETALLECOMPRA, Integer.parseInt(id.getText()));
			} 
			catch (NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Formato compra incorrecto", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public void setAreaDetalle(TransferCompra compra) 
	{
		mostrar.setText(compra.toString());
	}

	public void cerrar() 
	{
		id.setText("Id compra");
		mostrar.setText("Detalle compra");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANABOTONERACOMPRA, null);
	}
}
