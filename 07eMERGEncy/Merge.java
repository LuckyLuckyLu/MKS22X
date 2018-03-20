public class Merge{
    // public static void mergesort(int[] data){
    // 	if (data.length <= 1){
	    
    // 	} else {
    // 	    int lo = 0;
    // 	    int hi = data.length;
    // 	    int mi = lo/2 + hi/2;
    // 	    int[] temp = data.length/2;
	
    // }

    public static int[]  merge(int[] data, int[] temp){//, int lo, int mi, int hi){
	int[] total = new int[data.length+temp.length];
	int di = 0;
	int ti = 0;
	int index = 0;
	while (di < data.length || ti < data.length){
	    if (data[di] <= temp[ti]){
		total[index] = data[di];
		di++;
	    } else {
		total[index] = temp[ti];
		ti++;
	    }
	    index++;
	}
	//data = total;
	return total;
    }
    public static String toString(int[] data){
	String result = "";
	int index = 0;
	while (index < data.length){
	    result += data[index];
	    index++;
	}
	return result;
    }
    // public static void  msort(int[] data, int[] temp, int lo, int hi){
	
    // }
    public static void main(String[] Arg){
	int[] data = {1,2,3,4,5,6,7};
	int[] test = {2,6,7,9,19};
	System.out.println(toString(merge(data,test)));
	System.out.println(toString(data));
    }
}
