package bosonit.ejercicio_72.student.service;

import bosonit.ejercicio_72.student.dtos.input.IdsAsignaturasInputDTO;
import bosonit.ejercicio_72.student.dtos.input.StudentInputDTO;
import bosonit.ejercicio_72.student.dtos.output.StudentOutputDTO;
import bosonit.ejercicio_72.student.dtos.output.StudentPersonaOutputDTO;


public interface StudentService {
    StudentOutputDTO crearStudent(StudentInputDTO student);
    StudentOutputDTO actualizarStudent(String id, StudentInputDTO student);
    void eliminarStudent(String id);
    StudentOutputDTO obtenerStudent(String id);
    StudentPersonaOutputDTO obtenerStudentPersona(String id);
    void addAsignaturas(String id, IdsAsignaturasInputDTO idsAsig);
    void deleteAsignaturas(String id, IdsAsignaturasInputDTO idsAsig);
}
