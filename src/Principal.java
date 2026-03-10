import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);

        ConsultaApi consulta = new ConsultaApi();

        int opcion = 0;

        String menu = """
                ********************************************
                Sea bienvenido/a al Conversor de Moneda 
                
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso Boliviano
                6) Peso Boliviano =>> Dólar
                7) Salir
                Elija una opción válida:
                ********************************************
                """;

        while (opcion != 7) {
            System.out.println(menu);
            opcion = lectura.nextInt();

            switch (opcion) {
                case 1:
                    realizarConversion("USD", "ARS", consulta, lectura);
                    break;
                case 2:
                    realizarConversion("ARS", "USD", consulta, lectura);
                    break;
                case 3:
                    realizarConversion("USD", "BRL", consulta, lectura);
                    break;
                case 4:
                    realizarConversion("BRL", "USD", consulta, lectura);
                    break;
                case 5:
                    realizarConversion("USD", "BOB", consulta, lectura);
                    break;
                case 6:
                    realizarConversion("BOB", "USD", consulta, lectura);
                    break;
                case 7:
                    System.out.println("Finalizando el programa. ¡Gracias!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

    }
    private static void realizarConversion(String base, String destino, ConsultaApi consulta, Scanner lectura){

        System.out.println("Convirtiendo " + base + " a " + destino + "\n");

        System.out.println("Ingrese la cantidad que desea convertir: ");
        double cantidad = lectura.nextDouble();
        Moneda moneda = consulta.buscarMoneda(base, destino);
        double resultado = cantidad * moneda.conversion_rate();
        System.out.println("           RESULTADO"+"\n"+"---------------------------------------------------------");
        System.out.println(cantidad + "["+ base+ "]" + " equivale a ===>>> " + String.format("%.2f",resultado) + "[" + destino + "]");
        System.out.println("---------------------------------------------------------" + "\n");
    }



}
