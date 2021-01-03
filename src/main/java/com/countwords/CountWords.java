package com.countwords;

import java.util.HashMap;
import com.countwords.service.FileService;
import com.countwords.utils.WordUtils;

public class CountWords {

  private static FileService fileService;

  public static void main(String[] args) {
    for (String arg : args) {
      if (arg.contains("-F")) {
        fileService = new FileService(arg.split("=")[1]);
      }
    }

    if (fileService != null) {
      convertToKeyValuePair(args).forEach((k, v) -> {
            switch (k) {
              case "-C":
                WordUtils.countCharacters(fileService.getFileLines());
                break;
              case "-L":
                WordUtils.countWordsCapitalLetter(fileService.getFileLines());
                break;
              case "-S":
                String[] stopWords = v.split(",");
                WordUtils.countWords(fileService.getFileLines(), stopWords);
                break;
              default:
                break;
            }
          }
      );
    } else {
      System.out.println("File for parsing not found");
    }
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
