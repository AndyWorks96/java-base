package arrayList;

import java.time.LocalDate;


public class Employee extends Person {
	
	public Employee(String name,double salary,int year,int month,int day) {
		super(name);
		this.salary=salary;
		this.hireDay=LocalDate.of(year,month,day);
	}
	private double salary;
	private LocalDate hireDay;

	public double getSalary()
	{
		return salary;
	}
	
	public LocalDate getHireDay()
	{
		return hireDay;
	}
	
	
	public void raiseSalary(double byPercent)
	{
		double raise=salary*byPercent/100;
		salary+=raise;
	}
	
	@Override
	public String getDescription() {
		
		return String.format("an employee with a salary $%.2f",salary);
	}
	@Override
	public String toString() {
		return "Employee [name="+super.getName()+",salary=" + salary + ", hireDay=" + hireDay + "]";
	}
}
