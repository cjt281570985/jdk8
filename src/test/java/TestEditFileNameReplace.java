import java.io.File;

public class TestEditFileNameReplace {

    public static void main(String[] args) {
        //查找win文件
        File file = new File("I:\\01.study\\it架构师\\马士兵MCA架构师2025\\26-P7_面试突击\\4-金九银十大厂面试题全解 - 副本");
        //String newPath = "D:\\study\\李兴华Oracle";
        String delStr = "【更多资源微信x923713】";
        editName(file, delStr, file.getAbsolutePath());

        String addName = "chenjt";
        // addFileName(file, ".avi", addName, newPath);
    }

    private static void editName(File file, String delStr, String newPath) {
        String name = file.getName();
        if (name.indexOf(delStr) != -1) {
            //String newName = name.substring(regex.length());//截取_后面的String
            String newName = name.replace(delStr, "");
            file.renameTo(new File(newPath + "\\" + newName));
        }
        //检查子目录
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                editName(child, delStr, newPath);
            }
        }
    }

    private static void addFileName(File file, String regex, String addName, String path) {
        String name = file.getName();
        if (name.endsWith(regex)) {
            file.renameTo(new File(path + "\\" + addName + name));
        }
        //检查子目录
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                addFileName(child, regex, addName, path);
            }
        }
    }
}
