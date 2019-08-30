package in.net.usit.auth.to;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkCenterRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ROLE_ID")
	private Role roleId;
	
	@ManyToOne
	@JoinColumn(name = "WC_ID")
	private Workcentermaster wcId;
	
//	@ManyToMany
//	@JoinTable(
//			name = "role_screen"
//			)
//	private List<Screen> screens = new ArrayList<>();
	
	@OneToMany(mappedBy = "wcRoleId")
	private List<WorkCenterRoleScreens> screens = new ArrayList<WorkCenterRoleScreens>();
	
}
