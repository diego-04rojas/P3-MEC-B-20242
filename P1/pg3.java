 /*crear una clase llamada fraccion; con atributos correspondientes a numerador y denominador, crear una funcion pura que me permita sumar dos fracciones y me devuelva su resultado*/

package com.mycompany.proyecto_nuevo;


private class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException("El denominador no puede ser cero.");
        }
        this.numerador = numerador;
        this.denominador = denominador;
        simplificar();
    }
    public Fraccion(int numerador) {
        this(numerador, 1); 
    }
    private void simplificar() {
        int gcd = gcd(numerador, denominador);
        numerador /= gcd;
        denominador /= gcd;
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static Fraccion suma(Fraccion f1, Fraccion f2) {
        int nuevoNumerador = f1.numerador * f2.denominador + f2.numerador * f1.denominador;
        int nuevoDenominador = f1.denominador * f2.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    @Override
    public String toString() {
        return numerador + "/" + denominador;
    }

    public static void main(String[] args) {
      
        Fraccion fraccion1 = new Fraccion(1, 2);
        Fraccion fraccion2 = new Fraccion(1, 3);

       
        Fraccion resultado = Fraccion.suma(fraccion1, fraccion2);
 
        System.out.println("Fracción 1: " + fraccion1);
        System.out.println("Fracción 2: " + fraccion2);
        System.out.println("Resultado de la suma: " + resultado);  
    }
}
