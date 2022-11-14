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
                    new Category("Dia ly", R.drawable.corn),
                    new Category("Lich su", R.drawable.corn),
                    new Category("Sinh hoc", R.drawable.corn),
                    new Category("Am nhac", R.drawable.corn),
                    new Category("My thuat", R.drawable.corn),
                    new Category("Cong nghe", R.drawable.corn)

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
