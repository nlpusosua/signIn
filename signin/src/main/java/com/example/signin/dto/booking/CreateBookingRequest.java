package com.example.signin.dto.booking;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
public class CreateBookingRequest {
    private Integer itemId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private  String notes;
}
