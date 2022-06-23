
import org.junit.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class CuentaTest {
    @Test
    public void testExtraerSaldo() {
        Cuenta cuenta = new Cuenta();
        cuenta.extraerSaldo1(9000);
        int real = 0;
        int esperado = cuenta.getSaldo();
        assertEquals(esperado, real);
        System.out.println( real +" "+ esperado);
    }

    @Test
    public void testIngresarSaldo() {
        Cuenta cuenta = new Cuenta();
        cuenta.ingresarSaldo(1000);
        int real =1000;
        int esperado = cuenta.getSaldo();
        assertEquals(esperado,real);
        System.out.println( real +" "+esperado);

    }


}