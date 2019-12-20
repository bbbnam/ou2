package junit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public int add(String str) {
		if (isNullChk(str)){
			return 0;
		}
		
		return sum(toInts(split(str)));
		
	}
	private int [] toInts(String [] values){
		int [] numbers = new int[values.length];
		for (int i = 0; i < values.length; i++){
			numbers[i] = toPositive(values[i]);
		}
		return numbers;
	}
	
	private int toPositive(String value) {
		int num = Integer.parseInt(value);
		if (num < 0){
			throw new RuntimeException();
		}
		return num;
	}
	

	private int sum(int[] numbers) {
		int sum = 0;
		for (int number : numbers){
			sum += number;
		}
		return sum;
	}


	private String[] split(String str) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);
		if (m.find()){
			String customDivStr = m.group(1); 
			return m.group(2).split(customDivStr);
		}
		
		return str.split(",|:");
	}

	
	private boolean isNullChk(String str) {
		return str == null || str.isEmpty();
	}

}
