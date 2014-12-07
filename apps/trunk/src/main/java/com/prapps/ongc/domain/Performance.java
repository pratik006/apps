package com.prapps.ongc.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.prapps.core.domain.User;

@Entity
@Table(name="ONGC_PERFORMANCE")
public class Performance {

	@OneToOne
	@JoinColumn(name="USER_ID")
	private User user;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="TMT_NAME")
	private String tmtName;
	@Column(name="TMT_DATE")
	private Date tmtDate;
	@Column(name="TMT_END_DATE")
	private Date tmtEndDate;
	@Column(name="TMT_VENUE")
	private String venue;
	@Column(name="RANK")
	private String rank;
	@Column(name="SCORE")
	private String score;
	@Column(name="REMARKS")
	private String remarks;
	
	public String getTmtName() {
		return tmtName;
	}
	public void setTmtName(String tmtName) {
		this.tmtName = tmtName;
	}
	public Date getTmtDate() {
		return tmtDate;
	}
	public void setTmtDate(Date tmtDate) {
		this.tmtDate = tmtDate;
	}
	public void setTmtDate(java.util.Date tmtDate) {
		this.tmtDate = new Date(tmtDate.getTime());
	}
	
	public Date getTmtEndDate() {
		return tmtEndDate;
	}
	public void setTmtEndDate(Date tmtEndDate) {
		this.tmtEndDate = tmtEndDate;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Performance [tmtName=" + tmtName + ", tmtDate=" + tmtDate + ", venue=" + venue + ", rank=" + rank + ", score=" + score
				+ ", remarks=" + remarks + "]";
	}
	
}
