package com.durga.status;

import java.util.List;

public class Error 
{
	public String getErrorCount() {
		return errorCount;
	}
	public void setErrorCount(String errorCount) {
		this.errorCount = errorCount;
	}
	public List<ErrorMesages> getErrorMessages() {
		return errorMessages;
	}
	public void setErrorMessages(List<ErrorMesages> errorMessages) {
		this.errorMessages = errorMessages;
	}
	private String errorCount;
	private List<ErrorMesages> errorMessages; 
}
