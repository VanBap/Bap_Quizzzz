package com.example.bap_quizzzz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Category implements Serializable { // truyen bundle
    private String categoryName;
    private int categoryImage;
    private int categoryID;

    public Category() {
    }

    public Category(String categoryName, int categoryImage, int categoryID) {
        this.categoryName = categoryName;
        this.categoryImage = categoryImage;
        this.categoryID = categoryID;
    }

    public static ArrayList<Category> list = new ArrayList<>(
            Arrays.asList(
                    new Category("Toán học", R.drawable.math, 0),
                    new Category("Điện ảnh", R.drawable.film,1),
                    new Category("Công nghệ", R.drawable.technology,2),

                    new Category("Music", R.drawable.music,3),
                    new Category("Game", R.drawable.game,4),
                    new Category("Bóng đá", R.drawable.football,5),

                    new Category("Kpop", R.drawable.kpop,6),
                    new Category("Lịch sử", R.drawable.history,7),
                    new Category("Sinh học", R.drawable.biology,8),
                    new Category("Động vật", R.drawable.animal,9),
                    new Category("Mỹ thuật", R.drawable.art,10),
                    new Category("Địa lý", R.drawable.geography,11)

            )
    );
    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(int categoryImage) {
        this.categoryImage = categoryImage;
    }
}
