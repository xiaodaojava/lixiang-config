package utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import java.io.*;
import java.math.BigInteger;

/**
 * Created by lixiang on 02/04/2017.
 */
public class GenerateDoc {
    public static void createDoc(String sysNo , String price , String color , String size) {
        XWPFDocument doc = new XWPFDocument();
        CTDocument1 document = doc.getDocument();
        CTBody body = document.getBody();

        if (!body.isSetSectPr()) {
            body.addNewSectPr();
        }
        CTSectPr section = body.getSectPr();

        if(!section.isSetPgSz()) {
            section.addNewPgSz();
        }
        //设置页面大小
        CTPageSz pageSize = section.getPgSz();
        pageSize.setW(BigInteger.valueOf(3231));
        pageSize.setH(BigInteger.valueOf(1984));

        if(!section.isSetPgMar()){
            section.addNewPgMar();
        }
        CTPageMar pageMar = section.getPgMar();
        pageMar.setBottom(BigInteger.ZERO);
        pageMar.setLeft(BigInteger.ZERO);
        pageMar.setRight(BigInteger.ZERO);
        pageMar.setTop(BigInteger.ZERO);


        //创建一个新的文档
        XWPFParagraph p1 = doc.createParagraph();
        //设置文档居中
        p1.setAlignment(ParagraphAlignment.CENTER);
        //设置四边的边界
        p1.setBorderBottom(Borders.NONE);
        p1.setBorderTop(Borders.NONE);

        p1.setBorderRight(Borders.NONE);
        p1.setBorderLeft(Borders.NONE);

        p1.setBorderBetween(Borders.NONE);
        //设置垂直的居中程度
        p1.setVerticalAlignment(TextAlignment.TOP);

        //定义一些属性
        XWPFRun r1 = p1.createRun();
        //设置为粗体
        r1.setBold(true);
        //设置文字
        r1.setText("步步高裤行欢迎您");

        //r1.setBold(true);
        //设置字体
        r1.setFontFamily("Courier");
        //设置下划线
        r1.setFontSize(9);

        //下面的货号，颜色，价格等用一个新的段落格式
        XWPFParagraph p2 = doc.createParagraph();
        p2.setIndentationLeft(1200);
        XWPFRun r2 =p2.createRun();
        r2.setText("货号："+sysNo);
        r2.setFontSize(8);
        r2.addCarriageReturn();
        r2.setText("尺码："+size);
        r2.addCarriageReturn();
        r2.setText("颜色："+color);
        r2.addCarriageReturn();
        r2.setText("价格："+price);




        //插入二维码图片以及引导语
        int format = XWPFDocument.PICTURE_TYPE_JPEG;
        XWPFParagraph imagep= doc.createParagraph();

        XWPFRun guideRun = imagep.createRun();
        guideRun.setFontSize(6);
        guideRun.setText("扫码关注我们微信公共号");

        guideRun.setText("可获得更多优惠哦~");
        XWPFRun imagepRun = imagep.createRun();
        imagepRun.setTextPosition(-20);
        InputStream inputStream = GenerateImage.class.getResourceAsStream("/wxbbgkh.jpg");
        try {
            imagepRun.addPicture(inputStream, format, "bbgkh.jpg", Units.toEMU(40), Units.toEMU(40)); // 200x200 pixels
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try{
            FileOutputStream out = new FileOutputStream("simple.docx");
            doc.write(out);
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
