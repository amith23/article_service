package com.amith.article_service.resources;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.amith.article_service.util.constants.Publusher;

public class Article {

	@NotNull(message = "Name cannot be null")
	private String name;

	@NotNull(message = "Link cannot be null")
	private String link;

	@NotNull(message = "Publisher cannot be null")
	private Publusher publusher;

	@NotNull(message = "Publishdate cannot be null")
	private Date publishedDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Publusher getPublusher() {
		return publusher;
	}

	public void setPublusher(Publusher publusher) {
		this.publusher = publusher;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	@Override
	public String toString() {
		return "Article [name=" + name + ", link=" + link + ", publusher=" + publusher + ", publishedDate="
				+ publishedDate + "]";
	}

}
