package com.example.bap_quizzzz;

import java.util.ArrayList;
import java.util.Arrays;

public class Category {
    private String categoryName;
    private int categoryImage;

    public Category(String categoryName, int categoryImage) {
        this.categoryName = categoryName;
        this.categoryImage = categoryImage;
    }

    public static ArrayList<Category> list = new ArrayList<>(
            Arrays.asList(
                    new Category("Toán học", R.drawable.math),
                    new Category("Music", R.drawable.music),
                    new Category("Công nghệ", R.drawable.technology),
                    new Category("Điện ảnh", R.drawable.film),
                    new Category("Game", R.drawable.game),
                    new Category("Bóng đá", R.drawable.football),

                    new Category("Kpop", R.drawable.kpop),
                    new Category("Lịch sử", R.drawable.history),
                    new Category("Sinh học", R.drawable.biology),
                    new Category("Động vật", R.drawable.animal),
                    new Category("Mỹ thuật", R.drawable.art),
                    new Category("Địa lý", R.drawable.geography)

            )
    );

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
