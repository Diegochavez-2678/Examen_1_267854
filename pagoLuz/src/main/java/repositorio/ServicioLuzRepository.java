package repositorio;

import Modelo.ServicioLuz;
import Modelo.Cliente;
import java.util.ArrayList;
import java.util.List;


public class ServicioLuzRepository {

    private final List<ServicioLuz> servicios = new ArrayList<>();

    public ServicioLuzRepository() {
        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {
        Cliente juan = new Cliente(1, "Juan Perez");
        Cliente maria = new Cliente(2, "Maria Lopez");
        Cliente carlos = new Cliente(3, "Carlos Ramirez");

        servicios.add(new ServicioLuz(1, "100200300400", "Calle Reforma 123", "ACTIVO", juan));
        servicios.add(new ServicioLuz(2, "100200300500", "Avenida Juarez 45", "ACTIVO", maria));
        servicios.add(new ServicioLuz(3, "200300400500", "Calle Hidalgo 78", "ACTIVO", carlos));
        servicios.add(new ServicioLuz(4, "100200700800", "Calle Morelos 910", "ACTIVO", juan));
    }

    public List<ServicioLuz> buscarCoincidencias(String numero) {
        List<ServicioLuz> coincidencias = new ArrayList<>();
        for (ServicioLuz servicio : servicios) {
            if (servicio.getNumeroServicio().contains(numero)) {
                coincidencias.add(servicio);
            }
        }
        return coincidencias;
    }

    public ServicioLuz buscarPorId(int idServicio) {
        for (ServicioLuz servicio : servicios) {
            if (servicio.getIdServicio() == idServicio) {
                return servicio;
            }
        }
        return null;
    }
}