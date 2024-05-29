import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversorMenu {
    private int opcion;
    private TasaDeCambio tasaDeCambio;

    public ConversorMenu(int opcion) {
        this.opcion = opcion;
    }

    // FUNCIONES QUE REALIZAN LA CONVERSIÓN
    public double convierteADolar(String monedaAConvertir, double valorAConvertir) {
        TasaDeCambioConsulta consulta = new TasaDeCambioConsulta();
        this.tasaDeCambio = consulta.obtenTasaDeCambio(monedaAConvertir);
        return valorAConvertir * this.tasaDeCambio.USD();
    }

    public double convierteAPesoArgentino(String monedaAConvertir, double valorAConvertir) {
        TasaDeCambioConsulta consulta = new TasaDeCambioConsulta();
        this.tasaDeCambio = consulta.obtenTasaDeCambio(monedaAConvertir);
        return valorAConvertir * this.tasaDeCambio.ARS();
    }

    public double convierteAPesoColombiano(String monedaAConvertir, double valorAConvertir) {
        TasaDeCambioConsulta consulta = new TasaDeCambioConsulta();
        this.tasaDeCambio = consulta.obtenTasaDeCambio(monedaAConvertir);
        return valorAConvertir * this.tasaDeCambio.COP();
    }

    public double convierteARealBrasilenio(String monedaAConvertir, double valorAConvertir) {
        TasaDeCambioConsulta consulta = new TasaDeCambioConsulta();
        this.tasaDeCambio = consulta.obtenTasaDeCambio(monedaAConvertir);
        return valorAConvertir * this.tasaDeCambio.BRL();
    }

    // FUNCIÓN DEL MENÚ
    public void convierteMoneda() {
        Scanner lectura = new Scanner(System.in);
        String mensaje = "Ingrese el valor que desea convertir";
        double valorAConvertir = 0;
        double valorConvertido = 0;

        try {
            System.out.println(mensaje);
            valorAConvertir = lectura.nextDouble();
            switch (opcion) {
                case 1:
                    valorConvertido = convierteAPesoArgentino("USD", valorAConvertir);
                    System.out.println("El valor " + valorAConvertir + " [USD] corresponde al valor final de =>> " + valorConvertido + " [ARS]");
                    break;
                case 2:
                    valorConvertido = convierteADolar("ARS", valorAConvertir);
                    System.out.println("El valor " + valorAConvertir + " [ARS] corresponde al valor final de =>> " + valorConvertido + " [USD]");
                    break;
                case 3:
                    valorConvertido = convierteARealBrasilenio("USD", valorAConvertir);
                    System.out.println("El valor " + valorAConvertir + " [USD] corresponde al valor final de =>> " + valorConvertido + " [BRL]");
                    break;
                case 4:
                    valorConvertido = convierteADolar("BRL", valorAConvertir);
                    System.out.println("El valor " + valorAConvertir + " [BRL] corresponde al valor final de =>> " + valorConvertido + " [USD]");
                    break;
                case 5:
                    valorConvertido = convierteAPesoColombiano("USD", valorAConvertir);
                    System.out.println("El valor " + valorAConvertir + " [USD] corresponde al valor final de =>> " + valorConvertido + " [COP]");
                    break;
                case 6:
                    valorConvertido = convierteADolar("COP", valorAConvertir);
                    System.out.println("El valor " + valorAConvertir + " [COP] corresponde al valor final de =>> " + valorConvertido + " [USD]");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número.");
        } catch (RuntimeException e) {
            System.out.println("Ocurrió un error al convertir la moneda: " + e.getMessage());
        }
    }
}

