package evaluadorPacket;

import java.io.*;
import java.util.List;


public class EvaluadorExpresiones {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Metodos m = new Metodos();
        List<Expresion> expresiones = m.leerExpresiones();
        expresiones.forEach(e->System.out.println(m.resolverEnteros(e.getExpresion())));
    }

}
