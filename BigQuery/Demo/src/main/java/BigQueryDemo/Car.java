package BigQueryDemo;

import java.security.NoSuchAlgorithmException;

import org.apache.beam.sdk.transforms.SimpleFunction;

public class Car extends SimpleFunction<String,String>{

	String Hash(String input) {
		
		String arr[] = input.split(",");
		String agg = "";
		for(int i=0; i<arr.length; i++) {
			agg = agg+arr[i];
		}
		CalculateHashValue calHash = new CalculateHashValue();
		String hash = null;
		try {
			hash = calHash.createHash(agg);
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hash;
		
	}

}
