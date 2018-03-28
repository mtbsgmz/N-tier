package com.entities;

import java.io.Serializable;
import java.lang.Long;
import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Entity implementation class for Entity: BaseEntitiy
 *
 */

@MappedSuperclass
public class BaseEntitiy implements Serializable {

	   
	@Id
	@SequenceGenerator(allocationSize = 1, name = "SEQ_BASE", initialValue = 1)
	@GeneratedValue(strategy = SEQUENCE, generator = "SEQ_BASE")
	private Long ID;
	private static final long serialVersionUID = 1L;

	public BaseEntitiy() {
		super();
	}   
	public Long getID() {
		return this.ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntitiy other = (BaseEntitiy) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}
	
   
}
