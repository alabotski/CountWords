package com.countwords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileService {

  public List<String> readFile(String fileName) {
    if (!fileName.equals("") && Files.exists(Paths.get(fileName))) {
      System.out.println("File exists");

      Path path = Paths.get(fileName);
      try {
        return Files.lines(path)
            .collect(Collectors.toList());
      } catch (IOException e) {
        System.out.println("Error: " + e);
        return Collections.emptyList();
      }
    } else {
      return Collections.emptyList();
    }
  }
}
