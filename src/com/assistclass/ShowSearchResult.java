package com.assistclass;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.constant.Constant;
import com.data.Book;
import com.sqlservice.DriveSQL;

public class ShowSearchResult extends JPanel {

	private DriveSQL sql;
	private ImageIcon tip;
	private JPanel panel1, panel[];
	private JLabel label[];
	private JButton button[];
	private MyFunction function;
	private int type;

	public ShowSearchResult(DriveSQL sql,int type) {
		
		this.type = type;
		this.sql = sql;
		this.setLayout(new BorderLayout());
		this.setOpaque(false);

		function = new MyFunction();

		initialize();
	}

	public void initialize() {		
		Book book = new Book("TP312JA526", "Java�������������", "���", "������ ��Ծƽ", 39,
				1, "�ɽ�", "�廪��ѧ", "2013-9-1", "�Ȿ��ܺ�");// sql.getBook(str);

		tip = new ImageIcon("tipImage\\fixTip.png");

		panel1 = new JPanel();

		button = new JButton[Constant.TABLE_HEAD.length - 1];
		panel = new JPanel[Constant.TABLE_HEAD.length];
		label = new JLabel[Constant.TABLE_HEAD.length];

		panel1.setLayout(new GridLayout(5, 2, 10, 10));
		panel1.setOpaque(false);

		String obj;
		for (int i = 0; i < 10; i++) {
			obj = null;
			switch (i) {
			case 0:
				obj = " " + book.getBookNumber();
				break;
			case 1:
				obj = " " + book.getBookName();
				break;
			case 2:
				obj = " " + book.getBookType();
				break;
			case 3:
				obj = " " + book.getBookAuthor();
				break;
			case 4:
				obj = "  " + book.getBookPrice();
				break;
			case 5:
				obj = " " + book.getBookCount();
				break;
			case 6:
				obj = " " + book.getBookState();
				break;
			case 7:
				obj = " " + book.getBookPress();
				break;
			case 8:
				obj = " " + book.getBookDate();
				break;
			case 9:
				obj = " " + book.getBookDiscuss();
				break;
			}
			// System.out.println(Constant.TABLE_HEAD[i] + ":" + obj);
			label[i] = new JLabel(Constant.TABLE_HEAD[i] + ":" + obj);
			label[i].setFont(new Font("���Ŀ���", Font.BOLD, 20));
			label[i].setForeground(Color.BLUE);
			if (this.type == Constant.BOOK_UPDATE) {
				panel[i] = new JPanel();
				panel[i].setOpaque(false);
				panel[i].setLayout(new BorderLayout());
				if (i != 9) {
					button[i] = new JButton(tip);
					function.setButtonStyle(button[i]);
					button[i].addMouseListener(new MouseListenerImp());
					panel[i].add(button[i], BorderLayout.EAST);
				}
				panel[i].add(label[i], BorderLayout.CENTER);
				panel1.add(panel[i]);
			} else
				panel1.add(label[i]);
		}

		panel1.setBorder(new TitledBorder("ͼ����Ϣ"));

		this.add(panel1, BorderLayout.CENTER);

	}

	private class MouseListenerImp extends MouseAdapter {

		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == button[0]) {
				function.inputFixMsg("Ոݔ���µ�ͼ����");
			} else if (e.getSource() == button[1]) {
				function.inputFixMsg("Ոݔ���µ�ͼ������");
			} else if (e.getSource() == button[2]) {
				function.inputFixMsg("Ոݔ���µ�ͼ������");
			} else if (e.getSource() == button[3]) {
				function.inputFixMsg("Ոݔ���µ�ͼ������");
			} else if (e.getSource() == button[4]) {
				function.inputFixMsg("Ոݔ���µ�ͼ��۸�");
			} else if (e.getSource() == button[5]) {
				function.inputFixMsg("Ոݔ���µ��ִ�ͼ������");
			} else if (e.getSource() == button[6]) {
				function.inputFixMsg("Ոݔ���µ�ͼ����״̬");
			} else if (e.getSource() == button[7]) {
				function.inputFixMsg("Ոݔ���µ�ͼ�������");
			} else if (e.getSource() == button[8]) {
				function.inputFixMsg("Ոݔ���µ�ͼ���������");
			}
		}
	}
}
