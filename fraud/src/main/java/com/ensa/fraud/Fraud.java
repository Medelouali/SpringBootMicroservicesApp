package com.ensa.fraud;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Builder()
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Fraud {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private boolean isFraudulent;
}
