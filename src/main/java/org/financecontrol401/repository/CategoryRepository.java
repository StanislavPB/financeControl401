package org.financecontrol401.repository;


import org.financecontrol401.entity.Category;
import org.financecontrol401.entity.TransactionType;

import java.util.*;

public class CategoryRepository {
    private List<Category> categories;

    public CategoryRepository() {
        this.categories = new ArrayList<>();
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public List<Category> getCategories() {
        return categories;
    }


    public List<Category> getCategoryByType(Integer categoryType) {
        List<Category> findCategories = new ArrayList<>();
        for (Category category : categories) {
            if (category.getCategoryType().equals(categoryType)) {
                findCategories.add(category);

            }
        }
        return findCategories;
    }




    // Метод для ввода новой категории с указанием типа (INCOME или EXPENSE)
    public static void inputCategory(Map<String, TransactionType> categoryTypes) {
        Scanner scanner = new Scanner(System.in);
        // Добавляем предопределенные категории
        categoryTypes.put("Зарплата", TransactionType.INCOME);
        categoryTypes.put("Депозиты", TransactionType.INCOME);
        categoryTypes.put("Недвижимость", TransactionType.INCOME);
        categoryTypes.put("Продукты", TransactionType.EXPENSE);
        categoryTypes.put("Транспорт", TransactionType.EXPENSE);
        categoryTypes.put("Досуг", TransactionType.EXPENSE);
        categoryTypes.put("Одежда", TransactionType.EXPENSE);
        categoryTypes.put("Комунальные услуги", TransactionType.EXPENSE);
        categoryTypes.put("Аренда", TransactionType.EXPENSE);
        categoryTypes.put("Здоровье", TransactionType.EXPENSE);


        System.out.println("Введите название новой категории:");
        String categoryName = scanner.nextLine();

        // Проверяем, существует ли уже такая категория
        if (categoryTypes.containsKey(categoryName)) {
            System.out.println("Категория с таким названием уже существует.");
            return;
        }

        System.out.println("Введите тип категории (INCOME или EXPENSE):");
        String typeStr = scanner.nextLine();
        TransactionType type = TransactionType.valueOf(typeStr);

        // Добавляем категорию в Map
        categoryTypes.put(categoryName, type);

        System.out.println("Категория " + categoryName + " успешно добавлена.");
    }


    // Метод для разделения категорий на два типа: INCOME и EXPENSE
    public static Map<TransactionType, List<String>> categorizeCategories(List<String> categories, Map<String, TransactionType> categoryTypes) {
        Map<TransactionType, List<String>> categorizedCategories = new HashMap<>();

        // Инициализация списков категорий для типов INCOME и EXPENSE
        categorizedCategories.put(TransactionType.INCOME, new ArrayList<>());
        categorizedCategories.put(TransactionType.EXPENSE, new ArrayList<>());

        // Проходимся по всем категориям
        for (String category : categories) {
            // Получаем тип категории по ее названию из переданной Map
            TransactionType type = categoryTypes.get(category);
            // Если тип не найден или неверный, игнорируем эту категорию
            if (type == null) {
                continue;
            }
            // Проверяем, не содержит ли категория уже в списке
            if (categorizedCategories.get(type).contains(category)) {
                System.out.println("Категория " + category + " уже присутствует в списке.");
                continue;
            }
            // Добавляем категорию в соответствующий список в Map
            categorizedCategories.get(type).add(category);
        }

        return categorizedCategories;
    }




    public Optional<Category> findByCategory(String categoryName) {

        for (Category category : categories) {
            if (category.getCategoryName().equals(categoryName)) {
                return Optional.of(category);
            }
        }
        return Optional.empty();
    }
}


