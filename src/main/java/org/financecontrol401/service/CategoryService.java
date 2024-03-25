package org.financecontrol401.service;

import org.financecontrol401.entity.Category;
import org.financecontrol401.entity.TransactionType;
import org.financecontrol401.repository.CategoryRepository;

import java.io.*;
import java.util.List;

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
                    TransactionType type;
                    if (categoryType==1) {
                        type = TransactionType.INCOME;
                    } else if (categoryType==2) {
                        type = TransactionType.EXPENSE;
                    } else {
                        // Обработка ошибки при неверном значении типа транзакции
                        System.err.println("Ошибка при чтении файла CSV: Неверное значение типа транзакции");
                        continue; // Пропускаем эту строку и переходим к следующей
                    }
                    Category category = new Category(categoryName, type);
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

    public List<Category> findByType(TransactionType operationType) {
        return categoryRepository.findByType(operationType);
    }



    }




