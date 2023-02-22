package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

public class ReadFile {

    URL path = this.getClass().getClassLoader().getResource("/src/sample/employees.json");

    public static String read() {
        String data = "";
        try {
            String workingDir = System.getProperty("user.dir");
            String pathToFile = workingDir + "/src/sample/employees.json";
            File myObj = new File(pathToFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = data + "\n" + myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;
    }
}