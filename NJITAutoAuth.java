import java.net.*;
import java.io.IOException;
public class NJITAutoAuth{
	static class MyAuthenticator extends Authenticator {
		static String UCID;
		static String Password;
		public MyAuthenticator(String ucid,String password){
			UCID = ucid;
			Password = password;
		}
		public PasswordAuthentication getPasswordAuthentication(){
			return (new PasswordAuthentication(UCID, Password.toCharArray()));
		}
	}
	public NJITAutoAuth(String UCID, String UCIDPassword){
		try{
			Authenticator.setDefault(new MyAuthenticator(UCID, UCIDPassword));
			System.out.println("Authenticator Created...");
			String URLString = new String("http://auth.njit.edu/");
			URL myURL = new URL(URLString);
			System.out.println("URL Created...");
			HttpURLConnection myURLConnection = (HttpURLConnection) myURL.openConnection();
			System.out.println("URL Connection Created...");
			myURLConnection.getInputStream();
			System.out.println("Connected!");
		}
		catch (MalformedURLException e){
			e.printStackTrace();
		}
		catch (IOException e){
			System.out.println("Connection Refused! Try Again Later.");
		}
	}

	public static void main(String[] args){
		new NJITAutoAuth(args[0], args[1]);
	}
}