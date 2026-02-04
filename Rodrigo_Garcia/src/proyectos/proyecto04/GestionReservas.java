package proyectos.proyecto04;

import recursos.MyScanner;
import recursos.Utilidades;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class GestionReservas {

    private static final int espaciosMaxArray = 30;
    private static final MyScanner sc = new MyScanner();
    private static final Reserva[] reservas = new Reserva[espaciosMaxArray];
    private static int contador = 0;

    static void main(String[] args) {
        int opcion;
        do {
            opcion = sc.pedirNumero(""" 
                    \n========= RESERVAS ========
                    \t1. Añadir reservas
                    \t2. Mostrar reservas
                    \t3. Filtrar por año
                    \t4. Filtrar por mes
                    \t5. Filtrar por rango de años
                    \t6. Filtrar por id
                    \t7.Salir
                    Escoja una opción:""");

            switch (opcion) {
                case 1:
                    anyadirReserva();
                    break;
                case 2:
                    mostrarReservas();
                    break;
                case 3:
                    filtrarPorAnyo();
                    break;
                case 4:
                    filtrarPorMes();
                    break;
                case 5:
                    filtrarPorRango();
                    break;
                case 6:
                    filtrarPorId();
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no valida!");
                    break;
            }
        } while (opcion != 7);
    }

    public static void anyadirReserva() {
        if (contador == espaciosMaxArray) {
            System.out.println("\nNo se pueden añadir mas reservas!");
        } else {
            boolean exit = false;
            LocalDate fechaReserva = null;
            do {
                try {
                    String fecha = sc.pideTexto("\nIngrese la fecha de creación (yyyy-MM-dd): ");
                    fechaReserva = LocalDate.parse(fecha);
                    exit = true;
                } catch (DateTimeParseException e) {
                    System.out.println(e.getMessage());
                }
            } while (!exit);

            TipoReserva tipoReserva = Utilidades.pedirEnum(TipoReserva.class, "\nElige el tipo de reserva: ");

            String nomCliente = sc.pideTexto("\n¿Cuál es el nombre con el que quiere hacer la reserva?");

            String identifReserva = String.valueOf(contador);

            reservas[contador] = new Reserva(identifReserva, nomCliente, fechaReserva, tipoReserva);
            contador++;
        }
    }

    public static void mostrarReservas() {
        for (Reserva fecha : reservas) {
            if (fecha == null) {
                return;
            } else {
                System.out.println(fecha);
            }
        }
    }

    public static void filtrarPorAnyo() {
        int year = sc.pedirNumero("\nIngrese el año por el que desea filtrar: ");

        boolean encontrado = false;
        try {
            for (Reserva r : reservas) {
                if (r.getFechaReserva().getYear() == year) {
                    System.out.println(r);
                    encontrado = true;
                }
            }
        } catch (NullPointerException e) {
            if (!encontrado) {
                System.out.println("No se ha encontrado ningún registro para ese año");
            }
        }
    }

    public static void filtrarPorMes() {
        int month = sc.pedirNumero("\nIngrese el mes por el que desea filtrar: ");

        boolean encontrado = false;

        try {
            for (Reserva r : reservas) {
                if (r.getFechaReserva().getMonthValue() == month) {
                    System.out.println(r);
                    encontrado = true;
                }
            }
        } catch (NullPointerException e) {
            if (!encontrado) {
                System.out.println("No se ha encontrado ninguna reserva para ese mes");
            }
        }
    }

    public static void filtrarPorRango() {
        int minYear = sc.pedirNumero("\nIngrese el año por el que empezar a filtrar: ");
        int maxYear = -1;
        do {
            maxYear = sc.pedirNumero("Ingrese el año por el que terminar a filtrar (debe de ser mayor que el año por" +
                    " el que desea empezar): ");
        }while(minYear>maxYear);
        boolean encontrado = false;
        try {
            for (Reserva r : reservas) {
                if (r.getFechaReserva().getYear() >= minYear && r.getFechaReserva().getYear() <= maxYear) {
                    System.out.println(r);
                    encontrado = true;
                }
            }
        } catch (NullPointerException e) {
            if (!encontrado) {
                System.out.println("No se ha encontrado ninguna reserva para ese rango de años");
            }
        }
    }

    public static void filtrarPorId() {
        int id = sc.pedirNumero("\nIngrese el id por el que quiere filtrar:");

        boolean encontrado = false;
        try {
            for (Reserva r : reservas) {
                if (String.valueOf(id).equals(r.getIdentifReserva())) {
                    System.out.println(r);
                    encontrado = true;
                }
            }
        } catch (NullPointerException e) {
            if (!encontrado) {
                System.out.println("No se ha encontrado ninguna reserva para ese id");
            }
        }
    }
}