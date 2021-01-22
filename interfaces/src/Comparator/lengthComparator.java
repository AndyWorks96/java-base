package Comparator;



public class lengthComparator implements Comparator<String> {

	@Override
	public int compare(String first, String second) {
		return first.length()-second.length();
	}
	
}

