package com.restaran.restaran.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "faq")
public class FaqModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long faq_id;

    @NotEmpty(message = "name не может быть пустым")
    @Size(min=2, message="name не может быть короче 2 символов")
    private String text_answer;

    @NotEmpty(message = "name не может быть пустым")
    @Size(min=2, message="name не может быть короче 2 символов")
    private String text_request;

    @NotEmpty(message = "name не может быть пустым")
    @Size(min=2, message="name не может быть короче 2 символов")
    private String theme;

    public long getFaq_id() {
        return faq_id;
    }

    public void setFaq_id(long faq_id) {
        this.faq_id = faq_id;
    }

    public String getText_answer() {
        return text_answer;
    }

    public void setText_answer(String text_answer) {
        this.text_answer = text_answer;
    }

    public String getText_request() {
        return text_request;
    }

    public void setText_request(String text_request) {
        this.text_request = text_request;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FaqModel faqEquals = (FaqModel) o;
        return faq_id == faqEquals.faq_id &&
                faqEquals.text_answer.equals(faqEquals.text_answer);
    }

    @Override
    public int hashCode() {
        return (int) faq_id * text_answer.hashCode() * text_request.hashCode() * theme.hashCode();
    }
}
