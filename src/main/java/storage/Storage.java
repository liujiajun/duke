package storage;

import commons.DukeException;
import task.Task;

import java.util.*;
import java.io.*;

public class Storage {

    private String path;

    public Storage(String path) {
        this.path = path;
    }

    public void serialize(ArrayList<Task> tasks) throws DukeException{
        try {
            FileOutputStream fileOut =
                    new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(tasks);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            throw new DukeException("IO Exception");
        }
    }

    public ArrayList<Task> deserialize() throws DukeException{
        ArrayList<Task> tasks= null;
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            tasks = (ArrayList<Task>) in.readObject();
            in.close();
            fileIn.close();
            return tasks;
        } catch (ClassNotFoundException c) {
            throw new DukeException("File is damaged");
        } catch (IOException i) {
            if (i instanceof FileNotFoundException) { return new ArrayList<Task>(); }
            else { throw new DukeException("IO Exception"); }
        }
    }

    public void save(ArrayList<Task> tasks) throws DukeException{
        File f = new File(path);
        try {
            FileWriter fileWriter = new FileWriter(f);
            String line;
            for (Task t : tasks) {
                line = t.toString();
                fileWriter.write(line + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new DukeException("Error saving file");
        }
    }

//    public ArrayList<Task> load() throws DukeException{
//        ArrayList<Task> tasks= new ArrayList<>();
//        File f = new File(path);
//        try {
//            Scanner s= new Scanner(f);
//            while (s.hasNextLine()) {
//                String line = s.nextLine();
//
//            }
//        } catch (FileNotFoundException e) {
//            throw new DukeException("File not found");
//        }
//
//    }

    private ArrayList<String> getLines(String filePath) throws FileNotFoundException {
        File f = new File(filePath);
        Scanner s = new Scanner(f);
        ArrayList<String> lines = new ArrayList<>();
        while (s.hasNext()) {
            lines.add(s.nextLine());
        }
        return lines;
    }
}
