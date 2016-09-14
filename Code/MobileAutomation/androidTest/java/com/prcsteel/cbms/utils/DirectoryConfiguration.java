package com.prcsteel.cbms.utils;

import android.os.Environment;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by bob on 2015/7/27.
 * 配置测试目录.这里直接内存构建,后期改成直接读取配置文件
 */
public class DirectoryConfiguration {

    public static void directoryConfig(){
        //创建xml文件testdirs.xml
        Document document = new Document();
        Element root = new Element("testdirs");
        document.addContent(root);

        Element testdir = new Element("testdir").setAttribute("id", "测试根目录");
        root.addContent(testdir);

        Element testauto = new Element("testauto").setText("testauto");
        testdir.addContent(testauto);


        XMLOutputter outputter = new XMLOutputter(org.jdom2.output.Format.getPrettyFormat().setIndent("    "));

        try {
            outputter.output(document,new FileOutputStream(createDirTestauto()+ File.separator + "testdirs.xml"));   // 输出到sdcard/testauto/
        } catch (IOException e) {
            e.printStackTrace();
        }

        //创建testDatabase目录
        createDirTestDatabase();

        //创建log目录
        createDirTestLog();

    }

    //sdcard 目录
    public static File getSdcardDirectory(){
        File sdcardDir = Environment.getExternalStorageDirectory();
        return sdcardDir;
    }

    //创建/mnt/sdcard/testauto目录创建
    public static File createDirTestauto(){
        File sdcardDir = getSdcardDirectory();
        File testauto = new File(sdcardDir + File.separator + "testauto");
        if(!testauto.exists()){
            testauto.mkdirs();
        }
        return testauto;
    }

    //创建目录:/mnt/sdcard/testauto/database
    public static File createDirTestDatabase(){
        File sdcardDir = getSdcardDirectory();
        File testDatabase = new File(sdcardDir + File.separator + "testauto/database");
        if(!testDatabase.exists()){
            testDatabase.mkdirs();
        }
        return testDatabase;
    }

    //创建目录:/mnt/sdcard/testauto/log
    public static File createDirTestLog(){
        File sdcardDir = getSdcardDirectory();
        File testLog = new File(sdcardDir + File.separator + "testauto/log");
        if(!testLog.exists()){
            testLog.mkdirs();
        }
        return testLog;
    }

}
