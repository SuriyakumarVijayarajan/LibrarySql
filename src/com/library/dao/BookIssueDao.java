package com.library.dao;

import com.library.model.BookIssue;

public interface BookIssueDao {
	public void insert(BookIssue bookIssue);
	public void update(BookIssue bookIssue);
	public void delete(BookIssue bookIssue);
	public int getBookIssueNo(BookIssue book);
	public int returnBookIssue(BookIssue bookIssue);

}
