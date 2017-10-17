package Integracion.InstanciaDeVuelo.imp;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import Integracion.InstanciaDeVuelo.DaoInstanciaDeVuelo;
import Negocio.InstanciaDeVuelo.imp.TransferInstanciaDeVuelo;

public class DaoInstanciaDeVueloImp implements DaoInstanciaDeVuelo {
	public boolean add(TransferInstanciaDeVuelo t) {
		if(t.getId() == -1)
		{
			int cont = 1;
			while(searchId(cont) != null)
			{
				cont++;
			}
			t.setId(cont);
		}
		String nombArch = "instancia" + t.getId() + ".txt";
		String infoToWrite = t.getId() + " " + t.getFecha() + " _END_ " + t.getAvion() + " " + t.getVuelo() + " " + t.getPlazasLibres() + " ";
		if(t.getActivo()) {
			infoToWrite += "ACTIVO";
		} else {
			infoToWrite += "NO_ACTIVO";
		}
		try {
			File archivo = new File(nombArch);
			FileWriter escribir = new FileWriter(archivo, true);
			escribir.write(infoToWrite);
			escribir.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public TransferInstanciaDeVuelo search(String fecha, int avion, int vuelo) {
		String nombArch;
		String textAdder;
		String auxEnd;
		int cont = 1;
		TransferInstanciaDeVuelo t = new TransferInstanciaDeVuelo();
		try {
			do {
				nombArch = "instancia" + cont + ".txt";
				File archivo = new File(nombArch);
				Scanner sc = new Scanner(archivo);
				t.setId(sc.nextInt());
				textAdder = "";
				auxEnd = sc.next();
				while(!auxEnd.equals("_END_"))
				{
					textAdder += auxEnd;
					auxEnd = sc.next();
					if(!auxEnd.equals("_END_"))
						textAdder += " ";
				}
				t.setFecha(textAdder);
				t.setAvion(sc.nextInt());
				t.setVuelo(sc.nextInt());
				t.setActivo(sc.next().equals("ACTIVO"));
				sc.close();
				cont++;
			} while (!t.getFecha().equals(fecha) || t.getAvion() != avion || t.getVuelo() != vuelo);
			return t;
		} catch (Exception e) {
			return null;
		}
	}

	public TransferInstanciaDeVuelo searchId(int id) {
		String nombArch = "instancia" + id + ".txt";
		String textAdder;
		String auxEnd;
		TransferInstanciaDeVuelo t = new TransferInstanciaDeVuelo();
		try {
			File archivo = new File(nombArch);
			Scanner sc = new Scanner(archivo);
			t.setId(sc.nextInt());
			textAdder = "";
			auxEnd = sc.next();
			while(!auxEnd.equals("_END_"))
			{
				textAdder += auxEnd;
				auxEnd = sc.next();
				if(!auxEnd.equals("_END_"))
					textAdder += " ";
			}
			t.setFecha(textAdder);
			t.setAvion(sc.nextInt());
			t.setVuelo(sc.nextInt());
			t.setPlazasLibres(sc.nextInt());
			t.setActivo(sc.next().equals("ACTIVO"));
			sc.close();
			return t;
		} catch (Exception e) {
			return null;
		}
	}

	public boolean update(TransferInstanciaDeVuelo t) {
		String nombArch = "instancia" + t.getId() + ".txt";
		try {
			File archivo = new File(nombArch);
			archivo.delete();
			return add(t);
		} catch (Exception e) {
			return false;
		}
	}
}