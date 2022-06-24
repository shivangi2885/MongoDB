package mypkg.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import mypkg.entity.DatabaseSequence;

@Service
public class SequenceGeneratorService {
	
	@Autowired
	private MongoOperations mongoOperations;

	@SuppressWarnings("null")
	public long generateSequence(String sequenceName) {
		// TODO Auto-generated method stub
		
		DatabaseSequence counter=mongoOperations.findAndModify(query(where("_id").is(sequenceName)),
				new Update().inc("seq",1),options().returnNew(true).upsert(true),DatabaseSequence.class);
//		if(Objects.isNull(counter)) {
//			return counter.getSeq();
//		}
//		else
//		{
//			return 1;
//		}
		
		
		
		return !Objects.isNull(counter)? counter.getSeq() : 1;
	}

}
