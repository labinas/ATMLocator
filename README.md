# ATMLocator
## Краток опис за апликацијата
ATMLocator е едноставна, функционална и корисна апликација која наоѓа голема примена во секојдневниот живот. Главната цел на оваа апликација е да ги прикажува локациите на сите банкомати во рамките на нашиот главен град Скопје. Преку интерактивна мапа, корисниците може да ја дознаат точната локација на сите банкомати од секоја банка, како и подетални информации за нив. Апликацијата црпи информации за секој од банкоматите од open source базата на OpenStreetMap. Доколку на корисникот му е потребна некоја информација за одреден банкомат, наместо да губи време со скролање низ листата, може едноставно да го најде податокот со пребарување низ неа или пак со филтрирање на истата. Покрај тоа, креирани се и други функционалности како можноста за подредување на банкоматите според азбучен ред, оставање на рецензија за состојбата на банкоматот и можност за зачувување на одредени банкомати во персонална листа.
test commit push

ushte eden proben push
pushhhhhhhhh


## Опис на проектот
Проект по курсот Дизајн и архитектура на софтвер. Главната цел на оваа задача беше да се научи процесот на создавање на една апликација, односно осмислувањето и креирањето на потребната софтверска архитектура, како и целиот процес на развивање на логиката на апликацијата. Серверскиот дел е развиен во Java Spring Boot, со користење на MVC шаблон. Обезбедена е и автентикација и авторизација со помош на Spring Security. Поради барањето на задачата, серверскиот дел е изработен со монолитна, како и со микросервисна архитектура. Монолитната апликација се служи со една главна база, која е контејнеризирана во Docker. Базата се полни со податоци со помош на SQL скрипти, кои се мигрираат преку Flyway. Клиентскиот дел на монолитот е изработен со користење на Thymeleaf server rendering. Микросервисната апликација е поделена во четири главни сервиси кои комуницираат меѓусебно преку API gateway. Постои сервис за банкоматите и релевантните податоци околу нив, сервис за корисниците, сервис за рецензии, како и сервис за автентикација и авторизација преку JWT. Секој од нив има своја база исто така контејнеризирана во Docker. Сите овие сервиси, како и API gateway, се регистрирани како клиенти на еден Eureka сервер. Клиентскиот дел за микросервисите е развиен со JavaScript.

## Инсталација и стартување
За да се користи оваа апликација, потребно е да имате Docker инсталирано на својата машина. Во фолдерот Homework3 се наоѓа монолитната верзија, а во фолдерот Homework4 се наоѓа микросервисната верзија. За да се стартува базата за оваа апликација потребно е во фолдерот на истата да се изврши командата: 
```docker-compose -f .\docker-compose.yml up -d```

## Изглед на апликацијата 
![alt text](https://i.ibb.co/N270Gz2/atmhome.png)
![alt text](https://i.ibb.co/CH8f8rC/atmlist.png)
![alt text](https://i.ibb.co/k6Yn2Nt/atmmap.png)

## Линк
https://atmlocator.herokuapp.com/
