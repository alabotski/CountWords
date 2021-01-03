package com.countwords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileService {

  private List<String> fileLines;

  public void readFile(String fileName) {
    if (!fileName.equals("") && Files.exists(Paths.get(fileName))) {
      Path path = Paths.get(fileName);
      try {
        fileLines = Files.lines(path)
            .collect(Collectors.toList());
      } catch (IOException e) {
        System.out.println("Error: " + e);
        fileLines = Collections.emptyList();
      }
    } else {
      fileLines = Collections.emptyList();
    }
  }

  public List<String> getFileLines() {
    return fileLines;
  }
}
