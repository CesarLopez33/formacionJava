package bosonit.ejercicio_72.generadorIds;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.stream.Stream;

public class MiGenerador implements IdentifierGenerator{
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object o) throws HibernateException {
        String query = String.format("select %s from %s",
                session.getEntityPersister(o.getClass().getName(), o)
                        .getIdentifierPropertyName(),
                o.getClass().getSimpleName());

        Stream<String> ids = session.createQuery(query).stream();
        Integer max = ids.mapToInt(Integer::parseInt)
                .max()
                .orElse(0);

        return max + 1 + "";
    }
}
