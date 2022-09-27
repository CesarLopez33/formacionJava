package bosonit.ejercicio_72.asignaturas.service;

import bosonit.ejercicio_72.asignaturas.Estudiante_asignatura;
import bosonit.ejercicio_72.asignaturas.dtos.AsignaturaInputDTO;

import java.util.List;

public interface AsignaturaService {
    void crearAsignatura(AsignaturaInputDTO a);
    Estudiante_asignatura actualizaAsignatura(String id, AsignaturaInputDTO a);
    void eliminarAsignatura(String id);
    Estudiante_asignatura obtenerAsignatura(String id);

    List<Estudiante_asignatura> obtenerAsignaturasStudent(String id);
}
