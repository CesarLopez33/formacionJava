package bosonit.ejercicio_72.student.service;

import bosonit.ejercicio_72.student.Student;
import bosonit.ejercicio_72.student.dtos.IdsAsignaturasInputDTO;
import bosonit.ejercicio_72.student.dtos.StudentInputDTO;
import bosonit.ejercicio_72.student.dtos.StudentOutputDTO;
import bosonit.ejercicio_72.student.dtos.StudentPersonaOutputDTO;

import java.util.List;

public interface StudentService {
    StudentOutputDTO crearStudent(StudentInputDTO Student);
    StudentOutputDTO actualizarStudent(String id, StudentInputDTO Student);
    void eliminarStudent(String id);
    StudentOutputDTO obtenerStudent(String id);
    StudentPersonaOutputDTO obtenerStudentPersona(String id);
    Student obtenerStudentPorNombre(String nombre);
    List<Student> obtenerTodasStudents();
    void addAsignaturas(String id, IdsAsignaturasInputDTO ids_asig);
    void deleteAsignaturas(String id, IdsAsignaturasInputDTO ids_asig);
}
