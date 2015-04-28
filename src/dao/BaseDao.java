package dao;

import java.util.List;

import beans.Plan;

public interface BaseDao {
	public void CreateObject(Plan o);
	 public List<Plan> getAll();

}
