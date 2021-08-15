package practice;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class InetAddressStudy {

    private static Scanner scanner = new Scanner(System.in);
    private static String EXIT_CODE = "e";

    public static void main(String[] args) {
        try{
            boolean continueReading = true;
            String inputAddress;
            InetAddress[] targetIPs;
            while(continueReading){
                System.out.println("도메인 주소를 입력해주세요. 종료를 원하시면 'e'를 눌러주세요. ");
                inputAddress = scanner.nextLine();

                if(inputAddress.equals(EXIT_CODE)){
                    break;
                }

                targetIPs = InetAddress.getAllByName(inputAddress);
                for (InetAddress targetIP : targetIPs) {
                    System.out.println("IP = " + targetIP.getHostAddress());
                    System.out.println("hostname = " + targetIP.getHostName());
                }
            }
        }catch(UnknownHostException e){
            System.out.println("올바르지 않은 도메인 주소입니다. ");
        }
    }

    public void getLocalHostIP(){
        try{
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("local.getHostAddress() = " + local.getHostAddress());
        } catch (UnknownHostException e){
            System.out.println("Cannot find host IP address");
        }
    }
}
