
public class ProductValidator {
	
	static {
		System.out.println("Static Yapýcý Metod");
	};
	
	ProductValidator productValidator;
	public ProductValidator() {
		System.out.println("Yapýcý Metod");
	}
	public static boolean isValid(Product product) {
		if(product.price>0 && !product.name.isEmpty())
		{
			return true;
		}
		else {
			return false;
		}
	}

}
