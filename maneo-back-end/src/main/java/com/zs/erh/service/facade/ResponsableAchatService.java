package com.zs.erh.service.facade;

import com.zs.erh.bean.ResponsableAchat;
import com.zs.erh.service.vo.ResponsableAchatVo;


import java.util.List;
import java.util.Optional;

public interface ResponsableAchatService {
    ResponsableAchat save(ResponsableAchat ResponsableAchat);
    List<ResponsableAchat> search(ResponsableAchatVo responsableAchatVO);
    int deleteByCode(String code);
    Optional<ResponsableAchat> findById(Long id);
    ResponsableAchat update(ResponsableAchat client);
    ResponsableAchat findByCode(String code);
    List<ResponsableAchat> findAll();
}
