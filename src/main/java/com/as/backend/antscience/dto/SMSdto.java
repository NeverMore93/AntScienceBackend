package com.as.backend.antscience.dto;

import lombok.Data;

@Data
public class SMSdto {
    private String status;
    private String send_id;
    private Integer fee;
    private String sms_credits;
    private String code;
    private String msg;
    private String transactional_sms_credits;
}
