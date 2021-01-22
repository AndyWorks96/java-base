package Comparator;

public class comparatorTest {
	//comparator½Ó¿Ú
	
	public static void main(String[] args) {
		String []word={"abcd","a"};
		Comparator<String> comp=new lengthComparator();
		if(comp.compare(word[0], word[1])>0){
			System.out.println(comp.compare(word[0], word[1]));
		}
	}
}
