package application;

import java.util.Date;
import java.util.List;

import model.dao.SellerDao;
import model.dao.impl.DaoFactory;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
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
		
		
		
		
		
		
	}

}
