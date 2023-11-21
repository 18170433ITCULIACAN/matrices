package fracciones;
public class MatFrac {
    private Fraccion[][] matriz;
    private int filas, columnas;

    public MatFrac() {
        matriz = new Fraccion[1][1];
        } 
    public MatFrac(Fraccion[][] matriz) {
        this.matriz = matriz;
        validarMatriz();
    }


    public void setFraccion(int fila, int columna, Fraccion fraccion) {
        matriz[fila][columna] = fraccion;
    }

    public void validarMatriz() throws IllegalArgumentException {
        if (getFilas() <= 0 && getColumnas() <= 0) {
            throw new IllegalArgumentException("No se permite una fracción con numerador y denominador negativos.");
        }
        for (Fraccion[] fila : matriz) {
            for (Fraccion fraccion : fila) {
                if (fraccion == null || !(fraccion instanceof Fraccion)) {
                    throw new IllegalArgumentException("Todos los elementos de la matriz deben ser objetos de la clase Fraccion.");
                }
            }
        }
    }


    public Fraccion[][] getMatriz() {
        return matriz;
    }
    public int getFilas() {
        return matriz.length;
    }

    public int getColumnas() {
        return matriz[0].length;
    }
}
