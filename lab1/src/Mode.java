import org.apache.commons.codec.digest.DigestUtils;
import java.io.File;
import java.util.Scanner;


public abstract class Mode {
    
    public abstract void calcHash();

    public void md5Hash(String fileName) {
        if  (readFile(fileName) == null);
        else {
            System.out.println("Hash code using md5Hex: " + DigestUtils.md5Hex(readFile(fileName)));
        }
    }

    public void sha256Hash(String fileName) {
        if  (readFile(fileName) == null);
        else {
            System.out.println("Hash code using sha256Hex: " + DigestUtils.sha256Hex(readFile(fileName)));
        }
    }

    public String readFile(String fileName) {
        try {
            String entireFileText = new Scanner(new File(fileName)).useDelimiter("\\A").next();
            return entireFileText;
        } catch (Exception e) {
            System.out.println("Invalid file");
            return null;
        }
    }
}
