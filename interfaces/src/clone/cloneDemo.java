package clone;

public class cloneDemo {
	//�����¡
	//cloneable
	public static void main(String[] args) throws CloneNotSupportedException {
		Employee original=new Employee("John Public", 50000);
		Employee copy=original;//��¡�����֮ǰ��ԭ������ͬ
		copy.raiseSalary(10);
		System.out.println(original.getSalary());
		//ϣ�����Լ���״̬��Ҫʹ��clone����
		Employee copy01=original.clone();
		copy01.raiseSalary(20);
		System.out.println(original.getSalary());//ԭ����û�иı�
		System.out.println(copy01.getSalary());//��¡�������ı�
		System.out.println(original);
	}
	
}
