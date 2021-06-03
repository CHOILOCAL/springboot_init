package com.damdeeng.tour.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AppError {

    private String message;
    private String reason;

}
