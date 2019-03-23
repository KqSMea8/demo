package com.hexin.common.pdf;

import com.hexin.common.testClass.PDFReport;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.*;
import java.io.FileOutputStream;

/**
 * @ClassName html2PDF
 * @Description TODO
 * @Author shenxiaojie
 * @Date 2019-03-22 16:14
 * @Version 1.0
 */
public class html2PDF {

    public static void main(String[] args) throws Exception {
        new html2PDF().writeCharpter();
    }

    private static Font headfont;// 设置字体大小
    private static Font keyfont;// 设置字体大小
    private static Font textfont;// 设置字体大小

    public void writeCharpter() throws Exception {
        //新建document对象  第一个参数是页面大小。接下来的参数分别是左、右、上和下页边距。
        Document document = new Document(PageSize.A4, 20, 20, 20, 20);
        //建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("/Users/shenxiaojie/Desktop/ITextTest.pdf"));
        //打开文件
        document.open();

        //标题
        document.add(new Paragraph("\nthis is biao ti "));

        document.addTitle("Hello mingri example");
        //作者
        document.addAuthor("wolf");
        //主题
        document.addSubject("This example explains how to add metadata.");
        document.addKeywords("iText, Hello mingri");
        document.addCreator("My program using iText");
        // document.newPage();
        //向文档中添加内容
        document.add(new Paragraph("\n22222222222222222222222222222222222222222222222222222222222222222"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("First page of the document.", keyfont));
        document.add(new Paragraph("First page of the document."));
        document.add(new Paragraph("First page of the document."));
        document.add(new Paragraph("First page of the document."));
        document.add(new Paragraph("Some more text on the first page with different color and font type.",
                FontFactory.getFont(FontFactory.defaultEncoding, 10, Font.BOLD, new Color(0, 0, 0))));

        Paragraph title1 = new Paragraph("Chapter 1",
                FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC, new Color(0, 0, 255)));
        //新建章节
        Chapter chapter1 = new Chapter(title1, 1);
        chapter1.setNumberDepth(0);
        Paragraph title11 = new Paragraph("This is Section 1 in Chapter 1",
                FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, new Color(255, 0, 0)));
        Section section1 = chapter1.addSection(title11);
        Paragraph someSectionText = new Paragraph("This text comes as part of section 1 of chapter 1.");
        section1.add(someSectionText);
        someSectionText = new Paragraph("Following is a 3 X 2 table.");
        section1.add(someSectionText);
        document.add(chapter1);
        //关闭文档
        document.close();
    }

}
