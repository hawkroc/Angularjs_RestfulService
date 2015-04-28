package dao;

import java.util.List;


import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Plan;

/**
 * 
 * @author Pengyin
 *   this class operate file which alread be generate on disk.
 */

public class PlanDaoFile implements BaseDao {

	private static PlanDaoFile planDaoFile;
	ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
	private PlanDaoFile() {

	}

	public static PlanDaoFile getPlanDaoFile() {
		if (planDaoFile == null) {
			planDaoFile = new PlanDaoFile();
		}
		return planDaoFile;
	}



	@Override
	public List<Plan> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void CreateObject(Plan o) {
		// TODO Auto-generated method stub
		
	}
	

	

}
