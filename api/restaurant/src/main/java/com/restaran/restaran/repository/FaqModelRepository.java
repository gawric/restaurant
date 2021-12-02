package com.restaran.restaran.repository;


import com.restaran.restaran.model.DishesModel;
import com.restaran.restaran.model.FaqModel;
import com.restaran.restaran.model.UserModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaqModelRepository extends CrudRepository<FaqModel, Long> {

    @Query("select p from FaqModel p where theme = ?1")
    List<FaqModel> findTheme(String theme);

    @Query("select count(p) = 1 from FaqModel p where faq_id = ?1")
    boolean findExistByFaqId(long id);

    @Query("select p from FaqModel p where faq_id = ?1")
    FaqModel findByFaqId(long faq_id);

    @Query("select count(p) = 1 from FaqModel p where text_request = ?1")
    boolean findExistByRequest(String request);

    @Query(value = "SELECT * FROM faq WHERE theme=?1 ORDER BY faq_id LIMIT ?2 OFFSET ?3" , nativeQuery = true)
    List<FaqModel> findByThemePages(String theme , int pages , int offset);

    @Query(value = "SELECT * FROM faq WHERE theme=?1 ORDER BY faq_id LIMIT ?2 " , nativeQuery = true)
    List<FaqModel> findByThemePagesFirst(String theme , int pages);

    @Modifying
    @Query(value = "delete from FaqModel p where p.theme = ?1")
    void deleteByTheme(String theme);
}
