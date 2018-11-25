package StudentForm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Utils {

    public static void writeToFile(String fileName, List<Student> students) throws Exception {
        File dstFile = new File(fileName + ".txt");

        try {
            if (dstFile.exists() == false) {
                System.out.println("We had to make a new file");
                dstFile.createNewFile();
            }

            PrintWriter output = new PrintWriter(new FileWriter(dstFile, true));

            for (Student s : students) {
                output.append(s.getName() + ", " + s.getEmail() + ", " + s.getAge() + ", " + s.getGender() + ", " + s.getHobby() + ", " + s.getRound() + ", " + s.getNote() + "\n");
            }
            output.close();
        } catch (IOException ex) {
            System.out.println("Could not log!");
        }
    }

    public static void displayStudentsDataFromFile(String filename, DefaultTableModel model) {
        String line;
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(filename + ".txt"));
            while ((line = reader.readLine()) != null) {
                model.addRow(line.split(", "));
            }

            reader.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Buffered reader issue!");
        }
    }
}