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


	
}
