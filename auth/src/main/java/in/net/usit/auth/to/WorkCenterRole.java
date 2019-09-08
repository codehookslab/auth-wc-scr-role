package in.net.usit.auth.to;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkCenterRole {
	
	@Id
	private WorkCenterRoleCompositeKey id;
	
	
	@OneToMany(mappedBy = "id.wcRoleId")
	private List<WorkCenterRoleScreens> screens = new ArrayList<WorkCenterRoleScreens>();


	@Override
	public String toString() {
		return "WorkCenterRole [id=" + id + "]";
	}
	
	
}
