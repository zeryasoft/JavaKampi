package zeryasoft.hrms.core.utilities;

import java.util.Random;

public class GenerateRandomCode {
	public String Create(Integer id) {

		String[] alphabet = { "A", "B", "C", "D", "E","1","2","3","4","5"

		};

		String dogrulamaKodu = "";

		for (int k = 0; k < alphabet.length; k++) {
			Random r = new Random();
			int randomNumber = r.nextInt(alphabet.length);
			int randomNumber2 = r.nextInt(alphabet.length);

			int random = (int) Math.floor(Math.random() * 9999);
			dogrulamaKodu = alphabet[randomNumber] + "" + id + "" + alphabet[randomNumber2] + "" + random;

		}
		return dogrulamaKodu; // Callback
	}
}
