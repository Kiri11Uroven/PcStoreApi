#**Описание проекта** 
---
Сервис для работы с базой данных интернет магазина.
---
## IDEA (для разработки)
Установка и запуск

Склонировать репозиторий: 'git clone https://github.com/Kiri11Uroven/PcStoreApi'
Открыть код в редакторе
Запустить проект

### Api docs
Swagger: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

http://localhost:8080/products Метод POST - используется для добавления нового товара в базу данных, данные передаются в формате JSON 
например:{
  "type": "hdd",
  "seriesNumber": 12345,
  "manufacturer": "Seagate",
  "price": 5500.99,
  "productProperties": "8tb"
}
http://localhost:8080/products/type/{type} Метод GET - используется для получения списка товаров по их типу(Hdd,Monitor,Pc..)

http://localhost:8080/products/products/id/{id} Метод GET - используется для получения конкретного товара по id

http://localhost:8080/products/products/id/{id} Метод PUT - используется для изменения товара по id, новые данные передаются в теле запроса в JSON формате
