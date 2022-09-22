package bosonit.ejercicio_72.services;

import bosonit.ejercicio_72.entities.Student;

import java.util.List;

public interface StudentService {
    void crearStudent(Student Student);
    Student actualizarStudent(String id, Student Student);
    void eliminarStudent(String id);
    Student obtenerStudent(String id);
    Student obtenerStudentPorNombre(String nombre);
    List<Student> obtenerTodasStudents();
}
