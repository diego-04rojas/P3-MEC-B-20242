public class Proyecto_nuevo {
 
    class Fraccion:
    def __init__(self, numerador, denominador):
        # Asegúrate de que el denominador no sea cero
        if denominador == 0:
            raise ValueError("El denominador no puede ser cero.")
        self.__numerador = numerador
        self.__denominador = denominador
    
    # Métodos para obtener el numerador
    def get_numerador(self):
        return self.__numerador
    
    # Métodos para establecer el numerador
    def set_numerador(self, numerador):
        self.__numerador = numerador
    
   
    }
