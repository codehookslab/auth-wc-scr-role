package in.net.usit.auth.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Getter
@Setter
@Entity
@Table(name = "work_center_role_map")
@ToString
public class WorkCenterRoleScreens {
	
	@Id
	@JsonProperty(access = Access.WRITE_ONLY)
	private WorkCenterRoleScreensCompositeKey id;
	
	@Transient
	private WorkCenterRoleScreensCompositeKey transId;

	@Column(name = "can_insert")
	private Boolean canInsert;
	
	@Column(name = "can_update")
	private Boolean canUpdate;
	
	@Column(name = "can_remove")
	private Boolean canRemove;
	
	@Column(name = "can_view")
	private Boolean canView;
	
	@Column(name = "access_value")
	private Byte accessValue;
}
