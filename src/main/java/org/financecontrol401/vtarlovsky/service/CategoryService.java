package org.financecontrol401.vtarlovsky.service;

import entity.Category;
import repository.CategoryRepository;

import java.io.*;

public class CategoryService {

    private final CategoryRepository categoryRepository;
   private String filePath;

    public CategoryService(CategoryRepository categoryRepository,
                           String filePath) throws IOException {
        this.categoryRepository = categoryRepository;
        this.filePath = filePath;
        this.loadCategoriesFromCSV();
    }
    public void loadCategoriesFromCSV() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(this.filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 2) {
                    String categoryName = parts[0].trim();
                    Integer categoryType = Integer.parseInt(parts[1].trim());
                    Category category = new Category(categoryName, categoryType);
                    categoryRepository.addCategory(category);
                }
            }
        }
    }


        public void addCategory(Category category) {
            categoryRepository.addCategory(category);
            saveToCsv();
        }

        private void saveToCsv() {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                for (Category category : categoryRepository.findAll()) {
                    String csvLine = category.getCategoryName() + ";" + category.getCategoryType() + "\n";
                    writer.write(csvLine);
                }
            } catch (IOException e) {
                e.printStackTrace(); // Обработка ошибок записи в файл
            }
        }




    }




