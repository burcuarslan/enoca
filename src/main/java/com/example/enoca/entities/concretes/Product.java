package com.example.enoca.entities.concretes;

import com.example.enoca.entities.concretes.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;

/**
 * Product classı
 * @Data : Lombok kütüphanesinin Data annotation'ı ile getter, setter, toString, equals ve hashCode methodları oluşturulur.
 * @Entity : Product class'ı veritabanı tablosu ile ilişkilendirilir.
 * @Table(name = "products") : Product class'ı products tablosu ile ilişkilendirilir.
 * @AllArgsConstructor : Tüm alanları parametre alan constructor oluşturur.
 * @NoArgsConstructor : Parametresiz constructor oluşturur.
 */

@Data
@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    /**
     * @Id : id değerini belirtir. Primary key olarak kullanılır.
     * @GeneratedValue(strategy = GenerationType.IDENTITY) : id değerini otomatik olarak arttırır.
     * @Column(name = "id") : id değerinin veritabanındaki karşılığı
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * @Column(name = "product_name") : productName değerinin veritabanındaki karşılığı
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * @Column(name = "unit_price") : unitPrice değerinin veritabanındaki karşılığı
     */
    @Column(name = "unit_price")
    private double unitPrice;

    /**
     * @Column(name = "units_in_stock") : unitsInStock değerinin veritabanındaki karşılığı
     */
    @Column(name = "units_in_stock")
    private int unitsInStock;

    /**
     * @Column(name = "quantity_per_unit") : quantityPerUnit değerinin veritabanındaki karşılığı
     */
    @Column(name = "quantity_per_unit")
    private int quantityPerUnit;

    /**
     * @ManyToOne : Çoklu veri ile tekli veri arasında ilişki kurar. Categori ile Product arasında ilişki kurulur.
     * @JoinColumn(name = "category_id") : category_id değerinin veritabanındaki karşılığı
     */
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "category_id")

    private Category category;
}
