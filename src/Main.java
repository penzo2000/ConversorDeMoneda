import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);

        var mensaje = """
                ************************************************************************************
                Sea bienvenido/a al Conversor de Monedas =)
                
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso Colombiano
                6) Peso colombiano =>> Dólar
                7) Salir
                
                Elija una opción válida:
                ************************************************************************************
                """;
        try {
            System.out.println(mensaje);
            var opcion = lectura.nextInt();
            while (opcion >= 1 && opcion <= 6) {
                ConversorMenu conversor = new ConversorMenu(opcion);
                conversor.convierteMoneda();
                System.out.println(mensaje);
                opcion = lectura.nextInt();
            }
            if (opcion == 7) {
                System.out.println("Gracias por usar nuestro programa");
            } else {
                System.out.println("Elija una opción correcta por favor.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número.");
        } catch (RuntimeException e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        } finally {
            lectura.close();
        }
    }
}


