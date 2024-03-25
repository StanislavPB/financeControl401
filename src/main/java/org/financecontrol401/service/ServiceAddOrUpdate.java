package org.financecontrol401.service;

import org.financecontrol401.dto.TransactionDto;
import org.financecontrol401.entity.Transaction;
import org.financecontrol401.repository.TransactionRepository;
//Импорт пакетов: На первых трех строках импортируются классы TransactionDto, Transaction, и TransactionRepository из соответствующих пакетов. Эти классы вероятно относятся к управлению транзакциями в финансовом приложении.
//
public class ServiceAddOrUpdate {

        // Сервис для добавления и обновления транзакций
        private final TransactionRepository transactionRepository;

        public ServiceAddOrUpdate(TransactionRepository transactionRepository) {
            this.transactionRepository = transactionRepository;
        }

        public void add(TransactionDto transactionDto) {
            // Валидация данных
            validateTransaction(transactionDto);

            // Преобразование DTO в Entity
            Transaction transaction;
            transaction = new Transaction();
            transaction.setDate(transactionDto.getDate());
            transaction.setType(transactionDto.getType());
            transaction.setCategory(transactionDto.getCategory());
            transaction.setAmount(transactionDto.getAmount());

            // Сохранение транзакции в базе данных
            transactionRepository.save(transaction);
        }

        public void update(Long id, TransactionDto transactionDto) {
            // Валидация данных
            validateTransaction(transactionDto);


            // Обновление данных транзакции
            Transaction transaction = new Transaction();
            transaction.setDate(transactionDto.getDate());
            transaction.setType(transactionDto.getType());
            transaction.setCategory(transactionDto.getCategory());
            transaction.setAmount(transactionDto.getAmount());

            // Сохранение обновленной транзакции
            transactionRepository.save(transaction);
        }

        private void validateTransaction(TransactionDto transactionDto) {
            // TODO: Реализация валидации
        }
}

//Объявление класса ServiceAddOrUpdate: Этот класс отвечает за добавление и обновление транзакций в базе данных.
//
//Поля класса: Единственное поле класса - transactionRepository, представляет репозиторий транзакций, скорее всего используется для сохранения и получения транзакций из базы данных.
//
//Конструктор класса: Конструктор принимает TransactionRepository в качестве параметра и инициализирует поле transactionRepository значением этого параметра.
//
//Метод add: Этот метод принимает объект TransactionDto, который, вероятно, представляет данные новой транзакции. Внутри метода данные из TransactionDto преобразуются в объект Transaction (вероятно, представление транзакции в базе данных), и затем этот объект сохраняется в базе данных через transactionRepository.
//
//Метод update: Этот метод принимает идентификатор транзакции id и объект TransactionDto, который, вероятно, содержит обновленные данные транзакции. В методе данные из TransactionDto также преобразуются в объект Transaction, и затем этот объект обновляет существующую транзакцию с соответствующим id в базе данных через transactionRepository.
//
//Метод validateTransaction: Этот метод, вероятно, должен проводить валидацию данных перед сохранением или обновлением транзакции. В настоящее время его реализация отсутствует (// TODO: Реализация валидации), но обычно здесь встречается проверка на корректность данных, например, наличие даты, типа, категории и суммы транзакции.