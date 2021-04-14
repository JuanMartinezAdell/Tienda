/**
 * 
 */
package tienda;

/**
 * @author Juan
 *
 */
public class LineaPedido {
	
	private Producto producto;
	private int cantidad;
	
	
	/**
	 * @param producto
	 * @param cantidad
	 */
	public LineaPedido(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LineaPedido [producto=");
		builder.append(producto);
		builder.append(", cantidad=");
		builder.append(cantidad);
		builder.append(", subtotal()=");
		builder.append(subtotal());
		builder.append("]");
		return builder.toString();
	}
	
	/**
	 * Calcula el subtotal del precio por al cantidad y el iva
	 * 
	 * @return El subtotal calcualdo en esta linea
	 * 
	 */

	public double subtotal() {
		
		return producto.precio*producto.iva*cantidad;
		
	}
	

}
