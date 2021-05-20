import java.util.HashMap;

public class User {
	
	private String id;
	private String name;
	private String phoneNumber;
	private double fund;
	private double discountAmount = 0;
	private HashMap<String, Content> contentBought = new HashMap<String, Content>();		
	private boolean premium = false;
		
		
	public User(String iD, String name, String phoneNumber, int fund) {
		this.id = iD;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.fund = fund;
	}
	

	public User(String iD, String name, String phoneNumber) {
		this.id = iD;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.fund = 500;

	}


	public String getId() {
		return id;
	}	
	
	
	//method to make user premium
	public void becomePremium()throws myCustomException {
		// TODO Auto-generated method stub
		if (this.fund > 100) {
			this.fund -= 100;
			this.premium = true;
			System.out.println("User is premium now");
		}else {
			throw new myCustomException("Can't upgrade insufficient balance");
		}
	}
	
	
	//method to buy content for the user
	public void buyContent(Content buyRequested )throws myCustomException {
		// TODO Auto-generated method stub
			if(this.premium == true){
				this.discountAmount = buyRequested.getPrice() * 20;
				this.discountAmount = this.discountAmount / 100;				
				double contentPriceafterDIS = buyRequested.getPrice() - this.discountAmount; 
				double balance = this.fund;
				balance = balance - contentPriceafterDIS;
				
				if( balance < 0 ) {
					throw new myCustomException("Insufficienct Balance");
				}else {
					this.fund = balance;
					int increase = buyRequested.getNumberOfDownload();
					increase++;
					buyRequested.setNumberOfDownload(increase);
				}
			}else{
				this.fund -= buyRequested.getPrice();
				contentBought.put(buyRequested.getId(), buyRequested);	
				int increase = buyRequested.getNumberOfDownload();
				increase++;
				buyRequested.setNumberOfDownload(increase);
			}
		}
		
	
	//method to print content already bought by the user
	public void showContentBought() {
		// TODO Auto-generated method stub
		for (String id: contentBought.keySet()){
            String key = id;
            String value = contentBought.get(key).getName().toString(); 
            System.out.println("Content Id: " + key + "  Content Name:" + value);
		}
	}
}