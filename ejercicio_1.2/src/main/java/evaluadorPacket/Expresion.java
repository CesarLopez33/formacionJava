package evaluadorPacket;

import java.util.List;

public class Expresion {
    private List<String> expresion;

    public Expresion(List<String> expresion) {
        this.expresion = expresion;
    }

    public List<String> getExpresion() {
        return expresion;
    }

    public void setExpresion(List<String> expresion) {
        this.expresion = expresion;
    }
}
