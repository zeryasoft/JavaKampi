
public class ProductValidator {
	
	static {
		System.out.println("Static Yap�c� Metod");
	};
	
	ProductValidator productValidator;
	public ProductValidator() {
		System.out.println("Yap�c� Metod");
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
