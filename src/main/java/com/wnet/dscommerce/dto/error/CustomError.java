package com.wnet.dscommerce.dto.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor
public class CustomError {
        private Instant timestamp;
        private Integer status;
        private String error;
        private String path;
}
