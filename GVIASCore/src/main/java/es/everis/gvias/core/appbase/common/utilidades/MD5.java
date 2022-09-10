package es.everis.gvias.core.appbase.common.utilidades;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Class MD5.
 */
public class MD5 {  
	
	/**
	 * Obtiene el valor de m d5.
	 *
	 * @param entrada valor de entrada
	 * @return m d5
	 */
    public String getMD5(String entrada) {  
        try {  
            MessageDigest md = MessageDigest.getInstance("MD5");  
            byte[] messageDigest = md.digest(entrada.getBytes());  
            BigInteger number = new BigInteger(1, messageDigest);  
            String hashtext = number.toString(16);  
            while (hashtext.length() < 32) {  
                hashtext = "0" + hashtext;  
            }  
            return hashtext;  
        }  
        catch (NoSuchAlgorithmException e) {  
            throw new RuntimeException(e);  
        }  
    }  
   

    /**
     * Método main.
     *
     * @param args argumentos
     * @throws NoSuchAlgorithmException no such algorithm exception
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {  
    	
    	MD5 md5 = new MD5();
    	String sPasswd = "direccion";
    	String sEncryptPasswd = md5.getMD5(sPasswd);
        System.out.println(sEncryptPasswd);  
        
    }  
	
}
