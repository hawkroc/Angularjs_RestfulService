package dao;

import java.util.List;

import beans.Plan;

/**
 * 
 * @author Pengyin
 * you can finish this class. we can use memercache and Redis as cache
 */

public class PlanDaoCache implements BaseDao {

	private static PlanDaoCache planDaoCache;

	private PlanDaoCache() {

	}

	public static PlanDaoCache getPlanDaoCache() {
		if (planDaoCache == null) {
			planDaoCache = new PlanDaoCache();
		}
		return planDaoCache;
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
