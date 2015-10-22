# CSV file comparator tool

Basic tool to compare 2 CSV files and outputs as CSV file with different lines from second file.

There is `compare.sh` script to launch the tool

`$ ./compare.sh first.csv second.csv`

or alternatively 

`java -jar csvcompare-0.0.1-SNAPSHOT.jar -o first.csv -n second.csv -d ,`

Usage help is shown when you run it without arguments:
`java -jar csvcompare-0.0.1-SNAPSHOT.jar`

```
usage: csvcompare
 -d,--csv-delimiter <arg>
 -n,--new-file <arg>
 -o,--old-file <arg>
```
 