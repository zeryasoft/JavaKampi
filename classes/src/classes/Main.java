package classes;

public class Main {

	public static void main(String[] args) {
		CustomerManager customerManager=new CustomerManager(); //CustomerManager customerManager; bu stack te olu�ur
																//new CustomerManager(); buras� ise heap te olu�ur
		CustomerManager customerManager2=new CustomerManager();
		
		customerManager=customerManager2; //customerManager2 referans�n� customerManager nesnesine verdik
		
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
