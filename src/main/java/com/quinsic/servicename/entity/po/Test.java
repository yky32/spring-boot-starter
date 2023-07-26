package com.quinsic.servicename.entity.po;

import com.quinsic.core.entity.AuditEntity;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Builder
public class Test extends AuditEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String test;

    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private Object metadata;
}