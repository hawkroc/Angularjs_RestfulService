/**
 * 
 */
package services;

import java.util.List;

import beans.Plan;

/**
 * @author Pengyin
 * define the CRUD operaion of plans
 *
 */
public interface PlanManagerService {
	
	public void CreatPlan(Plan Plan);
	 public void updatePlan(Plan Plan);
	 public List<Plan> getAllPlans() ;
	 public Plan getAllPlan(int id) ;
	 
	 public Plan delPlan(int id);
	 
	

}
