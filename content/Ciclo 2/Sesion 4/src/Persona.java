/**
Cree una clase llamada Persona que cumpla las siguientes condiciones:
    1. Sus atributos son: nombre, edad, DNI, sexo (H hombre, M mujer), peso y altura. Añada un
    atributo de libre elección.
    2. Por defecto, todos los atributos menos el DNI serán valores por defecto según su tipo (0
    números, cadena vacía para String, etc.). Sexo será hombre por defecto.
    3. Se implantarán varios constructores:
         Un constructor por defecto.
         Un constructor con el nombre, edad.
         Un constructor con todos los atributos como parámetro.
    4. Los métodos que se implementarán son:
         calcularIMC(): calculara si la persona está en su peso ideal (peso en kg/(altura^2 en m)), si
            ésta fórmula devuelve un valor menor que 20, la función devuelve un -1, si devuelve un
            número entre 20 y 25 (incluidos), significa que está por debajo de su peso ideal y la
            función devuelve un 0 y si devuelve un valor mayor que 25 significa que tiene sobrepeso,
            la función devuelve un 1. Puede usar constantes para devolver estos valores.
         esMayorDeEdad(): indica si es mayor de edad, devuelve un booleano.
         generaDNI(): genera un número aleatorio de 8 cifras. 

DIAGRAMA DE CLASE
------------------------------------------------------------------------------------------------------
Persona
------------------------------------------------------------------------------------------------------
nombre: String
edad : int
dni : int
sexo : Character (H, M)
peso : double
altura : double
ejercita : Boolean
-------------------------------------------------------------------------------------------------------
Persona(String nombre, int edad, chart sexo, double peso, double altura, boolean control) Por defecto
Persona(String nombre, int edad) con dos parametros
Persona(String nombre, int edad, int dni, chart sexo, double peso, double altura, boolean control) con todos param
calcularIMC() : int
esMayorDeEdad() : booleano
generaDNI() : int
-------------------------------------------------------------------------------------------------------
 */

public class Persona {
    String nombre;
    int edad;
    int dni;
    Character sexo;
    double peso;
    double altura;
    Boolean ejercita;

    public Persona() {
        this.nombre = " ";
        this.edad = 0;
        this.sexo = 'H';
        this.peso = 0;
        this.altura = 0;
        this.ejercita = false;
    }

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Persona(String nombre, int edad, int dni, Character sexo, double peso, double altura, Boolean ejercita) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
        this.ejercita = ejercita;
    }

    public int calcularIMC() {  
        int imc= -1;
        final int pesoIdeal = -1;
        final int bajoPeso = 0;
        final int sobrePeso = 1;

        altura = Math.pow(altura, 2);
        if ((peso/altura) < 20){
            imc = pesoIdeal;
        }
        else if ((peso/altura) >=20 && (peso/altura) <= 25) {
            imc = bajoPeso;
        }
        else if ((peso/altura) >25) {
            imc = sobrePeso;
        }
        return imc;
    }

    public Boolean esMayorDeEdad(){
        Boolean mayor;
        if (edad > 17) {
            mayor = true;
        }
        else{
            mayor = false;
        }
        return mayor;
    }

    public int generaDNI(){
        dni = (int) (Math.random()*100000000);
        return dni;
    }

    
}
