package in.net.usit.auth.to;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "screen_module")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Screen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long uid;
	@Column(name = "screen_name")
	private String name;
	@Column(name = "router_path")
	private String routerPath;
	@Column(name = "is_module")
	private Boolean isModule;
	@Column(name = "is_root_module")
	private Boolean isRootModule;
	
	@JsonBackReference
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(
			name = "module_id", 	
			foreignKey = @ForeignKey(name = "module_id_fk")
			)
	private Screen module;
	
	@JsonManagedReference
	@OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "module_id", referencedColumnName = "id")
	private List<Screen> screens = new ArrayList<>();

	@Transient
	private String parentModuleName;
	@Transient
	private Long parentModuleId;
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRouterPath() {
		return routerPath;
	}
	public void setRouterPath(String routerPath) {
		this.routerPath = routerPath;
	}
	public Boolean getIsModule() {
		return isModule;
	}
	public void setIsModule(Boolean isModule) {
		this.isModule = isModule;
	}
	public Boolean getIsRootModule() {
		return isRootModule;
	}
	public void setIsRootModule(Boolean isRootModule) {
		this.isRootModule = isRootModule;
	}
	public Screen getModule() {
		return module;
	}
	public void setModule(Screen module) {
		this.module = module;
	}
	public List<Screen> getScreens() {
		return screens;
	}
	public void setScreens(List<Screen> screens) {
		this.screens = screens;
	}
	public String getParentModuleName() {
		return parentModuleName;
	}
	public void setParentModuleName(String parentModuleName) {
		this.parentModuleName = parentModuleName;
	}
	public Long getParentModuleId() {
		return parentModuleId;
	}
	public void setParentModuleId(Long parentModuleId) {
		this.parentModuleId = parentModuleId;
	}
}
