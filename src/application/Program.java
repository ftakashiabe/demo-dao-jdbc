package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.SellerDao;
import model.dao.impl.DaoFactory;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("===== TEST1 - Seller findById =====");
		Seller seller1 = sellerDao.findById(3);
		System.out.println(seller1);

		System.out.println("===== TEST2 - Seller findByDepartment =====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller seller2 : list) {
			System.out.println(seller2);
		}	
		
		System.out.println("===== TEST3 - Seller findAll =====");
		list = sellerDao.findAll();
		for (Seller seller3 : list) {
				System.out.println(seller3);	
		}
		
		System.out.println("===== TEST4 - Seller insert =====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New Id = " + newSeller.getId());
		
		System.out.println("===== TEST5 - Seller update =====");
		seller1 = sellerDao.findById(1);
		seller1.setName("Martha Wayne");
		seller1.setEmail("martha@gmail.com");
		sellerDao.update(seller1);
		System.out.println("Updated!");
		
		System.out.println("===== TEST6 - Seller delete =====");
		System.out.println("Type seller id to delete ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Deleted!");
		sc.close();
		
	}

}
