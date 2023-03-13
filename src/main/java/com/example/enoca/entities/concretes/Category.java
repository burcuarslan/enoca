package com.example.enoca.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Category classı
 *
 * @Data : Lombok kütüphanesinin Data annotation'ı ile getter, setter, toString, equals ve hashCode methodları oluşturulur.
 * @Entity : Category class'ı veritabanı tablosu ile ilişkilendirilir.
 * @Table(name = "categories") : Category class'ı categories tablosu ile ilişkilendirilir.
 * @AllArgsConstructor : Tüm alanları parametre alan constructor oluşturur.
 * @NoArgsConstructor : Parametresiz constructor oluşturur.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
@Entity
public class Category {

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
     * @Column(name = "category_name") : categoryName değerinin veritabanındaki karşılığı
     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     * @OneToMany : Category class'ı ile ilişkilendirilen Product class'ı ile 1'e çok ilişki kurulur.
     * @JoinColumn(name = "category_id") : Product class'ı ile ilişkilendirilen category_id değerinin veritabanındaki karşılığı
     * @OneToMany(mappedBy = "category") : Category class'ı ile ilişkilendirilen Product class'ı ile ilişki kurulur.
     */
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}