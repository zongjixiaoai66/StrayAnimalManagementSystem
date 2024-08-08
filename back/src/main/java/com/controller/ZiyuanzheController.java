
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 自愿者
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/ziyuanzhe")
public class ZiyuanzheController {
    private static final Logger logger = LoggerFactory.getLogger(ZiyuanzheController.class);

    @Autowired
    private ZiyuanzheService ziyuanzheService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("自愿者".equals(role))
            params.put("ziyuanzheId",request.getSession().getAttribute("userId"));
        params.put("ziyuanzheDeleteStart",1);params.put("ziyuanzheDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = ziyuanzheService.queryPage(params);

        //字典表数据转换
        List<ZiyuanzheView> list =(List<ZiyuanzheView>)page.getList();
        for(ZiyuanzheView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZiyuanzheEntity ziyuanzhe = ziyuanzheService.selectById(id);
        if(ziyuanzhe !=null){
            //entity转view
            ZiyuanzheView view = new ZiyuanzheView();
            BeanUtils.copyProperties( ziyuanzhe , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ZiyuanzheEntity ziyuanzhe, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,ziyuanzhe:{}",this.getClass().getName(),ziyuanzhe.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ZiyuanzheEntity> queryWrapper = new EntityWrapper<ZiyuanzheEntity>()
            .eq("username", ziyuanzhe.getUsername())
            .or()
            .eq("ziyuanzhe_phone", ziyuanzhe.getZiyuanzhePhone())
            .andNew()
            .eq("ziyuanzhe_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZiyuanzheEntity ziyuanzheEntity = ziyuanzheService.selectOne(queryWrapper);
        if(ziyuanzheEntity==null){
            ziyuanzhe.setZiyuanzheDelete(1);
            ziyuanzhe.setCreateTime(new Date());
            ziyuanzhe.setPassword("123456");
            ziyuanzheService.insert(ziyuanzhe);
            return R.ok();
        }else {
            return R.error(511,"账户或者手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZiyuanzheEntity ziyuanzhe, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,ziyuanzhe:{}",this.getClass().getName(),ziyuanzhe.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<ZiyuanzheEntity> queryWrapper = new EntityWrapper<ZiyuanzheEntity>()
            .notIn("id",ziyuanzhe.getId())
            .andNew()
            .eq("username", ziyuanzhe.getUsername())
            .or()
            .eq("ziyuanzhe_phone", ziyuanzhe.getZiyuanzhePhone())
            .andNew()
            .eq("ziyuanzhe_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZiyuanzheEntity ziyuanzheEntity = ziyuanzheService.selectOne(queryWrapper);
        if("".equals(ziyuanzhe.getZiyuanzhePhoto()) || "null".equals(ziyuanzhe.getZiyuanzhePhoto())){
                ziyuanzhe.setZiyuanzhePhoto(null);
        }
        if(ziyuanzheEntity==null){
            ziyuanzheService.updateById(ziyuanzhe);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者手机号已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<ZiyuanzheEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ZiyuanzheEntity ziyuanzheEntity = new ZiyuanzheEntity();
            ziyuanzheEntity.setId(id);
            ziyuanzheEntity.setZiyuanzheDelete(2);
            list.add(ziyuanzheEntity);
        }
        if(list != null && list.size() >0){
            ziyuanzheService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<ZiyuanzheEntity> ziyuanzheList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ZiyuanzheEntity ziyuanzheEntity = new ZiyuanzheEntity();
//                            ziyuanzheEntity.setUsername(data.get(0));                    //账户 要改的
//                            //ziyuanzheEntity.setPassword("123456");//密码
//                            ziyuanzheEntity.setZiyuanzheName(data.get(0));                    //自愿者姓名 要改的
//                            ziyuanzheEntity.setZiyuanzhePhoto("");//详情和图片
//                            ziyuanzheEntity.setZiyuanzhePhone(data.get(0));                    //手机号 要改的
//                            ziyuanzheEntity.setZiyuanzheEmail(data.get(0));                    //电子邮箱 要改的
//                            ziyuanzheEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            ziyuanzheEntity.setZiyuanzheDelete(1);//逻辑删除字段
//                            ziyuanzheEntity.setCreateTime(date);//时间
                            ziyuanzheList.add(ziyuanzheEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //手机号
                                if(seachFields.containsKey("ziyuanzhePhone")){
                                    List<String> ziyuanzhePhone = seachFields.get("ziyuanzhePhone");
                                    ziyuanzhePhone.add(data.get(0));//要改的
                                }else{
                                    List<String> ziyuanzhePhone = new ArrayList<>();
                                    ziyuanzhePhone.add(data.get(0));//要改的
                                    seachFields.put("ziyuanzhePhone",ziyuanzhePhone);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<ZiyuanzheEntity> ziyuanzheEntities_username = ziyuanzheService.selectList(new EntityWrapper<ZiyuanzheEntity>().in("username", seachFields.get("username")).eq("ziyuanzhe_delete", 1));
                        if(ziyuanzheEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZiyuanzheEntity s:ziyuanzheEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //手机号
                        List<ZiyuanzheEntity> ziyuanzheEntities_ziyuanzhePhone = ziyuanzheService.selectList(new EntityWrapper<ZiyuanzheEntity>().in("ziyuanzhe_phone", seachFields.get("ziyuanzhePhone")).eq("ziyuanzhe_delete", 1));
                        if(ziyuanzheEntities_ziyuanzhePhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZiyuanzheEntity s:ziyuanzheEntities_ziyuanzhePhone){
                                repeatFields.add(s.getZiyuanzhePhone());
                            }
                            return R.error(511,"数据库的该表中的 [手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        ziyuanzheService.insertBatch(ziyuanzheList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        ZiyuanzheEntity ziyuanzhe = ziyuanzheService.selectOne(new EntityWrapper<ZiyuanzheEntity>().eq("username", username));
        if(ziyuanzhe==null || !ziyuanzhe.getPassword().equals(password))
            return R.error("账号或密码不正确");
        else if(ziyuanzhe.getZiyuanzheDelete() != 1)
            return R.error("账户已被删除");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(ziyuanzhe.getId(),username, "ziyuanzhe", "自愿者");
        R r = R.ok();
        r.put("token", token);
        r.put("role","自愿者");
        r.put("username",ziyuanzhe.getZiyuanzheName());
        r.put("tableName","ziyuanzhe");
        r.put("userId",ziyuanzhe.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody ZiyuanzheEntity ziyuanzhe){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<ZiyuanzheEntity> queryWrapper = new EntityWrapper<ZiyuanzheEntity>()
            .eq("username", ziyuanzhe.getUsername())
            .or()
            .eq("ziyuanzhe_phone", ziyuanzhe.getZiyuanzhePhone())
            .andNew()
            .eq("ziyuanzhe_delete", 1)
            ;
        ZiyuanzheEntity ziyuanzheEntity = ziyuanzheService.selectOne(queryWrapper);
        if(ziyuanzheEntity != null)
            return R.error("账户或者手机号已经被使用");
        ziyuanzhe.setZiyuanzheDelete(1);
        ziyuanzhe.setCreateTime(new Date());
        ziyuanzheService.insert(ziyuanzhe);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        ZiyuanzheEntity ziyuanzhe = new ZiyuanzheEntity();
        ziyuanzhe.setPassword("123456");
        ziyuanzhe.setId(id);
        ziyuanzheService.updateById(ziyuanzhe);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        ZiyuanzheEntity ziyuanzhe = ziyuanzheService.selectOne(new EntityWrapper<ZiyuanzheEntity>().eq("username", username));
        if(ziyuanzhe!=null){
            ziyuanzhe.setPassword("123456");
            boolean b = ziyuanzheService.updateById(ziyuanzhe);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrZiyuanzhe(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        ZiyuanzheEntity ziyuanzhe = ziyuanzheService.selectById(id);
        if(ziyuanzhe !=null){
            //entity转view
            ZiyuanzheView view = new ZiyuanzheView();
            BeanUtils.copyProperties( ziyuanzhe , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = ziyuanzheService.queryPage(params);

        //字典表数据转换
        List<ZiyuanzheView> list =(List<ZiyuanzheView>)page.getList();
        for(ZiyuanzheView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZiyuanzheEntity ziyuanzhe = ziyuanzheService.selectById(id);
            if(ziyuanzhe !=null){


                //entity转view
                ZiyuanzheView view = new ZiyuanzheView();
                BeanUtils.copyProperties( ziyuanzhe , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ZiyuanzheEntity ziyuanzhe, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,ziyuanzhe:{}",this.getClass().getName(),ziyuanzhe.toString());
        Wrapper<ZiyuanzheEntity> queryWrapper = new EntityWrapper<ZiyuanzheEntity>()
            .eq("username", ziyuanzhe.getUsername())
            .or()
            .eq("ziyuanzhe_phone", ziyuanzhe.getZiyuanzhePhone())
            .andNew()
            .eq("ziyuanzhe_delete", 1)
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZiyuanzheEntity ziyuanzheEntity = ziyuanzheService.selectOne(queryWrapper);
        if(ziyuanzheEntity==null){
            ziyuanzhe.setZiyuanzheDelete(1);
            ziyuanzhe.setCreateTime(new Date());
        ziyuanzhe.setPassword("123456");
        ziyuanzheService.insert(ziyuanzhe);
            return R.ok();
        }else {
            return R.error(511,"账户或者手机号已经被使用");
        }
    }


}
