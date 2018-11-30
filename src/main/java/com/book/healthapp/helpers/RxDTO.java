package com.book.healthapp.helpers;

import lombok.Data;

@Data
public class RxDTO {
    private String patientId;
    private String patientName;
    private String symptoms;
    private String medicine;
}
