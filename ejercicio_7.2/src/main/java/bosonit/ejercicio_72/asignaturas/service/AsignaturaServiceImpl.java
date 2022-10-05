package bosonit.ejercicio_72.asignaturas.service;

import bosonit.ejercicio_72.asignaturas.Estudiante_asignatura;
import bosonit.ejercicio_72.asignaturas.dtos.AsignaturaInputDTO;
import bosonit.ejercicio_72.asignaturas.dtos.AsignaturaOutputDTO;
import bosonit.ejercicio_72.asignaturas.repositories.AsignaturaRepository;
import bosonit.ejercicio_72.exceptions.UnprocessableEntityException;
import bosonit.ejercicio_72.student.Student;
import bosonit.ejercicio_72.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
public class AsignaturaServiceImpl implements AsignaturaService{
    @Autowired
    AsignaturaRepository asignaturaRepository;
    @Autowired
    StudentRepository studentRepository;

    @Override
    public AsignaturaOutputDTO crearAsignatura(AsignaturaInputDTO a) {
        if (a.getInitial_date()==null) throw new UnprocessableEntityException("Initial_date no puede ser nulo");
        Estudiante_asignatura e = new Estudiante_asignatura(a);
        asignaturaRepository.save(e);
        return new AsignaturaOutputDTO(e);
    }

    @Override
    public Estudiante_asignatura actualizaAsignatura(String id, AsignaturaInputDTO a) {
        Estudiante_asignatura e = asignaturaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se ha encontrado asignatura con id: "+ id));
        if (a.getAsignatura()!=null) e.setAsignatura(a.getAsignatura());
        if (a.getInitial_date()!=null) e.setInitial_date(a.getInitial_date());
        if (a.getFinish_date()!=null) e.setFinish_date(a.getFinish_date());
        if (a.getComments()!=null) e.setComments(a.getComments());
        asignaturaRepository.save(e);
        return e;
    }

    @Override
    public void eliminarAsignatura(String id) {
        try {
            asignaturaRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new EntityNotFoundException("No se ha encontrado la asignatura con id: " + id);
        }
    }

    @Override
    public Estudiante_asignatura obtenerAsignatura(String id) {
        return asignaturaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "No se ha encontrado la asignatura con id: "+ id));
    }

    @Override
    public List<Estudiante_asignatura> obtenerAsignaturasStudent(String id) {
        Student s = studentRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("No se ha encontrado al estudiante con id: "+ id));
        return s.getAsignaturas();
    }
}
