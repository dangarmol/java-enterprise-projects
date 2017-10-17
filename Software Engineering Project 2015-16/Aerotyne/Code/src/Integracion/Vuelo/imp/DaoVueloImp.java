package Integracion.Vuelo.imp;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import Integracion.Vuelo.DaoVuelo;
import Negocio.Vuelo.imp.TransferVuelo;

public class DaoVueloImp implements DaoVuelo {
	public boolean add(TransferVuelo t) {
		if(t.getId() == -1)
		{
			int cont = 1;
			while(searchId(cont) != null)
			{
				cont++;
			}
			t.setId(cont);
		}
		String nombArch = "vuelo" + t.getId() + ".txt";
		String infoToWrite = t.getId() + " " + t.getOrigen() + " " + t.getDestino() + " " + t.getDiaSemana() + " " + t.getHora() + " _END_ ";
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

	@Override
	public TransferVuelo search(int origen, int destino, String diaSemana, String hora) {
		String nombArch;
		int cont = 1;
		String textAdder;
		String auxEnd;
		TransferVuelo t = new TransferVuelo();
		try {
			do {
				nombArch = "vuelo" + cont + ".txt";
				File archivo = new File(nombArch);
				Scanner sc = new Scanner(archivo);
				t.setId(sc.nextInt());
				t.setOrigen(sc.nextInt());
				t.setDestino(sc.nextInt());
				t.setDiaSemana(sc.next());
				textAdder = "";
				auxEnd = sc.next();
				while(!auxEnd.equals("_END_"))
				{
					textAdder += auxEnd;
					auxEnd = sc.next();
					if(!auxEnd.equals("_END_"))
						textAdder += " ";
				}
				t.setHora(textAdder);
				t.setActivo(sc.next().equals("ACTIVO"));
				sc.close();
				cont++;
			} while (!t.getDiaSemana().equals(diaSemana) || !t.getHora().equals(hora) || t.getOrigen() != origen || t.getDestino() != destino);
			return t;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public TransferVuelo searchId(int id) {
		String nombArch = "vuelo" + id + ".txt";
		String textAdder;
		String auxEnd;
		TransferVuelo t = new TransferVuelo();
		try {
			File archivo = new File(nombArch);
			Scanner sc = new Scanner(archivo);
			t.setId(sc.nextInt());
			t.setOrigen(sc.nextInt());
			t.setDestino(sc.nextInt());
			t.setDiaSemana(sc.next());
			textAdder = "";
			auxEnd = sc.next();
			while(!auxEnd.equals("_END_"))
			{
				textAdder += auxEnd;
				auxEnd = sc.next();
				if(!auxEnd.equals("_END_"))
					textAdder += " ";
			}
			t.setHora(textAdder);
			t.setActivo(sc.next().equals("ACTIVO"));
			sc.close();
			return t;
		} catch (Exception e) {
			return null;
		}
	}

	public boolean update(TransferVuelo t) {
		String nombArch = "vuelo" + t.getId() + ".txt";
		try {
			File archivo = new File(nombArch);
			archivo.delete();
			return add(t);
		} catch (Exception e) {
			return false;
		}
	}
}