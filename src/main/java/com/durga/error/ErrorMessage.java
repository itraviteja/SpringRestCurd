package com.durga.error;

import java.util.Date;

public class ErrorMessage
{
	private String errorCount;
    private String filedName;
    private String errorMessage;
    private Object previousValue;
	public String getFiledName() {
		return filedName;
	}
	public void setFiledName(String filedName) {
		this.filedName = filedName;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Object getPreviousValue() {
		return previousValue;
	}
	public void setPreviousValue(Object object) {
		this.previousValue = object;
	}
	public String getErrorCount() {
		return errorCount;
	}
	public void setErrorCount(String errorCount) {
		this.errorCount = errorCount;
	}
}
