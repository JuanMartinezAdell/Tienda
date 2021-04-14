/**
 * 
 */
package tienda;

/**
 * @author Juan
 *
 */
public class Producto {
	
	protected String codigo;
	protected String nombre;
	protected String descripcion;
	protected Categoria categoria;
	protected double precio;
	protected double iva;
	
	/**
	 * @param codigo
	 * @param nombre
	 * @param descripcion
	 * @param categoria
	 * @param precio
	 * @param iva
	 */
	public Producto(String nombre, String descripcion, Categoria categoria, double precio, double iva) {
		super();
		String digitos="";
		for(int i=1; i<=4; i++) 
			digitos+=((int) (Math.random() * 9 + 0));  //Añado cuatro digitos de manera aleatoria a String
		this.codigo=nombre.substring(0,4)+ digitos; //Cojo los 4 primeros caracteres del nombre y le añado los 4 digitos aleatorios al codigo
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoria=categoria;
		this.precio = precio;
		this.iva = iva;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Producto [codigo=");
		builder.append(codigo);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", categoria=");
		builder.append(categoria);
		builder.append(", precio=");
		builder.append(precio);
		builder.append(", iva=");
		builder.append(iva);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
