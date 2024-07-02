package com.example.hos.controller;

import com.example.hos.entity.Yycount;
import com.example.hos.entity.Yyrecord;
import com.example.hos.service.DocService;
import com.example.hos.service.YycountService;
import com.example.hos.service.YyrecordService;
import com.example.hos.util.common.Result;
import com.example.hos.vo.HpmidDTO;
import com.example.hos.vo.ListYy;
import com.example.hos.vo.RecordDTO;
import com.example.hos.vo.YycountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class RecordController {

    @Autowired
    private DocService docService;
    @Autowired
    private YyrecordService yyrecordService;
    @Autowired
    private YycountService yycountService;

    @PostMapping("/finishyyps")
    public Result<ListYy> InsertRecordPersons(@RequestBody Map<String,Integer> json){
        Integer yyid = json.get("yyid");
        Integer uid = json.get("uid");

        Integer record = yyrecordService.insertRecord(uid, yyid);
        if(record==1){
            return Result.success();
        }else if(record==0){
            HpmidDTO hpmidDTO = yycountService.getHidAndPmid(yyid);
            ListYy doc = docService.getDoc(hpmidDTO.getHid(), hpmidDTO.getPmid());
            if(doc != null){
                return Result.valFailed("失败",doc);
            }
        }else if(record ==2){
            HpmidDTO hpmidDTO = yycountService.getHidAndPmid(yyid);
            ListYy doc = docService.getDoc(hpmidDTO.getHid(), hpmidDTO.getPmid());
            if(doc != null){
                return Result.forbidden("不能重复预约同一科室",doc);
            }
        }
        return Result.failed();
    }

    //获取单独一个医生的可预约人数
    @PostMapping("/getdoccount")
    public Result<List<YycountDTO>> getdoccount(@RequestBody Map<String,Integer> json){
        Integer did = json.get("did");
        List<YycountDTO> docCount = yycountService.getDocCount(did);
        if(docCount != null){
            return Result.success(docCount);
        }
        return Result.failed("服务器错误");
    }

    @PostMapping("/finishyyp")
    public Result<List<YycountDTO>> InsertRecordPerson(@RequestBody Map<String,Integer> json){
        Integer yyid = json.get("yyid");
        Integer uid = json.get("uid");

        Integer record = yyrecordService.insertRecord(uid, yyid);
        if(record==1){
            return Result.success();
        }else if(record==0){
            Yycount yycount = yycountService.getYycountByyyid(yyid);
            List<YycountDTO> docCount = yycountService.getDocCount(yycount.getDid());
            if(docCount!=null){
                return Result.valFailed("失败",docCount);
            }
        }else if(record ==2){
            Yycount yycount = yycountService.getYycountByyyid(yyid);
            List<YycountDTO> docCount = yycountService.getDocCount(yycount.getDid());
            if(docCount != null){
                return Result.forbidden("不能重复预约同一科室",docCount);
            }
        }
        return Result.failed();
    }


    @PostMapping("/getrecord")
    public Result<List<RecordDTO>> getRecordByUid(@RequestBody Map<String,Integer> json){
        try {
            Integer uid = json.get("uid");
            List<RecordDTO> recordlist = yyrecordService.getrecordByUid(uid);
            if(recordlist!=null){
                return Result.success(recordlist);
            }else {
                return Result.valFailed("没有记录");
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("服务器错误");

        }

    }

    @PostMapping("/updatecancel")
    public Result<List<RecordDTO>> updateRecordCancel(@RequestBody Map<String,Object> json){
        Integer uid = (Integer) json.get("uid");
        String canceltext = (String) json.get("text");
        Integer yid = (Integer) json.get("yid");
        System.out.println(uid+canceltext+yid);
        Integer ctext = yyrecordService.updateYonCtext(canceltext, yid);
        List<RecordDTO> recordlist = yyrecordService.getrecordByUid(uid);
        if(ctext ==1){
            return Result.success(recordlist);
        }
        return Result.failed("服务器错误");
    }
}
