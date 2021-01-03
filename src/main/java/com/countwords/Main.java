package com.countwords;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  private static final FileService FILE_SERVICE = new FileService();
  private static final CharacterService CHARACTER_SERVICE = new CharacterService();

  public static void main(String[] args) {
    String fileNameArg = getArgs(args, "-F");
    List<String> fileLines = FILE_SERVICE.readFile(fileNameArg);

    if ("".equals(getArgs(args, "-C"))) {
      CHARACTER_SERVICE.countCharacters(fileLines);
    }

    String stopWordArg = getArgs(args, "-S");
    if (!"".equals(stopWordArg)) {
      String[] stopWords = stopWordArg.split(",");
      CHARACTER_SERVICE.countWords(fileLines, stopWords);
    }

    if ("".equals(getArgs(args, "-L"))) {
      CHARACTER_SERVICE.countWordsCapitalLetter(fileLines);
    }
  }

  private static String getArgs(String argArray[], String indicator) {
    String arguments = "";
    for (String s : argArray) {
      arguments = arguments + s + " ";
    }
    arguments = arguments.trim();
    Pattern p = Pattern.compile(indicator + " ([^\\-]*)");
    Matcher m = p.matcher(arguments);
    try {
      if (m.find()) {
        return m.group(1)
            .trim();
      } else {
        return "";
      }
    } catch (IllegalStateException e) {
      System.out.println("Error: " + e);
      return "";
    }
  }

}
