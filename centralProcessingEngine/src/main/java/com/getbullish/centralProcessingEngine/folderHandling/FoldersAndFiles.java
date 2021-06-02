package com.getbullish.centralProcessingEngine.folderHandling;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class FoldersAndFiles {



  public List<String> getlistofAllfilesInFolder(String directory) {

    String[] pathnames;
    File f = new File(directory);
    pathnames = f.list();
    List<String> list = new ArrayList<String>();
    list.addAll(Arrays.asList(pathnames));
    return list;

  }

  public List<String> getlistofAllfilesInFolderAsDirectories(String directory) {


    List<String> list = getlistofAllfilesInFolder(directory);
    List<String> directories = new ArrayList<String>();
    for (String str : list) {
      directories.add(directory + str);
    }
    return directories;

  }


  public List<String> getlistoffilesInFolderAsDirectoriesWithAextention(String directory,
      String extension) {

    List<String> list = getlistofAllfilesInFolder(directory);
    List<String> directories = new ArrayList<String>();
    for (String str : list) {
      if (str.endsWith(extension))
        directories.add(directory + str);
    }
    return directories;

  }


  public Map<String, String> getlistofAllfilesInFolderAsDirectoriesWithName(String directory) {


    List<String> list = getlistofAllfilesInFolder(directory);

    Map<String, String> nameAndDir = new HashMap<String, String>();
    for (String str : list) {
      nameAndDir.put(str, directory + str);

    }
    return nameAndDir;

  }



}
