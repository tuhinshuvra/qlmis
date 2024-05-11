package org.bd.quantum.qlmis.books;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bd.quantum.qlmis.author.Authors;
import org.bd.quantum.qlmis.publisher.Publishers;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "author")
    private Authors author;

    @ManyToOne
    @JoinColumn(name = "publisher")
    private Publishers publisher;

    private String details;
    private Integer page;
    private Integer price;
}