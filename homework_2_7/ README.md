Реализовано небольшое консольное приложение «Учёт студентов». 
Интерфейс консольного приложения реализован с помощью стартера Spring Shell. 
Сущность «Студент» представляет из себя идентификатор (id), имя (firstName), 
фамилию (lastName) и возраст (age). Id студента генирируется автоматически.

Приложение умеет:

1.Выводить всех имеющихся студентов в произвольном формате.
2.Добавлять нового студента. Команда на добавление принимает три поля: firstName, lastName и age. 
Идентификатор (id) студента генерируется при сохранении.
3.Удалять студента по идентификатору (id).
4.Полностью очищать список студентов.
5.Реагировать на события создания и удаления студента. 
При создании выводится в консоль информацию о созданном клиенте, а при удалении — идентификатор удалённого клиента.
6.Есть возможность создавать студентов при старте приложения. 
Эта функция конфигурируется в файле application.properties.По умолчанию она выключена.
7. Есть возможность запускать приложение в докер-контейнере.
--Запуск приложения через докер-контейнер с включенной настройкой осуществляется с помощью команды:
docker run --rm -e SWITCHABLE_LISTENER=true -i homework_2_7
--Запуск приложения через докер-контейнер с выключенной настройкой осуществляется с помощью команды:
docker run --rm -e SWITCHABLE_LISTENER=false -i homework_2_7
