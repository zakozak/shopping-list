package com.project.st3.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationTime;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private boolean bought = false;

    @ManyToOne
    @JoinColumn(name = "item_list_id")
    private ItemList itemListId;
}
