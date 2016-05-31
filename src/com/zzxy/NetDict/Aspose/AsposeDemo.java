package com.zzxy.NetDict.Aspose;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;

/**
 * 
 * 由于ASPOSE比较吃内存，操作大一点的文件就会堆溢出，所以请先设置好java虚拟机参数：-Xms512m -Xmx512m(参考值)<br>
 * 如有疑问，请在CSDN下载界面留言,或者联系QQ569925980<br>
 * 
 * @author Spark
 *
 */
public class AsposeDemo {

    /**
     * 获取license
     * 
     * @return
     */
    public static boolean getLicense() {
        boolean result = false;
        try {
            InputStream is = AsposeDemo.class.getClassLoader().getResourceAsStream("license.xml");
            License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 支持DOC, DOCX, OOXML, RTF, HTML, OpenDocument, PDF, EPUB, XPS, SWF等相互转换<br>
     * 
     * @param args
     */
    public static void main(String[] args) {
        // 验证License
        if (!getLicense()) {
            return;
        }

        try {
            long old = System.currentTimeMillis();
            
            Document doc = new Document("/Users/Magic_Zhang/Desktop/lunwen.doc");// 原始word路径
            File pdfFile = new File("/Users/Magic_Zhang/Desktop/lunwen.pdf");// 输出路径
            FileOutputStream fileOS = new FileOutputStream(pdfFile);

            doc.save(fileOS, SaveFormat.PDF);

            long now = System.currentTimeMillis();
            System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}