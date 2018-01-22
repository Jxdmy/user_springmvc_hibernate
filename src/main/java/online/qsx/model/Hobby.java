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
@Table(name="tb_hobby")
public class Hobby {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	private String hobby;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Hobby(Integer id, String hobby, Date createDate) {
		super();
		this.id = id;
		this.hobby = hobby;
		this.createDate = createDate;
	}
	public Hobby(String hobby, Date createDate) {
		super();
		this.hobby = hobby;
		this.createDate = createDate;
	}
	public Hobby(Integer id) {
		super();
		this.id = id;
	}
	public Hobby(String hobby) {
		super();
		this.hobby = hobby;
	}
	public Hobby() {
		super();
	}
	@Override
	public String toString() {
		return "Hobby [id=" + id + ", hobby=" + hobby + ", createDate=" + createDate + "]";
	}
	
}
