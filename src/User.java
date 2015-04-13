
public class User {
	private String username;
	private String password;
	private String email;
	private String alias;
	private int followers, tweetCount,  following;
	
	
	public String getAlias(){
		return alias;
	}
	
	public String getUsername(){
		return username;
	}
	public String getEmail(){
		return email;
	}
	public String getPassword(){
		return password;
	}
	
	public int getFollowers(){
		return followers; 
	}
	
	public int getTweetc(){
		return tweetCount;
	}
	
	public int getFollowing(){
		return following;
	}
	public User (){
		username = " ";
		password = " ";
		email= " ";
		alias= " ";
		followers = 0;
		tweetCount = 0;
		following = 0;
	}
	
	public void setUsername(String name){
		char atMe =  name.charAt(0);
		if (atMe == '@'){
			username = name;
			}
		else {
			username = ("@"+name);
		}
	}
	
	public void setAlias (String name){
		alias = name; 
	}
	
	public void setEmail (String name){
		email = name;
	}
	public void setPassword (String pass){
		password = pass;
	}
	
	public void setFollowers( int count){
		followers= count;
	}
	
	public void setTweetc(int count){
		tweetCount = count;
	}
	
	public void setFollowing( int count){
		following = count;
	}
	
	public void CreateUser (String user, String pass, String alias, String email){
		setUsername(user);
		setPassword(pass);
		setEmail(email);
		setAlias(alias);
		//User created add to database below	
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
		setAlias(alias);
		setEmail(email);
		setPassword(pass);
	}
	
	public void addFollowers(){
		setFollowers(getFollowers()+ 1);
	}
	public void lostSouls (){
		int nig = getFollowers();
		if (nig != 0) {
			nig--;
			setFollowers (nig);	
		}
		else if(nig==0){
			nig=0;
			setFollowers(nig);
		}
		else{
		}
	}
	
	public void followIt(){
		setFollowing(getFollowing()+1);
	}
	
	public void unfollow(){
		int nig = getFollowing();
		if (nig != 0) {
			nig--;
			setFollowing (nig);	
		}
		else if(nig==0){
			nig=0;
			setFollowing(nig);
		}
		else{
		}
	}
	
	
	
}
