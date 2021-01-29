package com.qf.cdmr.controller;

import com.qf.cdmr.entity.Pic;
import com.qf.cdmr.result.ResponseCode;
import com.qf.cdmr.result.ResponseData;
import com.qf.cdmr.service.PicService;
import com.sun.corba.se.impl.interceptors.PICurrent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Pic)表控制层
 *
 * @author makejava
 * @since 2021-01-11 15:43:45
 */

/**
 * 请求：http://localhost:8080/pic/yd
 */
//@responseBody+@controller  @responseBody将数据转换为json数据格式返回前端
@Api(value = "Pic")
@RestController         //控制层注解，表示当前层为控制层，并且被springmvc扫描
@RequestMapping("pic")  //路径映射
public class PicController {

    @Autowired //自动装配
    private PicService picService;

//    @RequestMapping("yd")
//    public String del(Pic pic){
//        //执行删除操作
//        return pic.getPId()+"-"+pic.getTitle();
//    }
//    @GetMapping("yd")
//    public String select(Pic pic){
//        //执行删除操作
//        return pic.getPId()+"-"+pic.getTitle();
//    }
//    /**
//     * post请求前端传的参数必须是json格式的参数
//     * json是带有特殊格式的字符串
//     * {"id":1,"title":"推荐","url":"xxx"}
//     * @RequestBody将json数据转换为java对象
//     */
////    @PostMapping("insertPic")
////    public String insert(@RequestBody Pic pic){
////        return "";
////    }
//    @PostMapping("insertPic")
//    public RespouseData insert(@RequestBody Pic pic){
//        return new RespouseData(ResponseCode.SUCCESS,null);
//    }
//    @PutMapping("put")
//    public String put(){
//        return "";
//    }
//    @DeleteMapping("delete/{id}")
//    public String del(@PathVariable("id") Integer id){
//        return "";
//    }
//    /**
//     * 后台如何返回数据 直接返回一个页面 直接返回json数据格式 将数据放在session或者model中。
//     */
//    /**
//     * 返回json数据格式
//     */
//    @GetMapping("queryPic")
//    public Pic queryPic(){
//        Pic pic = new Pic();
//        pic.setPId(1);
//        pic.setTitle("xixi");
//        pic.setUrl("xxx");
//        return pic;
//    }

    //通过图片类型获取图片列表
    @ApiOperation(value = "queryByType",notes = "通过图片类型获取对应图片列表")
    @ApiImplicitParam(name = "type",value = "图片类型lb-轮播，nav-导航",dataType = "string")
    @GetMapping("queryByType/{type}")
    public ResponseData queryByType(@PathVariable("type") String type){
        List<Pic> pics =  picService.queryByType(type);
        return new ResponseData(ResponseCode.SUCCESS,pics);
    }


    //获取所有图片列表
    //@CrossOrigin
    @ApiOperation(value = "queryAll",notes = "获取所有图片列表")
    @GetMapping("queryAll")
    public ResponseData queryAll(Integer page,Integer limit){

        return picService.queryAllByLimit(page, limit);
    }

    //获取所有图片列表
    //@CrossOrigin
    @ApiOperation(value = "updatePic",notes = "根据id修改图片状态")
    @PatchMapping("updatePic")
    public ResponseData updatePic(@RequestBody Pic pic){

        return picService.update(pic);
    }

    @ApiOperation(value = "delPic",notes = "根据id删除图片")
    @ApiImplicitParam(name = "pid",value = "图片的id",dataType = "int")
    @DeleteMapping("delPic/{pid}")
    public ResponseData delPic(@PathVariable("pid") Integer pid){
        boolean b = picService.deleteById(pid);
        if(b){
            return  new ResponseData(ResponseCode.SUCCESS);
        }else {
            return  new ResponseData(ResponseCode.FAILED);
        }
    }

    @ApiOperation(value = "insertPic",notes = "插入图片")
    @ApiImplicitParam(name = "pid",value = "pic对象",dataType = "int")
    @PostMapping("insertPic")
    public ResponseData insertPic(@RequestBody Pic pic){

        boolean b = picService.insert(pic);
        if(b){
            return  new ResponseData(ResponseCode.SUCCESS);
        }else {
            return  new ResponseData(ResponseCode.FAILED);
        }
    }

    //模糊查询
    @ApiOperation(value = "queryByLike",notes = "模糊查询")
    @ApiImplicitParam(name = "value",value = "类型，标题")
    @GetMapping("queryByLike")
    public ResponseData queryByLike(String value,Integer page,Integer limit){
        return picService.queryByLike(value,page,limit);
    }

//    //根据id获取对应图片
//    @ApiOperation(value = "queryById",notes = "根据id获取图片")
//    @ApiImplicitParam(name = "id",value = "图片id",dataType = "int",required = true)
//    @GetMapping("queryById/{id}")
//    public ResponseData queryById(@PathVariable("id")Integer id){
//        Pic pic = picService.queryById(id);
//        return new ResponseData(ResponseCode.SUCCESS,null);
//    }
//
//    //根据不同的条件获取图片
//    @ApiOperation(value = "queryByConditions",notes = "根据不同的条件获取图片")
//    @ApiImplicitParams({
//            @ApiImplicitParam(value = "id",dataType = "int",required = false),
//            @ApiImplicitParam(value = "name",dataType = "string",required = false)
//    })
//    @GetMapping("queryByConditions/{id}/{name}")
//    public ResponseData queryByConditions(@PathVariable("id")Integer id, @PathVariable("name")String name){
//
//        return new ResponseData(ResponseCode.SUCCESS,null);
//    }
//
//    @ApiOperation(value = "queryAllByLimit",notes = "分页查询")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "page",value = "当前页",dataType = "int"),
//            @ApiImplicitParam(name = "limit",value = "每页的条数",dataType = "int")
//    })
//    @GetMapping("queryAllByLimit/{page}/{limit}")
//    public ResponseData queryAllByLimit(@PathVariable("page")Integer page, @PathVariable("limit")Integer limit){
//        return picService.queryAllByLimit(page, limit);
//    }
}