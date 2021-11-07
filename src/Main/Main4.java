package Main;

import java.io.*;

public class Main4 {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ruanjie\\Desktop\\cpvton_imglist.txt";
        try {
            String encoding= "GBK" ;
            File file= new File(filePath);
            if (file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding); //考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null ;
                while ((lineTxt = bufferedReader.readLine()) != null ){
                    System.out.println(lineTxt);
                    makeDirs(lineTxt);
                    moveImages(lineTxt);
                }
                read.close();
            } else {
                System.out.println( "找不到指定的文件" );
            }
        } catch (Exception e) {
            System.out.println( "读取文件内容出错" );
            e.printStackTrace();
        }

    }

    public static void moveImages(String linetxt){
        copyFile("D:\\result\\final_result\\cpvton_source\\"+linetxt+".jpg","C:\\Users\\ruanjie\\Desktop\\cpvton_imgs\\"+linetxt+"\\source\\"+linetxt+".jpg");
        copyFile("D:\\result\\final_result\\cpvton_target\\"+linetxt+".jpg","C:\\Users\\ruanjie\\Desktop\\cpvton_imgs\\"+linetxt+"\\target\\"+linetxt+".jpg");
        copyFile("D:\\result\\final_result\\cpvton\\"+linetxt+".jpg","C:\\Users\\ruanjie\\Desktop\\cpvton_imgs\\"+linetxt+"\\cpvton\\"+linetxt+".jpg");
        copyFile("D:\\result\\final_result\\cpvton_plus\\"+linetxt+".jpg","C:\\Users\\ruanjie\\Desktop\\cpvton_imgs\\"+linetxt+"\\cpvtonplus\\"+linetxt+".jpg");
        copyFile("D:\\result\\final_result\\clothflow_result\\cross_cloth_result_viton_noarms\\img\\"+linetxt+".png","C:\\Users\\ruanjie\\Desktop\\cpvton_imgs\\"+linetxt+"\\clothflow\\"+linetxt+".png");
        copyFile("D:\\result\\final_result\\cross_result_viton_addpants_new_multiscale_epoch20\\img\\"+linetxt+".png","C:\\Users\\ruanjie\\Desktop\\cpvton_imgs\\"+linetxt+"\\mine\\"+linetxt+".png");
        copyFile("D:\\result\\final_result\\result_viton_addpants_new_multiscale_epoch20_new2\\img\\"+linetxt+".png","C:\\Users\\ruanjie\\Desktop\\cpvton_imgs\\"+linetxt+"\\mine_new\\"+linetxt+".png");
        copyFile("D:\\result\\final_result\\ACGAN\\"+linetxt+".jpg","C:\\Users\\ruanjie\\Desktop\\cpvton_imgs\\"+linetxt+"\\acgan\\"+linetxt+".jpg");

    }

    public static void copyFile(String oldPath, String newPath) {
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            if (oldfile.exists()) { //文件存在时
                InputStream inStream = new FileInputStream(oldPath); //读入原文件
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                int length;
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; //字节数 文件大小
                    System.out.println(bytesum);
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        } catch (Exception e) {
            System.out.println("复制单个文件操作出错");
            e.printStackTrace();

        }
    }

    public static void makeDirs(String lineTxt){
        String dirPath = "C:\\Users\\ruanjie\\Desktop\\cpvton_imgs"+"\\"+lineTxt;
        File dir = new File(dirPath);
        dir.mkdir();
        String subdir1 = dirPath+"\\"+"source";
        dir = new File(subdir1);
        dir.mkdir();
        String subdir2 = dirPath+"\\"+"target";
        dir = new File(subdir2);
        dir.mkdir();
        String subdir3 = dirPath+"\\"+"cpvton";
        dir = new File(subdir3);
        dir.mkdir();
        String subdir4 = dirPath+"\\"+"clothflow";
        dir = new File(subdir4);
        dir.mkdir();
        String subdir5 = dirPath+"\\"+"mine";
        dir = new File(subdir5);
        dir.mkdir();
        String subdir6 = dirPath+"\\"+"cpvtonplus";
        dir = new File(subdir6);
        dir.mkdir();
        String subdir7 = dirPath+"\\"+"acgan";
        dir = new File(subdir7);
        dir.mkdir();
        String subdir8 = dirPath+"\\"+"mine_new";
        dir = new File(subdir8);
        dir.mkdir();
    }


}
