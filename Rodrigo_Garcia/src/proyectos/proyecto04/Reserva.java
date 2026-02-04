package proyectos.proyecto04;

import java.time.LocalDate;

public class Reserva {


    // atributos
    private String identifReserva;
    private String nomCliente;
    private LocalDate fechaReserva;
    private TipoReserva tipoReserva;

    // constructor con parámetros
    public Reserva(String identifReserva, String nomCliente, LocalDate fechaReserva, TipoReserva tipoReserva) {
        this.identifReserva = identifReserva;
        this.nomCliente = nomCliente;
        this.fechaReserva = fechaReserva;
        this.tipoReserva = tipoReserva;
    }

    // getters y setters

    public String getIdentifReserva() {
        return identifReserva;
    }

    public void setIdentifReserva(String identifReserva) {
        this.identifReserva = identifReserva;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public TipoReserva getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(TipoReserva tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    // toString()

    @Override
    public String toString() {
        return String.format("Identificador de la reserva: %s, nombre del cliente: %s, " +
                "fecha de la reserva: %s, tipo de reserva: %s", identifReserva, nomCliente, fechaReserva, tipoReserva);
    }
}
