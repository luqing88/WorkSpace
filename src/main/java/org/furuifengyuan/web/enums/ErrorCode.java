package org.furuifengyuan.web.enums;

public enum ErrorCode {
	FAIL_ERROR(1000), NULL_ERROR(1001), EXCEPTION_ERROR(1002);

	private int value;

	private ErrorCode(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
