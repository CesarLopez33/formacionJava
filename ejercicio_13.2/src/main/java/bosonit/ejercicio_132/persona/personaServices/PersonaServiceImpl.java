package bosonit.ejercicio_132.persona.personaServices;

import bosonit.ejercicio_132.persona.Persona;
import bosonit.ejercicio_132.persona.dtos.PersonaInputDTO;
import bosonit.ejercicio_132.persona.dtos.PersonaOutputDTO;
import bosonit.ejercicio_132.persona.sequenceGenerator.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    SequenceService sequenceService;

    @Override
    public PersonaOutputDTO obtenerPersona(Integer id) {
        Persona p = mongoTemplate.findById(id,Persona.class);
        if(p==null)return null;
        else return new PersonaOutputDTO(p);
    }

    @Override
    public PersonaOutputDTO crearPersona(PersonaInputDTO persona) {
        Persona p = new Persona(persona);
        p.setId_persona(sequenceService.getNextSequence("sequence_persona"));
        mongoTemplate.insert(p,"persona");
        return new PersonaOutputDTO(p);
    }

    @Override
    public PersonaOutputDTO actualizarPersona(Integer id, PersonaInputDTO persona) {
        Persona p = mongoTemplate.findById(id,Persona.class);
        if(p==null) return null;
        if(persona.getUsuario()!=null){p.setUsuario(persona.getUsuario());}
        if(persona.getPassword()!=null){p.setPassword(persona.getPassword());}
        if(persona.getName()!=null){p.setName(persona.getName());}
        if(persona.getSurname()!=null){p.setSurname(persona.getSurname());}
        if(persona.getCompany_email()!=null){p.setCompany_email(persona.getCompany_email());}
        if(persona.getPersonal_email()!=null){p.setPersonal_email(persona.getPersonal_email());}
        if(persona.getCity()!=null){p.setCity(persona.getCity());}
        if(persona.getActive()!=null){p.setActive(persona.getActive());}
        if(persona.getCreated_date()!=null){p.setCreated_date(persona.getCreated_date());}
        if(persona.getImagen_url()!=null){p.setImagen_url(persona.getImagen_url());}
        mongoTemplate.save(p);
        return new PersonaOutputDTO(p);
    }

    @Override
    public void eliminarPersona(Integer id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        mongoTemplate.remove(query,Persona.class);

        /*
        Persona p = mongoTemplate.findById(id,Persona.class);
        if (p!=null) mongoTemplate.remove(p);
        */
    }

    @Override
    public List<PersonaOutputDTO> obtenerTodasPersonas() {
        return mongoTemplate.findAll(Persona.class).stream().map(p->new PersonaOutputDTO(p)).toList();
    }

    @Override
    public List<PersonaOutputDTO> obtenerTodasPersonasPaginada(int pageSize, int numPage) {
        Query query = new Query();
        query.skip(pageSize*numPage);
        query.limit(pageSize);
        return mongoTemplate.find(query,Persona.class).stream().map(p-> new PersonaOutputDTO(p)).toList();
    }
}
