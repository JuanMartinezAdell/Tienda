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
	
	private String email;
	private String password;
	private LocalDate fechaNacimiento;
	private LocalDate fechaRegistro;

	

	/**
	 * 
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

	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
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

	@Override
	public double descuento() {
		// TODO Auto-generated method stub
		return 5;
		
	}
	
	public boolean checkPassword(String pass) {
		
		if(this.password.equals(DigestUtils.sha256Hex(pass)))
			return true;
		else
			return false;
		
	}

}
