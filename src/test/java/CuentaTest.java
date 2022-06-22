
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class CuentaTest {
    @Test
    public void testExtraerSaldo() {
        Cuenta cuenta = new Cuenta();
        cuenta.extraerSaldo(9000);
        int real = -9000;
        int esperado = cuenta.getSaldo();
        Assertions.assertEquals(esperado, real);
        System.out.println( real +" "+ esperado);
    }

    @Test
    public void testInsertarSaldoYExtraerSaldo() {
    }


}