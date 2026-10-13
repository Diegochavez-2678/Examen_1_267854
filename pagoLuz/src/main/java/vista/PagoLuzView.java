package vista;

import controlador.PagoLuzController;
import Modelo.Recibo;
import Modelo.Consumo;
import Modelo.ServicioLuz;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Scanner;

public class PagoLuzView {

    private final PagoLuzController controller;
    private final Scanner lector = new Scanner(System.in);

    public PagoLuzView(PagoLuzController controller) {
        this.controller = controller;
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            System.out.println();
            System.out.println("SISTEMA DE PAGO DE LUZ");
            System.out.print("Ingrese el numero de servicio o 0 para salir: ");
            String numero = lector.nextLine().trim();

            if (numero.equals("0")) {
                salir = true;
            } else if (!numero.isEmpty()) {
                actualizarBusqueda(numero);
            }
        }
        System.out.println("Sistema finalizado");
    }

    public void actualizarBusqueda(String numero) {
        List<ServicioLuz> clientes = controller.buscarClientes(numero);
        mostrarClientes(clientes);

        if (!clientes.isEmpty()) {
            seleccionarServicio();
        }
    }

    public void mostrarClientes(List<ServicioLuz> clientes) {
        System.out.println();
        if (clientes.isEmpty()) {
            System.out.println("No se encontraron coincidencias");
            return;
        }

        System.out.println("COINCIDENCIAS ENCONTRADAS");
        for (ServicioLuz servicio : clientes) {
            System.out.println("Id: " + servicio.getIdServicio()
                    + " | Cliente: " + servicio.getCliente().getNombre()
                    + " | Servicio: " + servicio.getNumeroServicio()
                    + " | Direccion: " + servicio.getDireccion());
        }
    }

    private void seleccionarServicio() {
        System.out.print("Ingrese el id del servicio a pagar o 0 para nueva busqueda: ");
        String entrada = lector.nextLine().trim();

        int idServicio;
        try {
            idServicio = Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            mostrarMensaje("El id debe ser un numero");
            return;
        }

        if (idServicio == 0) {
            return;
        }

        try {
            Consumo consumo = controller.seleccionarServicio(idServicio);
            if (consumo == null) {
                mostrarMensaje("El servicio no tiene consumo pendiente");
                return;
            }
            mostrarConsumo(consumo);
            realizarPago();
        } catch (IllegalArgumentException e) {
            mostrarMensaje(e.getMessage());
        }
    }

    public void mostrarConsumo(Consumo consumo) {
        System.out.println();
        System.out.println("CONSUMO PENDIENTE");
        System.out.println("Cliente: " + consumo.getServicio().getCliente().getNombre());
        System.out.println("Servicio: " + consumo.getServicio().getNumeroServicio());
        System.out.println("Periodo: " + consumo.getPeriodo());
        System.out.println("Importe a pagar: " + formatearMonto(consumo.getImporte()));
    }

    public String solicitarTarjeta() {
        System.out.print("Ingrese el numero de tarjeta de 16 digitos: ");
        return lector.nextLine().trim();
    }

    private void realizarPago() {
        String tarjeta = solicitarTarjeta();
        try {
            Recibo recibo = controller.pagarServicio(tarjeta);
            mostrarRecibo(recibo);
        } catch (IllegalArgumentException | IllegalStateException e) {
            mostrarMensaje(e.getMessage());
        }
    }

    public void mostrarRecibo(Recibo recibo) {
        System.out.println();
        System.out.println("PAGO APROBADO");
        System.out.println("RECIBO DE PAGO");
        System.out.println("Folio: " + recibo.getFolio());
        System.out.println("Cliente: " + recibo.getPago().getServicio().getCliente().getNombre());
        System.out.println("Servicio: " + recibo.getPago().getServicio().getNumeroServicio());
        System.out.println("Monto pagado: " + formatearMonto(recibo.getMontoPagado()));
        System.out.println("Estado del pago: " + recibo.getPago().getEstado());
    }

    private void mostrarMensaje(String mensaje) {
        System.out.println();
        System.out.println("AVISO: " + mensaje);
    }

    private String formatearMonto(BigDecimal monto) {
        return monto.setScale(2, RoundingMode.HALF_UP).toPlainString();
    }
}