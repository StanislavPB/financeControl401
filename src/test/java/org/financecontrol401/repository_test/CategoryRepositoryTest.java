package org.financecontrol401.repository_test;

import org.financecontrol401.entity.Category;
import org.financecontrol401.entity.TransactionType;
import org.financecontrol401.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CategoryRepositoryTest {

    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        categoryRepository = new CategoryRepository();
    }

    @Test
    void addCategory() {
        // Создаем новую категорию
        Category category = new Category("Название категории", TransactionType.INCOME);
        // Добавляем ее в репозиторий
        categoryRepository.addCategory(category);
        // Проверяем, что она добавлена
        assertTrue(categoryRepository.getCategories().contains(category));
    }

    @Test
    void findByType() {
        // Создаем несколько категорий с разными типами
        Category category1 = new Category("1", TransactionType.INCOME);
        Category category2 = new Category("2", TransactionType.EXPENSE);
        categoryRepository.addCategory(category1);
        categoryRepository.addCategory(category2);

        // Ищем категории по типу
        List<Category> categoriesByType = categoryRepository.findByType(TransactionType.INCOME);

        // Проверяем, что возвращенные категории имеют правильный тип
        for (Category category : categoriesByType) {
            assertEquals(TransactionType.INCOME, category.getCategoryType());
        }
    }

    @Test
    void findByCategory() {
        // Создаем новую категорию и добавляем ее в репозиторий
        Category category = new Category("Название категории", TransactionType.INCOME);
        categoryRepository.addCategory(category);

        // Ищем категорию по имени
        Optional<Category> foundCategory = categoryRepository.findByCategory("Название категории");

        // Проверяем, что категория найдена
        assertTrue(foundCategory.isPresent());
        assertEquals("Название категории", foundCategory.get().getCategoryName());
    }

    @Test
    void findAll() {
        // Создаем несколько категорий и добавляем их в репозиторий
        Category category1 = new Category("1", TransactionType.INCOME);
        Category category2 = new Category("2", TransactionType.EXPENSE);
        categoryRepository.addCategory(category1);
        categoryRepository.addCategory(category2);

        // Получаем все категории из репозитория
        List<Category> allCategories = categoryRepository.findAll();

        // Проверяем, что количество категорий совпадает с ожидаемым
        assertEquals(2, allCategories.size());
    }
}
