import java.util.Scanner;

public class Main {

    public static void main(String[]args){

        Cuenta pers = new Cuenta();
        System.out.println("Ingresar saldo");
        Scanner sc = new Scanner (System.in);
        int cantidad = sc.nextInt();
        pers.insertarSaldo(cantidad);

        System.out.println("Extraer saldo");
        cantidad = sc.nextInt();
        pers.extraerSaldo1(cantidad);













    }
}
