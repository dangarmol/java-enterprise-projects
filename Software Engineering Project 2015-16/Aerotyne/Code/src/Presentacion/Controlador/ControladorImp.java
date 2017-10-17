package Presentacion.Controlador;

import java.util.ArrayList;

import Negocio.Aeropuerto.imp.TransferAeropuerto;
import Negocio.Aeropuerto.imp.TransferAeropuertoNoSeguro;
import Negocio.Aeropuerto.imp.TransferAeropuertoSeguro;
import Negocio.Avion.imp.TransferAvion;
import Negocio.Compra.imp.TransferBilletes;
import Negocio.Compra.imp.TransferCompra;
import Negocio.InstanciaDeVuelo.imp.TransferInstanciaDeVuelo;
import Negocio.Vuelo.imp.TransferVuelo;
import Negocio.factory.FactoryServicioAplicacion;
import Presentacion.Vistas.vistaAeropuerto.VistaAeropuerto;
import Presentacion.Vistas.vistaAeropuerto.VistaAeropuertoImp;
import Presentacion.Vistas.vistaAvion.VistaAvion;
import Presentacion.Vistas.vistaAvion.VistaAvionImp;
import Presentacion.Vistas.vistaBillete.VistaBillete;
import Presentacion.Vistas.vistaBillete.VistaBilleteImp;
import Presentacion.Vistas.vistaInstanciaDeVuelo.VistaInstanciaDeVuelo;
import Presentacion.Vistas.vistaInstanciaDeVuelo.VistaInstanciaDeVueloImp;
import Presentacion.Vistas.vistaPrincipal.VistaPrincipal;
import Presentacion.Vistas.vistaPrincipal.VistaPrincipalImp;
import Presentacion.Vistas.vistaVuelo.VistaVuelo;
import Presentacion.Vistas.vistaVuelo.VistaVueloImp;

public class ControladorImp extends Controlador {
	public final static int ALTA_AEROPUERTO_SEGURO = 1;
	public final static int ALTA_AEROPUERTO_NO_SEGURO = 61;
	public final static int BAJA_AEROPUERTO = 2;
	public final static int MODIFICAR_AEROPUERTO_SEGURO = 3;
	public final static int MODIFICAR_AEROPUERTO_NO_SEGURO = 62;
	public final static int LISTA_AEROPUERTO = 4; 
	public final static int DETALLE_AEROPUERTO = 63;
	public final static int VOLVER_AEROPUERTO = 64;
	public final static int ALTA_AVION = 5;  
	public final static int MODIFICAR_AVION = 6;
	public final static int BAJA_AVION = 7;   
	public final static int LISTA_AVION = 8;
	public final static int DETALLE_AVION = 9;  
	public final static int VOLVER_AVION = 66; 
	public final static int ALTA_INSTANCIA_VUELO = 10; 
	public final static int MODIFICAR_INSTANCIA_VUELO = 11;  
	public final static int BAJA_INSTANCIA_VUELO = 12;  
	public final static int LISTA_INSTANCIA_VUELO = 13;  
	public final static int DETALLE_INSTANCIA_VUELO = 14;   
	public final static int VOLVER_INSTANCIA_VUELO = 68;
	public final static int ALTA_VUELO = 15;  
	public final static int MODIFICAR_VUELO = 16;  
	public final static int BAJA_VUELO = 17;  
	public final static int LISTA_VUELO = 18;  
	public final static int DETALLE_VUELO = 19;
	public final static int VOLVER_VUELO = 67;
	public final static int INICIAR_COMPRA = 20;
	public final static int AÑADIR_BILLETE = 21;  
	public final static int ELIMINAR_BILLETE_CARRO = 22;  
	public final static int CERRAR_COMPRA = 23;   
	public final static int MODIFICAR_BILLETE = 24;  
	public final static int ELIMINAR_BILLETE_BD = 25;  
	public final static int LISTA_BILLETES = 26;  
	public final static int DETALLE_BILLETE = 27;
	public final static int VOLVER_BILLETES = 99;
	public final static int SALIR_OPERACIONES_AEROPUERTO = 72;
	public final static int SALIR_OPERACIONES_VUELO = 73;
	public final static int SALIR_OPERACIONES_AVION = 74;
	public final static int SALIR_OPERACIONES_INSTANCIA_VUELO = 75;
	public final static int SALIR_OPERACIONES_BILLETE = 76;

	public final static int VISTA_ALTA_AEROPUERTO_SEGURO = 28; 
	public final static int VISTA_ALTA_AEROPUERTO_NO_SEGURO = 69; 
	public final static int VISTA_BAJA_AEROPUERTO = 29;
	public final static int VISTA_MODIFICAR_AEROPUERTO_SEGURO = 30;
	public final static int VISTA_MODIFICAR_AEROPUERTO_NO_SEGURO = 70; 
	public final static int VISTA_LISTA_AEROPUERTO = 31;  
	public final static int VISTA_DETALLE_AEROPUERTO = 71; 
	public final static int VISTA_ALTA_AVION = 32;  
	public final static int VISTA_MODIFICAR_AVION = 33;
	public final static int VISTA_BAJA_AVION = 34;   
	public final static int VISTA_LISTA_AVION = 35;
	public final static int VISTA_DETALLE_AVION = 36;  
	public final static int VISTA_ALTA_INSTANCIA_VUELO = 37; 
	public final static int VISTA_MODIFICAR_INSTANCIA_VUELO =38;  
	public final static int VISTA_BAJA_INSTANCIA_VUELO = 39;  
	public final static int VISTA_LISTA_INSTANCIA_VUELO = 40;  
	public final static int VISTA_DETALLE_INSTANCIA_VUELO = 41;    
	public final static int VISTA_ALTA_VUELO = 42;  
	public final static int VISTA_MODIFICAR_VUELO = 43;  
	public final static int VISTA_BAJA_VUELO = 44;  
	public final static int VISTA_LISTA_VUELO = 45;  
	public final static int VISTA_DETALLE_VUELO = 46;  
	public final static int VISTA_INICIAR_COMPRA = 47;
	public final static int VISTA_ANADIR_BILLETE = 48;  
	public final static int VISTA_ELIMINAR_BILLETE_CARRO = 49;  
	public final static int VISTA_BAJA_BILLETE = 120;  
	public final static int VISTA_CERRAR_COMPRA = 50;   
	public final static int VISTA_MODIFICAR_BILLETE = 51;  
	public final static int VISTA_ELIMINAR_BILLETE_BD = 52;  
	public final static int VISTA_LISTA_BILLETES = 53;  
	public final static int VISTA_DETALLE_BILLETE = 54;
	public final static int VISTA_ELIMINAR_BILLETE = 100;

	public final static int VISTA_AEROPUERTOS = 55; 
	public final static int VISTA_AVIONES = 56; 
	public final static int VISTA_VUELOS = 57; 
	public final static int VISTA_INSTANCIA_VUELOS = 58; 
	public final static int VISTA_BILLETES = 59; 
	public final static int VISTA_PRINCIPAL = 65;
	public final static int SALIR = 60; 
	
	@Override
	public void accion(int evento, Object datos) {
		int res;
		TransferAeropuerto tAeropuerto;
		TransferAvion tAvion;
		TransferInstanciaDeVuelo tInstancia;
		TransferVuelo tVuelo;
		TransferCompra tCompra;
		TransferBilletes tBillete;
		
		switch (evento) {
			case ALTA_AEROPUERTO_SEGURO:
				res = FactoryServicioAplicacion.getInstance().createSAAeropuerto().altaAeropuerto((TransferAeropuertoSeguro) datos);
				if (res == 0) {
					VistaAeropuerto.getInstance().update(VistaAeropuertoImp.FIN_ALTA_SEGURO,"El aeropuerto se ha anadido correctamente");
				}
				else {
					VistaAeropuerto.getInstance().update(VistaAeropuertoImp.FIN_ALTA_SEGURO,"No se ha podido anadir el aeropuerto");
				}
		 		break;
			case ALTA_AEROPUERTO_NO_SEGURO:
				res = FactoryServicioAplicacion.getInstance().createSAAeropuerto().altaAeropuerto((TransferAeropuertoNoSeguro) datos);
				if (res == 0) {
					VistaAeropuerto.getInstance().update(VistaAeropuertoImp.FIN_ALTA_NO_SEGURO,"El aeropuerto se ha anadido correctamente");
				}
				else {
					VistaAeropuerto.getInstance().update(VistaAeropuertoImp.FIN_ALTA_NO_SEGURO,"No se ha podido anadir el aeropuerto");
				}
		 		break;
			  case BAJA_AEROPUERTO:
				  tAeropuerto = (TransferAeropuerto) datos;
				  res = FactoryServicioAplicacion.getInstance().createSAAeropuerto().bajaAeropuerto(tAeropuerto.getId());
					if (res == 0) {
						VistaAeropuerto.getInstance().update(VistaAeropuertoImp.FIN_BAJA,"El aeropuerto se ha eliminado correctamente");
					}
					else {
						VistaAeropuerto.getInstance().update(VistaAeropuertoImp.FIN_BAJA,"No se ha podido eliminar el aeropuerto");
					}
			  	break;
			  case DETALLE_AEROPUERTO:
				  tAeropuerto = (TransferAeropuerto) datos;
				  tAeropuerto = FactoryServicioAplicacion.getInstance().createSAAeropuerto().detalleAeropuerto(tAeropuerto.getId());
				  VistaAeropuerto.getInstance().update(VistaAeropuertoImp.FIN_DETALLE, tAeropuerto);
				break;
			  case MODIFICAR_AEROPUERTO_SEGURO:
				  res = FactoryServicioAplicacion.getInstance().createSAAeropuerto().modificarAeropuerto((TransferAeropuertoSeguro) datos);
					if (res == 0) {
						VistaAeropuerto.getInstance().update(VistaAeropuertoImp.FIN_MODIFICAR_SEGURO,"El aeropuerto se ha modificado correctamente");
					}
					else {
						VistaAeropuerto.getInstance().update(VistaAeropuertoImp.FIN_MODIFICAR_SEGURO,"No se ha podido modificar el aeropuerto");
					}
			 	break;
			  case MODIFICAR_AEROPUERTO_NO_SEGURO:
				  res = FactoryServicioAplicacion.getInstance().createSAAeropuerto().modificarAeropuerto((TransferAeropuertoNoSeguro) datos);
					if (res == 0) {
						VistaAeropuerto.getInstance().update(VistaAeropuertoImp.FIN_MODIFICAR_NO_SEGURO,"El aeropuerto se ha modificado correctamente");
					}
					else {
						VistaAeropuerto.getInstance().update(VistaAeropuertoImp.FIN_MODIFICAR_NO_SEGURO,"No se ha podido modificar el aeropuerto");
					}
				 break;
			  case LISTA_AEROPUERTO:
				  ArrayList<TransferAeropuerto> listaAeropuerto;
				  listaAeropuerto = FactoryServicioAplicacion.getInstance().createSAAeropuerto().listaAeropuerto();
				  VistaAeropuerto.getInstance().update(VistaAeropuertoImp.FIN_LISTA, listaAeropuerto);
			 	break;
			 	///////////////////////////////////////////////////////////////////////
			  case ALTA_AVION:
					res = FactoryServicioAplicacion.getInstance().createSAAvion().altaAvion((TransferAvion) datos);
					if (res == 0) {
						VistaAvion.getInstance().update(VistaAvionImp.FIN_ALTA,"El avion se ha anadido correctamente");
					}
					else {
						VistaAvion.getInstance().update(VistaAvionImp.FIN_ALTA,"No se ha podido anadir el avion");
					}
			 		break;
			  case BAJA_AVION:
				  tAvion = (TransferAvion) datos;
				  res = FactoryServicioAplicacion.getInstance().createSAAvion().bajaAvion(tAvion.getId());
					if (res == 0) {
						VistaAvion.getInstance().update(VistaAvionImp.FIN_BAJA,"El avion se ha eliminado correctamente");
					}
					else {
						VistaAvion.getInstance().update(VistaAvionImp.FIN_BAJA,"No se ha podido eliminar el avion");
					}
			  	break;
			  case DETALLE_AVION:
				  tAvion = (TransferAvion) datos;
				  tAvion = FactoryServicioAplicacion.getInstance().createSAAvion().detalleAvion(tAvion.getId());
				  VistaAvion.getInstance().update(VistaAvionImp.FIN_DETALLE, tAvion);
				break;
			  case MODIFICAR_AVION:
				  res = FactoryServicioAplicacion.getInstance().createSAAvion().modificarAvion((TransferAvion) datos);
					if (res == 0) {
						VistaAvion.getInstance().update(VistaAvionImp.FIN_MODIFICAR,"El avion se ha modificado correctamente");
					}
					else {
						VistaAvion.getInstance().update(VistaAvionImp.FIN_MODIFICAR,"No se ha podido modificar el avion");
					}
			 	break;
			  case LISTA_AVION:
				  ArrayList<TransferAvion> listaAvion;
				  listaAvion = FactoryServicioAplicacion.getInstance().createSAAvion().listaAvion();
				  VistaAvion.getInstance().update(VistaAvionImp.FIN_LISTA, listaAvion);
			 	break;	
				 	//////////////////////////////////////////////////////////
			  case ALTA_INSTANCIA_VUELO:
				res = FactoryServicioAplicacion.getInstance().createSAInstanciaDeVuelo().altaInstanciaDeVuelo((TransferInstanciaDeVuelo) datos);
				if (res == 0) {
					VistaInstanciaDeVuelo.getInstance().update(VistaInstanciaDeVueloImp.FIN_ALTA,"La instancia se ha anadido correctamente");
				}
				else {
					VistaInstanciaDeVuelo.getInstance().update(VistaInstanciaDeVueloImp.FIN_ALTA,"No se ha podido anadir la instancia");
				}
		 		break;
			  case BAJA_INSTANCIA_VUELO:
				  tInstancia = (TransferInstanciaDeVuelo) datos;
				  res = FactoryServicioAplicacion.getInstance().createSAInstanciaDeVuelo().bajaInstanciaDeVuelo(tInstancia.getId());
					if (res == 0) {
						VistaInstanciaDeVuelo.getInstance().update(VistaInstanciaDeVueloImp.FIN_BAJA,"La instancia se ha eliminado correctamente");
					}
					else {
						VistaInstanciaDeVuelo.getInstance().update(VistaInstanciaDeVueloImp.FIN_BAJA,"No se ha podido eliminar la instancia");
					}
			  	break;
			  case DETALLE_INSTANCIA_VUELO:
				  tInstancia = (TransferInstanciaDeVuelo) datos;
				  tInstancia = FactoryServicioAplicacion.getInstance().createSAInstanciaDeVuelo().detalleInstanciaDeVuelo(tInstancia.getId());
				  VistaInstanciaDeVuelo.getInstance().update(VistaInstanciaDeVueloImp.FIN_DETALLE, tInstancia);
				break;
			  case MODIFICAR_INSTANCIA_VUELO:
				  res = FactoryServicioAplicacion.getInstance().createSAInstanciaDeVuelo().modificarInstanciaDeVuelo((TransferInstanciaDeVuelo) datos);
					if (res == 0) {
						VistaInstanciaDeVuelo.getInstance().update(VistaInstanciaDeVueloImp.FIN_MODIFICAR,"La instancia se ha modificado correctamente");
					}
					else {
						VistaInstanciaDeVuelo.getInstance().update(VistaInstanciaDeVueloImp.FIN_MODIFICAR,"No se ha podido modificar la instancia");
					}
			 	break;
			  case LISTA_INSTANCIA_VUELO:
				  ArrayList<TransferInstanciaDeVuelo> listaInstancia;
				  listaInstancia = FactoryServicioAplicacion.getInstance().createSAInstanciaDeVuelo().listaInstanciaDeVuelo();
				  VistaInstanciaDeVuelo.getInstance().update(VistaInstanciaDeVueloImp.FIN_LISTA, listaInstancia);
			 	break;
			  	//////////////////////////////////////////////////////////
			  case ALTA_VUELO:
					res = FactoryServicioAplicacion.getInstance().createSAVuelo().altaVuelo((TransferVuelo) datos);
					if (res == 0) {
						VistaVuelo.getInstance().update(VistaVueloImp.FIN_ALTA,"El vuelo se ha añadido correctamente");
					}
					else {
						VistaVuelo.getInstance().update(VistaVueloImp.FIN_ALTA,"No se ha podido añadir el vuelo");
					}
			 		break;
			  case BAJA_VUELO:
				  tVuelo = (TransferVuelo) datos;
				  res = FactoryServicioAplicacion.getInstance().createSAVuelo().bajaVuelo(tVuelo.getId());
					if (res == 0) {
						VistaVuelo.getInstance().update(VistaVueloImp.FIN_BAJA,"El vuelo se ha eliminado correctamente");
					}
					else {
						VistaVuelo.getInstance().update(VistaVueloImp.FIN_BAJA,"No se ha podido eliminar el vuelo");
					}
			  	break;
			  case DETALLE_VUELO:
				  tVuelo = (TransferVuelo) datos;
				  tVuelo = FactoryServicioAplicacion.getInstance().createSAVuelo().detalleVuelo(tVuelo.getId());
				  VistaVuelo.getInstance().update(VistaVueloImp.FIN_DETALLE, tVuelo);
				break;
			  case MODIFICAR_VUELO:
				  res = FactoryServicioAplicacion.getInstance().createSAVuelo().modificarVuelo((TransferVuelo) datos);
					if (res == 0) {
						VistaVuelo.getInstance().update(VistaVueloImp.FIN_MODIFICAR,"El vuelo se ha modificado correctamente");
					}
					else {
						VistaVuelo.getInstance().update(VistaVueloImp.FIN_MODIFICAR,"No se ha podido modificar el vuelo");
					}
			 	break;
			  case LISTA_VUELO:
				  ArrayList<TransferVuelo> listaVuelo;
				  listaVuelo = FactoryServicioAplicacion.getInstance().createSAVuelo().listaVuelo();
				  VistaVuelo.getInstance().update(VistaVueloImp.FIN_LISTA, listaVuelo);
			 	break;	
			  	//////////////////////////////////////////////////////////////////
			  case INICIAR_COMPRA:
				  tCompra = (TransferCompra) datos;
				  VistaBillete.getInstance().update(VistaBilleteImp.DESACTIVAR_VISTAS, null);
				  VistaBillete.getInstance().createJFrameGestionarBilletes();
				  VistaBillete.getInstance().update(VistaBilleteImp.ACTIVAR_GESTIONAR_BILLETES, tCompra);
				  
			  	break;
			  case CERRAR_COMPRA:
				  tCompra = (TransferCompra) datos;
				  res = FactoryServicioAplicacion.getInstance().createSABilletes().cerrarCompra(tCompra);
				  if (res == 0) {
					  VistaBillete.getInstance().update(VistaBilleteImp.MOSTRAR_FINAL_COMPRA, "Compra finalizada con éxito :)");
				  }
				  else if (res == 1) {
					  VistaBillete.getInstance().update(VistaBilleteImp.MOSTRAR_FINAL_COMPRA, "Compra finalizada. Algunos billetes no se han podido vender");
				  }
				  else {
					  VistaBillete.getInstance().update(VistaBilleteImp.MOSTRAR_FINAL_COMPRA, "No se ha podido vender ningún billete");
				  }
				  VistaBillete.getInstance().update(VistaBilleteImp.DESACTIVAR_VISTAS, null);
				  VistaBillete.getInstance().update(VistaBilleteImp.ACTIVAR_BOTONERA, null);
			  	break;
			  case MODIFICAR_BILLETE:
				  tBillete = (TransferBilletes) datos;
				  res = FactoryServicioAplicacion.getInstance().createSABilletes().modificarBillete(tBillete);
				  if (res == 0) {
					  VistaBillete.getInstance().update(VistaBilleteImp.FIN_MODIFICAR_BILLETES, "El billete se ha modificado correctamente");
				  }
				  else {
					  VistaBillete.getInstance().update(VistaBilleteImp.FIN_MODIFICAR_BILLETES, "No se ha podido modificar el billete");
				  }
				  
			  	break;
			  case ELIMINAR_BILLETE_BD:
				  tBillete = (TransferBilletes) datos;
				  res = FactoryServicioAplicacion.getInstance().createSABilletes().devolucionBillete(tBillete.getId());
				  if (res == 0) {
					  VistaBillete.getInstance().update(VistaBilleteImp.FIN_BAJA_BILLETES, "El billete se ha eliminado correctamente");
				  }
				  else {
					  VistaBillete.getInstance().update(VistaBilleteImp.FIN_BAJA_BILLETES, "No se ha podido eliminar el billete");
				  }
			  	break;
			  case LISTA_BILLETES:
				  ArrayList<TransferBilletes> listaBilletes;
				  listaBilletes = FactoryServicioAplicacion.getInstance().createSABilletes().listadoBillete();
				  VistaBillete.getInstance().update(VistaBilleteImp.FIN_LISTA_BILLETES, listaBilletes);
			  	break;
			  case DETALLE_BILLETE:
				  tBillete = (TransferBilletes) datos;
				  tBillete = FactoryServicioAplicacion.getInstance().createSABilletes().detalleBillete(tBillete.getId());
				  VistaBillete.getInstance().update(VistaBilleteImp.FIN_DETALLE_BILLETES, tBillete);
			  	break;
			  	//////////////////////////////////////////////////
			  case VISTA_ALTA_AEROPUERTO_SEGURO:
				  VistaAeropuerto.getInstance().update(VistaAeropuertoImp.DESACTIVAR_BOTONERA, null);
				  VistaAeropuerto.getInstance().createJFrameAltaAeropuertoSeguro();
				  VistaAeropuerto.getInstance().update(VistaAeropuertoImp.ACTIVAR_ALTA_SEGURO, null);
			  	break;
			  case VISTA_ALTA_AEROPUERTO_NO_SEGURO:
				  VistaAeropuerto.getInstance().update(VistaAeropuertoImp.DESACTIVAR_BOTONERA, null);
				  VistaAeropuerto.getInstance().createJFrameAltaAeropuertoNoSeguro();
				  VistaAeropuerto.getInstance().update(VistaAeropuertoImp.ACTIVAR_ALTA_NO_SEGURO, null);
			  	break;
			  case VISTA_BAJA_AEROPUERTO:
				  VistaAeropuerto.getInstance().update(VistaAeropuertoImp.DESACTIVAR_BOTONERA, null);
				  VistaAeropuerto.getInstance().createJFrameBajaAeropuerto();
				  VistaAeropuerto.getInstance().update(VistaAeropuertoImp.ACTIVAR_BAJA, null);
			  	break;
			  case VISTA_MODIFICAR_AEROPUERTO_SEGURO:
				  VistaAeropuerto.getInstance().update(VistaAeropuertoImp.DESACTIVAR_BOTONERA, null);
				  VistaAeropuerto.getInstance().createJFrameModificarAeropuertoSeguro();
				  VistaAeropuerto.getInstance().update(VistaAeropuertoImp.ACTIVAR_MODIFICAR_SEGURO, null);
			  	break;
			  case VISTA_MODIFICAR_AEROPUERTO_NO_SEGURO:
				  VistaAeropuerto.getInstance().update(VistaAeropuertoImp.DESACTIVAR_BOTONERA, null);
				  VistaAeropuerto.getInstance().createJFrameModificarAeropuertoNoSeguro();
				  VistaAeropuerto.getInstance().update(VistaAeropuertoImp.ACTIVAR_MODIFICAR_NO_SEGURO, null);
			  	break;
			  case VISTA_LISTA_AEROPUERTO:
				  VistaAeropuerto.getInstance().update(VistaAeropuertoImp.DESACTIVAR_BOTONERA, null);
				  VistaAeropuerto.getInstance().createJFrameListaAeropuerto();
				  VistaAeropuerto.getInstance().update(VistaAeropuertoImp.ACTIVAR_LISTA, null);
			  	break;
			  case VISTA_DETALLE_AEROPUERTO:
				  VistaAeropuerto.getInstance().update(VistaAeropuertoImp.DESACTIVAR_BOTONERA, null);
				  VistaAeropuerto.getInstance().createJFrameDetalleAeropuerto();
				  VistaAeropuerto.getInstance().update(VistaAeropuertoImp.ACTIVAR_DETALLE, null);
			  	break;
			  case SALIR_OPERACIONES_AEROPUERTO:
				  VistaAeropuerto.getInstance().update(VistaAeropuertoImp.DESACTIVAR_VISTAS, null);
				  VistaAeropuerto.getInstance().update(VistaAeropuertoImp.ACTIVAR_BOTONERA, null);
				break;
			  case VISTA_ALTA_AVION:
				  VistaAvion.getInstance().update(VistaAvionImp.DESACTIVAR_BOTONERA, null);
				  VistaAvion.getInstance().createJFrameAltaAvion();
				  VistaAvion.getInstance().update(VistaAvionImp.ACTIVAR_ALTA, null);
			  	break;
			  case VISTA_BAJA_AVION:
				  VistaAvion.getInstance().update(VistaAvionImp.DESACTIVAR_BOTONERA, null);
				  VistaAvion.getInstance().createJFrameBajaAvion();
				  VistaAvion.getInstance().update(VistaAvionImp.ACTIVAR_BAJA, null);
			  	break;
			  case VISTA_MODIFICAR_AVION:
				  VistaAvion.getInstance().update(VistaAvionImp.DESACTIVAR_BOTONERA, null);
				  VistaAvion.getInstance().createJFrameModificarAvion();
				  VistaAvion.getInstance().update(VistaAvionImp.ACTIVAR_MODIFICAR, null);
			  	break;
			  case VISTA_LISTA_AVION:
				  VistaAvion.getInstance().update(VistaAvionImp.DESACTIVAR_BOTONERA, null);
				  VistaAvion.getInstance().createJFrameListaAvion();
				  VistaAvion.getInstance().update(VistaAvionImp.ACTIVAR_LISTA, null);
			  	break;
			  case VISTA_DETALLE_AVION:
				  VistaAvion.getInstance().update(VistaAvionImp.DESACTIVAR_BOTONERA, null);
				  VistaAvion.getInstance().createJFrameDetalleAvion();
				  VistaAvion.getInstance().update(VistaAvionImp.ACTIVAR_DETALLE, null);
			  	break;
			  case SALIR_OPERACIONES_AVION:
				  VistaAvion.getInstance().update(VistaAvionImp.DESACTIVAR_VISTAS, null);
				  VistaAvion.getInstance().update(VistaAvionImp.ACTIVAR_BOTONERA, null);
				break;
			  case VISTA_ALTA_INSTANCIA_VUELO:
				  VistaInstanciaDeVuelo.getInstance().update(VistaAvionImp.DESACTIVAR_BOTONERA, null);
				  VistaInstanciaDeVuelo.getInstance().createJFrameAltaInstanciaDeVuelo();
				  VistaInstanciaDeVuelo.getInstance().update(VistaInstanciaDeVueloImp.ACTIVAR_ALTA, null);
			  	break;
			  case VISTA_BAJA_INSTANCIA_VUELO:
				  VistaInstanciaDeVuelo.getInstance().update(VistaAvionImp.DESACTIVAR_BOTONERA, null);
				  VistaInstanciaDeVuelo.getInstance().createJFrameBajaInstanciaDeVuelo();
				  VistaInstanciaDeVuelo.getInstance().update(VistaInstanciaDeVueloImp.ACTIVAR_BAJA, null);
			  	break;
			  case VISTA_MODIFICAR_INSTANCIA_VUELO:
				  VistaInstanciaDeVuelo.getInstance().update(VistaAvionImp.DESACTIVAR_BOTONERA, null);
				  VistaInstanciaDeVuelo.getInstance().createJFrameModificarInstanciaDeVuelo();
				  VistaInstanciaDeVuelo.getInstance().update(VistaInstanciaDeVueloImp.ACTIVAR_MODIFICAR, null);
			  	break;
			  case VISTA_LISTA_INSTANCIA_VUELO:
				  VistaInstanciaDeVuelo.getInstance().update(VistaAvionImp.DESACTIVAR_BOTONERA, null);
				  VistaInstanciaDeVuelo.getInstance().createJFrameListaInstanciaDeVuelo();
				  VistaInstanciaDeVuelo.getInstance().update(VistaInstanciaDeVueloImp.ACTIVAR_LISTA, null);
			  	break;
			  case VISTA_DETALLE_INSTANCIA_VUELO:
				  VistaInstanciaDeVuelo.getInstance().update(VistaAvionImp.DESACTIVAR_BOTONERA, null);
				  VistaInstanciaDeVuelo.getInstance().createJFrameDetalleInstanciaDeVuelo();
				  VistaInstanciaDeVuelo.getInstance().update(VistaInstanciaDeVueloImp.ACTIVAR_DETALLE, null);
			  	break;
			  case SALIR_OPERACIONES_INSTANCIA_VUELO:
				  VistaInstanciaDeVuelo.getInstance().update(VistaInstanciaDeVueloImp.DESACTIVAR_VISTAS, null);
				  VistaInstanciaDeVuelo.getInstance().update(VistaInstanciaDeVueloImp.ACTIVAR_BOTONERA, null);
				break;
			  case VISTA_ALTA_VUELO:
				  VistaVuelo.getInstance().update(VistaAvionImp.DESACTIVAR_BOTONERA, null);
				  VistaVuelo.getInstance().createJFrameAltaVuelo();
				  VistaVuelo.getInstance().update(VistaVueloImp.ACTIVAR_ALTA, null);
			  	break;
			  case VISTA_BAJA_VUELO:
				  VistaVuelo.getInstance().update(VistaAvionImp.DESACTIVAR_BOTONERA, null);
				  VistaVuelo.getInstance().createJFrameBajaVuelo();
				  VistaVuelo.getInstance().update(VistaVueloImp.ACTIVAR_BAJA, null);
			  	break;
			  case VISTA_MODIFICAR_VUELO:
				  VistaVuelo.getInstance().update(VistaAvionImp.DESACTIVAR_BOTONERA, null);
				  VistaVuelo.getInstance().createJFrameModificarVuelo();
				  VistaVuelo.getInstance().update(VistaVueloImp.ACTIVAR_MODIFICAR, null);
			  	break;
			  case VISTA_LISTA_VUELO:
				  VistaVuelo.getInstance().update(VistaAvionImp.DESACTIVAR_BOTONERA, null);
				  VistaVuelo.getInstance().createJFrameListaVuelo();
				  VistaVuelo.getInstance().update(VistaVueloImp.ACTIVAR_LISTA, null);
			  	break;
			  case VISTA_DETALLE_VUELO:
				  VistaVuelo.getInstance().update(VistaAvionImp.DESACTIVAR_BOTONERA, null);
				  VistaVuelo.getInstance().createJFrameDetalleVuelo();
				  VistaVuelo.getInstance().update(VistaVueloImp.ACTIVAR_DETALLE, null);
			  	break;
			  case SALIR_OPERACIONES_VUELO:
				  VistaVuelo.getInstance().update(VistaVueloImp.DESACTIVAR_VISTAS, null);
				  VistaVuelo.getInstance().update(VistaVueloImp.ACTIVAR_BOTONERA, null);
				break;
			  case VISTA_INICIAR_COMPRA:
				  VistaBillete.getInstance().update(VistaBilleteImp.DESACTIVAR_BOTONERA, null);
				  VistaBillete.getInstance().createJFrameIniciarCompra();
				  VistaBillete.getInstance().update(VistaBilleteImp.ACTIVAR_INICIAR_COMPRA, null);
			  	break;
			  case VISTA_BAJA_BILLETE:
				  VistaBillete.getInstance().update(VistaBilleteImp.DESACTIVAR_BOTONERA, null);
				  VistaBillete.getInstance().createJFrameBajaBilletes();
				  VistaBillete.getInstance().update(VistaBilleteImp.ACTIVAR_BAJA_BILLETES, null);
				break;
			  case VISTA_MODIFICAR_BILLETE:
				  VistaBillete.getInstance().update(VistaBilleteImp.DESACTIVAR_BOTONERA, null);
				  VistaBillete.getInstance().createJFrameModificarBilletes();
				  VistaBillete.getInstance().update(VistaBilleteImp.ACTIVAR_MODIFICAR_BILLETE, null);
			  	break;
			  case VISTA_LISTA_BILLETES:
				  VistaBillete.getInstance().update(VistaBilleteImp.DESACTIVAR_BOTONERA, null);
				  VistaBillete.getInstance().createJFrameListaBilletes();
				  VistaBillete.getInstance().update(VistaBilleteImp.ACTIVAR_LISTA_BILLETES, null);
			  	break;
			  case VISTA_DETALLE_BILLETE:
				  VistaBillete.getInstance().update(VistaBilleteImp.DESACTIVAR_BOTONERA, null);
				  VistaBillete.getInstance().createJFrameDetalleBilletes();
				  VistaBillete.getInstance().update(VistaBilleteImp.ACTIVAR_DETALLE_BILLETE, null);
			  	break;
			  case SALIR_OPERACIONES_BILLETE:
				  VistaBillete.getInstance().update(VistaBilleteImp.DESACTIVAR_VISTAS, null);
				  VistaBillete.getInstance().update(VistaBilleteImp.ACTIVAR_BOTONERA, null);
				break;
			  case VISTA_AEROPUERTOS:
				  VistaPrincipal.getInstance().update(VistaPrincipalImp.DESACTIVAR);
				  VistaAeropuerto.getInstance().createJFrameBotoneraAeropuerto();
				  VistaAeropuerto.getInstance().update(VistaAeropuertoImp.ACTIVAR_BOTONERA, null);
			  	break;
			  case VOLVER_AEROPUERTO:
				  VistaAeropuerto.getInstance().update(VistaAeropuertoImp.DESACTIVAR_BOTONERA, null);
				  VistaPrincipal.getInstance().update(VistaPrincipalImp.ACTIVAR);
			  	break;
			  case VISTA_AVIONES:
				  VistaPrincipal.getInstance().update(VistaPrincipalImp.DESACTIVAR);
				  VistaAvion.getInstance().createJFrameBotoneraAvion();
				  VistaAvion.getInstance().update(VistaAvionImp.ACTIVAR_BOTONERA, null);
				break;
			  case VOLVER_AVION:
				  VistaAvion.getInstance().update(VistaAvionImp.DESACTIVAR_BOTONERA, null);
				  VistaPrincipal.getInstance().update(VistaPrincipalImp.ACTIVAR);
			  	break;
			  case VISTA_VUELOS:
				  VistaPrincipal.getInstance().update(VistaPrincipalImp.DESACTIVAR);
				  VistaVuelo.getInstance().createJFrameBotoneraVuelo();
				  VistaVuelo.getInstance().update(VistaVueloImp.ACTIVAR_BOTONERA, null);
			  	break;
			  case VOLVER_VUELO:
				  VistaVuelo.getInstance().update(VistaVueloImp.DESACTIVAR_BOTONERA, null);
				  VistaPrincipal.getInstance().update(VistaPrincipalImp.ACTIVAR);
				break;
			  case VISTA_INSTANCIA_VUELOS:
				  VistaPrincipal.getInstance().update(VistaPrincipalImp.DESACTIVAR);
				  VistaInstanciaDeVuelo.getInstance().createJFrameBotoneraInstanciaDeVuelo();
				  VistaInstanciaDeVuelo.getInstance().update(VistaInstanciaDeVueloImp.ACTIVAR_BOTONERA, null);
			  	break;
			  case VOLVER_INSTANCIA_VUELO:
				  VistaInstanciaDeVuelo.getInstance().update(VistaInstanciaDeVueloImp.DESACTIVAR_BOTONERA, null);
				  VistaPrincipal.getInstance().update(VistaPrincipalImp.ACTIVAR);
				break;
			  case VISTA_BILLETES:
				  VistaPrincipal.getInstance().update(VistaPrincipalImp.DESACTIVAR);
				  VistaBillete.getInstance().createJFrameBotoneraBilletes();
				  VistaBillete.getInstance().update(VistaBilleteImp.ACTIVAR_BOTONERA, null);
				break;
			  case VOLVER_BILLETES:
				  VistaBillete.getInstance().update(VistaBilleteImp.DESACTIVAR_BOTONERA, null);
				  VistaPrincipal.getInstance().update(VistaPrincipalImp.ACTIVAR);
				  break;
			  case VISTA_PRINCIPAL:
				  VistaPrincipal.getInstance().createJFramePrincipal();
				  VistaPrincipal.getInstance().update(VistaPrincipalImp.ACTIVAR);
				break;
		}
	}
}