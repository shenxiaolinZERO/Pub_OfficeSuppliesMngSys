package cn.fjnu.officeSystem.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

public class UpLoadFile {
	public void upLoadPic(MultipartFile[] pic) throws IOException{
        //Message msg = new Message();
       // System.out.println(name);
		String path = "F:/tomcatImg";
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < pic.length; i++) {
            MultipartFile file = pic[i];

            if (!file.isEmpty()) {
                InputStream in = null;
                OutputStream out = null;

                try {
//                	String rootPath = System.getProperty("catalina.home");
                    File dir = new File(path);
                    if (!dir.exists())
                        dir.mkdirs();
                    //文件名********************
                    File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
                    in = file.getInputStream();
                    out = new FileOutputStream(serverFile);
                     System.out.println(serverFile.getAbsolutePath());
                    byte[] b = new byte[1024];
                    int len = 0;
                    while ((len = in.read(b)) > 0) {
                        out.write(b, 0, len);
                    }
                    out.close();
                    in.close();
                } catch (Exception e) {
                    arr.add(i);
                } finally {
                    if (out != null) {
                        out.close();
                        out = null;
                    }

                    if (in != null) {
                        in.close();
                        in = null;
                    }
                }
            } else {
                arr.add(i);
            }

        }
        //return "success";
	}
}


