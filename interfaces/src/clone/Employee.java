package clone;

import java.util.Date;
import java.util.GregorianCalendar;



public class Employee implements Cloneable{
	
	private String name;
	private double salary;
	private Date hireDay;
	public Employee(String name,double salary) {
		this.name=name;
		this.salary=salary;	
		this.hireDay=new Date();
	}
	public String getName()
	{
		return name;
	}
	public double getSalary()
	{
		return salary;
	}
	public void raiseSalary(double byPercent)
	{
		double raise=salary*byPercent/100;
		salary+=raise;
	}
	public Employee clone() throws CloneNotSupportedException
	{
		//ctrl+1提示修复   alt+shift+L快速生成新的变量
		Employee cloned = (Employee) super.clone();
		//克隆可变的实例域
		cloned.hireDay=(Date) hireDay.clone();
		return (Employee) cloned;
	}
	public void setHireDay(int year,int month,int day)
	{
		Date newHireDay=new GregorianCalendar(year,month-1,day).getTime();
		hireDay.setTime(newHireDay.getTime());
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", hireDay=" + hireDay + "]";
	}
	
}
