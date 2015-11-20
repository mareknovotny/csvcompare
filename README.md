# CSV file comparator tool

Basic tool to compare two CSV files from [Windup](http://github.com/windup/windup) CSV export and outputs as CSV file with different lines from second file.

There is `compare.sh` script to launch the tool

`$ ./compare.sh <URL1> <URL2>`

or alternatively 

`java -jar csvcompare-0.0.1-SNAPSHOT.jar -o <URL1> -n <URL2> -d ,`

where *URL1* and *URL2* is [Uniform Resource Locator](http://www.ietf.org/rfc/rfc2396.txt)

Usage help is shown when you run it without arguments:
`java -jar csvcompare-0.0.1-SNAPSHOT.jar`

```
usage: csvcompare
 -d,--csv-delimiter <delimiter in CSV file>
 -n,--new-file <URL of CSV file>
 -o,--old-file <URL of CSV file>
```
 