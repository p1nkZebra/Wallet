package com.wallet.domain;

import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "user", schema = "java_task")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false , unique = true)
    private Long id;

    //@Getter(onMethod = @__(@NotNull))
    @Column(name = "user_name", nullable = false)
    private String name;
}
