package bosonit.ejercicio_72.persona.repository;

import bosonit.ejercicio_72.persona.Persona;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Repository
public class PersonaRepositoryImpl{
    @PersistenceContext
    EntityManager entityManager;

    public List<Persona> getData(HashMap<String,Object> condiciones,int numPage,int pageSize){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery(Persona.class);
        Root<Persona> root = query.from(Persona.class);

        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");

        List<Predicate> predicates = new ArrayList<>();
        List<Order> orderList = new ArrayList<>();
        condiciones.forEach((field,value)-> {
            switch (field){
                case "usuario":
                case "name":
                case "surname":
                    predicates.add(cb.like(root.get(field),"%"+ value.toString()+"%"));
                    break;
                case "created_date":
                    String date_condition = condiciones.get("date_condition").toString();
                    switch (date_condition){
                        case "greater":
                            try {
                                predicates.add(cb.greaterThan(root.<Date>get(field),formater.parse(value.toString())));
                            } catch (ParseException e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case "less":
                            try {
                                predicates.add(cb.lessThan(root.<Date>get(field),formater.parse(value.toString())));
                            } catch (ParseException e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case "equal":
                            try {
                                predicates.add(cb.equal(root.<Date>get(field), formater.parse(value.toString())));
                            } catch (ParseException e) {
                                throw new RuntimeException(e);
                            }
                            break;
                    }
                    break;
                case "order_by":
                    String order_by = condiciones.get(field).toString();
                    switch (order_by){
                        case "name":
                            orderList.add( cb.asc(root.get("name")));
                            break;
                        case "user":
                            orderList.add( cb.asc(root.get("user")));
                            break;
                    }
                    break;
            }
        });
        query.select(root).where(predicates.toArray(new Predicate[predicates.size()])).orderBy(orderList);
        TypedQuery<Persona> typedQuery = entityManager.createQuery(query);
        typedQuery.setFirstResult(numPage*pageSize);
        typedQuery.setMaxResults(pageSize);
        return typedQuery.getResultList();
    }
}
