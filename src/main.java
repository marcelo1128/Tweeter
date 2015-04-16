import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//IndiUsers doMe = new IndiUsers();
		Account twitter= new Account("andre", "king", "Merks", "email");
		//twitter.greaterThan();
		//twitter.makeDB();
		twitter.tweetNow();
		twitter.getTweets();
		twitter.followIt("@money");
		twitter.followIt("@bob3Builder");
		//doMe.insert(twitter);
		Account bang= new Account("bob3Builder", "job", "Handy", "handy@HGTV.com");
		//twitter.greaterThan();
		bang.makeDB();
		bang.followIt("@money");
		bang.tweetNow();
		//doMe.insert(bang);
		Account fag= new Account("money", "j$$", "John Bi", "dolla@sines.com");
		//twitter.greaterThan();
		//fag.makeDB();
		fag.tweetNow();
		fag.followIt("@andre");
		fag.followed();
		//doMe.insert(fag);
		//displayList(doMe);
		
		
		//System.out.println (twitter.getUsername());
		//System.out.println (twitter.getFollowing());
	}
	public static void displayList (IndiUsers productList){
		   int i;
		   //makes a temporary productInventory object
		   Account temp = new Account();
		   //iterates though the arraylist displaying the product at every index
		   for(i=0; i< productList.getLength(); i++){ 
		      temp = productList.retrieve(i); 
		      temp.displayProduct(); 
		   } 
	}
}
