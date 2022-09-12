package ejercicios;


import java.io.IOException;

public class Ejercicio1 {
    public static void main(String[] args) throws IOException,InvalidLineFormatException {
        Metodos m = new Metodos();
        m.printPeople(m.leerFichero());
    }
}
