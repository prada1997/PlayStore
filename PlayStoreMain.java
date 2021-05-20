import java.util.Scanner;

public class PlayStoreMain {
    public static void main(String[] args) {
        PlayStore store = new PlayStore();
        
        Scanner input = new Scanner (System.in);
                
        // new publications
        String[] authors1 = {"L. Tolstoy"};
        Book b1 = new Book ("b1", "War and Peace", 12.55, "The Russian Messenger", 1225, authors1);
                
        String[] authors2 = {"F. Scott Fitzgerald"};
        Book b2 = new Book ("b2", "The great gatsby", 10, "Charles Scribner's Sons", 180, authors2);
                
        String[] authors3 = {"Thomas H. Cormen", "Charles E. Leiserson", "Ronald L. Rivest", "Clifford Stein"};
        Book b3 = new Book ("b3", "Introduction to algorithms", 100, "MIT Press", 1312, authors3);
                
        Magazine m1 = new Magazine("m1", "Forbes", 8.99, "Forbes Media", 50, 201904);
                       
        store.addContent(b1);
        store.addContent(b2);
        store.addContent(b3);
        store.addContent(m1);
                
        Application g1 = new Application("g1", "Pokemon", 5.3, "androidV4");    
        Application g2 = new Application("g2", "Pokemon", 900, "iOSV10"); //edited amount from 5 to 900
        //a free app
        Application app1 = new Application("app1", "Calendar", "androidV3"); 

        store.addContent(g1);
        store.addContent(g2);
        store.addContent(app1);                
                
        // Adding new users
        User u1 = new User("u1", "John Doe", "0412000", 20); //edited fund from 200 to 20
        User u2 = new User("u2", "Mary Poppins", "0433191");  
        User u3 = new User("u3", "Dave Smith", "0413456", 1000);
        User u4 = new User("u4", "Jackie Chan", "0417654");
                
        store.addUser(u1);
        store.addUser(u2);
        store.addUser(u3);
        store.addUser(u4);
               
        Comment comment1 = new Comment(u1, "This is a fantastic game!");
        g1.addReview(comment1);
                
        Comment comment2 = new Comment(u2, "I never liked this game!");
        g1.addReview(comment2);
                
        g1.addReview(new Comment(u3, "The game crashes frequently"));
 
        b1.addReview(new Comment(u2, "I love Tolstoy!"));
                                
        //Simulating transactions, showing content, comments etc etc.  
        //They can be driven by menu input as well.
       
     
        // to do: call a method to show all content items of a particular type, e.g. book, magazine, application.
        
        // other necessary code to test the required functionalities.        
       
        
        int menuInput = 0; 
        do{
        	System.out.println("\nMenu: \n1. Upgrade a user to premium account \n2. Buy one item for one user \n3. Listing all available contents \n4. Showing all purchased items of a user \n5. Showing all comments of a content \n6. Exit");
        	menuInput = input.nextInt();	
        	
        	//option for making user premium
        	if(menuInput == 1) {	
        		try {
        		for (String name: store.getAllUser().keySet())
        		{
                    String key = name;
                    String value = "User"; 
                    System.out.println(key + " " + value);
        		}
        		
        		System.out.println("\nType user id to make the user Premium:");
        		(store.getAllUser().get(input.next())).becomePremium();
        		
        	}catch(Exception e) {
        		System.out.println(e.getMessage());
        		
        		}
        	}
        	
        	//option for buy the content for user
        	else if(menuInput == 2) {        		
        		for (String name: store.getAllUser().keySet())
        		{
                    String key = name;
                    String value = store.getAllUser().get(name).getClass().toString(); 
                    System.out.println("\nUser Id: " + key);  
        		}
        		
        		System.out.println("\nType user id of user, who wants to buy:");
        		User whichUser = store.getAllUser().get(input.next());
        		
        		for (String name: store.getAllContent().keySet())
        		{
                    String key = name;
                    String value = store.getAllContent().get(name).getName().toString(); 
                    System.out.println("\nContent Id: " + key + " \nContent Name: " + value);
        		}
        		
        		System.out.println("\nType conent id of content user want to buy:");
        		try{
        		whichUser.buyContent(store.getAllContent().get(input.next()));
      		
        		}catch(Exception e) {
        		System.out.println(e.getMessage());
        		}
        	}
        	
        	//option show contents
        	else if(menuInput == 3) {
        		System.out.println("1. Application \n2. Book \n3. Magazine \n4. All Content");
        		int option = menuInput = input.nextInt();
        		
        		if(option == 1)
        			store.showContent("class Application");
        		
        		else if(option == 2)
        			store.showContent("class Book");
        		
        		else if(option == 3)
        			store.showContent("class Magazine");
        		
        		else if(option == 4)
        			store.showContent("class");
        	}
        	
        	//option to show content bought by user
        	else if(menuInput == 4) {	
        		for (String name: store.getAllUser().keySet())
        		{
                    String key = name;
                    String value = store.getAllUser().get(name).getClass().toString(); 
                    System.out.println("User ID: " + key);  
        		}
        		
        		System.out.println("\nType user id of user to show content by that user:");
        		(store.getAllUser().get(input.next())).showContentBought();
        	}
        	
        	//option to show comments of content
        	else if(menuInput == 5) {
        		for (String name: store.getAllContent().keySet())
        		{
                    String key = name;
                    String value = store.getAllContent().get(name).getName().toString(); 
                    System.out.println("\nContent Id: " + key + " Content Name:" + value);  
        		}
        		
        		System.out.println("\nType content id to show conent of that content:");
        		(store.getAllContent().get(input.next())).showReview();
        	}
        	
        	//option to terminate the program
        	else if(menuInput == 6) {
        		System.out.println("program terminated");
        		System.exit(0);
        	}        	
        }while(menuInput != 6);
        input.close();
        }
}