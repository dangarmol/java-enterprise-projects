package main;

import presentacion.ListaComandos;
import presentacion.controlador.Controlador;

public class Main
{
	public static void main(String[] args) 
	{
		Controlador.getInstance().accion(ListaComandos.VENTANAPRINCIPAL, null);
	}
}