import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DataProcessing {
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static boolean connectToDB=false;
	//public static int Id[]=new int[10];
	public static int Id;
	public static int flag = 0;
	
	static String url="jdbc:mysql://localhost:3306/bsonline?autoReconnect=true&useSSL=false";       // 声明数据库的URL
    static String user="root";                                      // 数据库用户
    static String password="123456";								// 用户密码
    static String driverName="com.mysql.jdbc.Driver";               // 加载数据库驱动类
    
    public static  void connectToDatabase(String driverName){ //连接数据库
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("数据驱动错误");
		}catch (SQLException e) {
			System.out.println("数据库错误");
		}
		connectToDB = true;
	}
    
    public static void disconnectFromDatabase(){//断开数据库
		if (connectToDB){
			try{
				resultSet.close();
				statement.close();
				connection.close();
			}catch (SQLException e){
				e.printStackTrace();
			}finally{
				connectToDB  = false;
			}
		}
	}
    
    public static String searchQt(int Id) throws SQLException{
    	String context = null;
    	connectToDatabase(driverName);
		if (!connectToDB)
			throw new SQLException("Not Connected to DataBase!");
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		String sql = "select * from exam where ID="+Id;
		resultSet = statement.executeQuery(sql);
		
		if(resultSet.next()){
			Id = Integer.valueOf(resultSet.getString("Id")).intValue();
			context = resultSet.getString("context");
			String A = resultSet.getString("selectA");
			String B = resultSet.getString("selectB");
			String C = resultSet.getString("selectC");
			String D = resultSet.getString("selectD");
			context = context +"\nA:"+ A +"\tB:"+ B +"\tC:"+ C+"\tD:" +D;
		}
		System.out.println(Id);
    	return context;
    }
    
    public static exam searchQT(int Id) throws SQLException{
    	exam e1 = null;
    	String context = null;
    	connectToDatabase(driverName);
		if (!connectToDB)
			throw new SQLException("Not Connected to DataBase!");
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		String sql = "select * from exam where ID="+Id;
		resultSet = statement.executeQuery(sql);
		
		if(resultSet.next()){
			Id = Integer.valueOf(resultSet.getString("Id")).intValue();
			context = resultSet.getString("context");
			String A = resultSet.getString("selectA");
			String B = resultSet.getString("selectB");
			String C = resultSet.getString("selectC");
			String D = resultSet.getString("selectD");
			int ans = Integer.valueOf(resultSet.getString("answer")).intValue();
			e1 = new exam(Id,context,A,B,C,D,ans);
			//context = context +"\nA:"+ A +"\tB:"+ B +"\tC:"+ C+"\tD:" +D;
		}
		//System.out.println(Id);
    	return e1;
    }
    
    //public static int[] getId(){
    //	return Id;
    //}
    
    public static int Calc(int id[],int ans[]) throws SQLException{
    	int count=0;
    	connectToDatabase(driverName);
		if (!connectToDB)
			throw new SQLException("Not Connected to DataBase!");
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
    	for(int i=0;i<10;i++){
    		//System.out.println(i+1+".id:"+id[i]+" ans:"+ans[i]);
    		String sql = "select * from exam where ID="+id[i];
    		resultSet = statement.executeQuery(sql);
    		
    		if(resultSet.next()){
    			int a = Integer.valueOf(resultSet.getString("answer")).intValue();
    			//System.out.println(a+" "+ans[i]);
    			if(a == ans[i])
    				count += 10;
    		}
    		
    	}
    	
    	return count;
    }
}
