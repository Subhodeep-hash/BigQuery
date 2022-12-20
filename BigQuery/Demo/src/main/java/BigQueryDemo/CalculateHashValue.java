package BigQueryDemo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CalculateHashValue {

	public String createHash(String agg) throws NoSuchAlgorithmException {
		String hash = null;
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] messageDigest = md.digest(agg.getBytes());
		hash = bytesToHex(messageDigest);
		return hash;
		
	}
	
	private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }


}
