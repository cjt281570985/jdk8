import java.io.File;
import java.util.regex.Pattern;

/**
 * 工具6个对外方法，全部增加 isTest 参数
 * isTest = true：预览模式，只打印日志，不真实修改/删除
 * isTest = false：真实执行操作
 *
 * 1. renameMp4File          mp4文件名移除指定字符串重命名
 * 2. deleteDotStartMp4File  删除以.开头的mp4文件
 * 3. deleteFileByPrefixArray删除文件名前缀匹配数组的文件
 * 4. deleteDirByName        删除指定名称文件夹
 * 5. replaceFileNameStr     文件名A字符串替换B
 * 6. removeFileNameByRegex 正则删除文件名匹配片段
 */
public class Mp4RenameUtil2 {

    /**
     * 1. mp4文件名删除指定字符串重命名
     * @param rootDirPath 主目录
     * @param deleteStr 需要删除的字符串
     * @param isTest true=预览，false=真实执行
     */
    public static void renameMp4File(String rootDirPath, String deleteStr, boolean isTest) {
        if (deleteStr == null || deleteStr.isEmpty()) {
            System.err.println("待删除字符串不能为空");
            return;
        }
        File rootDir = new File(rootDirPath);
        if (!rootDir.exists() || !rootDir.isDirectory()) {
            System.err.println("目录不存在：" + rootDirPath);
            return;
        }
        walkDirRename(rootDir, deleteStr, isTest);
    }

    private static void walkDirRename(File currentDir, String deleteStr, boolean isTest) {
        File[] files = currentDir.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                walkDirRename(file, deleteStr, isTest);
            } else {
                String fileName = file.getName();
                if (fileName.toLowerCase().endsWith(".mp4")) {
                    processMp4File(file, deleteStr, isTest);
                }
            }
        }
    }

    private static void processMp4File(File file, String deleteStr, boolean isTest) {
        String oldFileName = file.getName();
        if (!oldFileName.contains(deleteStr)) {
            return;
        }

        String newFileName = oldFileName.replace(deleteStr, "");
        if (newFileName.equals(oldFileName)) {
            return;
        }

        File newFile = new File(file.getParent(), newFileName);
        if (newFile.exists()) {
            System.out.printf("【跳过】目标文件已存在：%s%n", newFile.getAbsolutePath());
            return;
        }

        if (isTest) {
            System.out.printf("[TEST预览] 将要重命名：%s → %s%n", oldFileName, newFileName);
            return;
        }
        boolean renameSuccess = file.renameTo(newFile);
        if (renameSuccess) {
            System.out.printf("【成功重命名】%s → %s%n", oldFileName, newFileName);
        } else {
            System.err.printf("【重命名失败】%s%n", file.getAbsolutePath());
        }
    }


    /**
     * 2. 删除以`.`开头后缀mp4文件
     * @param rootDirPath 主目录
     * @param isTest true=预览，false=真实执行
     */
    public static void deleteDotStartMp4File(String rootDirPath, boolean isTest) {
        File rootDir = new File(rootDirPath);
        if (!rootDir.exists() || !rootDir.isDirectory()) {
            System.err.println("目录不存在：" + rootDirPath);
            return;
        }
        walkDirDeleteDotMp4(rootDir, isTest);
    }

    private static void walkDirDeleteDotMp4(File currentDir, boolean isTest) {
        File[] files = currentDir.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                walkDirDeleteDotMp4(file, isTest);
            } else {
                String fileName = file.getName();
                boolean startWithDot = fileName.startsWith(".");
                boolean isMp4 = fileName.toLowerCase().endsWith(".mp4");

                if (startWithDot && isMp4) {
                    if (isTest) {
                        System.out.printf("[TEST预览] 将要删除文件：%s%n", file.getAbsolutePath());
                        return;
                    }
                    boolean deleteOk = file.delete();
                    if (deleteOk) {
                        System.out.printf("【已删除】%s%n", file.getAbsolutePath());
                    } else {
                        System.err.printf("【删除失败】%s，文件可能被占用/权限不足%n", file.getAbsolutePath());
                    }
                }
            }
        }
    }


    /**
     * 3. 删除文件名前缀匹配数组的文件
     * @param rootDirPath 主目录
     * @param prefixArr 前缀数组
     * @param isTest true=预览，false=真实执行
     */
    public static void deleteFileByPrefixArray(String rootDirPath, String[] prefixArr, boolean isTest) {
        File rootDir = new File(rootDirPath);
        if (!rootDir.exists() || !rootDir.isDirectory()) {
            System.err.println("目录不存在：" + rootDirPath);
            return;
        }
        if (prefixArr == null || prefixArr.length == 0) {
            System.err.println("前缀数组不能为空");
            return;
        }
        walkDirDeleteByPrefix(rootDir, prefixArr, isTest);
    }

    private static void walkDirDeleteByPrefix(File currentDir, String[] prefixArr, boolean isTest) {
        File[] files = currentDir.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                walkDirDeleteByPrefix(file, prefixArr, isTest);
            } else {
                String fileName = file.getName();
                boolean match = false;
                for (String prefix : prefixArr) {
                    if (prefix == null || prefix.isEmpty()) {
                        continue;
                    }
                    if (fileName.startsWith(prefix)) {
                        match = true;
                        break;
                    }
                }
                if (match) {
                    if (isTest) {
                        System.out.printf("[TEST预览] 将要删除文件：%s%n", file.getAbsolutePath());
                        return;
                    }
                    boolean deleteOk = file.delete();
                    if (deleteOk) {
                        System.out.printf("【前缀匹配已删除】%s%n", file.getAbsolutePath());
                    } else {
                        System.err.printf("【前缀匹配删除失败】%s，文件被占用/权限不足%n", file.getAbsolutePath());
                    }
                }
            }
        }
    }


    /**
     * 4. 删除指定名字文件夹
     * @param rootDirPath 主目录
     * @param targetDirName 待删除文件夹名称
     * @param isTest true=预览，false=真实执行
     */
    public static void deleteDirByName(String rootDirPath, String targetDirName, boolean isTest) {
        File rootDir = new File(rootDirPath);
        if (!rootDir.exists() || !rootDir.isDirectory()) {
            System.err.println("目录不存在：" + rootDirPath);
            return;
        }
        if (targetDirName == null || targetDirName.isEmpty()) {
            System.err.println("待删除文件夹名称不能为空");
            return;
        }
        walkDirDeleteTargetDir(rootDir, targetDirName, isTest);
    }
    /**
     * 递归遍历，查找并删除目标文件夹
     */
    private static void walkDirDeleteTargetDir(File currentDir, String targetDirName, boolean isTest) {
        File[] files = currentDir.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                // 如果文件夹名字等于目标名称，则删除整个文件夹
                if (targetDirName.equals(file.getName())) {
                    if (isTest) {
                        System.out.printf("[TEST预览] 将要删除整个文件夹：%s%n", file.getAbsolutePath());
                        continue;
                    }
                    boolean success = deleteDirectory(file);
                    if (success) {
                        System.out.printf("【删除文件夹成功】%s%n", file.getAbsolutePath());
                    } else {
                        System.err.printf("【删除文件夹失败】%s，文件被占用或权限不足%n", file.getAbsolutePath());
                    }
                    // 删除完成，不再递归进入这个文件夹内部
                    continue;
                }
                // 不是目标文件夹，继续递归子目录
                walkDirDeleteTargetDir(file, targetDirName, isTest);
            }
        }
    }

    /**
     * 真实删除文件夹内部所有内容，预览模式不会进入
     */
    private static boolean deleteDirectory(File dir) {
        if (!dir.exists()) {
            return true;
        }
        File[] files = dir.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    deleteDirectory(f);
                } else {
                    f.delete();
                }
            }
        }
        return dir.delete();
    }


    /**
     * 5.文件名字符串A替换B
     * @param rootDirPath 主目录
     * @param strA 待替换
     * @param strB 替换为
     * @param isTest true=预览，false=真实执行
     */
    public static void replaceFileNameStr(String rootDirPath, String strA, String strB, boolean isTest) {
        File rootDir = new File(rootDirPath);
        if (!rootDir.exists() || !rootDir.isDirectory()) {
            System.err.println("目录不存在：" + rootDirPath);
            return;
        }
        if (strA == null || strA.isEmpty()) {
            System.err.println("待替换字符串A不能为空");
            return;
        }
        walkDirReplaceFileName(rootDir, strA, strB, isTest);
    }

    private static void walkDirReplaceFileName(File currentDir, String strA, String strB, boolean isTest) {
        File[] files = currentDir.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                // 递归子目录，文件夹名字不做任何修改
                walkDirReplaceFileName(file, strA, strB, isTest);
            } else {
                String oldFileName = file.getName();
                // 递归子目录，文件夹名字不做任何修改
                if (!oldFileName.contains(strA)) {
                    continue;
                }
                // 全部替换A为B
                String newFileName = oldFileName.replace(strA, strB);
                // 替换后名字没变则跳过
                if (newFileName.equals(oldFileName)) {
                    continue;
                }
                File newFile = new File(file.getParent(), newFileName);
                // 判断目标文件是否已存在，防止覆盖
                if (newFile.exists()) {
                    System.out.printf("【跳过重命名】目标文件已存在：%s%n", newFile.getAbsolutePath());
                    continue;
                }
                if (isTest) {
                    System.out.printf("[TEST预览] 将要重命名：%s → %s%n", oldFileName, newFileName);
                    continue;
                }
                boolean renameOk = file.renameTo(newFile);
                if (renameOk) {
                    System.out.printf("【文件名替换成功】%s → %s%n", oldFileName, newFileName);
                } else {
                    System.err.printf("【文件名替换失败】%s，文件被占用/权限不足%n", file.getAbsolutePath());
                }
            }
        }
    }


    /**
     * 6.正则删除文件名匹配片段
     * @param rootDirPath 主目录
     * @param regex 正则表达式字符串，匹配到的片段会被删除（替换为空）
     * @param isTest true=预览，false=真实执行
     */
    public static void removeFileNameByRegex(String rootDirPath, String regex, boolean isTest) {
        File rootDir = new File(rootDirPath);
        if (!rootDir.exists() || !rootDir.isDirectory()) {
            System.err.println("目录不存在：" + rootDirPath);
            return;
        }
        if (regex == null || regex.isEmpty()) {
            System.err.println("正则表达式不能为空");
            return;
        }
        Pattern pattern;
        try {
            pattern = Pattern.compile(regex);
        } catch (Exception e) {
            System.err.println("正则表达式语法错误：" + e.getMessage());
            return;
        }
        walkDirRemoveByRegex(rootDir, pattern, isTest);
    }

    private static void walkDirRemoveByRegex(File currentDir, Pattern pattern, boolean isTest) {
        File[] files = currentDir.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                // 文件夹继续递归遍历，文件夹名字不处理
                walkDirRemoveByRegex(file, pattern, isTest);
            } else {
                String oldFileName = file.getName();
                // 将正则匹配到的片段替换为空，也就是删除匹配部分
                String newFileName = pattern.matcher(oldFileName).replaceAll("");

                // 如果替换前后文件名没变，说明没有匹配到，直接跳过
                if (newFileName.equals(oldFileName)) {
                    continue;
                }

                File newFile = new File(file.getParent(), newFileName);
                // 新文件名已存在，跳过，防止覆盖
                if (newFile.exists()) {
                    System.out.printf("【跳过】重命名目标已存在：%s%n", newFile.getAbsolutePath());
                    continue;
                }

                if (isTest) {
                    System.out.printf("[TEST预览] 将要重命名：%s → %s%n", oldFileName, newFileName);
                    continue;
                }

                boolean renameOk = file.renameTo(newFile);
                if (renameOk) {
                    System.out.printf("【正则删除片段成功】%s → %s%n", oldFileName, newFileName);
                } else {
                    System.err.printf("【正则重命名失败】%s，文件被占用/权限不足%n", file.getAbsolutePath());
                }
            }
        }
    }


    // ========== 测试main方法 ==========
    public static void main(String[] args) {
        String rootPath = "G:\\琼\\001教材相关\\电子书\\人教版•小学数学【电子课本】";
        boolean isTest = true; // true预览模式，false真实执行

        // 1.mp4重命名
        // renameMp4File(rootPath, "_2026", isTest);

        // 2.删除点开头mp4
        // deleteDotStartMp4File(rootPath, isTest);

        //3.前缀数组删除
        // String[] deletePrefixArr = {"temp", "cache", "tmp"};
        // deleteFileByPrefixArray(rootPath, deletePrefixArr, isTest);
        isTest = false;
        //4.删除文件夹"广告"
        // deleteDirByName(rootPath, "广告", isTest);

        //5.字符串替换
         replaceFileNameStr(rootPath, "数学课本•", "数学", isTest);

        //6.正则删除片段
        //removeFileNameByRegex(rootPath, "我的人", isTest);
    }
}
