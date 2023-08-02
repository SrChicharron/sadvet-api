package com.dtaem.sadvet.service;
import com.dtaem.sadvet.model.bean.EmailDetailsBean;

public interface EmailService {

    String sendSimpleMail(EmailDetailsBean details);

    String sendMailWithAttachment(EmailDetailsBean details);
}