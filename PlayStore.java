//You may need the following packages
import java.util.HashMap;
import java.lang.Object;
//import java.util.ArrayList;

public class PlayStore {
	
	// Instance variables that you need.
	// They must all be marked as private
	
	// Declare a private variable (array or similar) to store your Content objects here
	private HashMap<String, Content> allContent = new HashMap<String, Content>();
	// Declare a private variable (array or similar) to store your User objects here
	private HashMap<String, User> allUser = new HashMap<String, User>();
	
	
	public PlayStore() {
		// any code you need here
	}
	
	
	public void addContent(Content content) {
		// add the content into your content list		
		allContent.put(content.getId(), content);
	}
	
	
	public void addUser(User user) {
		// add the user to your list of users		
		allUser.put(user.getId(), user);
	}	
	
	//method to print all content
	public void showContent(String contentType) {
		// add your code here
		for (String key: allContent.keySet()){
            String contentId = key;
            String value = allContent.get(contentId).getName().toString(); 
               
            if(contentType.equals(allContent.get(key).getClass().toString())){   
            	
            	System.out.println("Content ID: " + contentId + "\nContent Type: "+ contentType.substring(6) +"\nContent Name: " + value);   
            	System.out.println("Price: " + allContent.get(contentId).getPrice());
            	System.out.println("Number of Downloads: " + allContent.get(contentId).getNumberOfDownload());
            	
            	if(contentType.equals("class Magazine")) {
            		System.out.println("Content ID: " + contentId + "\nContent Type: "+ contentType.substring(6) +"\nContent Name: " + value);   
            		System.out.println("Price: " + allContent.get(contentId).getPrice());
            		System.out.println("Number of Downloads: " + allContent.get(contentId).getNumberOfDownload());
            		System.out.println("Publisher: " + ((Magazine)allContent.get(contentId)).getPublisher());
            		System.out.println("Number of Pages: " + ((Magazine)allContent.get(contentId)).getNumberOfPages());
            		System.out.println("Volume: " + ((Magazine)allContent.get(contentId)).getVolume() + "\n");
                 	
            	}else if(contentType.equals("class Application")) {
            		System.out.println("Content ID: " + contentId + "\nContent Type: "+ contentType.substring(6) +"\nContent Name: " + value);   
            		System.out.println("Price: " + allContent.get(contentId).getPrice());
            		System.out.println("Number of Downloads: " + allContent.get(contentId).getNumberOfDownload());
            		System.out.println("OS Type: " + ((Application)allContent.get(contentId)).getOsType() + "\n");
            		
            	}else if(contentType.equals("class Book")) {
            		System.out.println("Content ID: " + contentId + "\nContent Type: "+ contentType.substring(6) +"\nContent Name: " + value);   
            		System.out.println("Price: " + allContent.get(contentId).getPrice());
            		System.out.println("Number of Downloads: " + allContent.get(contentId).getNumberOfDownload());
            		System.out.println("Publisher: " + ((Book)allContent.get(contentId)).getPublisher());
            		System.out.println("Number of Pages: " + ((Book)allContent.get(contentId)).getNumberOfPages() + "");
            		
            	}
            	
           	}else if(contentType.equals(allContent.get(key).getClass().toString().substring(0, 5))){
            	
            	String type = allContent.get(contentId).getClass().toString().substring(6);
            	System.out.println("Content ID: " + contentId +  "\nContent Type: " + type +  "\nContent Name: " + value);     
            	System.out.println("Price: " + allContent.get(contentId).getPrice());
            	System.out.println("Number of Downloads: " + allContent.get(contentId).getNumberOfDownload() + "\n");
           	}
		}
	}


	public HashMap<String, Content> getAllContent() {
		return allContent;
	}


	public HashMap<String, User> getAllUser() {
		return allUser;
	}		
}