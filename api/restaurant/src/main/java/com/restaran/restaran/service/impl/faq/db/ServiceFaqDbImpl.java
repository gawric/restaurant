package com.restaran.restaran.service.impl.faq.db;


import com.restaran.restaran.model.FaqModel;
import com.restaran.restaran.repository.FaqModelRepository;
import com.restaran.restaran.service.serviceinterface.dbinterface.IServiceFaqDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("IServiceFaqDb")
public class ServiceFaqDbImpl implements IServiceFaqDb {

    @Autowired
    private FaqModelRepository fmRepository;

    @Override
    public List<FaqModel> findByTheme(String theme) {
        return fmRepository.findTheme(theme);
    }

    @Transactional(readOnly = true)
    @Override
    public FaqModel findByFaqId(long faq_id) {
        return fmRepository.findByFaqId(faq_id);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean findByExistsFaqId(long faq_id) {
        return fmRepository.findExistByFaqId(faq_id);
    }

    @Override
    public boolean saveFaq(FaqModel fModel) {
        if(fModel != null)
        {
            fmRepository.save(fModel);
            return true;
        }

        return false;
    }

    @Transactional(readOnly = true)
    @Override
    public boolean findExistByRequest(String request) {
        return fmRepository.findExistByRequest(request);
    }

    @Transactional(readOnly = true)
    @Override
    public List<FaqModel> findByThemePages(String theme, int pages , int rows) {
        //нужная страница * на сколько записей влазиет на страницу
        int allRows = pages * rows;

        if(allRows != rows)
        {
            int currentRows = allRows - rows;

            return fmRepository.findByThemePages(theme , rows , currentRows);
        }
        else {
            return fmRepository.findByThemePagesFirst(theme , rows);
        }


    }

    @Override
    public boolean deleteById(long faq_id) {
        try
        {
            fmRepository.deleteById(faq_id);
            return true;
        }catch (org.springframework.dao.EmptyResultDataAccessException ex)
        {
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean deleteByTheme(String theme) {


        try
        {
            fmRepository.deleteByTheme(theme);
            return true;
        }catch (org.springframework.dao.EmptyResultDataAccessException ex)
        {
            ex.printStackTrace();
            return false;
        }
    }
}
