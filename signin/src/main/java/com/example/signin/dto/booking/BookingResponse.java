package com.example.signin.dto.booking;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter@Setter
public class BookingResponse {
    private Integer id;
    private String status;
    private BigDecimal depositAmount;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
