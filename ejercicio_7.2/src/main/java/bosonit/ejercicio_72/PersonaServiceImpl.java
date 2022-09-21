package bosonit.ejercicio_72;

import bosonit.ejercicio_72.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    PersonaRepository ps;


    @Override
    public void crearPersona(Persona persona) {
        try {
            compruebaCampos(persona);
        } catch (Exception e) {
            return;
        }
        ps.save(persona);
    }

    @Override
    public Persona actualizarPersona(Integer id, Persona persona){
        try {
            Persona p = ps.findById(id).orElseThrow(() -> new FileNotFoundException());

            if(persona.getUsuario()!=null){
                if(p.getUsuario().length()>10){throw new Exception("Longitud usuario no puede ser superior a 10");}
                if(p.getUsuario().length()<6){throw new Exception("Longitud de usuario no puede ser inferior a 6");}
            }
            if(persona.getPassword()!=null){p.setPassword(persona.getPassword());}
            if(persona.getName()!=null){p.setName(persona.getName());}
            if(persona.getCompany_email()!=null){p.setCompany_email(persona.getCompany_email());}
            if(persona.getPersonal_email()!=null){p.setPersonal_email(persona.getPersonal_email());}
            if(persona.getCity()!=null){p.setCity(persona.getCity());}
            if(persona.getActive()!=null){p.setActive(persona.getActive());}
            if(persona.getCreated_date()!=null){p.setCreated_date(persona.getCreated_date());}
            ps.save(p);
            return p;
        }catch (FileNotFoundException e){
            System.out.println("Persona no encontrada");
            return null;
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public Persona obtenerPersona(Integer id) throws FileNotFoundException{
        return ps.findById(id).orElseThrow(()-> new FileNotFoundException("Persona no encontrada"));
    }

    @Override
    public void eliminarPersona(Integer id) {
        ps.deleteById(id);
    }

    @Override
    public List<Persona> obtenerTodasPersonas() {
        ArrayList personas = new ArrayList<>();
        ps.findAll().forEach(p->personas.add(p));
        return personas;
    }

    @Override
    public Persona obtenerPersonaPorNombre(String nombre) throws FileNotFoundException{
        return ps.findFirstByName(nombre).orElseThrow(()->new FileNotFoundException("No se encuentra a la persona"));
    }
    static void compruebaCampos(Persona p) throws Exception{
        if(p.getUsuario()==null){throw new Exception("Usuario no puede ser nulo");}
        if(p.getUsuario().length()>10){throw new Exception("Longitud usuario no puede ser superior a 10");}
        if(p.getUsuario().length()<6){throw new Exception("Longitud de usuario no puede ser inferior a 6");}
        if(p.getPassword()==null){throw new Exception("Password no puede ser nulo");}
        if(p.getName()==null){throw new Exception("Name no puede ser nulo");}
        if(p.getCompany_email()==null){throw new Exception("Company_email no puede ser nulo");}
        if(p.getPersonal_email()==null){throw new Exception("Personal_email no puede ser nulo");}
        if(p.getCity()==null){throw new Exception("City no puede ser nulo");}
        if(p.getActive()==null){throw new Exception("Campo active no puede ser nulo");}
        if(p.getCreated_date()==null){throw new Exception("Created_date no puede ser nulo");}
    }
}
