package bosonit.ejercicio_72.persona.service;

import bosonit.ejercicio_72.persona.Persona;
import bosonit.ejercicio_72.exceptions.UnprocessableEntityException;
import bosonit.ejercicio_72.persona.repository.PersonaRepository;
import bosonit.ejercicio_72.profesor.Profesor;
import bosonit.ejercicio_72.profesor.dtos.ProfesorPersonaOutputDTO;
import bosonit.ejercicio_72.profesor.repository.ProfesorRepository;
import bosonit.ejercicio_72.student.Student;
import bosonit.ejercicio_72.student.dtos.StudentPersonaOutputDTO;
import bosonit.ejercicio_72.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ProfesorRepository profesorRepositoryr;


    @Override
    public void crearPersona(Persona persona){
        compruebaCampos(persona);
        personaRepository.save(persona);
    }

    @Override
    public Persona actualizarPersona(Integer id, Persona persona){

        Persona p = personaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "No se ha encontrado a la persona con id: "+ id));

        if(persona.getUsuario()!=null){
            if(p.getUsuario().length()>10){throw new UnprocessableEntityException("Longitud usuario no puede ser superior a 10");}
            if(p.getUsuario().length()<6){throw new UnprocessableEntityException("Longitud de usuario no puede ser inferior a 6");}
        }
        if(persona.getPassword()!=null){p.setPassword(persona.getPassword());}
        if(persona.getName()!=null){p.setName(persona.getName());}
        if(persona.getCompany_email()!=null){p.setCompany_email(persona.getCompany_email());}
        if(persona.getPersonal_email()!=null){p.setPersonal_email(persona.getPersonal_email());}
        if(persona.getCity()!=null){p.setCity(persona.getCity());}
        if(persona.getActive()!=null){p.setActive(persona.getActive());}
        if(persona.getCreated_date()!=null){p.setCreated_date(persona.getCreated_date());}
        personaRepository.save(p);
        return p;

    }

    @Override
    public void eliminarPersona(Integer id) {
        try {
            personaRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new EntityNotFoundException("No se ha encontrado a la persona con id: " + id);
        }
    }
    @Override
    public Persona obtenerPersona(Integer id){
        return personaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "No se ha encontrado a la persona con id: "+ id));
    }

    @Override
    public ResponseEntity obtenerPersonaConTodo(Integer id) {
        Persona persona = personaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "No se ha encontrado a la persona con id: "+ id));
        Optional<Student> student = studentRepository.findByPersona(persona);
        if(student.isPresent()) return new ResponseEntity(new StudentPersonaOutputDTO(student.get()), HttpStatus.OK);
        Optional<Profesor> profesor = profesorRepositoryr.findByPersona(persona);
        if(profesor.isPresent()) return new ResponseEntity(new ProfesorPersonaOutputDTO(profesor.get()),HttpStatus.OK);
        throw new EntityNotFoundException("La persona no tiene ni estudiante ni profesor asociados");
    }

    @Override
    public List<Persona> obtenerPersonaPorNombre(String nombre){
        List<Persona> p = personaRepository.findByName(nombre);
        if(p.isEmpty()) throw new EntityNotFoundException("No se ha encontrado a la persona con nombre: "+ nombre);
        else return p;
    }

    @Override
    public ResponseEntity obtenerPersonaPorNombreConTodo(String nombre) {
        List<Persona> personas = personaRepository.findByName(nombre);
        if(personas.isEmpty()) throw new EntityNotFoundException("No se han encontrado personas con nombre: "+ nombre);
        ArrayList<Object> datos = new ArrayList<>();
        for(Persona p : personas){
            Optional<Student> student = studentRepository.findByPersona(p);
            Optional<Profesor> profesor = profesorRepositoryr.findByPersona(p);
            if(student.isPresent()) datos.add(new StudentPersonaOutputDTO(student.get()));
            else if(profesor.isPresent()) datos.add(new ProfesorPersonaOutputDTO(profesor.get()));
            else datos.add(p);
        }
        return new ResponseEntity(datos,HttpStatus.OK);
    }

    @Override
    public List<Persona> obtenerTodasPersonas() {
        ArrayList personas = new ArrayList<>();
        personaRepository.findAll().forEach(p->personas.add(p));
        return personas;
    }

    @Override
    public ResponseEntity obtenerTodasPersonaConTodo() {
        List<Persona> personas = personaRepository.findAll();
        if(personas.isEmpty()) throw new EntityNotFoundException("No hay personas en la base de datos");
        ArrayList<Object> datos = new ArrayList<>();
        for(Persona p : personas){
            Optional<Student> student = studentRepository.findByPersona(p);
            Optional<Profesor> profesor = profesorRepositoryr.findByPersona(p);
            if(student.isPresent()) datos.add(new StudentPersonaOutputDTO(student.get()));
            else if(profesor.isPresent()) datos.add(new ProfesorPersonaOutputDTO(profesor.get()));
            else datos.add(p);
        }
        return new ResponseEntity(datos,HttpStatus.OK);
    }

    private static void compruebaCampos(Persona p){
        if(p.getUsuario()==null){throw new UnprocessableEntityException("Usuario no puede ser nulo");}
        if(p.getUsuario().length()>10){throw new UnprocessableEntityException("Longitud usuario no puede ser superior a 10");}
        if(p.getUsuario().length()<6){throw new UnprocessableEntityException("Longitud de usuario no puede ser inferior a 6");}
        if(p.getPassword()==null){throw new UnprocessableEntityException("Password no puede ser nulo");}
        if(p.getName()==null){throw new UnprocessableEntityException("Name no puede ser nulo");}
        if(p.getCompany_email()==null){throw new UnprocessableEntityException("Company_email no puede ser nulo");}
        if(p.getPersonal_email()==null){throw new UnprocessableEntityException("Personal_email no puede ser nulo");}
        if(p.getCity()==null){throw new UnprocessableEntityException("City no puede ser nulo");}
        if(p.getActive()==null){throw new UnprocessableEntityException("Campo active no puede ser nulo");}
        if(p.getCreated_date()==null){throw new UnprocessableEntityException("Created_date no puede ser nulo");}
    }
}
