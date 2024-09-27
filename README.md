# Library-Task

#### Simple REST Api web-app for save books
#### Stack: Kotlin, Spring Boot, H2

### Описание проекта

Это простое web-приложение на Kotlin для хранения книг и взаимодействия с ними
с помощью HTTP-запросов

Реализовано 8 endpoint-ов
```
GET    /books                        -Запрос на вывод всех книг
POST   /books                        -Помещение книги в библиотеку
GET    /books/{id}                   -Поиск книги по id
PUT    /books                        -Обновление записи книги
DELETE /books/{id}                   -Удаление книги
GET    /books/author/{author}        -Нахождение всех книг автора
GET    /books/title/{title}          -Нахождение всех книг по названию
PATCH  /books/rating/{newRating}     -Обновление рейтинга
```

Таблица имеет следующие поля:
```
id          -Первичный ключ
author      -Автор
title       -Название книги(обязательно к заполнению)
rating      -Рейтинг(от 0 до 10)
description -Описание
```

Пример создания записи. Прошу заметить, id указывать не нужно
```
{
 author: "Dostoevsky"
 title: "White Nights"
 rating: 10
 description: "Its a good"
}
```

Также был реализован scheduler, который раз в 10 секунд удаляет записи с рейтингом равным нулю

В файле application.yml можно изменить время срабатывания scheduler-а

В файле application.properties можно закомментировать настройки для выведения логов SQL\Hibernate
