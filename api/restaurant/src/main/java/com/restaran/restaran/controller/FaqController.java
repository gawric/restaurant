package com.restaran.restaran.controller;

import com.restaran.restaran.model.FaqModel;
import com.restaran.restaran.model.UserModel;
import com.restaran.restaran.service.serviceinterface.IServiceFaq;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("faq-rest")
public class FaqController {

   @Autowired
   private IServiceFaq serviceFaq;


    @PostMapping(path  = "/addFaq" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addFaq(@Valid @RequestBody FaqModel faqModel) {
        return serviceFaq.addFaqWeb(faqModel);
    }

    @GetMapping(value = "/getThemeFaq")
    public ResponseEntity<Object> getThemeFaq(@RequestParam String themeName ) {
        return serviceFaq.findByThemeWeb(themeName);
    }
    //25 записей на одной странице
    @GetMapping(value = "/getThemeFaqPages")
    public ResponseEntity<Object> getThemeFaqPages(@RequestParam String themeName , @RequestParam int pages ) {
        return serviceFaq.findByThemeWebPages( themeName ,  pages);
    }


    @GetMapping(value = "/delFaqId")
    public ResponseEntity<Object> delFaqId(@RequestParam long id) {
        return serviceFaq.delFaqWeb(id);
    }


    @GetMapping(value = "/delFaqTheme")
    public ResponseEntity<Object> delFaqTheme(@RequestParam String themeName) {
        return serviceFaq.delFaqThemeWeb(themeName);
    }



    @PostMapping(path  = "/updFaq" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object>  updateUser(@Valid @RequestBody FaqModel fModel) {
        return serviceFaq.updFaqWeb(fModel);
    }

}
