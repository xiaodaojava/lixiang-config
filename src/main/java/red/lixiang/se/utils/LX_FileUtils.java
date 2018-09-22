package red.lixiang.se.utils;

import red.lixiang.se.model.LX_FilePart;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static red.lixiang.se.model.CONST.THREE_KB;

/**
 * @Author lixiang
 * @CreateTime 2018/9/21
 **/
public class LX_FileUtils {
    private static Map<String , Long > fileMap  = new HashMap<>();

    public static void main(String[] args) {
        String filePath  = "/Users/lixiang/soft/WechatIMG283.jpeg";
        List<LX_FilePart> fileParts = splitFile(filePath);

        HttpClient client = HttpClient.newHttpClient();

        for (LX_FilePart filePart : fileParts) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8099/utils/uploadFile"))
                    .header("file-name", filePart.getFileName())
                    .header("total-part", String.valueOf(filePart.getTotalPart()))
                    .header("current-part", String.valueOf(filePart.getCurrentPart()))
                    .header("total-length", String.valueOf(filePart.getTotalLength()))
                    .POST(BodyPublishers.ofByteArray(filePart.getCurrentBytes()))
                    .build();

            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println(filePart.getCurrentPart());
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

        }

    }


    public static List<LX_FilePart> splitFile(String filePath) {
        var filePartList  = new ArrayList<LX_FilePart>();
        var file = new File(filePath);
        var name  = file.getName();
        var totalLength  = file.length();
        var totalPart  = Long.valueOf(totalLength/THREE_KB).intValue();
        if(totalLength%THREE_KB >0){
            totalPart+=1;
        }
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            for (int i = 0; i < totalPart; i++) {
                byte[] bytes = new byte[THREE_KB];
                var read = inputStream.read(bytes);
                LX_FilePart filePart = new LX_FilePart();
                filePart.setCurrentBytes(bytes);
                filePart.setTotalLength(totalLength);
                filePart.setCurrentPart(i);
                filePart.setTotalPart(totalPart);
                filePart.setFileName(name);
                filePartList.add(filePart);
                if(read == -1){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePartList;
    }

    /**
     * String path = "/Users/lixiang/files/_posts";
     *         while (true){
     *             monitorFiles(path);
     *             LX_ThreadUtils.sleep(10L);
     *         }
     * @param path
     */

    public static void monitorFiles(String path) {

        File baseFile = new File(path);
        if (baseFile.isDirectory()) {
            File[] files = baseFile.listFiles();
            for (File file : files) {
                String name  = file.getName();
                Long lastModified = file.lastModified();
                Long aLong = fileMap.get(name);
                if(aLong!=null){
                    if (aLong<lastModified){
                        System.out.println(name+".被修改了");
                        fileMap.put(name,lastModified);
                    }
                }else {
                    fileMap.put(name,lastModified);
                    System.out.println(name+".被新建了");
                }

            }
        }
    }
}
