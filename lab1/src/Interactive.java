import java.util.Scanner;


public class Interactive extends Mode {
    
    private String fileName_;

    @Override
    public void calcHash() {
        System.out.println("For file: " + fileName_);
        md5Hash(fileName_);
        sha256Hash(fileName_);
    }

    public void menu() {     
        loop_: while (true) {   
            System.out.println("To calculate hash of a new file press 1, to exit press 0");
            try {
                byte x = new Scanner(System.in).nextByte();

                switch(x) {
                    case 1: 
                        System.out.println("Enter the file path");
                        fileName_ = new Scanner(System.in).nextLine();
                        calcHash();
                        break;

                    case 0: 
                        break loop_;

                    default: System.out.println("Incorrect number, try again");
                }             
            } catch (Exception e) {
                System.out.println("Incorrect input, try again");
            } 
        }
    } 
}
