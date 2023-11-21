package fracciones;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test void ExcepcionesConstructor() {
        assertThrows(NoSuchMethodException.class, () -> {
            Class<?> fraccionClass = Fraccion.class;
            Constructor<?> constructor = fraccionClass.getConstructor(String.class, int.class);
        });
        assertDoesNotThrow(()->{new Fraccion(2,1);});
        assertDoesNotThrow(()->{new Fraccion(5,3);});
        
    }

    @Test void ManejoErrores() {
        assertDoesNotThrow(()->{new Fraccion(-3,2);});
        assertThrows(IllegalArgumentException.class, ()->{new Fraccion(-4,-2);});        
        assertThrows(IllegalArgumentException.class, ()->{new Fraccion(4,-2);});
        assertThrows(IllegalArgumentException.class, ()->{new Fraccion(4,0);});
        assertDoesNotThrow(()->{new Fraccion(7,4);});
       

    }
    @Test void sumarFracciones() {
         
        f1 = new Fraccion(1,4);
        f2 = new Fraccion(2,4);
        resultado = f1.sumarFracciones(f2);
        assertEquals(3, resultado.getNumerador());
        assertEquals(4, resultado.getDenominador());
        
        f1 = new Fraccion(2,4);
        f2 = new Fraccion(2,4);
        resultado = f1.sumarFracciones(f2);
        assertEquals(1, resultado.getNumerador());
        assertEquals(1, resultado.getDenominador());

        f1 = new Fraccion(3,4);
        f2 = new Fraccion(8,3);
        resultado = f1.sumarFracciones(f2);
        assertEquals(41, resultado.getNumerador());
        assertEquals(12, resultado.getDenominador());

    }
    @Test void MultiplicacionFracciones(){
        f1 = new Fraccion(1,1);
        f2 = new Fraccion(6,2);
        Fraccion multiplicacion = f1.multiplicar(f2);
        assertEquals(3,multiplicacion.getNumerador());
        assertEquals(1,multiplicacion.getDenominador());
 

        f1 = new Fraccion(2,4);
        f2 = new Fraccion(3,4);
        multiplicacion = f1.multiplicar(f2);
        assertEquals(3,multiplicacion.getNumerador());
        assertEquals(8,multiplicacion.getDenominador());


        f1 = new Fraccion(2,5);
        f2 = new Fraccion(8,3);
        multiplicacion = f1.multiplicar(f2);
        assertEquals(16,multiplicacion.getNumerador());
        assertEquals(15,multiplicacion.getDenominador());

    }
    @Test void imprimir(){
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Fraccion fraccion = new Fraccion(2, 5);
        fraccion.imprimir();
        String salida = outputStream.toString().trim();
        assertEquals("2/5", salida);

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        fraccion = new Fraccion(3, 4);
        fraccion.imprimir();
        salida = outputStream.toString().trim();
        assertEquals("3/4", salida);
       
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        fraccion = new Fraccion(5, 2);
        fraccion.imprimir();
        salida = outputStream.toString().trim();
        assertEquals("5/2", salida);
        
    }
    @Test void validarMatriz(){
        assertDoesNotThrow(()->{new MatFrac(new Fraccion[][] { {new Fraccion(6, 1), new Fraccion(7, 2)},
        {new Fraccion(2, 5), new Fraccion(3, 2)}});});
        assertDoesNotThrow(()->{new MatFrac(new Fraccion[][] { {new Fraccion(5, 1), new Fraccion(7, 2)},
        {new Fraccion(6, 3), new Fraccion(8, 9)}});});        
    }    

    @Test void validarContenidoMatriz(){
        assertThrows(IllegalArgumentException.class, ()->{new MatFrac(new Fraccion[][] { {new Fraccion(0, 1), new Fraccion(-7, -2)},
        {new Fraccion(2, 5), new Fraccion(3, 2)}});});
        assertThrows(IllegalArgumentException.class, ()->{new MatFrac(new Fraccion[][] { {new Fraccion(6, 1), new Fraccion(7, -2)},
        {new Fraccion(2, 5), new Fraccion(3, 2)}});});
        assertDoesNotThrow(()->{new MatFrac(new Fraccion[][] { {new Fraccion(5, 1), new Fraccion(7, 2)},
        {new Fraccion(6, 3), new Fraccion(8, 9)}});});        
        
    }
    //para operaciones
    Fraccion f1,f2, resultado;

}
