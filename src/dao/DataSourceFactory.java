package dao;
/**
 * 
 * @author Pengyin
 * this is factory which can generate the dao base on type.
 */
public class DataSourceFactory {
	private static DataSourceFactory dataSourceFactory;
	
	private DataSourceFactory(){
		
	}
	
	
	public static DataSourceFactory getDataSourceFactory(){
    if(dataSourceFactory==null){
    	dataSourceFactory=new DataSourceFactory();
    }
    
    return dataSourceFactory;
	}
	
	public BaseDao getPlanOperateDao(String type){
		if(type.equalsIgnoreCase("file")){
			return PlanDaoFile.getPlanDaoFile();
		}else if(type.equalsIgnoreCase("DataBase")){
			return PlanDaoDB.getPlanDaoDB();
		}else if(type.equalsIgnoreCase("cache")){
			return PlanDaoCache.getPlanDaoCache();
		}else{
			return null;
		}
	}

}
