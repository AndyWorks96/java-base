package clone;

public class cloneDemo {
	//对象克隆
	//cloneable
	public static void main(String[] args) throws CloneNotSupportedException {
		Employee original=new Employee("John Public", 50000);
		Employee copy=original;//克隆对象和之前的原变量相同
		copy.raiseSalary(10);
		System.out.println(original.getSalary());
		//希望有自己的状态需要使用clone方法
		Employee copy01=original.clone();
		copy01.raiseSalary(20);
		System.out.println(original.getSalary());//原变量没有改变
		System.out.println(copy01.getSalary());//克隆对象发生改变
		System.out.println(original);
	}
	
}
