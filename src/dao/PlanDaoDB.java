package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;








import beans.Plan;
import utilities.*;

/**
 * 
 * @author Pengyin
 *  you can finish this class. it can operate the data from relationship database(mysql)
 */
public class PlanDaoDB  implements BaseDao {
	
	
	private static PlanDaoDB planDaoDB;
	private Connection connection = null;

	private PlanDaoDB() {
		 connection = DBUtility.getConnection();
	}

	public static PlanDaoDB getPlanDaoDB() {
		if (planDaoDB == null) {
			planDaoDB = new PlanDaoDB();
		}
		return planDaoDB;
	}

	@Override
	public void CreateObject(Plan plan){
		
		
		  try {
			  System.out.println(plan.toString());
			  String sql=""
			  		+ "insert into plans_list"
			  		+ "(time,"
			  		+ "activity,"
			  		+ "type,"
			  		+ "address) "
			  		+ "values (?, ?, ?,?)";
			   PreparedStatement preparedStatement = connection
			     .prepareStatement(sql);
			
			   preparedStatement.setString(1, plan.getTime());
			   preparedStatement.setString(2, plan.getActivity());   
			   preparedStatement.setString(3, plan.getType());
			   preparedStatement.setString(4,plan.getAddress());
		 
			   preparedStatement.executeUpdate();

			  } catch (SQLException e) {
			   e.printStackTrace();
			  }
	
	}
	
	
	

	 public  List<Plan>  getAll() {
	  List<Plan> plans = new ArrayList<Plan>();
	  try {
	   Statement statement = connection.createStatement();
	   ResultSet rs = statement.executeQuery("select * from plans_list ");
	   while (rs.next()) {
		   Plan plan = new Plan();
		   plan.setId(rs.getInt("id"));
		   plan.setActivity(rs.getString("activity"));
		   plan.setTime(rs.getString("time"));
		   plan.setType(rs.getString("type"));
		   plan.setAddress(rs.getString("address"));

	    plans.add(plan);
	   }
	  } catch (SQLException e) {
	   e.printStackTrace();
	  }

	  return plans;
	 }

	
	
	
}
