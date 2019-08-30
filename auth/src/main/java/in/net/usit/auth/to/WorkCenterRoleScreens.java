package in.net.usit.auth.to;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "work_center_role_map")
public class WorkCenterRoleScreens {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "wc_role_id")
	private WorkCenterRole wcRoleId;

	@ManyToOne
	@JoinColumn(name = "screen_id")
	private Screen screenId;
	
	@Column(name = "can_insert")
	private Boolean canInsert;
	
	@Column(name = "can_update")
	private Byte canUpdate;
	
	@Column(name = "can_remove")
	private Byte canRemove;
	
	@Column(name = "can_view")
	private Byte canView;
	
	@Column(name = "access_value")
	private Byte accessValue;
}
