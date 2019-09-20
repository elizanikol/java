public class Default extends Mode {
    
    private String[] fileNames_;
    private String hashType_;
    
    public Default(String[] args) {
        this.fileNames_ = java.util.Arrays.copyOfRange(args, 2, args.length);
        this.hashType_ = args[0];
    }

    @Override
    public void calcHash() {
        
        if (hashType_.equals("-md5")) {    
            for (String fileName : fileNames_) {
                System.out.println("For file: " + fileName);
                md5Hash(fileName);
            } 
        } else {
            for (String fileName : fileNames_) {
                System.out.println("For file: " + fileName);
                sha256Hash(fileName);
            }
        }
    }
}
