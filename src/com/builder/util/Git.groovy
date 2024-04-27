#!/usr/bin/env groovy
package com.builder.util

public class Git {

    Git objGit;
    String nameDir;
    String nameFile;
    String nameRepo;
    List<Git> objLista = [];

    //Constructor
    Git(Git objGit) {
        this.objGit.nameDir = objGit.nameDir
        this.objGit.nameFile = objGit.nameFile
        this.objGit.nameRepo = objGit.nameRepo
        this.objGit.objLista = objGit.objLista
    }

    Git(String nameDir, String nameFile, String nameRepo) {
        this.nameDir = nameDir;
        this.nameFile = nameFile;
        this.nameRepo = nameRepo;
    }

    Git() {
    }

    def listarGit(Git git) {
        try {
            def objGit = new Git(nameDir: git.nameDir);
            return objGit.listarGit(git)
        }
        catch (Exception ex) {
            return ex.toString()
        }
    }

}