package com.amith.article_service.util.constants;

public enum Header {
	AUTH("Authorization"), CORELATION_ID("X-Correlation-ID"), X_FORWARDED_FOR("X-FORWARDED-FOR");

	private final String name;

	public String getName() {
		return name;
	}

	private Header(String name) {
		this.name = name;
	}

}
