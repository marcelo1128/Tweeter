import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class IndiUsers extends Account {
ArrayList item = new ArrayList();
    
	// Default list constructor
    /**
     * Default constructor
     */
	 public IndiUsers( ) { 
		 item.size();
	}

	// Get the length of the list 
	 /**
	  * Gets the length of the array so system can index
	  * @return int
	  */
	public int getLength( ){ 
	   return item.size(); 
	}


	// Add a new item 
	/**
	 * Method to insert a product into a array list at a specific index
	 * @param patient
	 */
	@SuppressWarnings("unchecked")
	public void insert(Account items) { 
	   item.add(items);
	   //sort();

	}



	// Remove an item 
	/**
	 * Takes in a product inventory to remove from the array list
	 * @param items
	 */
	public void removeIT(Account items) { 
		int position = search(items);
		item.remove(position);
	}
	
	/**
	 * Overrides the product inventory decrement method and decrements the product from the list
	 */
	//public void decrement(ProductInventory items){
		//int position = search(items);
		//items = (ProductInventory) item.get(position);
		//items.decrement((ProductInventory) item.get(position));
	//}

	/**
	 * Finds a product inventory at an index and returns the product info
	 * @param index
	 * @return PatientType
	 */
	public Account retrieve (int index) { 
	   return (Account) item.get(index); 
	}


	// Search for an item 
	/**
	 * Searches for a product inventory object sees if the name exists
	 * @param thing
	 * @return int
	 */
	public int search(Account thing) { 
	   int position = -1; 
	   int i = 0; 
	   while ((position == -1) && (i < item.size())) {
	      if (item.get(i) == thing) { 
	         position = i; 
	         } 
	         i++;  
	         } 
	  return position;

	}   
	/**
	 * Sorts array list based on alphabetical order
	 */
	@SuppressWarnings("unchecked")
	public void sortAlpha(){
		Collections.sort(item, new Comparator<Account>() {
	        public int compare(Account  prod1, Account  prod2)
	        {

	            return  prod1.getUsername().compareTo(prod2.getUsername());
	        }
	    });
		
	}

	//Sort the list
	/**
	 * Sorts the array list based on date
	 */

}

