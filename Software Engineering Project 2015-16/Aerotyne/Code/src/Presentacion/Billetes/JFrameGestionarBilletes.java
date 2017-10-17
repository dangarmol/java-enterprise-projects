package Presentacion.Billetes;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import Negocio.Compra.imp.TransferBilletes;
import Negocio.Compra.imp.TransferCompra;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.ControladorImp;

@SuppressWarnings("serial")
public class JFrameGestionarBilletes extends JFrame {
	private JTextField nombrePasajero;
	private JTextField dniPasajero;
	private JTextField precio;
	private JTextField instanciaDeVuelo;
	private JTextField numeroBillete;
	private JButton agregar;
	private JButton eliminar;
	private JButton cerrarCompra;
	private JButton salir;
	private JTextArea billetes;
	private TransferCompra tCompra;
	private JButton okAgregar;
	private JButton okEliminar;
	private JButton salirAgregar;
	private JButton salirEliminar;
	private int numBilletes = 1;
	
	private JFrame anadirBillete;
	private JFrame eliminarBillete;
	
	public static final int ANADIR_BILLETE = 1;
	public static final int ELIMINAR_BILLETE = 2;
	public static final int CERRAR_COMPRA = 3;
	
	public JFrameGestionarBilletes () {
		super("Gestión de billetes");
		this.setSize(800, 800);
		
		this.agregar = new JButton ("Agregar Billete");
		this.eliminar = new JButton ("Eliminar Billete");
		this.cerrarCompra = new JButton ("Cerrar Compra");
		this.salir = new JButton ("Salir");
		this.billetes = new JTextArea ();
		JScrollPane scroll = new JScrollPane(billetes);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		this.salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				vaciar();
				billetes.setText("");
				numBilletes = 1;
				Controlador.getInstance().accion(ControladorImp.SALIR_OPERACIONES_BILLETE, null);
			}
			
		});
		this.agregar.addActionListener(new ActionListenerGestionarCompra(ANADIR_BILLETE));
		this.eliminar.addActionListener(new ActionListenerGestionarCompra(ELIMINAR_BILLETE));
		this.cerrarCompra.addActionListener(new ActionListenerGestionarCompra(CERRAR_COMPRA));
		
		this.setLayout(new GridLayout(5, 1, 5, 5));
		this.add(scroll);
		this.add(agregar);
		this.add(eliminar);
		this.add(cerrarCompra);
		this.add(salir);
		
	}
	
	public void update (Object datos) {
		this.tCompra = new TransferCompra();
		this.tCompra = (TransferCompra) datos;
	}
	
	public void mostrarMensaje(Object datos) {
		JOptionPane.showMessageDialog(this,(String) datos);
	}
	
	private void vaciar () {
		this.nombrePasajero.setText("");
		this.dniPasajero.setText("");
		this.precio.setText("");
		this.instanciaDeVuelo.setText("");
		//this.billetes.setText("");
		
	}
	
	private void createAnadirBillete () {
		if (anadirBillete == null) {
			anadirBillete = new JFrame ("Agregar Billete");
			anadirBillete.setSize(500, 500);
			
			JLabel nombreEt = new JLabel("Nombre Pasajero");
			JLabel dniEt = new JLabel ("DNI");
			JLabel instanciaEt = new JLabel("Instancia de vuelo");
			JLabel precioEt = new JLabel("Precio");
			this.nombrePasajero = new JTextField();
			this.dniPasajero = new JTextField();
			this.instanciaDeVuelo = new JTextField();
			this.precio = new JTextField();
			this.okAgregar = new JButton ("OK");
			this.okAgregar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
						if (nombrePasajero.getText().equals("")|| dniPasajero.getText().equals("") || instanciaDeVuelo.getText().equals("") || precio.getText().equals("")) {
							throw new Exception ();
						}
						TransferBilletes tBillete = new TransferBilletes();
						tBillete.setId(-1);
						tBillete.setNumBillete(numBilletes);
						tBillete.setNombre(nombrePasajero.getText());
						tBillete.setDni(dniPasajero.getText());
						tBillete.setActivo(true);
						tBillete.setInstanciaDeVuelo(Integer.parseInt(instanciaDeVuelo.getText()));
						tBillete.setPrecio(Double.parseDouble(precio.getText()));
						tCompra.setBillete(tBillete.getNumBillete(), tBillete);
						anadirBillete.setVisible(false);
						billetes.append("Billete añadido con éxito (billete " + numBilletes + ")" + System.getProperty("line.separator"));
						numBilletes++;
						vaciar();
					}
					catch (Exception e) {
						anadirBillete.setVisible(false);
						billetes.append("Faltan datos o son incorrectos" + System.getProperty("line.separator"));
						vaciar();
					}
					
				}
				
			});
			this.salirAgregar = new JButton ("Cancelar");
			this.salirAgregar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					vaciar();
					anadirBillete.setVisible(false);
					
				}
				
			});
			this.anadirBillete.setLayout(new GridLayout(5, 2, 5, 5));
			this.anadirBillete.add(nombreEt);
			this.anadirBillete.add(this.nombrePasajero);
			this.anadirBillete.add(dniEt);
			this.anadirBillete.add(this.dniPasajero);
			this.anadirBillete.add(instanciaEt);
			this.anadirBillete.add(this.instanciaDeVuelo);
			this.anadirBillete.add(precioEt);
			this.anadirBillete.add(this.precio);
			this.anadirBillete.add(this.okAgregar);
			this.anadirBillete.add(this.salirAgregar);
			
		} 
		this.anadirBillete.setVisible(true);
	}
	
	private void createEliminarBillete() {
		if (eliminarBillete == null) {
			eliminarBillete = new JFrame ("Eliminar billete");
			eliminarBillete.setSize(400, 400);
			
			JLabel numBilleteEt = new JLabel ("Número de billete");
			numeroBillete = new JTextField ();
			this.okEliminar = new JButton ("OK");
			this.okEliminar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
						TransferBilletes t;
						if (numeroBillete.getText().equals("")) {
							throw new Exception();
						}
						int num = Integer.parseInt(numeroBillete.getText());
						t = tCompra.removeBilleteId(num);
						if (t == null) {
							throw new Exception();
						}
						eliminarBillete.setVisible(false);
						billetes.append("Billete eliminado con éxito (billete " + num + ")" + System.getProperty("line.separator"));
						vaciar();
					}
					catch (Exception e) {
						vaciar();
						eliminarBillete.setVisible(false);
						billetes.append("No se ha podido eliminar ese billete" + System.getProperty("line.separator"));
					}
				}
				
			});
			this.salirEliminar = new JButton ("Cancelar");
			this.salirEliminar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					vaciar();
					eliminarBillete.setVisible(false);
					
				}
				
			});
			
			eliminarBillete.setLayout(new GridLayout (2, 2, 5, 5));
			
			eliminarBillete.add(numBilleteEt);
			eliminarBillete.add(numeroBillete);
			eliminarBillete.add(okEliminar);
			eliminarBillete.add(salirEliminar);
			
		}
		eliminarBillete.setVisible(true);
	}
	
	public class ActionListenerGestionarCompra implements ActionListener {
		
		private int accion;
		
		public ActionListenerGestionarCompra(int accion) {
			this.accion = accion;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			switch (this.accion) {
			case ANADIR_BILLETE:
				createAnadirBillete();
				break;
			case ELIMINAR_BILLETE:
				createEliminarBillete();
				break;
			case CERRAR_COMPRA:
				numBilletes = 1;
				Controlador.getInstance().accion(ControladorImp.CERRAR_COMPRA, tCompra);
				billetes.setText("");
				break;
			}
			
		}
	
	}
}