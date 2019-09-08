package com.wallet.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "transaction", schema = "java_task")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false , unique = true)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Getter(onMethod = @__(@NotNull))
    @Column(name = "date_time")
    private LocalDate date_time;

    @JsonIgnore
    @Getter(onMethod = @__(@NotNull))
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Getter(onMethod = @__(@NotNull))
    @Column(name = "user_id", insertable = false, updatable = false)
    private Long user_id;

    @Column(name = "ammount")
    private int ammount;

    @Column(name = "comment")
    private String comment;


    @JsonIgnore
    @Getter(onMethod = @__(@NotNull))
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transaction_id", referencedColumnName = "id", nullable = false)
    private TypeTransaction typeTransaction;

    @Getter(onMethod = @__(@NotNull))
    @Column(name = "transaction_id", insertable = false, updatable = false)
    private Long transaction_id;

}
