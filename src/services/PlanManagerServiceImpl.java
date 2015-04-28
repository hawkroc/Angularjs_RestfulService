package services;


import java.util.List;

import dao.DataSourceFactory;
import beans.*;
/**
 * 
 * @author pengyin
 * 
 */
public class PlanManagerServiceImpl implements  PlanManagerService {
 
private DataSourceFactory dataSource= DataSourceFactory.getDataSourceFactory();
private static PlanManagerServiceImpl planServiceImpl=null;

 private PlanManagerServiceImpl() {
 
 }
 
 public static PlanManagerServiceImpl getPlanManagerServiceImpl(){
	 if(planServiceImpl==null){
		 planServiceImpl=new PlanManagerServiceImpl();
	 }
	 return planServiceImpl;
 }

@Override
public void CreatPlan(Plan plan) {
	// TODO Auto-generated method stub
	dataSource.getPlanOperateDao("DataBase").CreateObject(plan);
	
}

@Override
public void updatePlan(Plan Plan) {
	// TODO Auto-generated method stub
	
}

@Override
public List<Plan> getAllPlans() {
	// TODO Auto-generated method stub
	
	return 	dataSource.getPlanOperateDao("DataBase").getAll();
}

@Override
public Plan getAllPlan(int id) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Plan delPlan(int id) {
	// TODO Auto-generated method stub
	return null;
}

}