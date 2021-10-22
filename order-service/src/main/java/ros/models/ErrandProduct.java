package ros.models;

import javax.persistence.*;

public class ErrandProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private Integer piece;

    @ManyToOne
    @JoinColumn(name="productId",nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name="errandId",nullable = false)
    private Errand errand;
}
