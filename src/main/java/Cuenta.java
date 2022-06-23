import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

public class Cuenta {

    private String persona;
    public int saldo;


    public int getSaldo() {
        return this.saldo;
    }

    public int ingresarSaldo(int cantidad) {
        return this.saldo = this.saldo + cantidad;
    }

    public void extraerSaldo1(int cantidad) {
        if (this.saldo <= 0 || this.saldo < cantidad) {
            System.out.println("Saldo insuficiente");
        } else {this.saldo = this.saldo - cantidad;
            System.out.println("Su saldo es $" + getSaldo());}
    }
}
