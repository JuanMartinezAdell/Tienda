/**
 * 
 */
package tienda;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 * @author Juan
 *
 */
public class Pedido {
	
	private static int codigoPedido; //Se crea una variable estatica que se incrementara cada ve que se cree un pedido(se llame al constructor)
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
		codigoPedido++;  //Contador codigoPedido
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * Calula el total del precio del pedido sumando el subtotal de todas la lienas del pedido y aplicandole el descuento segun cliente
	 * 
	 * @return precio total
	 */
	public double getTotal( ) {
		
		this.total=0;
		
		for(LineaPedido l : lineasPedido) //Sumo el subtotal a total
		  this.total+=l.subtotal();
			
		//if(cliente instanceof ClienteRegistrado)  //No hace falta!! llama al metodo y aplica el descuento corregido Javi
		this.total=this.total-(double)cliente.descuento(); //Al total le aplico el descuento
		//else if(cliente instanceof ClienteNoRegistrado) 
		//	this.total=total-(double)cliente.descuento();
			
		
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
	
	/**
	 * Añado nueva liena de pedido
	 * 
	 * @param lp
	 */
	public void nuevaLinea(LineaPedido lp) {
		this.lineasPedido.add(lp);
	}	
	
	public void toPDF() {
	
		try (PDDocument factura = new PDDocument()) {
			PDPage page = new PDPage(PDRectangle.A4);
			factura.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(factura, page);

        // Text
        contentStream.beginText();
        contentStream.setFont(PDType1Font.TIMES_BOLD, 42);
        contentStream.newLineAtOffset( 20, page.getMediaBox().getHeight() - 52);
        contentStream.showText("Trek factory");
        contentStream.endText();
        
        if (cliente != null) { //Si tiene cliente asociado pintamos los datos
        	contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_BOLD, 12);
            contentStream.newLineAtOffset( 20, page.getMediaBox().getHeight() - 80);
            contentStream.showText("Cliente: " + cliente.getDni() + " " + cliente.getApellidos() + ", " + cliente.getNombre());
            contentStream.newLineAtOffset(0, -15);
            contentStream.showText("Direccion: " + cliente.getDireccion() + ", " + cliente.getLocalidad());
            contentStream.endText();
        }
        
        contentStream.beginText();
        contentStream.setFont(PDType1Font.TIMES_BOLD, 16);
        contentStream.newLineAtOffset( 20,  page.getMediaBox().getHeight() - 250);
        StringBuilder texto = new StringBuilder();
        for( LineaPedido p : lineasPedido) {
            texto.setLength(0); //Vaciar StringBuilder

            texto.append("Producto: " + p.getProducto().getCodigo() );
            texto.append(" - Precio: " + p.getProducto().getPrecio());
            texto.append("€ - Cantidad: " + p.getCantidad());
            texto.append(" =  " + p.subtotal() + "€");
            contentStream.showText(texto.toString());
            contentStream.newLineAtOffset( 0, -30);
        }
        
        contentStream.showText("Total = "+getTotal()+"€");
        if ( (cliente != null) && (cliente.descuento() > 0) )
        	contentStream.showText("  (descuento incluido de " + cliente.descuento() + " euros)");
        
        contentStream.endText();
        
      // Image
      PDImageXObject image = PDImageXObject.createFromByteArray(factura, TestPedido.class.getResourceAsStream("TiendaImage.jpg").readAllBytes(), "Java Logo");
      contentStream.drawImage(image, 450, 650, image.getWidth() / 6, image.getHeight() / 6);
      contentStream.close();

      factura.save("pedido"+codigoPedido+".pdf");
        
    } catch (Exception ex) {
    	System.out.println("Error: "+ex.getMessage());
    }
	}

}
