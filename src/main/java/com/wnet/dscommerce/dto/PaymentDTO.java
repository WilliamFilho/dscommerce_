package com.wnet.dscommerce.dto;

import com.wnet.dscommerce.entities.Payment;
import lombok.Data;

import java.time.Instant;
@Data
public class PaymentDTO {
    private Long id;
    private Instant moment;

    public PaymentDTO(Payment payment){
        id = payment.getId();
        moment = payment.getMoment();
    }
}
