package bosonit.ejercicio_72.asignaturas.service;

import bosonit.ejercicio_72.asignaturas.Asignatura;
import bosonit.ejercicio_72.asignaturas.dtos.AsignaturaInputDTO;
import bosonit.ejercicio_72.asignaturas.dtos.AsignaturaOutputDTO;

import java.util.List;

public interface AsignaturaService {
    AsignaturaOutputDTO crearAsignatura(AsignaturaInputDTO a);
    AsignaturaOutputDTO actualizaAsignatura(String id, AsignaturaInputDTO a);
    void eliminarAsignatura(String id);
    AsignaturaOutputDTO obtenerAsignatura(String id);

    List<Asignatura> obtenerAsignaturasStudent(String id);
}
