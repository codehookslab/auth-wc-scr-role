package in.net.usit.auth.to;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class WorkCenterRoleCompositeKey implements Serializable {

	@ManyToOne
	@JoinColumn(name = "ROLE_ID")
	private Role roleId;
	
	@ManyToOne
	@JoinColumn(name = "WC_ID")
	private Workcentermaster wcId;

	public Role getRoleId() {
		return roleId;
	}

	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}

	public Workcentermaster getWcId() {
		return wcId;
	}

	public void setWcId(Workcentermaster wcId) {
		this.wcId = wcId;
	}

	@Override
	public String toString() {
		return "WorkCenterRoleCompositeKey [roleId=" + roleId + ", wcId="
				+ wcId + "]";
	}
	
	
	
}
