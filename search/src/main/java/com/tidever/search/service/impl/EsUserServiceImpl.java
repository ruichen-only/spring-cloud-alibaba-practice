package com.tidever.search.service.impl;

import com.tidever.search.dao.EsUserDao;
import com.tidever.search.domain.EsUser;
import com.tidever.search.repository.EsUserRepository;
import com.tidever.search.service.EsUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Visit业务实现类
 *
 * @author LiuXin on 2021/11/25
 */
@Service
public class EsUserServiceImpl implements EsUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EsUserServiceImpl.class);
    @Autowired
    private EsUserDao userDao;
    @Autowired
    private EsUserRepository userRepository;

    @Override
    public int importAll() {
        List<EsUser> esUserList = userDao.getAllEsUserList(null);
        Iterator<EsUser> iterator = userRepository.saveAll(esUserList).iterator();
        int result = 0;
        while (iterator.hasNext()) {
            result++;
            iterator.next();
        }
        return result;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void delete(List<Long> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            List<EsUser> esVisitList = new ArrayList<>();
            for (Long id : ids) {
                EsUser esVisit = new EsUser();
                esVisit.setId(id);
                esVisitList.add(esVisit);
            }
            userRepository.deleteAll(esVisitList);
        }
    }

    @Override
    public EsUser create(Long id) {
        EsUser result = null;
        List<EsUser> esVisitList = userDao.getAllEsUserList(id);
        if (!esVisitList.isEmpty()) {
            EsUser esVisit = esVisitList.get(0);
            result = userRepository.save(esVisit);
        }
        return result;
    }

    @Override
    public Page<EsUser> search(String username, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return userRepository.findByUsername(username, pageable);
    }
}
