package inheritance;

public class ManagerTest {

	public static void main(String[] args) {
		Manager boss=new Manager("Carl Craker", 80000, 1996, 8, 3);
		boss.setBonus(5000);
		Employee[] staff=new Employee[3];
		
		staff[0]=boss;
		staff[1]=new Employee("Harry Hacker",5000,1989,10,1);
		staff[2]=new Employee("Tommy Tester",4000,1990,3,15);
		for(Employee e:staff)
			System.out.println("name="+e.getName()+",salary="+e.getSalary());
	
		if(staff[0] instanceof Manager)
			System.out.println(staff[0].getClass());
	}
}
