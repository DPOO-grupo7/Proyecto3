package posterityKeeper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import modelo.Habitacion;
import modelo.Hotel;


public class Archivador implements Serializable{
	private static final long serialVersionUID = 1L;
//	private static final String RUTA_HUESPED="./data/huespedes.bin";
//	private static final String RUTA_ADMIN="./data/admins.bin";
//	private static final String RUTA_RECEP="./data/recepcionistas.bin";
//	private static final String RUTA_RESER="./data/reserva.bin";
	private static final String RUTA_HABITA="./data/habitaciones.bin";
	private static final String RUTA_HOTEL="./data/hotel.bin";
	public Archivador() {
	}
	public void guardarHabitaciones(ArrayList<Habitacion> habitaciones)
	{
		try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(RUTA_HABITA))) {
            stream.writeObject(habitaciones);
        } catch (IOException e) {
            System.out.println("Error writing binary file: " + e.getMessage());
        }
	}
	public ArrayList<Habitacion> cargarHabitaciones()  {
		try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(RUTA_HABITA))) {
            ArrayList<Habitacion> inventario = (ArrayList<Habitacion>) stream.readObject();
            System.out.println(inventario.size());
            return inventario;
            
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading binary file: " + e.getMessage());
        }
		return new ArrayList<Habitacion>();
	}
	public void guardarHotel(Hotel hotel) {

		try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(RUTA_HOTEL))) {
            stream.writeObject(hotel);
        } catch (IOException e) {
            System.out.println("Error writing binary file: " + e.getMessage());
        }

	}
	public Hotel cargarHotel()
	{
		try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(RUTA_HOTEL))) {
            Object object = stream.readObject();
            // Cast the object to the appropriate class
            if (object instanceof Hotel) {
                Hotel hotel= (Hotel) object;
                return hotel;
            } else {
                System.err.println("Hubo un error al cargar el archivo.");
            }
            
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading binary file: " + e.getMessage());
        }
		return new Hotel(this);

	}
}
