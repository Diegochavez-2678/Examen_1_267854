package repositorio;

import Modelo.Consumo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ConsumoRepository {

    private final List<Consumo> consumos = new ArrayList<>();

    public ConsumoRepository(ServicioLuzRepository servicioRepository) {
        consumos.add(new Consumo(1, "Septiembre 2026", new BigDecimal("450.75"), "PENDIENTE", servicioRepository.buscarPorId(1)));
        consumos.add(new Consumo(2, "Septiembre 2026", new BigDecimal("1280.40"), "PENDIENTE", servicioRepository.buscarPorId(2)));
        consumos.add(new Consumo(3, "Septiembre 2026", new BigDecimal("322.10"), "PENDIENTE", servicioRepository.buscarPorId(3)));
        consumos.add(new Consumo(4, "Agosto 2026", new BigDecimal("610.00"), "PAGADO", servicioRepository.buscarPorId(4)));
    }

    public Consumo obtenerPendiente(int idServicio) {
        for (Consumo consumo : consumos) {
            boolean mismoServicio = consumo.getServicio().getIdServicio() == idServicio;
            boolean pendiente = consumo.getEstado().equals("PENDIENTE");
            if (mismoServicio && pendiente) {
                return consumo;
            }
        }
        return null;
    }

    public void marcarPagado(int idConsumo) {
        for (Consumo consumo : consumos) {
            if (consumo.getIdConsumo() == idConsumo) {
                consumo.setEstado("PAGADO");
            }
        }
    }
}