# Hash Generator

## Description:
Console program for generating file hashes using md5 and sha256 hash functions. Works in interactive and default modes.
Tips: 
* Choose interactive mode to calculate hashes of the given file using both md5 and sha256 hash functions. 
* Choose default mode to calculate hashes of as many files as you want using either md5 or sha256 function.

## Compilation:
Before running the program type in terminal:

```
$ ./Compile.sh
```

(File, which contains all necessary instructions)

## Usage:
* To use interactive mode write in terminal:

```
$ java -jar test.jar -i /*name of your file*/
```

If you want to calculate hashes of other files, you can continue execution by entering 1 and typing the name of another file, otherwise, enter 0.

* To use default mode write in terminal one of these lines:

```
$ java -jar test.jar -md5 -f /*names of files separated by spaces*/

$ java -jar test.jar -sha256 -f /*names of files separated by spaces*/
```

depending on what hash function you want to use.
