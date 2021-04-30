package homework;

public class Main {

	public static void main(String[] args) {
		Menu menu1=new Menu();
		menu1.id=1;
		menu1.name="Kurslarım";
		
		Menu menu2=new Menu();
		menu2.id=2;
		menu2.name="Tüm Kurslar";
		
		Menu menu3=new Menu();
		menu3.id=3;
		menu3.name="Kampa Hazırlık";
		
		Menu menu4=new Menu();
		menu4.id=4;
		menu4.name="Sık Sorulan Sorular";
		
		Menu[] menus=new Menu[]{menu1,menu2,menu3,menu4};
		for (Menu menu : menus) {
			System.out.println(menu.name);
		}
		
		Course course1=new Course();
		course1.id=1;
		course1.name="﻿(100+ Saat) Aranan Programcı Olma Kamp Kursu| Python,Java,C#";
		course1.detail="Sürekli güncel kalan kurs içeriğiyle sıfırdan Python, JAVA, C#, Flutter, Angular, React ve çok daha fazlasını öğrenin.";
		
		Course course2=new Course();
		course2.id=2;
		course2.name="Modern Web Geliştirme Kursu | Sıfırdan Sektörün Yükseklerine";
		course2.detail="Modern tekniklerle Web Geliştirme (WebDevelopment) öğrenin. HTML, CSS, Node, JavaScript, React, Angular, ASP.NET Core.";
		
		Course course3=new Course();
		course3.id=3;
		course3.name="﻿Modern C# Kursu : .NET Dünyası İçin Sıfırdan Profesyonelliğe";
		course3.detail="Tamamı Kasım 2020'de çekilmiş en güncel içerikle sıfırdan başlayıp, sektörün gerçek ihtiyaçlarına uygun C# öğrenin.";
		
		Course[] courses= {course1,course2,course3};
		for (Course course : courses) {
			System.out.println(course.name);
		}

	}

}
