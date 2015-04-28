package controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import beans.Plan;
import services.PlanManagerServiceImpl;


@RestController
public class TaskManagerController {
	
	PlanManagerServiceImpl taskmanagerservice=PlanManagerServiceImpl.getPlanManagerServiceImpl();
	
	 @RequestMapping(value="/tasks",method = RequestMethod.GET,headers="Accept=application/json")
	 public List<Plan> getAllTasks() {	 
	  List<Plan> tasks=taskmanagerservice.getAllPlans();
	  return tasks;
	
	 }
	 
	 
//	 @RequestMapping(value="/tasks/archive/{taskIds}",method = RequestMethod.POST,headers="Accept=application/json")
//	 public List<Task> archiveAllTasks(@PathVariable int[] taskIds) {	
//		 for(int i=0;i<taskIds.length;i++){
//			 taskmanagerservice.archiveTask(taskIds[i]);	
//			 
//		 }
//	  List<Task> tasks=taskmanagerservice.getAllTasks();
//	  return tasks;
//	
//	 }
//	 
//	 @RequestMapping(value="/tasks/{taskId}/{taskStatus}",method = RequestMethod.POST,headers="Accept=application/json")
//	 public List<Task> changeTaskStatus(@PathVariable int taskId,@PathVariable String taskStatus) throws ParseException {	
//		 taskmanagerservice.changeTaskStatus(taskId,taskStatus);		 
//		 return taskmanagerservice.getAllTasks();
//		 
//	 }
	 
	 @RequestMapping(value="/tasks/create/{time}/{type}/{activity}/{address}",method = RequestMethod.POST,headers="Accept=application/json")
	 public void addTask(@PathVariable String time,@PathVariable String type,@PathVariable String activity,@PathVariable String address) throws ParseException {	
		 Plan task = new Plan();
		 task.setTime(time);
		 task.setActivity(activity);
		 task.setType(type);
		 task.setAddress(address);

		taskmanagerservice.CreatPlan(task);

		 
	 }	 	 	 	 
}