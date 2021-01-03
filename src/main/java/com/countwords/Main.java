package com.countwords;

import java.util.HashMap;

public class Main {

  private static final FileService FILE_SERVICE = new FileService();
  private static final CharacterService CHARACTER_SERVICE = new CharacterService();

  public static void main(String[] args) {
    for (String arg : args) {
      if (arg.contains("-F")) {
        FILE_SERVICE.readFile(arg.split("=")[1]);
      }
    }

    convertToKeyValuePair(args).forEach((k, v) -> {
          switch (k) {
            case "-C":
              CHARACTER_SERVICE.countCharacters(FILE_SERVICE.getFileLines());
              break;
            case "-L":
              CHARACTER_SERVICE.countWordsCapitalLetter(FILE_SERVICE.getFileLines());
              break;
            case "-S":
              String[] stopWords = v.split(",");
              CHARACTER_SERVICE.countWords(FILE_SERVICE.getFileLines(), stopWords);
              break;
            default:
              break;
          }
        }
    );
  }

  private static HashMap<String, String> convertToKeyValuePair(String[] args) {
    HashMap<String, String> params = new HashMap<>();
    for (String arg : args) {
      if (arg.contains("=")) {
        String[] splitFromEqual = arg.split("=");
        params.put(splitFromEqual[0], splitFromEqual[1]);
      } else {
        params.put(arg, null);
      }
    }
    return params;
  }
}
