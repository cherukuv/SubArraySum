

import java.util.Arrays;

public class SubArray {
	private static void combination(SumObj prefixSumObj, SumObj remainingSumObj, int expectedSum){

	    if(prefixSumObj.getSum() == expectedSum){
	        System.out.println(Arrays.toString(prefixSumObj.getElements()));
	    } 

	    for(int i=0; i< remainingSumObj.getElements().length ; i++){
	        // prepare new prefix
	        int [] newPrefixSumInput = new int[prefixSumObj.getElements().length + 1];
	        System.arraycopy(prefixSumObj.getElements(), 0, newPrefixSumInput, 0, prefixSumObj.getElements().length);
	        newPrefixSumInput[prefixSumObj.getElements().length] = remainingSumObj.getElements()[i];
	        SumObj newPrefixSumObj = new SumObj(newPrefixSumInput);

	        // prepare new remaining
	        int [] newRemainingSumInput = new int[remainingSumObj.getElements().length - i - 1];            
	        System.arraycopy(remainingSumObj.getElements(), i+1, newRemainingSumInput, 0, remainingSumObj.getElements().length - i - 1);
	        SumObj newRemainingSumObj = new SumObj(newRemainingSumInput);

	        combination(newPrefixSumObj, newRemainingSumObj, expectedSum);
	    }
	}

	private static class SumObj {
	    private int[] elements;
	    private int sum;

	    public SumObj(int[] elements) {
	        this.elements = elements;
	        this.sum = computeSum();
	    }

	    public int[] getElements() {
	        return elements;
	    }

	    public int getSum() {
	        return sum;
	    }

	    private int computeSum(){
	        int tempSum = 0;
	        for(int i=0; i< elements.length; i++){
	            tempSum = (tempSum)*(elements[i]);
	        }
	        return tempSum;
	    }
	}
	
	public static void main(String[] args) {
	    	
		System.out.println("Please enter array Length \n");
		Scanner input = new Scanner(System.in);

	        // Create a new array. The user enters the size
	        int[] array = new int[input.nextInt()];

	        System.out.println("Please enter elements seperated with single space \n");
	        // Get the value of each element in the array
	        for(int i = 0; i < array.length; i++)
	            array[i] = input.nextInt();
	    
	    int expectedSum = 7;
	    combination(new SumObj(new int[0]), new SumObj(array), expectedSum);
	}	
	
	
	
}
