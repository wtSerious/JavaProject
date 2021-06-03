package Main;

import java.io.*;

public class Main5 {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ruanjie\\Desktop\\cpvton_xiaorong.txt";
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
        copyFile("D:\\result\\final_result\\cpvton_source\\"+linetxt+".jpg","C:\\Users\\ruanjie\\Desktop\\cpvton_xiaorong_imgs\\"+linetxt+"\\source\\"+linetxt+".jpg");
        copyFile("D:\\result\\final_result\\cpvton_target\\"+linetxt+".jpg","C:\\Users\\ruanjie\\Desktop\\cpvton_xiaorong_imgs\\"+linetxt+"\\target\\"+linetxt+".jpg");
        copyFile("D:\\result\\final_result\\cross_result_viton_addpants_wo_deconv_epoch15\\img\\"+linetxt+".png","C:\\Users\\ruanjie\\Desktop\\cpvton_xiaorong_imgs\\"+linetxt+"\\wodeconv\\"+linetxt+".png");
        copyFile("D:\\result\\final_result\\cross_result_viton_addpants_wo_featurewarp_epoch15\\img\\"+linetxt+".png","C:\\Users\\ruanjie\\Desktop\\cpvton_xiaorong_imgs\\"+linetxt+"\\wofeaturewarp\\"+linetxt+".png");
        copyFile("D:\\result\\final_result\\cross_result_viton_addpants_wo_iterative_epoch15\\img\\"+linetxt+".png","C:\\Users\\ruanjie\\Desktop\\cpvton_xiaorong_imgs\\"+linetxt+"\\woiterative\\"+linetxt+".png");
        copyFile("D:\\result\\final_result\\cross_result_viton_addpants_wo_mask_epoch15\\img\\"+linetxt+".png","C:\\Users\\ruanjie\\Desktop\\cpvton_xiaorong_imgs\\"+linetxt+"\\womask\\"+linetxt+".png");
        copyFile("D:\\result\\final_result\\cpvton_mine\\cross_result_viton_addpants_epoch20\\img\\"+linetxt+".png","C:\\Users\\ruanjie\\Desktop\\cpvton_xiaorong_imgs\\"+linetxt+"\\full\\"+linetxt+".png");
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
        String dirPath = "C:\\Users\\ruanjie\\Desktop\\cpvton_xiaorong_imgs"+"\\"+lineTxt;
        File dir = new File(dirPath);
        dir.mkdir();
        String subdir1 = dirPath+"\\"+"source";
        dir = new File(subdir1);
        dir.mkdir();
        String subdir2 = dirPath+"\\"+"target";
        dir = new File(subdir2);
        dir.mkdir();
        String subdir3 = dirPath+"\\"+"womask";
        dir = new File(subdir3);
        dir.mkdir();
        String subdir4 = dirPath+"\\"+"woiterative";
        dir = new File(subdir4);
        dir.mkdir();
        String subdir5 = dirPath+"\\"+"wodeconv";
        dir = new File(subdir5);
        dir.mkdir();
        String subdir6 = dirPath+"\\"+"wofeaturewarp";
        dir = new File(subdir6);
        dir.mkdir();
        String subdir7= dirPath+"\\"+"full";
        dir = new File(subdir7);
        dir.mkdir();
    }


}
