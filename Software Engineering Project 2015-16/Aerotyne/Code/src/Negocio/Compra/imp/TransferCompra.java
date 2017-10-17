package Negocio.Compra.imp;

import java.util.Collection;
import java.util.HashMap;

public class TransferCompra {
	private int id;
	private String dni;
	private String nombre;
	private int tarjetaDeCredito;
	private HashMap<Integer, TransferBilletes> billetes;
	private boolean activo;
	
	public TransferCompra () {
		this.billetes = new HashMap<Integer, TransferBilletes>();
	}
	
	public int getId() {
		return this.id;
	}
	
	public Collection<TransferBilletes> getBilletes() {
		return this.billetes.values();
	}

	public TransferBilletes getBillete(int num) {
		return billetes.get(num);
	}

	public int getTarjetaDeCredito() {
		return this.tarjetaDeCredito;
	}

	public String getDni() {
		return this.dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public boolean getActivo() {
		return this.activo;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setTarjetaDeCredito(int tarjeta) {
		this.tarjetaDeCredito = tarjeta;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public void setBillete(int id, TransferBilletes t) {
		this.billetes.put(id, t);
	}

	public TransferBilletes removeBilleteId(int id) {
		return this.billetes.remove(id);
	}
}