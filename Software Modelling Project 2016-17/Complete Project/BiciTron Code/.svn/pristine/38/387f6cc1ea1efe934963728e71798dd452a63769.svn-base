package negocio.compra;

import java.util.ArrayList;
import presentacion.controlador.Contexto;
import negocio.compra.imp.TransferCompra;
import negocio.compra.imp.TransferLineaCompra;

public interface ServicioAplicacionCompra 
{
	public TransferCompra iniciarCompra(int id);
	public Contexto agregarArticulo(Contexto articulo);
	public TransferCompra finalizarCompra(TransferCompra tCompra);
	public int devolverArticulo(TransferLineaCompra tLineaCompra);
	public TransferCompra detalleCompra(int id);
	public ArrayList<TransferCompra> listaCompra();
}