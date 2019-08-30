package in.net.usit.auth.to;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "CGTL$_WORKCENTERMASTER", uniqueConstraints = @UniqueConstraint(columnNames = { "WORKCENTERCODE"}))
public class Workcentermaster implements java.io.Serializable {
	@Id
	@Column(name = "WORKCENTERID", unique = true, nullable = false, precision = 22, scale = 0)
	private BigDecimal workcenterid;
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "PLANTID", nullable = false)
//	private Plantmaster plantmaster;
	@Column(name = "WORKCENTERCODE", nullable = false, length = 20)
	private String workcentercode;
	@Column(name = "WORKCENTERDESCRIPTION", nullable = false, length = 40)
	private String workcenterdescription;
	@Temporal(TemporalType.DATE)
	@Column(name = "VALIDFROM", nullable = false, length = 7)
	private Date validfrom;
	@Temporal(TemporalType.DATE)
	@Column(name = "VALIDTO", nullable = false, length = 7)
	private Date validto;
	@Column(name = "WORKCENTERSTATUS", nullable = false, precision = 1, scale = 0)
	private boolean workcenterstatus;
	
}
