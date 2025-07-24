import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static  void main(String[] args) {

        Folder folder1 = new Folder("folder 01");
        Folder folder2 = new Folder("folder 02");

        File file1 = new File("file 01");
        File file2 = new File("file 02");

        folder1.add(file1);
        folder2.add(file2);

        folder1.display();



    }



    // Component
    interface FileSystem {
        void display();
    }

    // Leaf
    class File implements FileSystem {
        private String name;
        public File(String name) {
            this.name = name;
        }
        public void display() {
            System.out.println("File: " + name);
        }
    }

    // Composite
    class Folder implements FileSystem {
        private String name;
        private List<FileSystem> children = new ArrayList<>();

        public Folder(String name) {
            this.name = name;
        }

        public void add(FileSystem fs) {
            children.add(fs);
        }

        public void display() {
            System.out.println("Folder: " + name);
            for (FileSystem child : children) {
                child.display();
            }
        }
    }
}

