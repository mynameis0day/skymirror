package com.vul.springboot_vul.Upload;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
@RequestMapping("/upload")
public class FileUploadVuls {

//    注意！需要先在D盘下建立一个文件夹upload，该文件夹是用来存放上传的文件的

    //    第一关：content-type白名单绕过
    @RequestMapping("/fileUpload1")
    public String testFileUpload1(@RequestParam("myfile") MultipartFile file) throws IOException {
        //判断文件是否为空
        if (file.isEmpty()) {
            return "/upload_fail";
        }
        //创建输入输出流
        InputStream inputStream = null;
        OutputStream outputStream = null;
        String contentType = file.getContentType();
        String[] white_type = {"image/gif", "image/jpeg", "image/jpg", "image/png"};//允许上传的图片类型
        Boolean ctFlag = false;
        for (String suffix : white_type) {
            if (contentType.equalsIgnoreCase(suffix)) {
                ctFlag = true;
                break;
            }
        }
        if (!ctFlag) {//不允许上传的图片类型会返回提示"content-type not allow"
            System.out.println("该类型文件不允许被上传！");
            return "upload_fail";
        }
        try {
            //指定上传的位置为 d:/upload/
            String path = "d:/upload/";
            //获取文件的输入流
            inputStream = file.getInputStream();
            String fileName = file.getOriginalFilename();
            File targetFile = new File(path + fileName);
            //判断文件父目录是否存在
            if (!targetFile.getParentFile().exists()) {
                //不存在就创建一个
                targetFile.getParentFile().mkdir();
            }
            //获取文件的输出流
            outputStream = new FileOutputStream(targetFile);
            FileCopyUtils.copy(inputStream, outputStream);
            //告诉上传成功了
            System.out.println("文件上传成功！");
        } catch (IOException e) {
            e.printStackTrace();
            //出现异常，则告诉失败
            System.out.println("文件上传失败！");
            return "upload_fail";
        } finally {
            //无论成功与否，都有关闭输入输出流
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "/upload_success";
    }

    //    第二关：js前端校验绕过
    @RequestMapping("/fileUpload2")
    public String testFileUpload2(@RequestParam("myfile") MultipartFile file) throws IOException {
        //判断文件是否为空
        if (file.isEmpty()) {
            return "/upload_fail";
        }
        //创建输入输出流
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            //指定上传的位置为 d:/upload/
            String path = "d:/upload/";
            //获取文件的输入流
            inputStream = file.getInputStream();
            String fileName = file.getOriginalFilename();
            File targetFile = new File(path + fileName);
            //判断文件父目录是否存在
            if (!targetFile.getParentFile().exists()) {
                //不存在就创建一个
                targetFile.getParentFile().mkdir();
            }
            //获取文件的输出流
            outputStream = new FileOutputStream(targetFile);
            FileCopyUtils.copy(inputStream, outputStream);
            //告诉上传成功了
            System.out.println("文件上传成功！");
        } catch (IOException e) {
            e.printStackTrace();
            //出现异常，则告诉失败
            System.out.println("文件上传失败！");
            return "upload_fail";
        } finally {
            //无论成功与否，都有关闭输入输出流
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "/upload_success";
    }

    //    第三关：双写后缀名绕过
    @RequestMapping("/fileUpload3")
    public String testFileUpload3(@RequestParam("myfile") MultipartFile file) throws IOException {
        //判断文件是否为空
        if (file.isEmpty()) {
            return "/upload_fail";
        }
        //创建输入输出流
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            //指定上传的位置为 d:/upload/
            String path = "d:/upload/";
            //获取文件的输入流
            inputStream = file.getInputStream();
            String fileName = file.getOriginalFilename();
            String fileSuffix = fileName.substring(fileName.lastIndexOf("."));//获取后缀名
            String[] white_suffix = {"jsp", "class", "java"};//后缀名黑名单
            for (String suffix : white_suffix) {//若后缀名在黑名单里面，则去除该后缀名
                if (fileSuffix.contains(suffix)) {
                    fileName = fileName.replaceAll(suffix, "");
                    System.out.println("filename=" + fileName);
                    break;
                }
            }
            File targetFile = new File(path + fileName);
            //判断文件父目录是否存在
            if (!targetFile.getParentFile().exists()) {
                //不存在就创建一个
                targetFile.getParentFile().mkdir();
            }
            //获取文件的输出流
            outputStream = new FileOutputStream(targetFile);
            FileCopyUtils.copy(inputStream, outputStream);
            //告诉上传成功了
            System.out.println("文件上传成功！");
        } catch (IOException e) {
            e.printStackTrace();
            //出现异常，则告诉失败
            System.out.println("文件上传失败！");
            return "upload_fail";
        } finally {
            //无论成功与否，都有关闭输入输出流
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "/upload_success";
    }

    //    第四关：大小写绕过
    @RequestMapping("/fileUpload4")
    public String testFileUpload4(@RequestParam("myfile") MultipartFile file) throws IOException {
        //判断文件是否为空
        if (file.isEmpty()) {
            return "/upload_fail";
        }
        //创建输入输出流
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            //指定上传的位置为 d:/upload/
            String path = "d:/upload/";
            //获取文件的输入流
            inputStream = file.getInputStream();
            String fileName = file.getOriginalFilename();
            fileName = fileName.replaceAll(" ", "");//若文件名包含空格，则去除空格
            String fileSuffix = fileName.substring(fileName.lastIndexOf("."));//获取后缀名
            //若文件名包含多个“.”时，则不允许上传
            char[] str = fileName.toCharArray();//把文件名转化为char数组
            int i = 0;//记录“.”的个数
            for (char p : str) {
                if (p == '.') {
                    i++;
                }
            }
            if (i > 1) {
                return "suffix not allow";
            }
            String[] white_suffix = {"jsp", "class", "java"};//后缀名黑名单
            for (String suffix : white_suffix) {//若后缀名在黑名单里面，则不允许上传
                if (fileSuffix.contains(suffix)) {
                    return "suffix not allow";
                }
            }
            File targetFile = new File(path + fileName);
            //判断文件父目录是否存在
            if (!targetFile.getParentFile().exists()) {
                //不存在就创建一个
                targetFile.getParentFile().mkdir();
            }
            //获取文件的输出流
            outputStream = new FileOutputStream(targetFile);
            FileCopyUtils.copy(inputStream, outputStream);
            //告诉上传成功了
            System.out.println("文件上传成功！");
        } catch (IOException e) {
            e.printStackTrace();
            //出现异常，则告诉失败
            System.out.println("文件上传失败！");
            return "upload_fail";
        } finally {
            //无论成功与否，都有关闭输入输出流
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "/upload_success";
    }

    //    第五关：点绕过
    @RequestMapping("/fileUpload5")
    public String testFileUpload5(@RequestParam("myfile") MultipartFile file) throws IOException {
        //判断文件是否为空
        if (file.isEmpty()) {
            return "/upload_fail";
        }
        //创建输入输出流
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            //指定上传的位置为 d:/upload/
            String path = "d:/upload/";
            //获取文件的输入流
            inputStream = file.getInputStream();
            String fileName = file.getOriginalFilename();
            fileName = fileName.replaceAll(" ", "");//若文件名包含空格，则去除空格
            String fileSuffix = fileName.substring(fileName.lastIndexOf("."));//获取后缀名
            fileSuffix = fileSuffix.toLowerCase();//把后缀名转化为小写
            String[] white_suffix = {"jsp", "class", "java"};//后缀名黑名单
            for (String suffix : white_suffix) {//若后缀名在黑名单里面，则不允许上传
                if (fileSuffix.contains(suffix)) {
                    return "suffix not allow";
                }
            }
            File targetFile = new File(path + fileName);
            //判断文件父目录是否存在
            if (!targetFile.getParentFile().exists()) {
                //不存在就创建一个
                targetFile.getParentFile().mkdir();
            }
            //获取文件的输出流
            outputStream = new FileOutputStream(targetFile);
            FileCopyUtils.copy(inputStream, outputStream);
            //告诉上传成功了
            System.out.println("文件上传成功！");
        } catch (IOException e) {
            e.printStackTrace();
            //出现异常，则告诉失败
            System.out.println("文件上传失败！");
            return "upload_fail";
        } finally {
            //无论成功与否，都有关闭输入输出流
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "/upload_success";
    }

    //    第六关：空格绕过
    @RequestMapping("/fileUpload6")
    public String testFileUpload6(@RequestParam("myfile") MultipartFile file) throws IOException {
        //判断文件是否为空
        if (file.isEmpty()) {
            return "/upload_fail";
        }
        //创建输入输出流
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            //指定上传的位置为 d:/upload/
            String path = "d:/upload/";
            //获取文件的输入流
            inputStream = file.getInputStream();
            String fileName = file.getOriginalFilename();
            String fileSuffix = fileName.substring(fileName.lastIndexOf("."));//获取后缀名
            fileSuffix = fileSuffix.toLowerCase();//把后缀名转化为小写
            //若文件名包含多个“.”时，则不允许上传
            char[] str = fileName.toCharArray();//把文件名转化为char数组
            int i = 0;//记录“.”的个数
            for (char p : str) {
                if (p == '.') {
                    i++;
                }
            }
            if (i > 1) {
                return "suffix not allow";
            }
            String[] white_suffix = {"jsp", "class", "java"};//后缀名黑名单
            fileSuffix = fileSuffix.replace(".", "");
            for (String suffix : white_suffix) {//若后缀名在黑名单里面，则不允许上传
                if (fileSuffix.equals(suffix)) {
                    return "suffix not allow";
                }
            }
            File targetFile = new File(path + fileName);
            //判断文件父目录是否存在
            if (!targetFile.getParentFile().exists()) {
                //不存在就创建一个
                targetFile.getParentFile().mkdir();
            }
            //获取文件的输出流
            outputStream = new FileOutputStream(targetFile);
            FileCopyUtils.copy(inputStream, outputStream);
            //告诉上传成功了
            System.out.println("文件上传成功！");
        } catch (IOException e) {
            e.printStackTrace();
            //出现异常，则告诉失败
            System.out.println("文件上传失败！");
            return "upload_fail";
        } finally {
            //无论成功与否，都有关闭输入输出流
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "/upload_success";
    }
}
