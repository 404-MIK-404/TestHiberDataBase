package com.hiberdata.databasehiber.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "test_spr")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TEST_SPR {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name_test")
    private String nameTest;

}
