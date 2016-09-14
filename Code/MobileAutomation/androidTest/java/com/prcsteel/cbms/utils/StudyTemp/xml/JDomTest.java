package com.prcsteel.cbms.utils.StudyTemp.xml;

/**
 * Created by bob on 2015/7/29.
 */

import org.jdom2.Attribute;
import org.jdom2.Comment;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.List;

/**
 * 使用JDom在内存构造xml文档并输出,然后在解析这个文档。
 * 思路：首先构造Document对象，然后将元素都添加到Doucument对象上，最后在将Document对象输出
 *
 * @author bob
 */
public class JDomTest {
    public static void jdomParser() throws Exception {
        Document document = new Document();        //创建根节点

        Element root = new Element("testcases").setAttribute("id", "login");    //创建根元素
        document.addContent(root);    //将根元素添加到根节点

        Element testcase = new Element("testcase").setAttribute("id", "TC001");        //使用方法链方式编程
        root.addContent(testcase);

        Element id = new Element("id").setText("TC001");
        Element username = new Element("username").setText("admin");
        Element password = new Element("password").setText("password");
        Element expect = new Element("expect").setText("用户名或者密码错误！");
        Comment comment = new Comment("setXXX方法一般无返回值，这里使用返回值创建这个对象，然后可以使用方法链方式编写代码更加简洁明了");
        testcase.addContent(comment);
        testcase.addContent(id).addContent(username).addContent(password).addContent(expect);    //addContent()方法返回Element对象，使用方法链方式编程

        //写入到文件
        Format format = Format.getPrettyFormat();
        format.setIndent("    ");    // 设置缩进
        XMLOutputter output = new XMLOutputter(format);
        output.output(document, new FileWriter("jdom.xml"));    //将document输出到文件

        System.out.println("--------------读取xml文件------------------");

        SAXBuilder builder = new SAXBuilder();
        document = builder.build(new File("jdom.xml"));
        Element element = document.getRootElement();
        System.out.println(element.getName());

        testcase = element.getChild("testcase");        //返回指定元素的列表
        System.out.println(testcase.getName());
        System.out.println(testcase.getText());
        System.out.println(testcase.getValue());

        // 获得testcase里面的属性
        List<Attribute> list = (List<Attribute>) testcase.getAttributes();
        for (int i = 0; i < list.size(); i++) {
            Attribute attr = list.get(i);    //将获得的list里面的元素转换成Attribute
            String attrName = attr.getName();
            String attrValue = attr.getValue();
            System.out.println(attrName + "=" + attrValue);
        }

        //删除指定标签元素
        testcase.removeChild("id");

        //输出
        format.getPrettyFormat().setIndent("    ");
        output.output(document, new FileOutputStream("jdom2.xml"));
    }
}
