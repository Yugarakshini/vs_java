import java.io.*;
public class FileOperationsDemo {
    public static void main(String[] args) {
        // File path for the demo file
        String filePath = "demo.txt";
        // Create a new file
        createFile(filePath);
        // Write data to the file
        writeToFile(filePath, "Hello, this is a sample text.\n");
        // Read data from the file
        String data = readFromFile(filePath);
        System.out.println("Content of the file:");
        System.out.println(data);
        // Append more data to the existing file
        appendToFile(filePath, "This is additional data.\n");
        // Read data again after appending
        data = readFromFile(filePath);
        System.out.println("Updated content of the file:");
        System.out.println(data);
    }
    public static void createFile(String filePath) {
        File file = new File(filePath);
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }
    public static void writeToFile(String filePath, String content) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
            System.out.println("Data written to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
    public static String readFromFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file.");
            e.printStackTrace();
        }
        return content.toString();
    }
    public static void appendToFile(String filePath, String content) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(content);
            System.out.println("Data appended to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while appending to the file.");
            e.printStackTrace();
        }
    }
}
