
public class Magazine extends Publication{
	private int volume;

	protected Magazine(String id, String name, double price, String publisher, int numberOfPages, int volume) {
		super.setId(id);
		super.setName(name);
		super.setPrice(price);
		super.setPublisher(publisher);
		super.setNumberOfPages(numberOfPages);
		this.volume = volume;
	}

	public int getVolume() {
		return volume;
	}
}
