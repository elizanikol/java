javac -classpath lib/commons-codec-1.13.jar *.java
jar cfm test.jar manifest.txt Default.class Main.class Interactive.class Mode.class
