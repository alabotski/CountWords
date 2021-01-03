package com.countwords;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CharacterService {

  public void countCharacters(List<String> fileLines) {
    long countCharacters = fileLines.stream()
        .mapToInt(String::length)
        .sum();
    System.out.println("Count characters: " + countCharacters);
  }

  public void countWords(List<String> fileLines, String[] stopWords) {
    long wordCount = prepareTextFile(fileLines)
        .filter(line -> Arrays.stream(stopWords)
            .noneMatch(line::equals))
        .count();
    System.out.println("Count words: " + wordCount);
  }

  public void countWordsCapitalLetter(List<String> fileLines) {
    long wordsCapitalLetterCount = prepareTextFile(fileLines)
        .filter(line -> line.charAt(0) == Character.toUpperCase(line.charAt(0)))
        .count();
    System.out.println("Count words with capital letter: " + wordsCapitalLetterCount);
  }

  private Stream<String> prepareTextFile(List<String> fileLines) {
    return fileLines.stream()
        .filter(line -> !line.isEmpty())
        .flatMap(line -> Arrays.stream(line.split(" ")));
  }
}
