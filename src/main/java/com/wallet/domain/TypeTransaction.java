package com.wallet.domain;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "type", schema = "java_task")
public class TypeTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false , unique = true)
    private Long id;

    //@Getter(onMethod = @__(@NotNull))
    @Column(name = "type_name", nullable = false)
    private String name;
}
