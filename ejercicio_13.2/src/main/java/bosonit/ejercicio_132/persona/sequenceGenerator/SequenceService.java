package bosonit.ejercicio_132.persona.sequenceGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class SequenceService {
    @Autowired
    MongoTemplate mongoTemplate;

    public Integer getNextSequence(String seqName) {
        Query query = new Query();
        FindAndModifyOptions options = new FindAndModifyOptions();
        CustomSequences counter = mongoTemplate.findAndModify(
                query.addCriteria(Criteria.where("_id").is(seqName)),
                new Update().inc("seq",1),
                options.returnNew(true).upsert(true),
                CustomSequences.class);
        return counter.getSeq();
    }

}
