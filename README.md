Gif Service - Сервис, который обращается к сервису курсов валют, и отдает gif в ответ.

Spring Boot 2 + Java 11, сборщик Gradle.

...................................................................

Сборка:

Генерация образа с Gradle:

./gradlew bootBuildImage

Подготовьте Docker-демона к работе и запустите контейнер:

docker run --name [имя контейнера] -d -p 8080:8080 [имя сгенерированного образа]