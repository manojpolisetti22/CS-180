/**
 * CS180 Lab03
 * This program creates usernames from full names
 * @author Manoj Kumar Polisetti. mpoliset@purdue.edu
 * Created by mpoliset on 9/6/2015.
 */
import java.util.Scanner;
public class StringManipulator {
    public String makeUserName(String name){
        if(name == null) {
            return null;
        }
        name = name.toLowerCase();
        int positionSpace= name.indexOf(' ');
        int stringLength= name.length();
        char c = name.charAt(0);
        String username = c + name.substring(positionSpace+1, stringLength);
        return username;

    }
    public String makeEmail(String name, String domain){
        if( name == null) {
            return null;
        }
        name = name.toLowerCase();
        domain = domain.toLowerCase();
        StringManipulator sm = new StringManipulator();
        //int positionSpace= name.indexOf(' ');
        //int stringLength= name.length();
        //char c = name.charAt(0);
        String username = sm.makeUserName(name) + "@" + domain;  //c + name.substring(positionSpace+1)
        //username = username + "@" + domain;
        return username;
    }
    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
        System.out.println("Enter your Name");
        String name= s.nextLine();
        System.out.println("Enter domain");
        String domain = s.nextLine();
        StringManipulator sm = new StringManipulator();
        System.out.println(sm.makeUserName(name));
        System.out.println(sm.makeEmail(name, domain));

        /*char c= name.charAt(0);
        int positionSpace= name.indexOf(' ');
        int stringLength= name.length();
        String username = c + name.substring(positionSpace+1, stringLength);
        username = username + "@purdue.edu";
        System.out.println("The username is "+ username);
        */
    }
}
