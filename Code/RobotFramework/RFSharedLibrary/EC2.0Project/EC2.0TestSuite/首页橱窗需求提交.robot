*** Settings ***
Resource          ../../SharedLibrary/Action/Selenium.txt
Resource          ../../SharedLibrary/Action/BuilIn.txt
Resource          ../../SharedLibrary/Action/AutoIt.txt
Resource          ../../SharedLibrary/Assert/Assert.txt
Resource          ../EC2.0Flow/Flow_EC2.0.txt
Resource          ../ProjectResource_2.0.txt
Resource          ../EC2.0Flow/FlowNormal_EC2.0.txt

*** Test Cases ***
回执需求-通过电话聊需求
    [Setup]    Run Keywords    流程登录正常
    流程需求-通过电话聊需求    xpath=//*[@id="mmain"]//div[@class="menuul"]//li[text()="我想我们还是通过电话聊吧"]
    关闭当前浏览器

回执需求-发送采购单空需求
    [Setup]    Run Keywords    流程登录正常
    流程需求-发送采购单-空需求    xpath=//*[@id="mmain"]//div[@class="menuul"]//li[text()="我想发送采购单的文件"]
    超市首页-发送需求-点击提交
    ${Temp}    获取元素文本    xpath=//*[@id="banner03"]//ul[@id="telCheckLogin"]//span[text()="需求提交太频繁"]
    Run Keyword If    '${Temp}' != '需求提交太频繁'    测试失败
    关闭当前浏览器

文字需求-发送采购单文字需求
    [Setup]    Run Keywords    流程登录正常
    流程需求-发送采购单-文字需求    xpath=//*[@id="mmain"]//div[@class="menuul"]//li[text()="我想发送采购单的文件"]    要求要求
    关闭当前浏览器

文件需求-发送采购单文件需求
    [Setup]    Run Keywords    流程登录正常
    流程需求-发送采购单-文件需求    xpath=//*[@id="mmain"]//div[@class="menuul"]//li[text()="我想发送采购单的文件"]    ${testFiles.NormalPic}
    关闭当前浏览器

文件需求-发送不符要求文件
    [Setup]    Run Keywords    流程登录正常
    超市首页-点击我想发送采购单    xpath=//*[@id="mmain"]//div[@class="menuul"]//li[text()="我想发送采购单的文件"]
    超市首页-点击我想发送采购单-上传文件（中间+）    ${testFiles.OverLarge}
    ${Temp}    获取元素文本    xpath=//*[@id="banner03"]//div[@class="markbtn"]//span[text()="文件超过2M"]
    Run Keyword If    '${Temp}' != '文件超过2M'    测试失败
    超市首页-点击我想发送采购单-上传文件（中间+）    ${testFiles.AbnormalFormat}
    ${Temp}    获取元素文本    xpath=//*[@id="banner03"]//div[@class="markbtn"]//span[text()="文件格式有误"]
    Run Keyword If    '${Temp}' != '文件格式有误'    测试失败
    超市首页-点击我想发送采购单-上传文件（中间+）    ${testFiles.IllegalFormat}
    ${Temp}    获取元素文本    xpath=//*[@id="banner03"]//div[@class="upload_btn"]//span[text()="非法上传文件"]
    Run Keyword If    '${Temp}' != '非法上传文件'    测试失败
    关闭当前浏览器

文件需求-发送文件超过5个
    [Setup]    Run Keywords    流程登录正常
    超市首页-点击我想发送采购单    xpath=//*[@id="mmain"]//div[@class="menuul"]//li[text()="我想发送采购单的文件"]
    超市首页-点击我想发送采购单-上传文件（中间+）    ${testFiles.NormalPng}
    超市首页-点击我想发送采购单-上传文件（左下+）    ${testFiles.NormalTxt}
    超市首页-点击我想发送采购单-上传文件（左下+）    ${testFiles.NormalDocx}
    超市首页-点击我想发送采购单-上传文件（左下+）    ${testFiles.NormalXlsx}
    超市首页-点击我想发送采购单-上传文件（左下+）    ${testFiles.NormalDoc}
    超市首页-点击我想发送采购单-上传文件（左下+）    ${testFiles.NormalPng}
    ${Temp}    获取元素文本    xpath=//*[@id="banner03"]//div[@class="upload_btn"]//span[text()="最多上传5个文件"]
    Run Keyword If    '${Temp}' != '最多上传5个文件'    测试失败
    关闭当前浏览器
