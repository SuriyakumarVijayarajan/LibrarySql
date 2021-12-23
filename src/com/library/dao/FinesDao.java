package com.library.dao;

import com.library.model.Fines;

public interface FinesDao {
	public void insert(Fines fine);
	public void update(Fines fine);
	public void delete(Fines fine);
	public int fineCalculation(Fines fine);
	

}
