import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
        
        if (args.length < 2) {
            throw new Exception("Invalid input format: not enough arguments");
        }
        
        String flag = args[0];

        switch(flag) {            
            case "-i":
                if (args.length != 2) {
                    throw new Exception("Invalid input format: not enough arguments");
                }
                Interactive interMode = new Interactive(args[1]);
                interMode.calcHash();
                interMode.menu();           
                break;

            case "-md5": 
            case "-sha256":
                if (args.length < 3) {
                    throw new Exception("Invalid input format: not enough arguments");
                }
                if (!args[1].equals("-f")) {
                    throw new Exception("Invalid flag");
                }
                Default defMode = new Default(args);
                defMode.calcHash();
                break;

            default: System.out.println("Invalid hash type");
        }
    }
}
