package controlador;

import Modelo.Recibo;
import Modelo.Consumo;
import Modelo.ServicioLuz;
import repositorio.ConsumoRepository;
import servicio.PagoService;
import repositorio.ServicioLuzRepository;
import java.util.ArrayList;
import java.util.List;
public class PagoLuzController {

    private final ServicioLuzRepository servicioLuzRepository;
    private final ConsumoRepository consumoRepository;
    private final PagoService pagoService;

    private ServicioLuz servicioSeleccionado;
    private Consumo consumoPendiente;

    public PagoLuzController(ServicioLuzRepository servicioLuzRepository,
            ConsumoRepository consumoRepository,
            PagoService pagoService) {
        this.servicioLuzRepository = servicioLuzRepository;
        this.consumoRepository = consumoRepository;
        this.pagoService = pagoService;
    }

    public List<ServicioLuz> buscarClientes(String numero) {
        if (numero == null || numero.trim().isEmpty()) {
            return new ArrayList<>();
        }
        return servicioLuzRepository.buscarCoincidencias(numero.trim());
    }

    public Consumo seleccionarServicio(int id) {
        ServicioLuz servicio = servicioLuzRepository.buscarPorId(id);
        if (servicio == null) {
            throw new IllegalArgumentException("El servicio seleccionado no existe");
        }
        servicioSeleccionado = servicio;
        return consultarConsumo(id);
    }

    public Consumo consultarConsumo(int id) {
        consumoPendiente = consumoRepository.obtenerPendiente(id);
        return consumoPendiente;
    }

    public Recibo pagarServicio(String tarjeta) {
        if (servicioSeleccionado == null || consumoPendiente == null) {
            throw new IllegalStateException("Debe seleccionar un servicio con consumo pendiente");
        }

        Recibo recibo = pagoService.procesarPago(servicioSeleccionado, consumoPendiente.getImporte(), tarjeta);
        consumoRepository.marcarPagado(consumoPendiente.getIdConsumo());
        consumoPendiente = null;
        return recibo;
    }
}