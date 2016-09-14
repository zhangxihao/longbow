#-*-coding:utf-8-*-
import sys
from _sqlite3 import Row
from mailbox import fcntl
reload(sys)
sys.setdefaultencoding('utf-8')  #设置python的编码格式
#print sys.getdefaultencoding()  #查看设置的编码格式
import csv

class TestTemp():
    def my_r_csv(self,fname,L_name,ID_L_value,*list_name):
        '''fname为文件路径和名称，ex：d:\\test.csv
		L_name为文件里唯一id列名，ID_L_value为唯一id值
		*list_name为所要获取值的列名'''  #这里的内容为该关键字的注释讲解
        with open(fname,'rb') as cfile:
        #cfile = open('d:\\test.csv','rb')
            reader = csv.DictReader(cfile)
        #a = open('d:\\aaa.txt','wb')
            for row in reader:
        #    a.write(row.get('aaa')+'\n')
                if row.get(L_name) == ID_L_value:
                    re_list = []
                    for name in list_name:
                        re_list.append(row.get(name))
                    return re_list

    def my_w_csv(self,R_fname,W_fname,R_l_name,R_values,actual_list,actual_value,listname=[]):
        '''将内容从R_fname读取成字典，并对字典进行修改后，写入到W_fname里
        R_fname：读取的文件名以及路径
        R_l_name：读取文件的id列名
        R_values：读取文件的id值
        W_fname：写入的文件名以及路径
        actual_list：实际结果列名
        actual_value：实际结果值
        listname=[]：表头顺序
        '''
        with open(R_fname,'rb') as wfile:
            reader = csv.DictReader(wfile)
            w_fanme = open(W_fname,'ab+')   #ab+：以二进制读写模式打开
            FTELDS = listname   #定义列表头顺序，在写入文件的时候，values按照这个顺序
            writer = csv.DictWriter(w_fanme,fieldnames=FTELDS)
            #writer.writerow(dict(zip(FTELDS,FTELDS))) #将表头写入到文件里
            for row in reader:
                if row.get(R_l_name) == R_values:
                    row[actual_list] = actual_value    #对字典row进行修改操作，增加了键、值
                    #writer.writerow(dict(zip(FTELDS,FTELDS)))
                    writer.writerow(row)
            w_fanme.close()