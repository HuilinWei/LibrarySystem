package com.app;

import com.data.Reader;
import com.frame.MainFrame;

public class Main {
	public static void main(String args[]){
		Reader user = new Reader(2013083225,"Ҧ��","84878323","��",21,
			 	"15640928579","2293952179@qq.com","�������ѧ�빤��ѧԺ���繤��",
			 	"�����ҳ�Ա","2013��","����Ա");
		
		new MainFrame(user);
	//	new LoginWindow();	
	}
}
