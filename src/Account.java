import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;



public class Account extends User{
	private User followersN;
	private User followingN;
	private String tweet;
	private int count;
	public String driver;
	public String dbName;
	public String connectionURL;
	public String createString;
	public Statement st;
	public Connection conn;
	public ResultSet  rs;
	
	ArrayList <String> List = new ArrayList <String> ();
	
	public Account(){
		super.getUsername();
		super.getEmail();
		super.getAlias();
		super.getPassword();
		tweet = "";
		driver = "com.mysql.jdbc.Driver";
		dbName="Twitter";
		connectionURL = "jdbc:derby:" + dbName + ";create=true";
		createString = "CREATE TABLE usernames  "
				  +  "(tweets_id INT NOT NULL GENERATED ALWAYS AS IDENTITY " 
				  +  " users VARCHAR(20) NOT NULL) " ;
		}
	
	 public void makeDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/twitter","root","");
			st = conn.createStatement();
			System.out.println ("worked");
			
		} catch (Exception  e1) {
			System.out.println (" bang");
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			try {
			    String query = "select * from usernames";
			    rs = st.executeQuery(query);
			    System.out.println (" bang");
			    while(rs.next()){
			    	String name = rs.getString("users");
			    	String password = rs.getString("password");
			    	System.out.println (name + " " + password);
			    }
			} catch(Exception e) {
				System.out.println (" bang");
			}

			} 
		
	
	
	
	public int sameName(String firstN) {
		 // compares the name entered against the name stored
		   // if the product is stored returns an 1
		   int found;
		   if (getUsername().equals(firstN)) {
		         found = 1;
		      }
		   else {
		         found = 0;
		      }
		   return found;
		}

	public void editProfileAlias( String alias, String email, String pass){
		super.setAlias(alias);
		super.setEmail(email);
		super.setPassword(pass);
	}
	
	public void addFollowers(){
		super.setFollowers(super.getFollowers()+ 1);
	}
	public void toFollow (String user){
		
	}
	public void lostSouls (){
		int nig = getFollowers();
		if (nig != 0) {
			nig--;
			super.setFollowers (nig);	
		}
		else if(nig==0){
			nig=0;
			super.setFollowers(nig);
		}
		else{
		}
	}
	
	public void followIt(){
		super.setFollowing(super.getFollowing()+1);
	}
	
	public void unfollow(){
		int nig = getFollowing();
		if (nig != 0) {
			nig--;
			super.setFollowing (nig);	
		}
		else if(nig==0){
			nig=0;
			super.setFollowing(nig);
		}
		else{
		}
	}

	//default constructor


	//non default constructor



	//user can tweet and the tweet will get saved to an array list
	public void tweetNow() {

	Scanner input = new Scanner(System.in);

	String user = getUsername();


	System.out.println("What would you like to tweet?");
	tweet = user +input.nextLine();



	if(tweet.length() > 140){
	    System.out.println("too many characters, please try again");
	    tweet = null;
	    }
	else {
		List.add(tweet);
		count++;
	    }  
	       
	}

	//show the list of tweets for a user
	public void getTweets(){

	for (int i = 0; i < count; i ++ ) {
		System.out.println(List.get(i));
	}

	}

}
