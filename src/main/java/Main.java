import java.util.Scanner;

public class Main {

    public static void main(String[]args){

        Cuenta pers = new Cuenta();
        System.out.println("Ingresar saldo");
        Scanner sc = new Scanner (System.in);

        System.out.println("Extraer saldo");
        int cantidad = sc.nextInt();
        pers.extraerSaldo(cantidad);
        System.out.println("Su saldo es $ " + pers.getSaldo());









    }
}
