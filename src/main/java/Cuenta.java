
public class Cuenta {

    private String persona;
    public int saldo;

    public int getSaldo() {
        return this.saldo;
     }

    public int insertarSaldo (int cantidad) {
        return this.saldo = this.saldo + cantidad;
    }

    public int extraerSaldo (int cantidad) {
        return this.saldo = this.saldo - cantidad;


        }


    public String mensaje(){
        return "Sin saldo disponible";
    }
}

