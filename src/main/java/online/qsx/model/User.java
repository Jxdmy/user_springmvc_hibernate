package online.qsx.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tb_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	private String userName;
	private String password;
	private String job;
	private String email;
	private boolean sex;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthDay;
	private String hobby;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createDay;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public Date getCreateDay() {
		return createDay;
	}
	public void setCreateDay(Date createDay) {
		this.createDay = createDay;
	}
	
	public User(String userName, String password, String job, String email, boolean sex, Date birthDay, String hobby,
			Date createDay) {
		super();
		this.userName = userName;
		this.password = password;
		this.job = job;
		this.email = email;
		this.sex = sex;
		this.birthDay = birthDay;
		this.hobby = hobby;
		this.createDay = createDay;
	}
	public User(Integer id, String userName, String password, String job, String email, boolean sex, Date birthDay,
			String hobby, Date createDay) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.job = job;
		this.email = email;
		this.sex = sex;
		this.birthDay = birthDay;
		this.hobby = hobby;
		this.createDay = createDay;
	}
	public User(Integer id) {
		super();
		this.id = id;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", job=" + job + ", email=" + email + ", sex=" + sex
				+ ", birthDay=" + birthDay + ", hobby=" + hobby + ", createDay=" + createDay + "]";
	}
	
}
