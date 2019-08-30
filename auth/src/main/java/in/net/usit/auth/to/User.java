package in.net.usit.auth.to;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
import antlr.collections.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user")
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long uid;
	@Column(name = "user_name")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "valid_from")
	private Date validFrom;
	@Column(name = "valid_upto")
	private Date validUpto;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "role_id_fk"))
//	private Role role;
	@ManyToMany
	@JoinTable(name = "user_wc_role")
	private Set<WorkCenterRole> wcRolesMap;
	
	@Transient
	private Set<Screen> screenOrModules;

}
