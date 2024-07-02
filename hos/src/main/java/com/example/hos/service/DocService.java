package com.example.hos.service;

import com.example.hos.mapper.PmMapper;
import com.example.hos.vo.DocDTO;
import com.example.hos.vo.ListYy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface DocService {
    List<DocDTO> getAllDoc();

    ListYy getDoc(Integer hid, Integer pmid);
}
