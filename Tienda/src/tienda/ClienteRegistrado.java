/**
 * 
 */
package tienda;

import java.time.LocalDate;

import org.apache.commons.codec.digest.DigestUtils;



/**
 * @author Juan
 *
 */
public class ClienteRegistrado extends Cliente{
	
	//Atributos
	private String email;
	private String password;
	private LocalDate fechaNacimiento;
	private LocalDate fechaRegistro;

	

	/**
	 * Constructor
	 */
	public ClienteRegistrado() {
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
	public ClienteRegistrado(String nombre, String apellidos, String dni, String localidad, String direccion, String email, String password, LocalDate fechaNacimiento) {
		super(nombre, apellidos, dni, localidad, direccion);
		// TODO Auto-generated constructor stub
		this.email=email;
		this.password=DigestUtils.sha256Hex(password);
		this.fechaRegistro=LocalDate.now();
		this.fechaNacimiento=fechaNacimiento;
	}

	//Gettesr y Setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		
		return password;
	}

	public void setPassword(String password) {
		this.password = DigestUtils.sha256Hex(password);
	}

	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClienteRegistrado: ");
		builder.append("\n");
		builder.append("Email: ");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", fechaNacimiento=");
		builder.append(fechaNacimiento);
		builder.append(", fechaRegistro=");
		builder.append(fechaRegistro);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
	//Metodos
	
	/**
	 *Compruebo si el password es correcto comparnadolo con la contrasela guardad 
	 * 
	 * @param pass
	 * @return Si coincide o no el password
	 **/ 
	public boolean chekPass(String pas) {
		if (DigestUtils.sha256Hex(pas).equals(password))
			return true;
		
		return false;
	}
	
	
	/**
	 * Devuelvo al cantidad a descontar
	 * 
	 * @return Devuelvo 5 euros de descuento
	 */
	
	@Override
	public double descuento() {
		// TODO Auto-generated method stub
		return 5; //Aplico descuento de 5€
		
	}
	
	

}
