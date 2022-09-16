package evaluadorPacket;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Metodos {
    public List<Expresion> leerExpresiones() throws IOException, FileNotFoundException {
        String nombreArchivo ="ejercicio_1.2/expresiones.txt";
        FileReader fr = new FileReader(nombreArchivo);
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();
        List<Expresion> expresionesLineas = new ArrayList<>();
        while(line!=null) {
            String[] datosLinea = line.split(" ");
            Expresion e = new Expresion(Arrays.asList(datosLinea));
            expresionesLineas.add(e);
            line = br.readLine();
        }
        return expresionesLineas;
    }
    public String resolverCadenas(List<String> datos){
        if(datos.size()==1) return datos.get(0);
        for (String d : datos) {
            if (d.equals("+"))
                return resolverCadenas(datos.subList(0, datos.indexOf(d))).concat(
                        resolverCadenas(datos.subList(datos.indexOf(d) + 1,datos.size()))
                        );
        }
        for (String d : datos) {
            if (d.equals("*")) {
                int num = Integer.parseInt(datos.get(datos.indexOf(d) + 1));
                String aux = "";
                for (int i=0; i<num; i++)
                    aux=aux.concat(d);
                return resolverCadenas(datos.subList(0, datos.indexOf(d)));

            }
        }
        return "";
    }
    public int resolverEnteros(List<String> datos){
        if(datos.size()==1) return Integer.parseInt(datos.get(0));
        for (String d : datos) {
            if (d.equals("-"))
                return resolverEnteros(datos.subList(0, datos.indexOf(d)))
                        - resolverEnteros(datos.subList(datos.indexOf(d) + 1,datos.size()));
        }
        for (String d : datos) {
            if (d.equals("+"))
                return resolverEnteros(datos.subList(0, datos.indexOf(d)))
                        + resolverEnteros(datos.subList(datos.indexOf(d) + 1,datos.size()));
        }
        for (String d : datos) {
            if (d.equals("/"))
                return resolverEnteros(datos.subList(0, datos.indexOf(d)))
                        / resolverEnteros(datos.subList(datos.indexOf(d) + 1,datos.size()));
        }
        for (String d : datos) {
            if (d.equals("*"))
                return resolverEnteros(datos.subList(0, datos.indexOf(d)))
                        * resolverEnteros(datos.subList(datos.indexOf(d) + 1,datos.size()));
        }
        return -1;
    }
}
