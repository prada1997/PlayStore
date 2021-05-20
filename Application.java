
public class Application extends Content{
	
	//if no price is passed then application is free
	private String osType;

	protected Application(String id, String name, double price, String osType){
		super.setId(id);
		super.setName(name);
		super.setPrice(price);
		this.osType = osType;	 
		super.setNumberOfDownload(0);
	}
	
	
	protected Application(String id, String name, String osType){
		super.setId(id);
		super.setName(name);
		this.osType = osType;
		super.setPrice(0);
		super.setNumberOfDownload(0);
	}


	public String getOsType() {
		return osType;
	}
}
