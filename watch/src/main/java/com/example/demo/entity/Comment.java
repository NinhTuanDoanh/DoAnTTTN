package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Columns;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcomment;
    @Column(name="content")
    private String content;
    @Column(name="create_at")
    private LocalDateTime createat;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "users_comment")
    private Users users;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="product_commnet")
    private Products products;

}
