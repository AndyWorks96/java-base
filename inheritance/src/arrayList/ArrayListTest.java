package arrayList;
import java.util.*;

//���������б�
public class ArrayListTest {
	
	public static void main(String[] args) {
		
		//�����﷨
		ArrayList<Employee> staff=new ArrayList<>();
		Employee test=new Employee("Mary", 8000, 1998, 8, 3);
		staff.add(new Employee("andy", 10000, 1996, 8, 3));
		staff.add(new Employee("Tom", 20000, 1997, 7, 3));
		System.out.println(staff);
		System.out.println(staff.size());
		
		//add��set���� add�����Ԫ�أ�setֻ���滻�����Ѿ����ڵ�Ԫ��
		staff.set(0, test);
		//get����
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
