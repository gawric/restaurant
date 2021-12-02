package com.restaran.restaran.service.impl.faq;


import com.restaran.restaran.exception.IncorrectUserNameException;
import com.restaran.restaran.exception.NotFoundUserException;
import com.restaran.restaran.model.DishesModel;
import com.restaran.restaran.model.FaqModel;
import com.restaran.restaran.model.UserModel;
import com.restaran.restaran.service.serviceinterface.IServiceFaq;
import com.restaran.restaran.service.serviceinterface.dbinterface.IServiceDishesDb;
import com.restaran.restaran.service.serviceinterface.dbinterface.IServiceFaqDb;
import com.restaran.restaran.variable.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("IServiceFaq)")
public class ServiceFaq implements IServiceFaq {

    //работа с базой
    @Autowired
    private IServiceFaqDb serviceFaqDb;
    private final int rowsPages = 25;

    @Override
    public ResponseEntity<Object> addFaqWeb(FaqModel newFaq) {
        try
        {
            sNull(newFaq);
            if(serviceFaqDb.findExistByRequest(newFaq.getText_request())) throw new IncorrectUserNameException("Request already in use");
            if(serviceFaqDb.saveFaq(newFaq))return new ResponseEntity(HttpStatus.OK);
        }
        catch (IncorrectUserNameException e)
        {
            e.printStackTrace();
            return ErrorMessage.getResponceError("Faq already in use");
        }
        catch (NotFoundUserException ex)
        {
            ex.printStackTrace();
            return ErrorMessage.getResponceError("Faq not found");
        }


        return ErrorMessage.getResponceError("Unknown error");
    }

    @Override
    public ResponseEntity<Object> updFaqWeb(FaqModel fmodel) {
        try
        {
            //если мы передали null значение
            sNull(fmodel);
            if(serviceFaqDb.findByExistsFaqId(fmodel.getFaq_id()) == false)throw new NotFoundUserException("faqModel  not found ");

            serviceFaqDb.saveFaq(fmodel);
            return new ResponseEntity<>("Faq "+fmodel.getFaq_id()+" update to db", HttpStatus.OK);
        }
        catch (NotFoundUserException ex)
        {
            ex.printStackTrace();
            return ErrorMessage.getResponceErrorHttpStatus("Not found Faq exception", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Object> delFaqWeb(long faq_id) {
        try{

            if(!serviceFaqDb.deleteById(faq_id))
            {
                throw new NotFoundUserException("Not found faq:  "+faq_id+" exception");
            }
        }
        catch(NotFoundUserException ex){
            ex.printStackTrace();
            return ErrorMessage.getResponceErrorHttpStatus("Not found faq exception", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("faq  delete succes", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> delFaqThemeWeb(String themeName) {
        try{

            if(!serviceFaqDb.deleteByTheme(themeName))
            {
                throw new NotFoundUserException("Not found faq theme:  "+themeName+" exception");
            }
        }
        catch(NotFoundUserException ex){
            ex.printStackTrace();
            return ErrorMessage.getResponceErrorHttpStatus("Not found faq theme exception", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("faq theme  delete succes", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> findByIdWeb(long dishes_id) {
        return null;
    }

    @Override
    public ResponseEntity<Object> findByThemeWeb(String themeName) {
        try
        {
            List<FaqModel> fModelList = serviceFaqDb.findByTheme(themeName);
            sNullList(fModelList);
            return new ResponseEntity<>(fModelList, HttpStatus.OK);
        }catch (NotFoundUserException ex)
        {
            ex.printStackTrace();
            return ErrorMessage.getResponceErrorHttpStatus("Not found Theme exception", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Object> findByThemeWebPages(String themeName, int pages) {
        try
        {
            List<FaqModel> listPages = serviceFaqDb.findByThemePages(themeName , pages , rowsPages);
            sNullList(listPages);
            return new ResponseEntity<>(listPages, HttpStatus.OK);
        }catch (NotFoundUserException ex)
        {
            ex.printStackTrace();
            return ErrorMessage.getResponceErrorHttpStatus("Not found Theme exception", HttpStatus.NOT_FOUND);
        }
    }


    private void sNull(FaqModel faqModel) throws NotFoundUserException {
        if(faqModel == null) throw new NotFoundUserException("faqModel  not defined");
    }

    private void sNullList(List<FaqModel> faqModel) throws NotFoundUserException {
        if(faqModel == null) throw new NotFoundUserException("Theme  not defined");
    }

}
