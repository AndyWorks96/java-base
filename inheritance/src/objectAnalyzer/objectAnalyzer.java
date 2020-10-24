package objectAnalyzer;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class objectAnalyzer {
	private ArrayList<Object> visited=new ArrayList<>();
	public String toString(Object obj)
	{
		if(obj==null)return "null";
		if(visited.contains(obj)) return "...";
		visited.add(obj);
		Class cl=obj.getClass();
		if(cl==String.class) return (String)obj;
		if(cl.isArray())
		{
			String r=cl.getComponentType()+"[]{";
			for(int i=0;i<Array.getLength(obj);i++)
			{
				if(i>0) r+=",";
				Object val=Array.get(obj, i);
				if(cl.getComponentType().isPrimitive()) r+=val;
				else r+=toString(val);//�˴���һ���ݹ�
				
			}
			return r+"}";
		}
		String r=cl.getName();
		do {
			r+="[";
			Field[] fields=cl.getDeclaredFields();
			//��仰�ܹؼ����޴˾�����һ������
			
			AccessibleObject.setAccessible(fields, true);
			for(Field f:fields)
			{
				if(!Modifier.isStatic(f.getModifiers()))
				{
					if(!r.endsWith("[")) r+=",";
					r+=f.getName()+"=";
					try {
						Class tClass=f.getType();
						Object val=f.get(obj);//���obj��ĵ�ǰֵ
						if(tClass.isPrimitive())r+=val;
						else r+=toString(val);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
			r+="]";
			cl=cl.getSuperclass();//object��ĳ���Ϊ����������ѭ��
			
		} while (cl!=null);
		
		
		return r;
	}
	
}

