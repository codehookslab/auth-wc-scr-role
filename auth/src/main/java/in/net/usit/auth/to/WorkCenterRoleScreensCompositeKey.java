package in.net.usit.auth.to;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class WorkCenterRoleScreensCompositeKey implements Serializable{


	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "wc_id"),
		@JoinColumn(name = "role_id")
	})
	private WorkCenterRole wcRoleId;

	@ManyToOne
	@JoinColumn(name = "screen_id")
	private Screen screenId;

	public WorkCenterRole getWcRoleId() {
		return wcRoleId;
	}

	public void setWcRoleId(WorkCenterRole wcRoleId) {
		this.wcRoleId = wcRoleId;
	}

	public Screen getScreenId() {
		return screenId;
	}

	public void setScreenId(Screen screenId) {
		this.screenId = screenId;
	}

	@Override
	public String toString() {
		return "WorkCenterRoleScreensCompositeKey [wcRoleId=" + wcRoleId
				+ ", screenId=" + screenId + "]";
	}

}
