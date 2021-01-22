package map;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;



public class MapTest {
	public static void main(String[] args) {
		Map<String,Employee> staff=new HashMap<>();
		staff.put("144-25-5464",new Employee("Amy Lee"));
		staff.put("567-24-2546",new Employee("Hary Hacker"));
		staff.put("157-62-7935",new Employee("Gary Cooper"));
		staff.put("456-62-5527",new Employee("Francesca Cruz"));
		
		//映射视图
		//第一种：普遍使用，由于二次取值,效率会比第二种和第三种慢一倍
		  System.out.println("通过Map.keySet遍历key和value：");  
		  for (String key : staff.keySet()) {  
		   System.out.println("key= "+ key + " and value= " + staff.get(key));  
		  }  
		    
		  //第二种  
		  System.out.println("通过Map.entrySet使用iterator遍历key和value：");  
		  Iterator<Entry<String, Employee>> it = staff.entrySet().iterator();  
		  while (it.hasNext()) {  
		   Entry<String, Employee> entry = it.next();  
		   System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());  
		  }  
		    
		  //第三种：无法在for循环时实现remove等操作  
		  System.out.println("通过Map.entrySet遍历key和value");  
		  for (Entry<String, Employee> entry : staff.entrySet()) {  
		   System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());  
		  }  
		  
		  //第四种：只能获取values,不能获取key 
		  System.out.println("通过Map.values()遍历所有的value，但不能遍历key");  
		  for (Employee v : staff.values()) {  
		   System.out.println("value= " + v);  
		  }
//		System.out.println(staff);	
//		
//		staff.remove("567-24-2546");
//		System.out.println(staff);
//		staff.put("456-62-5527", new Employee("Tom"));
//		System.out.println(staff);
//		System.out.println(staff.get("157-62-7935"));
//		staff.forEach((k,v)->
//						System.out.println("key="+k+",value="+v)
//				);
	}
	
}
