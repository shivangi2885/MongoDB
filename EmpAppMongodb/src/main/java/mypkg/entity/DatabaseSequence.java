package mypkg.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "database_sequnce")
public class DatabaseSequence {
	
	private String id;
	private long seq;
	public DatabaseSequence() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getSeq() {
		return seq;
	}
	public void setSeq(long seq) {
		this.seq = seq;
	}
	
	

}
