package Modelo;

public class ServicioLuz {

    private int idServicio;
    private String numeroServicio;
    private String direccion;
    private String estado;
    private Cliente cliente;

    public ServicioLuz(int idServicio, String numeroServicio, String direccion, String estado, Cliente cliente) {
        this.idServicio = idServicio;
        this.numeroServicio = numeroServicio;
        this.direccion = direccion;
        this.estado = estado;
        this.cliente = cliente;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNumeroServicio() {
        return numeroServicio;
    }

    public void setNumeroServicio(String numeroServicio) {
        this.numeroServicio = numeroServicio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}