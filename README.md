# Calculator

## Запуск вручную

Чтобы посмотреть проект, нужно запустить несколько частей:
1. `mvn clean install` - Собираем весь проект целиком.
2. `cd backend && mvn jetty:run` - Запускаем серверную часть
3. `cd frontend && mvn jetty:run` - Запускаем клиентскую часть
4. Открываем в браузере http://localhost:8080
5. `cd frontend && mvn test -Pwith-integration-test` - Запускаем тест клиентской части

## Автозапуск

`./run.sh` Запускаем backend, запускаем frontend, открываем в chromium-browser http://localhost:9090.
Надеемся, что chromium-browser установлен...

`./stop.sh` Тихо убиваем все jetty:run процессы :(

`./test.sh` Запускаем backend, запускаем тесты на frontend
