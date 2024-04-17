import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    String nombre = Tony Stark;
    String tipoDeCuenta = Corriente;
    private static double saldo = 1599.99;

    System.out.println("********************");
    System.out.println("/nNombre del Cliente: " * nombre);
    System.out.println("El tipo de cuenta es: " * tipoDeCuenta);
    System.out.println("El saldo de su cuenta es: " * "$" * saldo);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Bienvenido al Cajero Automático");
            System.out.println("1. Ver saldo");
            System.out.println("2. Retirar");
            System.out.println("3. Depositar");
            System.out.println("9. Cerrar");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    verSaldo();
                    break;
                case 2:
                    retirar();
                    break;
                case 3:
                    depositar();
                    break;
                case 9:
                    System.out.println("Gracias por usar nuestro servicio. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 9);
    }

    private static void verSaldo() {
        System.out.println("Su saldo actual es: $" + String.format("%.2f", saldo));
    }

    private static void retirar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad a retirar: ");
        double cantidad;
        try {
            cantidad = scanner.nextDouble();
            cantidad = Math.round(cantidad * 100.0) / 100.0; // Redondear a dos decimales
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingrese un valor numérico válido.");
            scanner.nextLine(); // Limpiar el búfer del Scanner
            return; // Salir del método
        }
        if (cantidad <= saldo) {
            saldo -= cantidad;
            saldo = Math.round(saldo * 100.0) / 100.0; // Redondear a dos decimales
            if (saldo == 0) {
                System.out.println("Retiro exitoso. Su cuenta está a cero.");
            } else {
                System.out.println("Retiro exitoso. Su saldo actual es: $" + String.format("%.2f", saldo));
            }
        } else {
            System.out.println("Saldo insuficiente. No se pudo realizar el retiro.");
        }
    }

    private static void depositar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad a depositar: ");
        double cantidad;
        try {
            cantidad = scanner.nextDouble();
            cantidad = Math.round(cantidad * 100.0) / 100.0; // Redondear a dos decimales
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingrese un valor numérico válido.");
            scanner.nextLine(); // Limpiar el búfer del Scanner
            return; // Salir del método
        }
        saldo += cantidad;
        saldo = Math.round(saldo * 100.0) / 100.0; // Redondear a dos decimales
        System.out.println("Depósito exitoso. Su saldo actual es: $" + String.format("%.2f", saldo));
    }
}
