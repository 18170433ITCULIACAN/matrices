package fracciones;

public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion() {
        this.numerador = 0;
        this.denominador = 1;
    }

    public Fraccion(int numerador, int denominador) {
        validarNumeros(numerador, denominador);
        int maxCD = calcularMCD(numerador, denominador);
        this.numerador = numerador / maxCD;
        this.denominador = denominador / maxCD;

    }

    private int calcularMCD(int num1, int num2) {
        // Asegurarse de que num1 sea mayor o igual que num2
        if (num2 > num1) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        // Calcular el MCD utilizando el algoritmo de Euclides
        while (num2 != 0) {
            int resto = num1 % num2;
            num1 = num2;
            num2 = resto;
        }

        return num1;
        // Elaborar funcion privada de deteccion de numeradores y denominadores
        // invalidos TASK 78

    }

    private void validarNumeros(int numerador, int denominador) throws IllegalArgumentException {
        if (numerador < 0 && denominador <= 0) {
            throw new IllegalArgumentException("No se permite una fracción con numerador y denominador negativos.");
        } else if (numerador >= 0 && denominador <= 0) {
            throw new IllegalArgumentException(
                    "No se permite una fracción con numerador positivo y denominador negativo.");
        }

    }

    
    public Fraccion sumarFracciones(Fraccion f) {
        int numeradorSuma = (getNumerador() * f.getDenominador()) + (f.getNumerador() * getDenominador());
        int denominadorSuma = getDenominador() * f.getDenominador();
        return new Fraccion(numeradorSuma,denominadorSuma);
    }

    public Fraccion multiplicar(Fraccion f){
        numerador = getNumerador()*f.getNumerador();
        denominador = getDenominador()*f.getDenominador();
        return new Fraccion(numerador,denominador);
    }

    public int getNumerador(){
        return numerador;
    }
    public int getDenominador(){
        return denominador;
    }
    public void imprimir(){
        System.out.println(getNumerador()+"/"+getDenominador());
    }
}
