import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {

    private String persona;
    private int saldo;
    private List <String> palabras;

    public int getSaldo() {
        return this.saldo;
    }

    public void setPalabras(List arrayDePalabras) {
        this.palabras = arrayDePalabras;
    }

    public int ingresarSaldo(int cantidad) {
        this.saldo = this.saldo + cantidad;
        this.palabras.add("se ingreso saldo por cantidad: " + cantidad);
        return this.saldo;
    }

    public void extraerSaldo1(int cantidad) {
        if (this.saldo <= 0 || this.saldo < cantidad) {
            System.out.println("Saldo insuficiente");
        } else {this.saldo = this.saldo - cantidad;
            this.palabras.add("se retiro saldo por cantidad: " + cantidad);
            System.out.println("Su saldo es $" + getSaldo());}
    }

    public void imprimirMovimientos() {
        for(int indice = 0; indice < palabras.size(); indice++) {
            System.out.println(palabras.get(indice));
        }
    }
}
