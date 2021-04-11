/**
 * 
 */
package tienda;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @author Juan
 *
 */
public class Pedido {
	
	private static int codigoPedido;
	private ArrayList<LineaPedido> lineasPedido;
	private LocalDate fecha;
	private double total;
	private Cliente cliente;
	
	/**
	 * @param fecha
	 */
	public Pedido() {
		super();
		this.fecha = LocalDate.now();
		codigoPedido++;
		this.total=0;
		this.lineasPedido = new ArrayList<LineaPedido>();
		this.cliente=null;
	}
	
	public ArrayList<LineaPedido> getLineasPedido() {
		return lineasPedido;
	}
	
	public static int getCodigoPedido() {
		return codigoPedido;
	}

	public static void setCodigoPedido(int codigoPedido) {
		Pedido.codigoPedido = codigoPedido;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setLineasPedido(ArrayList<LineaPedido> lineasPedido) {
		this.lineasPedido = lineasPedido;
	}
	

	public double getTotal( ) {
		
		this.total=0;
		
		for(LineaPedido l : lineasPedido) 
		  this.total+=l.subtotal();
			
		if(cliente instanceof ClienteRegistrado) 
			this.total=this.total-(double)cliente.descuento();
		else if(cliente instanceof ClienteNoRegistrado) 
			this.total=total-(double)cliente.descuento();
			
		
		return this.total;	
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pedido: ");
		builder.append(codigoPedido);
		builder.append("\n");
		builder.append("Fecha: ");
		builder.append(fecha);
		builder.append("\n");
		builder.append("Subtotal: ");
		for(LineaPedido l : lineasPedido) 
			  this.total+=l.subtotal();
		builder.append(this.total);
		builder.append("\n");
		builder.append("Total= ");
		builder.append(getTotal());
		builder.append(" \n");
		builder.append(cliente);
		builder.append("]");
		return builder.toString();
	}

	public void nuevaLinea(LineaPedido lp) {
		this.lineasPedido.add(lp);
	}	
	

}
