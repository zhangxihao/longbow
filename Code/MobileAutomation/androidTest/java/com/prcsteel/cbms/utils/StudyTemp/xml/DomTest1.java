package com.prcsteel.cbms.utils.StudyTemp.xml;

import org.w3c.dom.Attr;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by bob on 2015/7/25.
 * 使用递归解析任意xml文档
 */
public class DomTest1 {

    public static void paserAnyXml() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(new File("login.xml"));    //获得文档根节点

            Element root = document.getDocumentElement();    //获得文档根元素

            String xmlVersion = document.getXmlVersion();
            String xmlEncoding = document.getXmlEncoding();
            Boolean xmlStandalone = document.getXmlStandalone();
            System.out.println("<?version=\"" + xmlVersion + "\" encoding=\"" + xmlEncoding + "\" standalone=\"" + xmlStandalone + "\"" + "?>");
            parseElement(root);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void parseElement(Element element) {
        String tagName = element.getNodeName();

        NodeList children = element.getChildNodes();    //获得所有根元素下的子元素

        System.out.print("<" + tagName);

        NamedNodeMap map = (NamedNodeMap) element.getAttributes();        //获得element的所有属性，需要对其进行判断
        //如果存在属性
        if (null != map) {
            for (int i = 0; i < map.getLength(); i++) {
                Attr attr = (Attr) map.item(i);        //获得元素的每个属性

                String attrName = attr.getNodeName();
                String attrValue = attr.getNodeValue();

                System.out.print(" " + attrName + "=" + "\"" + attrValue + "\"");
            }
        }
        System.out.print(">");        //处理根元素

        //遍历所有子元素
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            // 获得节点的类型
            short nodeType = node.getNodeType();

            if (nodeType == Node.ELEMENT_NODE) {
                parseElement((Element) node);    //是元素继续递归
            } else if (nodeType == Node.TEXT_NODE) {
                System.out.print(node.getNodeValue());    //递归出口
            } else if (nodeType == Node.COMMENT_NODE) {
                System.out.print("<!--");

                Comment comment = (Comment) node;
                System.out.print(comment.getData());    //打印注释内容

                System.out.print("-->");
            }
        }
        System.out.print("</" + tagName + ">");
    }

}
