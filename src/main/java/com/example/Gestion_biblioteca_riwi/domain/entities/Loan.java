package com.example.Gestion_biblioteca_riwi.domain.entities;

import com.example.Gestion_biblioteca_riwi.utils.enums.StatusLoan;
import com.example.Gestion_biblioteca_riwi.utils.enums.StatusReservation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "loan")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime loanDate;
    @Column(nullable = false)
    private LocalDateTime returnDate;
    @Column(nullable = false)
    private StatusLoan status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @PrePersist
    protected void onCreate() {
        this.loanDate = LocalDateTime.now();
    }
}
