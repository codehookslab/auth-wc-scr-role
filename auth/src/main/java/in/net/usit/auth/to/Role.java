package in.net.usit.auth.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "role")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long uid;
	@Column(name = "role_name")
	private String roleName;
	@Column(name = "role_desc")
	private String roleDesc;
	
	@Override
	public String toString() {
		return "Role [uid=" + uid + ", roleName=" + roleName + ", roleDesc="
				+ roleDesc + "]";
	}
}
