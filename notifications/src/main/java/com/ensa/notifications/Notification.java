package com.ensa.notifications;

import jakarta.persistence.*;
import lombok.*;

@Table
@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String clientId;
    private String message;
}
