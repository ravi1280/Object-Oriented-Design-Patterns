import java.util.ArrayList;
import java.util.List;

interface FileComponent {
    void showDetails(String intend);
}

class Files implements FileComponent {

    private String name;
    
    public Files(String name) {
        this.name = name;
    }
    @Override
    public void showDetails(String intend) {
        System.out.println(intend+"|-File : "+name);

    }
}
class Folders implements FileComponent {
    private String name;
    private List<FileComponent> childs = new ArrayList<>();

    public Folders(String name) {
        this.name = name;
    }
    public void add(FileComponent component) {
        childs.add(component);
    }

    public void remove(FileComponent component) {
        childs.remove(component);
    }

    @Override
    public void showDetails(String intend) {
        System.out.println(intend+"|-Folder : "+name);
        for (FileComponent component : childs) {
            component.showDetails(intend+" ");
        }
    }
}

public class composite {
    public static void main(String[] args) {
        FileComponent file1 = new Files("Resume.pdf");
        FileComponent file2 = new Files("Test.txt");
        FileComponent files3= new Files("Image.jpg");

        Folders folder2 = new Folders("Documents");
        folder2.add(file1);
        folder2.add(file2);

        Folders folder3 = new Folders("Images");
        folder3.add(files3);

        Folders root = new Folders("Root");
        root.add(folder3);
        root.add(folder2);
        root.showDetails("");
    }

}
