import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;



public class Account extends User{
	private User followersN;
	private User followingN;
	private String tweet;
	private int count;
	private Connection conn;
	private ResultSet  rs;
	private Statement up;
	private int time;
	ArrayList <String> List = new ArrayList <String> ();
	ArrayList <String> followers = new ArrayList <String> ();
	ArrayList <String> following = new ArrayList <String> ();
	
	
	public Account(){
		super.getUsername();
		super.getEmail();
		super.getAlias();
		super.getPassword();
		tweet = "";
		}
	
	public Account (String user, String pass, String name, String email){
		super(user,pass,name,email);
		super.setUsername(user);
		tweet= "";
		time = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/twitter","root","");
			
		} catch (Exception  e1) {
			e1.printStackTrace();
		}
		try {
			String maybe = getUsername();
			System.out.println (maybe);
			Boolean exist = false;
			up = conn.createStatement();
			String query= "select * from usernames";
			//System.out.println (query);				    
			rs= up.executeQuery(query);
			System.out.println ("complete");
			while(rs.next()){
				String bro = rs.getString("users");
				String password = rs.getString("password");			
			if (bro.equals(maybe)){
				//System.out.println ("YO HE EXISTS MAN ");	
				exist= true;	
			}
		    System.out.println (bro + " " + getUsername() + " Bool = "+ exist);
		    }
		if (exist== false){
			query = "insert INTO usernames (users, alias, email, password) VALUES ("+ "'" + getUsername() + "'" +","+  "'" +getAlias()+  "'" + ","+  "'" + getEmail() + "'"  + ","+ "'" + getPassword()+ "'" +")";
			//System.out.println (query);
			up.executeUpdate(query);
			//System.out.println ("complete");
		}

	} catch(Exception e) {
		System.out.println (" bang");
		}

	}
	
	 public void makeDB() {
			try {
				String maybe = getUsername();
				Boolean exist = false;
				up = conn.createStatement();
				String query= "select * from usernames";
				//System.out.println (query);				    
				rs= up.executeQuery(query);
				System.out.println ("complete");
				while(rs.next()){
					String name = rs.getString("users");
					
					if (name.equals(maybe)){
						System.out.println ("YO HE EXISTS MAN ");	
						exist= true;						
					}
				    System.out.println (name + " " + getUsername() + " Bool = "+ exist);
				    }
				if (exist== false){
					query = "insert INTO usernames (users, alias, email, password) VALUES ("+ "'" + getUsername() + "'" +","+  "'" +getAlias()+  "'" + ","+  "'" + getEmail() + "'"  + ","+ "'" + getPassword()+ "'" +")";
					System.out.println (query);
					up.executeUpdate(query);
					System.out.println ("complete");
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
	
	public void followed(){
		try {
			up = conn.createStatement();
		    if(followers.size()>=0){
		    	if(followers.size()==0){
		    		String query= ("select * from followers where users = '" + getUsername()+ "'");
		    		rs= up.executeQuery(query);
					System.out.println ("complete");
					while(rs.next()){
					    String name1 = rs.getString("followers");						    	
					    followers.add(name1);
					   	 
					    }
		    		}
		    	}
		    else{
		    	String query= ("select * from followers where users = '" + getUsername()+ "'");
	    		rs= up.executeQuery(query);
				System.out.println ("complete");
				while(rs.next()){
				    String name1 = rs.getString("followers");
				    for (int i = 0; i < following.size(); i ++ ) {
				    	if (following.get(i).equals(name1)){
				    		System.out.println ("Already in it");
				    	}
				    	else{
				    		followers.add(name1);
				    	}
				    }
				   	 		 
				}
		    }
		}catch (SQLException e) {
							e.printStackTrace();
						}
		for (int i = 0; i < followers.size(); i ++ ) {
			System.out.println(followers.get(i));
		}	
	}
	
	public void followIt(String fellow){
			try {
				boolean through= false;
				boolean isIT = false; 
				ResultSet  rt;
				Statement upp;
				up = conn.createStatement();
				upp= conn.createStatement();
			    String query= "select * from usernames";
			    System.out.println (query);
			    rs= up.executeQuery(query);
			    System.out.println ("complete");
			    while(rs.next()){
			    	String name = rs.getString("users");
			    	if(following.size()>=0){
			    		if(following.size()==0){
			    			String query1= ("select * from following where users = '" + getUsername()+ "'");
						    rt= upp.executeQuery(query1);
						    System.out.println ("complete");
						    while(rt.next()){
						    	String name1 = rt.getString("following");
						    	following.add(name1);
						    }
			    			if (fellow.equals(name)){
			    				System.out.println("Yo ur boy " + super.getUsername() + " is now following" + fellow);
			    				through = true;
			    				
			    		}
			    		}
			    	else{			    		
			    		for (int i = 0; i < following.size(); i ++ ) {
			    			if (fellow.equals(name)){
			    				//System.out.println("Yo ur boy " + super.getUsername() + " is now following" + fellow);
			    				through = true;
			    				if(following.get(i).equals(name)){
			    					isIT = true;
				    	}
			    		}
			    		}
			    	}
			    	}
			    }			    
			    	if ((isIT== false)&&(through== true)){
			    		System.out.println("Yo ur boy " + super.getUsername() + " is now following" + fellow);
			    		following.add(fellow);
			    		super.setFollowing(super.getFollowing()+1);
			    		query = "insert INTO following (users, following) VALUES ("+ "'" + getUsername() + "'" +","+  "'" +fellow+  "')";						
						up.executeUpdate(query);
						query = "insert INTO followers (users, followers) VALUES ("+ "'" + fellow + "'" +","+  "'" + getUsername()+  "')";
						up.executeUpdate(query);
			    	}
			    	else{
			    		System.out.println ("You already FOLLOW dis nigga!!!!!");
			    	}
			    } catch(Exception e) {
			    	System.out.println (" bang");
			}
			for (int i = 0; i < following.size(); i ++ ) {
				System.out.println(following.get(i));
			}
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

	//user can tweet and the tweet will get saved to an array list
	
	public void tweetNow() {
		String userID;
		Scanner input = new Scanner(System.in);
		String user = getUsername();
		GregorianCalendar date = new GregorianCalendar();
        int hr = date.get(Calendar.HOUR);
        int min = date.get(Calendar.MINUTE);
        int sec = date.get(Calendar.SECOND);
        String pattern1= "00";
		//Output is formatted in this function
		DecimalFormat myFormat = new DecimalFormat(pattern1);
		//Output is formatted in this function
		String HH = myFormat.format(hr);
		String MM = myFormat.format(min);
		String SS = myFormat.format(sec);
        String timeMe = HH + MM + SS;
        //System.out.println("timeMe= "+timeMe);
        time = Integer.parseInt(timeMe);
		System.out.println("What would you like to tweet?");
		String tweets = user + ": " +input.nextLine();
		try {	
		    String query="insert INTO tweets (users, tweets, timeOfTweet) VALUES ("+ "'" + getUsername() + "'" +","+  "'" +tweets+  "'" + ","+  "'" + time + "'" +")"; ;
		    //System.out.println (query);
		    up.executeUpdate(query);		    
		    } catch(Exception e) {
		    	System.out.println (" bang");
		}
		if(tweet.length() > 140){
			System.out.println("too many characters, please try again");
			tweet = null;
	    }
		else {
			String query= "select tweets from tweets where users= "+ "'"+ getUsername() + "'";
		    //System.out.println (query);
		    try {
				rs= up.executeQuery(query);
				while(rs.next()){
			    	tweet= rs.getString("tweets");
			    	List.add(tweet);
					count++;
			    	}
					super.setTweetc(count);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}  

	//show the list of tweets for a user
	public void getTweets(){
		for (int i = 0; i < List.size(); i ++ ) {
			System.out.println(List.get(i));
			}
	}
	
	
	
	public void displayProduct(){
		System.out.println( count + " " + super.getUsername());
		for (int i = 0; i < followers.size(); i ++ ) {
			System.out.println(followers.get(i));
			}
		System.out.println("");
		getTweets();		
	}
}
