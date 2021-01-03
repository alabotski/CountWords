# CountWords

Create console Data analyzer utility which: accepts as command line parameters:

- (must) local file system path to a *.txt file(s)
- (must) data command(s)


supports the following data processing commands:
Application should count all words in the provided file and support following options.
- (must) (-F) file name(s)
- (must) (-S) words counter should support "stopwords" option. "Stopwords" are words which will not be counted. For example we need to exclude English articles (a, the) and preposition words (at, on etc.) or any other words
- (must) (-C) count number of characters in the file
- (nice to have)(-L) count words which start with a Capital letter

Data processing results should be printed to output for each file separately and for all resources as total.
Unit testing is not required, but is a nice to have.
Also it would be nice if it will be built with maven

Command line parameters example for Java implementation:
java –jar scraper.jar -F sample.txt –C -S a,the,on,at,any