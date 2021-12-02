package com.restaran.restaran.service.serviceinterface.dbinterface;

import com.restaran.restaran.model.DishesModel;
import com.restaran.restaran.model.FaqModel;

import java.util.List;

public interface IServiceFaqDb {

    List<FaqModel> findByTheme(String themeName);
    FaqModel findByFaqId(long faq_id);
    boolean findByExistsFaqId(long faq_id);
    boolean saveFaq(FaqModel fModel);
    boolean findExistByRequest(String request);
    List<FaqModel> findByThemePages(String theme , int pages , int offset);
    boolean deleteById(long faq_id);
    boolean deleteByTheme(String theme);
}
