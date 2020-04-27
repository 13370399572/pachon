package com.feng.webmagic.pipeline;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.github.pagehelper.util.StringUtil;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Component
public class TestPipeline implements Pipeline {

	private String  title = null;

	@Override
	public void process(ResultItems resultItems, Task task) {
		// TODO Auto-generated method stub
		List<String> links = resultItems.get("links");
		String	title1 = resultItems.get("zhang");
		List<String> imgs = resultItems.get("imgs");
		if (StringUtil.isNotEmpty(title1)) {
			title = title1;
			System.out.println(title);
		}

		if (CollectionUtils.isNotEmpty(imgs)) {
			int z= 1;
			for (String string : imgs) {
				downloadimges(string,title,z);
				z++;
			}
		}


		int i = 1;
		if (CollectionUtils.isNotEmpty(links)) {
			for (String link : links) {
				downloadPicture(link,i,title);
				i++;
			}
		}

	}

	private void downloadimges(String link,String title ,int z) {
		// TODO Auto-generated method stub
		URL url = null;
		try {
			//https://cbu01.alicdn.com/img/ibank/2019/663/122/12928221366_127191958.jpg
			File file=new File("d:/test/" + title);
			if (!file.exists()) {
				file.mkdir();
			}
			String name="主图"+z+".jpg";
			url = new URL(link);
			DataInputStream dataInputStream = new DataInputStream(url.openStream());
			FileOutputStream fileOutputStream = new FileOutputStream(new File("d:/test/" + title+"/"+name));
			ByteArrayOutputStream output = new ByteArrayOutputStream();

			byte[] buffer = new byte[1024];
			int length;

			while ((length = dataInputStream.read(buffer)) > 0) {
				output.write(buffer, 0, length);
			}
			fileOutputStream.write(output.toByteArray());
			dataInputStream.close();
			fileOutputStream.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	private void downloadPicture(String link ,int i,String title) {
		// TODO Auto-generated method stub
		URL url = null;
		try {
			//https://cbu01.alicdn.com/img/ibank/2019/663/122/12928221366_127191958.jpg
			File file=new File("d:/test/" + title);
			if (!file.exists()) {
				file.mkdir();
			}
			String name="副图"+i+".jpg";
			url = new URL(link);
			DataInputStream dataInputStream = new DataInputStream(url.openStream());
			FileOutputStream fileOutputStream = new FileOutputStream(new File("d:/test/" + title+"/"+name));
			ByteArrayOutputStream output = new ByteArrayOutputStream();

			byte[] buffer = new byte[1024];
			int length;

			while ((length = dataInputStream.read(buffer)) > 0) {
				output.write(buffer, 0, length);
			}
			fileOutputStream.write(output.toByteArray());
			dataInputStream.close();
			fileOutputStream.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
