package pasarelaPago;

public class PayU implements Pagos {
	public PayU() {

	}

	public boolean Pago(String InformacionTarjeta, String InformacionDueno, int Cobro) {
		System.out.print("PayU");
		return true;
	}
}
