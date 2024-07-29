package com.qlik.demo.java;

import org.springframework.data.annotation.Id;

public record TrainDocument(@Id String id, String destination) {
}
