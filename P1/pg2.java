 /*crear una clase llamada fraccion; con atributos correspondientes a numerador y denominador, crear una sobre carga para el constructor y crear un objeto para cada una de sus formas del contructos*/

package com.mycompany.proyecto_nuevo;


class Fraccion{
    def__init__(self, numerador , denominador=1)
     
        if denominador == 0:
            raise ValueError("El denominador no puede ser cero.")
        self.numerador = numerador
        self.denominador = denominador

    def __str__(self):
        return f"{self.numerador}/{self.denominador}"

    def __repr__(self):
        return f"Fraccion({self.numerador}, {self.denominador})"




fraccion1 = Fraccion(3, 4)
print(fraccion1)  Output: 3/4

fraccion2 = Fraccion(7)
print(fraccion2)  Output: 7/1
}
