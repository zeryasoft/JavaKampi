package classes;

public class Main {

	public static void main(String[] args) {
		CustomerManager customerManager=new CustomerManager(); //CustomerManager customerManager; bu stack te oluþur
																//new CustomerManager(); burasý ise heap te oluþur
		CustomerManager customerManager2=new CustomerManager();
		
		customerManager=customerManager2; //customerManager2 referansýný customerManager nesnesine verdik
		
		customerManager.Add();
		customerManager.Delete();
		customerManager.Update();
		
		
		Product product=new Product();
		product.setId(1);
		product.getId();
		product.setName("Laptop");
		product.getName();
		
		ProductManager productManager=new ProductManager();
		productManager.Add(product);

	}

}
