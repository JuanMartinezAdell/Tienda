/**
 * 
 */
package tienda;

/**
 * @author Juan
 *
 */
public class ClienteNoRegistrado extends Cliente{

	
	
	/**
	 * 
	 */
	public ClienteNoRegistrado() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param localidad
	 * @param direccion
	 */
	public ClienteNoRegistrado(String nombre, String apellidos, String dni, String localidad, String direccion) {
		super(nombre, apellidos, dni, localidad, direccion);
		// TODO Auto-generated constructor stub
	}
	
	
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClienteNoRegistrado [toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

	@Override
	public double descuento() {
		// TODO Auto-generated method stub
		
		
		
		return 0;
	}

}
