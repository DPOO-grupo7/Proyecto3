package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import modelo.Hotel;
import posterityKeeper.Archivador;

public class HotelTest {
    private Hotel hotel;
    private Archivador archivador;

    @Before
    public void setUp() {
    	
        //instancia de Hotel para realizar las pruebas
        hotel = new Hotel(archivador, true , true, true ,true , true, true, true);
    }

    @Test
    public void testIniciarSesion_AdminExistente_Correcto() {
        assertTrue(hotel.iniciarSesion("1", "admin", "password"));
    }

    @Test
    public void testIniciarSesion_AdminInexistente_Incorrecto() {
        assertFalse(hotel.iniciarSesion("1", "admin123", "password"));
    }

    @Test
    public void testIniciarSesionHuesped_HuespedExistente_Correcto() {
        assertTrue(hotel.iniciarSesionHuesped("huesped", "password"));
    }

    @Test
    public void testIniciarSesionHuesped_HuespedInexistente_Incorrecto() {
        assertFalse(hotel.iniciarSesionHuesped("huesped123", "password"));
    }


}
