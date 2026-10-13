package com.mycompany.pagoluz;

import controlador.PagoLuzController;
import repositorio.ConsumoRepository;
import repositorio.PagoRepository;
import repositorio.ServicioLuzRepository;
import servicio.PagoService;
import servicio.ReciboService;
import vista.PagoLuzView;

public class Main {

    public static void main(String[] args) {
        ServicioLuzRepository servicioLuzRepository = new ServicioLuzRepository();
        ConsumoRepository consumoRepository = new ConsumoRepository(servicioLuzRepository);
        PagoRepository pagoRepository = new PagoRepository();
        ReciboService reciboService = new ReciboService();
        PagoService pagoService = new PagoService(pagoRepository, reciboService);

        PagoLuzController controller = new PagoLuzController(servicioLuzRepository, consumoRepository, pagoService);
        PagoLuzView vista = new PagoLuzView(controller);
        System.out.println("DATOS DE PRUEBA");
        System.out.println("Id: 1 | Cliente: Juan Perez | Servicio: 100200300400 | Direccion: Calle Reforma 123 | Consumo pendiente: 450.75");
        System.out.println("Id: 2 | Cliente: Maria Lopez | Servicio: 100200300500 | Direccion: Avenida Juarez 45 | Consumo pendiente: 1280.40");
        System.out.println("Id: 3 | Cliente: Carlos Ramirez | Servicio: 200300400500 | Direccion: Calle Hidalgo 78 | Consumo pendiente: 322.10");
        System.out.println("Id: 4 | Cliente: Juan Perez | Servicio: 100200700800 | Direccion: Calle Morelos 910 | Sin consumo pendiente");
        System.out.println("Tarjeta de prueba: 1234567890123456");
        vista.iniciar();
    }
}