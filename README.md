Создание сайта с выводом баннеров, редактирование через залогиневшегося пользователя.
	- главная страница : переход на страницу авторизации пользователя (если пользователять не авторизирован),вывод линка выхода из аккаунта и перехода в кабинен редактирования баннеров пользователя в виде ника пользователя (если пользователь авторизирован), вывод линков на страцу пользователя с добавленными баннерами.
	- страница баннеров пользователя : ссылка на главную страницу, вывод баннеров данного пользователя.
	- страница авторизации : авторизация пользователя и "запомнить меня", форма создания пользователя (логин [unique], пароль, ник).
	- страница авторизированного пользователя : возможность добавить баннер, удалить, изменить (отображаются на странице пользователя).

Используемые компоненнты: Java 8, Spring MVC, Spring Security, Spring Data, JSTL, Apache Tomcat 6, сборщик (Ant либо Maven), MariaDB.
