package com.spingworkapps.sampletask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;
import java.util.Optional;

import com.spingworkapps.sampletask.entity.SequenceTasks;
import com.spingworkapps.sampletask.entity.Tasks;
import com.spingworkapps.sampletask.repository.TaskRepo;

@Service
public class TaskServices {

	@Autowired
	TaskRepo tr;
	
	@Autowired
	TaskServices ts;
	
	@Autowired 
	private MongoOperations mongo;

    public int getNextSequence(String seqName)
    {
       
    	SequenceTasks counter = mongo.findAndModify(
                query(where("_id").is(seqName)),
                new Update().inc("sqe",1),
                options().returnNew(true).upsert(true),
                SequenceTasks.class);
            return counter.getSqe();
    }
	
	public Tasks saveall(Tasks t) {
		t.setId(ts.getNextSequence(Tasks.SEQUENCE_NAME));
		t.setStatus("created");
		tr.save(t);
		return t;
		
	}

	public List<Tasks> getall() {
	  List<Tasks> li=tr.findAll();
		return li;
	}
	
	public Tasks getbyid(int id) {
		Optional<Tasks> li= tr.findById(id);
		Tasks t= li.get();
		return t;
	}


	public int deletebyid(int id) {
		tr.deleteById(id);
		return id;
		
		
	}

	public Tasks update(int id) {
		Optional<Tasks> tk= tr.findById(id);
            Tasks ta= tk.get();
			ta.setStatus("completed");
		 return tr.save(ta);
		}
		
		
	}

	

