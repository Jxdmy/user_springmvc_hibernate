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
@Table(name="tb_job")
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	private String job;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Job(Integer id, String job, Date createDate) {
		super();
		this.id = id;
		this.job = job;
		this.createDate = createDate;
	}
	public Job(String job, Date createDate) {
		super();
		this.job = job;
		this.createDate = createDate;
	}
	public Job(Integer id) {
		super();
		this.id = id;
	}
	public Job(String job) {
		super();
		this.job = job;
	}
	public Job() {
		super();
	}
	@Override
	public String toString() {
		return "Job [id=" + id + ", job=" + job + ", createDate=" + createDate + "]";
	}
	
}
