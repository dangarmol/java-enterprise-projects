package presentacion.vistas.vistaCompra.compra;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import negocio.compra.imp.TransferCompra;
import presentacion.ListaComandos;
import presentacion.controlador.Controlador;

public class JFrameListaCompra extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JTextArea mostrar;
	private JButton enviar;
	private JButton salir;

	public JFrameListaCompra()
	{
		this.setTitle("Lista compra");
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

		JPanel buttonPanel = new JPanel(new GridLayout(2, 1));

		mostrar = new JTextArea("Lista compra");
		enviar = new JButton("Enviar");
		salir = new JButton("Salir");

		mostrar.setRows(8);
		mostrar.setEditable(false);

		mostrar.setWrapStyleWord(true);
		mostrar.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(mostrar);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		enviar.setPreferredSize(new Dimension(800, 35));

		enviar.addActionListener(new ActionListenerListaCompra());

		salir.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cerrar();
			}
		});

		buttonPanel.add(enviar);
		buttonPanel.add(salir);
		panelPrincipal.add(scrollPane);
		panelPrincipal.add(buttonPanel);
		this.getContentPane().add(panelPrincipal);
		this.pack();
	}

	public class ActionListenerListaCompra implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			Controlador.getInstance().accion(ListaComandos.NEGOCIOLISTACOMPRA, null);
		}
	}

	public void setAreaDetalle(ArrayList<TransferCompra> compra) 
	{
		String msg = "";

		for (int k = 0; k < compra.size(); ++k)
			msg += compra.get(k).toString() + "\n";

		mostrar.setText(msg);
	}

	public void cerrar() 
	{
		mostrar.setText("Lista compra");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANABOTONERACOMPRA, null);
	}
}