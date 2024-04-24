package com.example.projectpet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.projectpet.model.Application;
import com.example.projectpet.model.ApplicationDAO;
import com.example.projectpet.model.Case;
import com.example.projectpet.model.CaseDAO;
import com.example.projectpet.model.Employee;
import com.example.projectpet.model.EmployeeDAO;
import com.example.projectpet.model.Inquire;
import com.example.projectpet.model.InquireDAO;
import com.example.projectpet.model.Item;
import com.example.projectpet.model.ItemDAO;
import com.example.projectpet.model.Member;
import com.example.projectpet.model.MemberDAO;
import com.example.projectpet.model.Order;
import com.example.projectpet.model.OrderDAO;
import com.example.projectpet.model.OrderDetail;
import com.example.projectpet.model.OrderDetailDAO;
import com.example.projectpet.model.Pet;
import com.example.projectpet.model.PetDAO;

@SpringBootApplication
public class ProjectpetApplication implements CommandLineRunner {
	
	@Autowired
    private PetDAO petDAO;
	@Autowired
    private ApplicationDAO appDAO;
	@Autowired
	private CaseDAO caseDAO;
	@Autowired
	private ItemDAO itemDAO;
	@Autowired
	private MemberDAO memDAO;
	@Autowired
	private EmployeeDAO empDAO;
	@Autowired
	private InquireDAO inqDAO;
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private OrderDetailDAO odDAO;

	public static void main(String[] args) {
		SpringApplication.run(ProjectpetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		List<String> a = new ArrayList<>();
//        a.add("image/img1");
//        a.add("image/img2");
//        a.add("image/img3");
        
		petDAO.save(new Pet(1,"Tom","male",5,3,"Dog","Mix",true,"Taipei","送養","健康","待領養",true,"20240103","http://localhost:8080/image/dog1.jpg"));
		petDAO.save(new Pet(2,"John","male",5,3,"Dog","Mix",true,"Taipei","收容中心","健康","待領養",true,"20240303","http://localhost:8080/image/dog2.jpg"));
		petDAO.save(new Pet(3,"Nini","female",5,3,"Dog","Mix",true,"Taipei","收容中心","健康","待領養",true,"20240323","http://localhost:8080/image/dog3.jpg"));
		petDAO.save(new Pet(4,"Eve","male",5,3,"Dog","Mix",true,"Taipei","中途","健康","待領養",true,"20231225","http://localhost:8080/image/dog4.jpg"));
		petDAO.save(new Pet(5,"Stanly","male",5,3,"Dog","Mix",true,"Taipei","送養","健康","待領養",true,"20240309","http://localhost:8080/image/dog5.jpg"));
		petDAO.save(new Pet(6,"Gigi","female",5,2,"Dog","Mix",true,"Taipei","收容中心","健康","待領養",true,"20240303","http://localhost:8080/image/dog6.jpg"));
		petDAO.save(new Pet(7,"Titi","male",8,9,"Dog","Mix",true,"Taipei","中途","健康","待領養",true,"20240308,","http://localhost:8080/image/dog7.jpg"));
		petDAO.save(new Pet(8,"Benson","male",8,9,"Cat","Mix",true,"Taipei","","健康","待領養",true,"20240308,","http://localhost:8080/image/cat1.jpg"));
		petDAO.save(new Pet(9,"Ming","male",10,3,"Cat","Mix",true,"Taipei","中途","健康","待領養",true,"20240303","http://localhost:8080/image/cat2.jpg"));
		petDAO.save(new Pet(10,"Rainbow","female",5,8,"Cat","Mix",true,"Taipei","送養","健康","待領養",true,"20240303","http://localhost:8080/image/cat3.jpg"));
		petDAO.save(new Pet(11,"Daniel","male",11,3,"Cat","Mix",true,"Taipei","收容中心","健康","待領養",true,"20240303","http://localhost:8080/image/cat4.jpg"));
		petDAO.save(new Pet(12,"Ken","male",7,3,"Cat","Mix",true,"Taipei","中途","健康","待領養",true,"20240301","http://localhost:8080/image/cat5.jpg"));
		petDAO.save(new Pet(13,"Lolo","female",6,7,"Cat","Mix",true,"Taipei","送養","健康","待領養",true,"20240131","http://localhost:8080/image/cat6.jpg"));
		petDAO.save(new Pet(14,"Sunny","male",5,3,"Cat","Mix",true,"Taipei","送養","健康","待領養",true,"20240203","http://localhost:8080/image/cat7.jpg"));

		appDAO.save(new Application(1,"小明","王","台北市","0912123456","man",33,true,"IT","xxx@xxx.com","台北市","陪伴"));
		appDAO.save(new Application(2,"小琳","林","台北市","0912123451","woman",43,true,"IT","xxx@xxx.com","台北市","陪伴"));
		appDAO.save(new Application(3,"大明","陳","台北市","0912123452","man",23,false,"Fin","xxx@xxx.com","高雄市","陪伴"));

		caseDAO.save(new Case(1,"領養",appDAO.queryById(1),petDAO.queryById(1),"20240303"));
		caseDAO.save(new Case(2,"領養",appDAO.queryById(2),petDAO.queryById(2),"20240303"));
		caseDAO.save(new Case(3,"送養",appDAO.queryById(3),petDAO.queryById(3),"20240303"));
		
		itemDAO.save(new Item(1,"精選T-Shirt",700,50,"我愛毛孩大宣言","20240303",true,"http://localhost:8080/image/product1.jpg"));
		itemDAO.save(new Item(2,"貼心馬克杯",450,50,"每天的好朋友","20240304",true,"http://localhost:8080/image/product2.jpg"));
		itemDAO.save(new Item(3,"貼心小抱枕",800,30,"伴你入好眠","20240305",true,"http://localhost:8080/image/product3.jpg"));
		itemDAO.save(new Item(4,"可愛實用環保袋 (淺紫款)",600,50,"圖樣1環保袋","20240304",true,"http://localhost:8080/image/product4.jpg"));
		itemDAO.save(new Item(5,"可愛實用環保袋 (深藍款)",600,50,"圖樣2環保袋","20240305",true,"http://localhost:8080/image/product5.jpg"));


		//memDAO.save(new Member(1,"書尤","林","Taipei","0912000111","xxx@xxx.com"));
		//memDAO.save(new Member(2,"俠客","王","Taipei","0912000111","xxx@xxx.com"));
		//memDAO.save(new Member(3,"浩然","陳","Taipei","0912000111","xxx@xxx.com"));
		
		empDAO.save(new Employee(1,"管理","王","Taipei","0978777111","admin@petex.com","Administrator","admin","admin"));
		empDAO.save(new Employee(2,"幫手","林","Taipei","0918033111","admin@petex.com","Assistance","lin","lin"));
		empDAO.save(new Employee(3,"高手","陳","Taipei","0977888999","admin@petex.com","Engineer","tech","tech"));
		
		inqDAO.save(new Inquire(1,"林木一","09883347111","q1@xxx.com","詢問1",false));
		inqDAO.save(new Inquire(2,"陳明朗","0974327111","q2@xxx.com","詢問2",false));
		inqDAO.save(new Inquire(3,"王大明","0973777231","q3@xxx.com","詢問3",false));
		
		//orderDAO.save(new Order(1,memDAO.findBymemberId(1),"20240303","盡快出貨","已出貨","20240306"));
		//orderDAO.save(new Order(2,memDAO.findBymemberId(2),"20240306","沒有","待處理",""));
		//orderDAO.save(new Order(3,memDAO.findBymemberId(3),"20240309","佛心公司","待處理",""));
		
		//odDAO.save(new OrderDetail(orderDAO.findByorderId(1),itemDAO.queryByitemId(1),350,1,350));
		//odDAO.save(new OrderDetail(orderDAO.findByorderId(1),itemDAO.queryByitemId(2),500,2,1000));
		//odDAO.save(new OrderDetail(orderDAO.findByorderId(2),itemDAO.queryByitemId(3),350,1,350));

	}

}
