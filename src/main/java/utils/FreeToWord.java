package utils;

/**
 * Created by lixiang on 27/04/2017.
 */

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.WriterException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;

public class FreeToWord {
    private static Configuration configuration = null;
    private static Map<String, Template> allTemplates = null;

    static {
        configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
        configuration.setClassForTemplateLoading(FreeToWord.class, "/ftl");
        allTemplates = new HashMap<>();
        try {
            allTemplates.put("tag", configuration.getTemplate("tag.ftl"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private FreeToWord() {
        throw new AssertionError();
    }

    public static File createDoc(Map<String, String> dataMap, String type) {

        String name = "temp" + (int) (Math.random() * 100000) + ".doc";
        File f = new File(name);
        Template t = allTemplates.get(type);
        try {
            BufferedImage image = GenerateQrcode.createQRCode(dataMap.get("scanUrl"));

            ByteArrayOutputStream bout = new ByteArrayOutputStream();

            BASE64Encoder encoder = new BASE64Encoder();
            ImageIO.write(image, "png", bout);
            byte[] data = bout.toByteArray();
            String qrdata = encoder.encode(data);
            dataMap.put("qrimage",qrdata);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            // 这个地方不能使用FileWriter因为需要指定编码类型否则生成的Word文档会因为有无法识别的编码而无法打开
            Writer w = new OutputStreamWriter(new FileOutputStream(f), "utf-8");
            t.process(dataMap, w);
            w.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return f;
    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("sysNo","999");
        map.put("price","98");
        map.put("color","999");
        map.put("size","29");
        String scanUrl = "http://m.admin.bbgkh.shop/scanSale?price=98";


        FreeToWord.createDoc(map,"tag");
    }

}
