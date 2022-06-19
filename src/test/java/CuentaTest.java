import org.junit.jupiter.api.Test;



class CuentaTest {

    @Test
    void testNombreCuenta() {
        Cuenta cuenta = new Cuenta();
        cuenta.setPersona("Andrés");
        String esperado ="andrés";
        String real = cuenta.getPersona();
        System.out.println(esperado.equals(real));

    }

}