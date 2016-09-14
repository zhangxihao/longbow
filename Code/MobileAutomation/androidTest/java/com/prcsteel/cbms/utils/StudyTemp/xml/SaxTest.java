package com.prcsteel.cbms.utils.StudyTemp.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.util.Stack;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by bob on 2015/7/29.
 */
public class SaxTest {
    public static void saxParser() throws Exception {
        // step1: 获得Sax解析工厂实例
        SAXParserFactory factory = SAXParserFactory.newInstance();
        // step2: 获得SAX解析器实例
        SAXParser parser = factory.newSAXParser();
        // step3:开始解析
        parser.parse(new File("login.xml"), new Myhandler());
    }
}

class Myhandler extends DefaultHandler {

    // 先将解析的东西全部保存到一个容器里
    private Stack<String> stack = new Stack<String>();
    private String id;
    private String username;
    private String password;
    private String expect;

    //qName：标签名
    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        stack.push(qName);	//解析元素开始的时候将元素标签名压栈

        // 处理属性
        for(int i = 0; i < attributes.getLength(); i++){
            String attrName = attributes.getQName(i);
            String attrValue = attributes.getValue(i);
            System.out.print(qName + " ");
            System.out.println(attrName + "=" + attrValue);
        }
    }

    // 获得元素中的内容
    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {

        String tag = stack.peek();		//将标签里面的值取出来

        if("id".equals(tag)){
            id = new String(ch, start, length);
        }else if("username".equals(tag)){
            username = new String(ch, start, length);
        }else if("password".equals(tag)){
            password = new String(ch, start, length);
        }else if("expect".equals(tag)){
            expect = new String(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        stack.pop();		//遇到元素结尾将元素弹出,表示该元素已经解析完毕，需要重栈中弹出

        if("testcase".equals(qName)){	//当遇到testcase结束标签时打印里面元素内容
            System.out.println("id: " + id);
            System.out.println("username: " + username);
            System.out.println("password: " + password);
            System.out.println("expect: " + expect);
        }
    }
}