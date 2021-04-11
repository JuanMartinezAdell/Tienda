/**
 * 
 */
package tienda;

import java.io.IOException;
import java.time.LocalDate;

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
public class TestPedido {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		Cliente cliente = new ClienteRegistrado("Juan", "Maritnez", "2234567j", "Overa", "Limones", "jumadell@gmail", 
															"12345", LocalDate.of(1980, 7, 20));
		
		
		Categoria transmision = new Categoria("Transmison");
		Categoria ruedas = new Categoria("Ruedas");
		Categoria herramientas = new Categoria("Herramientas");
		
		Producto bielas = new Producto("Biela", "Sram", transmision, 800, 1.15);
		Producto cadena = new Producto ("cadena", "shimano", transmision, 50, 1.15);
		Producto coronas = new Producto ("coronas", "shimano", transmision, 80, 1.15);
		Producto pedales = new Producto ("pedales", "look", transmision, 120, 1.15);
		Producto cazoletas = new Producto ("cazoletas", "rotor", transmision, 50, 1.15);
		Producto platos = new Producto ("platos", "rotor", transmision, 110, 1.15);
		Producto cambio = new Producto ("cambio", "campanolo", transmision, 160, 1.15);
		
		Pedido ped = new Pedido( );
		ped.nuevaLinea(new LineaPedido(bielas,1));
		ped.nuevaLinea(new LineaPedido(coronas, 2));
		ped.nuevaLinea(new LineaPedido(platos, 3));
		ped.nuevaLinea(new LineaPedido(pedales, 1));
		ped.nuevaLinea(new LineaPedido(cambio,2));
		ped.nuevaLinea(new LineaPedido(cazoletas,1));
		ped.nuevaLinea(new LineaPedido(cadena,2));
		ped.setCliente(cliente);
		
		System.out.println(ped);
		
		try (PDDocument factura = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            factura.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(factura, page);

            // Text
            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_BOLD, 18);
            contentStream.newLineAtOffset( 20, page.getMediaBox().getHeight() - 52);
            contentStream.showText("Factura BiciLocura");
            contentStream.endText();

           // Image
            /*PDImageXObject image = PDImageXObject.createFromByteArray(factura, TestPedido.class.getResourceAsStream("/TiendaImage").readAllBytes(), "Java Logo");
            contentStream.drawImage(image, 20, 20, image.getWidth() / 3, image.getHeight() / 3);*/

            contentStream.close();

            factura.save("factura.pdf");
		
		}
		
	}

}
