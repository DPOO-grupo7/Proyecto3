package programaUsuario;

import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import com.toedter.calendar.JCalendar;

public class JOptionPaneCalendario {

    public Date mostrarCalendario() {
        JCalendar calendar = new JCalendar();
        JOptionPane.showMessageDialog(null, calendar, "Seleccione una fecha", JOptionPane.PLAIN_MESSAGE);

        Calendar fechaSeleccionada = calendar.getCalendar();
        return fechaSeleccionada.getTime();
    }
    
    public static void main(String[] args) {
        JOptionPaneCalendario jOptionPaneCalendario = new JOptionPaneCalendario();
        Date fechaSeleccionada = jOptionPaneCalendario.mostrarCalendario();
        System.out.println("Fecha seleccionada: " + fechaSeleccionada);
    }
}