package kodlamaio.northwind.entities.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductWithCategoryDto {
	//Dto:Data Transformation object
	private int id;
	private String productName;
	private String categoryName;
}
