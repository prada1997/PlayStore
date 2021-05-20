import java.util.HashMap;

abstract class Content {
	private String id;
	private String name;
	private int numberOfDownload;
	private double price;
	private HashMap<String, String> review = new HashMap<String, String>();

	//only single user can only review once
	//method to add review
	public void addReview(Comment commentObj) {
		review.put(commentObj.getUser().getId() , commentObj.getComment());		
	}
	
	
	//method to show comments of the content
	public void showReview() {
		for (String key: review.keySet()){
            String user = key;
            String comment = review.get(key);  
            System.out.println("User: "+ user + "\nCommented: " + comment + "\n");
		}		
	}
		
	
	public String getId() {
		return id;
	}
	
	
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getNumberOfDownload() {
		return numberOfDownload;
	}
	
	
	public void setNumberOfDownload(int numberOfDownload) {
		this.numberOfDownload = numberOfDownload;
	}
	
	
	public double getPrice() {
		return price;
	}
	
	
	public void setPrice(double price) {
		this.price = price;
	}
}
