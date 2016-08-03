package com.example.jindutiao;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	Button button;
	Button button2;
	Context context = this;
	Button button3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// ��ʼ���ؼ�
		button = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		// �Ի���
		button.setOnClickListener(this);
		button2.setOnClickListener(this);
		button3.setOnClickListener(this);
	}

	public void onClick(View v) {
		// ��ѡ�Ի����е�Item
		String[] items = new String[] { "1", "2" };
		switch (v.getId()) {
		case R.id.button1:
			AlertDialog.Builder builder = new Builder(this);
			builder.setTitle("��ʱ����");
			builder.setNegativeButton("ȡ��",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub

						}
					});
			builder.setPositiveButton("ȷ��",
					new DialogInterface.OnClickListener() {

						public void onClick(DialogInterface dialog, int which) {
							AlertDialog.Builder builder2 = new Builder(
									MainActivity.this);
							builder2.setTitle("zheshibiaoqi");
							builder2.setNegativeButton("cancel",
									new DialogInterface.OnClickListener() {
										public void onClick(
												DialogInterface dialog,
												int which) {
											// TODO Auto-generated method stub

										}
									});
							builder2.setPositiveButton("queding",
									new DialogInterface.OnClickListener() {

										public void onClick(
												DialogInterface dialog,
												int which) {

										}
									});
							builder2.show();
						}
					});
			builder.show();
			break;
		case R.id.button2:
			// ��ѡ�Ի���
			AlertDialog.Builder builder3 = new Builder(MainActivity.this);
			builder3.setTitle("bioti");
			builder3.setSingleChoiceItems(items, -1,
					new DialogInterface.OnClickListener() {

						public void onClick(DialogInterface dialog, int which) {
							switch (which) {
							case 0:
								Toast.makeText(context, "λ��" + which, 0).show();
								break;
							case 1:
								Log.i("Mainactivity", which + "");
								break;
							default:
								break;
							}
						}
					});
			builder3.show();
		case R.id.button3:
			// ��ѡ�Ի���
			AlertDialog.Builder builder4 = new Builder(context);
			builder4.setTitle("title");
			builder4.setMultiChoiceItems(items, null,
					new OnMultiChoiceClickListener() {

						public void onClick(DialogInterface dialog, int which,
								boolean isChecked) {
							Toast.makeText(context, "ѡ����" + which, 0).show();
						}
					});
			builder4.show();
			break;
		default:
			break;
		}
	}
}
