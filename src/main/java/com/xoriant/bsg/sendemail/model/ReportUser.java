package com.xoriant.bsg.sendemail.model;

public class ReportUser {
	
	private String usersHavingAccess;
	
	private String category;
	
	private String reportName;
	
	private String emailAdd;
	
	public ReportUser(String usersHavingAccess, String category, String reportName, String emailAdd) {
		this.usersHavingAccess = usersHavingAccess;
		this.category = category;
		this.reportName = reportName;
		this.emailAdd = emailAdd;
	}

	public String getUsersHavingAccess() {
		return usersHavingAccess;
	}

	public void setUsersHavingAccess(String usersHavingAccess) {
		this.usersHavingAccess = usersHavingAccess;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getEmailAdd() {
		return emailAdd;
	}

	public void setEmailAdd(String emailAdd) {
		this.emailAdd = emailAdd;
	}

	@Override
	public String toString() {
		return "ReportUser [usersHavingAccess=" + usersHavingAccess + ", category=" + category + ", reportName="
				+ reportName + ", emailAdd=" + emailAdd + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((emailAdd == null) ? 0 : emailAdd.hashCode());
		result = prime * result + ((reportName == null) ? 0 : reportName.hashCode());
		result = prime * result + ((usersHavingAccess == null) ? 0 : usersHavingAccess.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReportUser other = (ReportUser) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (emailAdd == null) {
			if (other.emailAdd != null)
				return false;
		} else if (!emailAdd.equals(other.emailAdd))
			return false;
		if (reportName == null) {
			if (other.reportName != null)
				return false;
		} else if (!reportName.equals(other.reportName))
			return false;
		if (usersHavingAccess == null) {
			if (other.usersHavingAccess != null)
				return false;
		} else if (!usersHavingAccess.equals(other.usersHavingAccess))
			return false;
		return true;
	}
	
}
