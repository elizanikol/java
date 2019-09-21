# Hash Generator

## Description:
Console program for generating file hashes using md5 and sha256 hash functions. Works in interactive and default modes.
Tips: 
* Choose interactive mode to calculate hashes of each of your files using both md5 and sha256 hash functions. 
* Choose default mode to calculate hashes of as many files as you want at once using either md5 or sha256 function.

## Compilation:
Before running the program type in terminal:

```
$ ./Compile.sh
```

(File, which contains all necessary instructions)

## Usage:
* To use interactive mode write in terminal:

```
$ java -jar test.jar -i
```

If you want to calculate hashe of a file, you can continue execution by entering 1 and typing the file path, otherwise, enter 0. If you chose 1, enter the file path to find its hash. You can repeat this process as many times as you like.

* To use default mode write in terminal one of these lines:

```
$ java -jar test.jar -md5 -f /*file paths separated by spaces*/

$ java -jar test.jar -sha256 -f /*file paths separated by spaces*/
```

depending on the hash function you want to use.
