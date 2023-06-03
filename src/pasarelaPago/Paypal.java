package pasarelaPago;

public class Paypal implements Pagos {

	public Paypal() {

	}

	public boolean Pago(String InformacionTarjeta, String InformacionDueno, int Cobro) {
		System.out.print("Paypal");
		return true;
	}

}
