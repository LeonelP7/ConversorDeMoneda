import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    private static int opcion;

    public static void main(String[] args) {
        menu();
        System.out.println("Finalizo el programa :)");

    }

    public static void menu(){
        ConsultaCambio consultaCambio = new ConsultaCambio();
        CodigosConversiones codigosConversiones = new CodigosConversiones();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        String baseCode = "";
        String targetCode = "";
        float amount = 0;
        while(opcion != 2){
            System.out.println("""
                Ingrese una opcion:
                1) Hacer una conversion.
                2) Salir.
                """);

            try{
                opcion = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("¡Opcion no valida! intente nuevamente" + e);
                menu();
            }

            if (opcion == 1){
                System.out.println("Monedas validas:\n" + codigosConversiones.getCurrencyCodes());
                System.out.println("Que moneda quieres convertir?: ");
                try{
                   baseCode = scanner.next();
                    if (!codigosConversiones.getCurrencyCodes().containsKey(baseCode)){
                        System.out.println("Moneda no valida");
                        continue;
                    }
                }catch (InputMismatchException e){
                    System.out.println("Moneda no valida, intenta de nuevo");
                    menu();
                }
                System.out.println("A que moneda quieres convertir?: ");
                try{
                    targetCode = scanner.next();
                    if (!codigosConversiones.getCurrencyCodes().containsKey(targetCode)){
                        System.out.println("Moneda no valida");
                        continue;
                    }
                }catch (InputMismatchException e){
                    System.out.println("Moneda no valida, intenta de nuevo");
                    menu();
                }

                System.out.println("Que valor quieres convertir?: ");
                try {
                    amount = scanner.nextFloat();
                }catch (InputMismatchException e){
                    System.out.println("Cantidad no valida" + e);
                    menu();
                }

                System.out.println("La conversion es: "
                        + consultaCambio.consultaCambio(baseCode, targetCode, amount) + " " + targetCode);

            } else if (opcion == 2) {
                break;
            }else {
                System.out.println("Opcion no valida");
                continue;
            }
        }

    }
}
