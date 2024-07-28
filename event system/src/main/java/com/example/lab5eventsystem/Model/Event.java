package com.example.lab5eventsystem.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Event {
    private int id;
    private String description;
    private int capacity;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
