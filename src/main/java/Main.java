import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Cuenta pers = new Cuenta();

        List movimientos = new ArrayList<>();
        pers.setPalabras(movimientos);

        Scanner sc = new Scanner(System.in);
        int cantidad;
        System.out.println("ingrese el numero cero para depositar saldo");
        System.out.println("Ingrese en numero 1 para extraer saldo");

        boolean operar = true;

        while (operar) {
            int opcion = sc.nextInt();
            switch (opcion) {

                case 0:
                    System.out.println("Ingrese cantidad de saldo");
                    cantidad = sc.nextInt();
                    pers.ingresarSaldo(cantidad);
                    System.out.println(" Su saldo es " + pers.getSaldo());
                    break;
                case 1:
                    System.out.println("Ingrese la cantidad que quiere extraer");
                    cantidad = sc.nextInt();
                    pers.extraerSaldo1(cantidad);
                    break;
                case 2:
                    pers.imprimirMovimientos();
                    break;
                case 3:
                    operar = false;

            }
        }
    }
}
