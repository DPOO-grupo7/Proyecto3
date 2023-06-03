package pasarelaPago;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PasarelaPago {
	private Pagos newPago;

	@SuppressWarnings("unchecked")
	public void Pagar(String TipoPago, String InformacionTarjeta, String InformacionDueno, int Cobro) {
		try {

			@SuppressWarnings("rawtypes")
			Class clase = Class.forName(TipoPago);
			newPago = (Pagos) clase.getDeclaredConstructor().newInstance();
			newPago.Pago(InformacionTarjeta, InformacionDueno, Cobro);
		} 
		catch (ClassNotFoundException e) {
			System.out.println("No existe la clase " + TipoPago);
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Hubo otro error construyendo la agenda telefónica: " + e.getMessage());
			e.printStackTrace();
		}
	}


	public static void main(String[] args) throws IOException {
		System.out.println("Indique el nombre de la clase ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String nombreClase = reader.readLine();
		if (nombreClase.length() == 0) // El usuario no tecleó nada
			nombreClase = "pasarelaPago.PayU";
		PasarelaPago pasarelaPago = new PasarelaPago();
		pasarelaPago.Pagar(nombreClase, "33322232", "nombreDue;o", 10);
	}
}
