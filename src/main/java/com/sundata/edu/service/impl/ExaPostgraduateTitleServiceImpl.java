package com.sundata.edu.service.impl;


import com.sundata.edu.dao.ExaPostgraduteMapper;
import com.sundata.edu.domain.ExaPostgraduateTitle;
import com.sundata.edu.service.ExaPostgraduateTitleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  服务层实现
 * 
 * @author zz
 * @date 2021-11-30 11:54:15
 */
@Service("exaPostgraduateTitleService")
//@Transactional
public class ExaPostgraduateTitleServiceImpl  implements ExaPostgraduateTitleService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private ExaPostgraduteMapper exaPostgraduteMapper;


    @Override
    public List<ExaPostgraduateTitle> selectExaPostgraduateTitleList (ExaPostgraduateTitle exaPostgraduateTitle){

        return exaPostgraduteMapper.selectExaPostgraduateTitleList(exaPostgraduateTitle);
    }

    /**
     * 修改教师资格证考试名称修改
     *
     * @param exaPostgraduateTitle 教师资格证考试名称修改
     * @return 结果
     */
    @Override
    public int updateExaPostgraduateTitle(ExaPostgraduateTitle exaPostgraduateTitle)
    {
        return exaPostgraduteMapper.updateExaPostgraduateTitle(exaPostgraduateTitle);
    }

}
