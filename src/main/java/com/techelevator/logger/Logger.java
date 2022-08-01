package com.techelevator.logger;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private File auditFile;
    private PrintWriter writer;

    public Logger(String pathName){
        this.auditFile = new File(pathName);
        if (!auditFile.exists()){
            try {
                this.writer = new PrintWriter(this.auditFile);
            } catch (FileNotFoundException e){
                System.out.println("FILE NOT FOUND");
            }
        } else {
            try {
                this.writer = new PrintWriter(new FileWriter(this.auditFile, true));
            } catch (IOException ie){
                System.out.println("ERROR FILE NOW WRITTEN");
            }
        }
    }

    public void write(String logMessage){
        this.writer.println(logMessage);
        this.writer.flush();
        this.writer.close();
    }


}
