package arrayList;
import java.util.*;

//泛型数组列表
public class ArrayListTest {
	
	public static void main(String[] args) {
		
		//菱形语法
		ArrayList<Employee> staff=new ArrayList<>();
		Employee test=new Employee("Mary", 8000, 1998, 8, 3);
		staff.add(new Employee("andy", 10000, 1996, 8, 3));
		staff.add(new Employee("Tom", 20000, 1997, 7, 3));
		System.out.println(staff);
		System.out.println(staff.size());
		
		//add和set方法 add添加新元素，set只能替换数组已经存在的元素
		staff.set(0, test);
		//get方法
		Employee getOne=(Employee)staff.get(1);
		System.out.println(staff.get(1).getClass());
		System.out.println(getOne);
		for(Employee e:staff)
		{
			e.raiseSalary(5);
		}
		for(Employee e:staff)
		{
			System.out.println("name="+e.getName()+",salary="+e.getSalary()+",hireDay="+e.getHireDay());
		}
		Employee []a=new Employee[2];
		staff.toArray(a);
		System.out.println(a[0]);
	}

	
}
