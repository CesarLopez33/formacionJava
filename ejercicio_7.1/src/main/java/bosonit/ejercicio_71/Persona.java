package bosonit.ejercicio_71;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
public class Persona implements java.io.Serializable{
    @Id
    private String id;

    @Column
    private String nombre;

    @Column
    private String edad;

    @Column
    private String poblacion;

}
