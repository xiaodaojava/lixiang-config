package red.lixiang.se.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author lixiang
 * @CreateTime 2018/9/21
 **/
public class LX_FileUtils {
    private static Map<String , Long > fileMap  = new HashMap<>();

    public static void main(String[] args) {
        File baseFile = new File("/Users/lixiang/files/_posts");
        if (baseFile.isDirectory()) {
            File[] files = baseFile.listFiles();
            for (File file : files) {
                String name  = file.getName();
                Long lastModified = file.lastModified();
                Long aLong = fileMap.get(name);
                if(aLong!=null){
                    if (aLong<lastModified){
                        System.out.println(name+".被修改了");
                    }
                }else {
                    fileMap.put(name,lastModified);
                    System.out.println(name+".被新建了");
                }

            }
        }
    }
}
