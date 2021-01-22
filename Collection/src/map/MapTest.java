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
		
		//ӳ����ͼ
		//��һ�֣��ձ�ʹ�ã����ڶ���ȡֵ,Ч�ʻ�ȵڶ��ֺ͵�������һ��
		  System.out.println("ͨ��Map.keySet����key��value��");  
		  for (String key : staff.keySet()) {  
		   System.out.println("key= "+ key + " and value= " + staff.get(key));  
		  }  
		    
		  //�ڶ���  
		  System.out.println("ͨ��Map.entrySetʹ��iterator����key��value��");  
		  Iterator<Entry<String, Employee>> it = staff.entrySet().iterator();  
		  while (it.hasNext()) {  
		   Entry<String, Employee> entry = it.next();  
		   System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());  
		  }  
		    
		  //�����֣��޷���forѭ��ʱʵ��remove�Ȳ���  
		  System.out.println("ͨ��Map.entrySet����key��value");  
		  for (Entry<String, Employee> entry : staff.entrySet()) {  
		   System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());  
		  }  
		  
		  //�����֣�ֻ�ܻ�ȡvalues,���ܻ�ȡkey 
		  System.out.println("ͨ��Map.values()�������е�value�������ܱ���key");  
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
