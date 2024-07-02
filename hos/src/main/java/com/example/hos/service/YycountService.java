package com.example.hos.service;

import com.example.hos.entity.Yycount;
import com.example.hos.vo.HpmidDTO;
import com.example.hos.vo.YycountDTO;

import java.util.List;

public interface YycountService {
    public Yycount getYycountByyyid(Integer yyid);
    public HpmidDTO getHidAndPmid(Integer yyid);
    public List<YycountDTO> getDocCount(Integer did);
}
