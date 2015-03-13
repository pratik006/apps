package com.prapps.ongc.vo;

import java.util.Date;

import org.springframework.beans.BeanUtils;

public class Performance {

	private String cpfNo;
	private String playerName;
	private String tmtName;
	private Date tmtDate;
	private Date tmtEndDate;
	private String venue;
	private String rank;
	private String score;
	private String remarks;
	
	public Performance() {
		// TODO Auto-generated constructor stub
	}
	
	public Performance(com.prapps.ongc.domain.Performance performance) {
		cpfNo = performance.getUser().getUserName();
		playerName = performance.getUser().getFirstName()+" "+performance.getUser().getLastName();
		BeanUtils.copyProperties(performance, this);
	}
	
	public String getCpfNo() {
		return cpfNo;
	}
	public void setCpfNo(String cpfNo) {
		this.cpfNo = cpfNo;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
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
	
}
