
public class Book extends Publication{
	private String[] authorName;
	
	protected Book(String id, String name, double price, String publisher, int numberOfPages, String[] authorName){
		super.setId(id);
		super.setName(name);
		super.setPrice(price);
		super.setPublisher(publisher);
		super.setNumberOfPages(numberOfPages);
		this.authorName = authorName;
	}
}
