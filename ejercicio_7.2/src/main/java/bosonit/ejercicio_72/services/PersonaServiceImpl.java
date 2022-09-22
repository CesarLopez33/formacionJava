package bosonit.ejercicio_72.services;

import bosonit.ejercicio_72.entities.Persona;
import bosonit.ejercicio_72.exceptions.UnprocessableEntityException;
import bosonit.ejercicio_72.repository.PersonaRepository;
import bosonit.ejercicio_72.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    PersonaRepository pr;


    @Override
    public void crearPersona(Persona persona){
        compruebaCampos(persona);
        pr.save(persona);
    }

    @Override
    public Persona actualizarPersona(Integer id, Persona persona){

        Persona p = pr.findById(id).orElseThrow(() -> new EntityNotFoundException(
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
        pr.save(p);
        return p;

    }

    @Override
    public void eliminarPersona(Integer id) {
        try {
            pr.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new EntityNotFoundException("No se ha encontrado a la persona con id: " + id);
        }
    }
    @Override
    public Persona obtenerPersona(Integer id){
        return pr.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "No se ha encontrado a la persona con id: "+ id));
    }
    @Override
    public Persona obtenerPersonaPorNombre(String nombre){
        return pr.findFirstByName(nombre).orElseThrow(()->new EntityNotFoundException(
                "No se ha encontrado a la persona con nombre: "+ nombre));
    }
    @Override
    public List<Persona> obtenerTodasPersonas() {
        ArrayList personas = new ArrayList<>();
        pr.findAll().forEach(p->personas.add(p));
        return personas;
    }

    static void compruebaCampos(Persona p){
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
