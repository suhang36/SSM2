package controller;

import Service.UserService;
import Service.impl.UserServiceImpl;
import entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("user")
//@RequestMapping("/user")
// 这是区分不同的controller之间的区别的方法，写了这个在方法上的路径就不用写了，
// 意为方法上的url和类上的url组成为一个url作为该controller的传入路径，这样就可以区分其他的controller了。
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/dbc")
    public String getDbc(){
        return "dbc";
    }

    @RequestMapping(value = "/VUName",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Integer> verificationUserName(User user, HttpSession session, Model model){
        List<User> userParameterWithName = userService.findUserParameterWithName(user);
        Map<String,Integer> map= new HashMap<>();
        System.out.println("get");
        User user2 = (User) session.getAttribute("user");
        if (userParameterWithName==null||userParameterWithName.isEmpty()){
            map.put("check",1);
        }else {
            map.put("check",0);
        }
       return map;
    }
    @RequestMapping(value = "/VUName",method = RequestMethod.POST)
    @ResponseBody
    public User login(User user, HttpSession session, Model model){
        System.out.println("post");
        List<User> users = userService.findUser();
        if (users.isEmpty()||users==null){
            return new User();
        }else {
            System.out.println(users.get(0));
            return users.get(0);
        }
    }
//
//    @RequestMapping("/VUName{path}")
//    public String verificationUserName2(@PathVariable("path") String path){
//        System.out.println(path);
//        return "login";
//    }
//    @RequestMapping("/VUName")
//    public String verificationUserName3(User user, Model model){
//        model.addAttribute("username",user.getName());
//        return "login";
//    }
//    @RequestMapping("/VUName")
//    public ModelAndView verificationUserName3(User user, ModelAndView modelAndView){
//        modelAndView.addObject("username",user.getName());
//        modelAndView.setViewName("login");
//        return modelAndView;
//    }

//    用ajax的方式来传值
//    @RequestMapping("/VUName")
//    @ResponseBody
//    public Map userLoginJsonData(User user){
//        Map<String,Object> pram=new HashMap<>();
//        pram.put("name",user.getName());
//        return pram;
//    }

//    用ajax的方式传值，返回值是json数组
//    @RequestMapping(value = "/VUName",method = RequestMethod.POST)
//    @ResponseBody
//    public ModelAndView userLoginJsonData(User user,ModelAndView modelAndView){
//        post的方式拿到值
//        System.out.println("这是post的方式提交的方法");
//        modelAndView.setViewName("login");
//        modelAndView.addObject("username",user.getName());
//        return modelAndView;
//    }

//    @RequestMapping(value = "/VUName",method = RequestMethod.GET)
//    public String userLoginJsonDataWithGet(User user){
////        get的方式拿到值
//        System.out.println("这是Get方式提交的方法");
//        return "login";
//    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/alluser")
    public String alluser(HttpServletRequest request){
        List<User> users = userService.findUser();
        System.out.println(users+"-------------------------------------");
        request.setAttribute("users",users);
        return "alluser";
    }

//    文件上传
    @RequestMapping(value = "/file/upload",method = RequestMethod.POST)
    public ModelAndView uploadFile(@RequestParam(value = "file",required = true) MultipartFile file, HttpServletRequest request, ModelAndView modelAndView){
        //原始文件名
        String originalFilename = file.getOriginalFilename();
        //获取保存路径
        String fileRelationPath="/upload/"+originalFilename;
        String path=request.getServletContext().getRealPath("")+fileRelationPath;
        System.out.println(path +"      "+fileRelationPath);
        File f=new File(path);
        //检查文件是否存在，不存在则创建
        if (!f.getParentFile().exists()){
            f.getParentFile().mkdirs();
        }
        //将文件上传到指定路径
        try {
            file.transferTo(f);
        }catch (Exception e){
            e.printStackTrace();
        }
       modelAndView.setViewName("login");
        modelAndView.addObject("fileRelationPath",fileRelationPath);
        modelAndView.addObject("filename",originalFilename);
        modelAndView.addObject("downloadUrl","http://localhost:8080/download/two?filename="+originalFilename);
        return modelAndView;
    }

    //文件下载
    @RequestMapping("/download/two")
    public void downloadFile(String filename, HttpServletResponse response,HttpServletRequest request) throws IOException {
        InputStream resourceAsStream = request.getServletContext().getResourceAsStream("/upload/"+filename);
        System.out.println(filename);
        byte[] bytes = new byte[1024];
        //中文乱码问题的解决
        URLEncoder.encode(filename,"utf-8");
        response.setHeader("Content-Disposition",String.format("attachment;filename=\"%s\"",filename));
        response.setContentType("application/octet-stream");
        ServletOutputStream outputStream = response.getOutputStream();
        while (resourceAsStream.read(bytes)!=-1){
            outputStream.write(bytes);
        }
        outputStream.flush();
        outputStream.close();
        resourceAsStream.close();
    }
}
