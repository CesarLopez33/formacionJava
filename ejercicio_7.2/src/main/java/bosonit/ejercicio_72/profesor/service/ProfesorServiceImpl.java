package bosonit.ejercicio_72.profesor.service;

import bosonit.ejercicio_72.exceptions.UnprocessableEntityException;
import bosonit.ejercicio_72.persona.Persona;
import bosonit.ejercicio_72.persona.service.PersonaService;
import bosonit.ejercicio_72.profesor.Profesor;
import bosonit.ejercicio_72.profesor.dtos.ProfesorInputDTO;
import bosonit.ejercicio_72.profesor.dtos.ProfesorOutputDTO;
import bosonit.ejercicio_72.profesor.dtos.ProfesorPersonaOutputDTO;
import bosonit.ejercicio_72.profesor.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ProfesorServiceImpl implements ProfesorService{
    @Autowired
    ProfesorRepository profesorRepository;
    @Autowired
    PersonaService personaService;

    @Override
    public void crearProfesor(ProfesorInputDTO profesor) {
        if (profesor.getBranch()==null) throw new UnprocessableEntityException("Branch no puede ser nulo");
        if (profesor.getId_persona()==null) throw new UnprocessableEntityException("id_persona no puede ser nulo");
        Persona p = personaService.obtenerPersona(profesor.getId_persona());
        Profesor pro = new Profesor(profesor);
        pro.setPersona(p);
        profesorRepository.save(pro);
    }

    @Override
    public ProfesorOutputDTO obtenerProfesor(String id) {
        return new ProfesorOutputDTO(profesorRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("No se ha encontrado al profesor con id" + id)));
    }

    @Override
    public ProfesorPersonaOutputDTO obtenerProfesorPersona(String id) {
        return new ProfesorPersonaOutputDTO(profesorRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("No se ha encontrado al profesor con id" + id)));
    }

    @Override
    public ProfesorOutputDTO actualizarProfesor(ProfesorInputDTO profesor, String id) {
        Profesor p = profesorRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("No se ha encontrado al profesor con id" + id));
        if(profesor.getBranch()!=null) p.setBranch(profesor.getBranch());
        if(profesor.getComments()!=null) p.setComments(profesor.getComments());
        profesorRepository.save(p);
        return new ProfesorOutputDTO(p);
    }

    @Override
    public void eliminarProfesor(String id) {
        try {
            profesorRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new EntityNotFoundException("No se ha encontrado al profesor con id: " + id);
        }
    }
}
