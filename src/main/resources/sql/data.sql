use vaccination;

-- Vaccine table
insert into vaccine values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'Pfizer_BioNTech');
insert into vaccine values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'Moderna');
insert into vaccine values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'Johnson');
insert into vaccine values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'AstraZeneca');

-- Vaccination point
insert into vaccination_points values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'ТЦ "ACADEM City" вул. Академіка Палладіна, буд. 16');
insert into vaccination_points values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'БМ "Агромат" вул. Академіка Булаховського, буд. 4');
insert into vaccination_points values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'ТЦ "ART Mall" вул. Академіка Заболотного, буд. 37');
insert into vaccination_points values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'ТЦ "АЛАДДІН" вул. Михайла Гришка, буд. 3А');
insert into vaccination_points values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), '"Optimum busines center" вул. Полтавський шлях, буд. 56');
insert into vaccination_points values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'ТРЦ "Французький бульвар" вул. Академіка Павлова, буд. 44Б');
insert into vaccination_points values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'ТРЦ "Nikolsky" вул. Пушкінська, буд. 2');
insert into vaccination_points values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'ТРЦ "КАРАВАН" вул. Лугова, буд. 12');

-- Users

insert into user values ('MAIN_ADMIN', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'main.admin@gmail.com', 1, 'Микола', 'main.admin@gmail.com', 'Васильович', 'ROLE_MAIN_ADMIN', 'Малиновський', null);

insert into user values ('POINT_ADMIN', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'point1.admin@gmail.com', 1, 'Анатолій', 'point1.admin@gmail.com', 'Сергійович', 'ROLE_POINT_ADMIN', 'Хмельник', 1);
insert into user values ('POINT_ADMIN', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'point2.admin@gmail.com', 1, 'Микита', 'point2.admin@gmail.com', 'Іванович', 'ROLE_POINT_ADMIN', 'Озеров', 2);
insert into user values ('POINT_ADMIN', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'point3.admin@gmail.com', 1, 'Ірина', 'point3.admin@gmail.com', 'Максимівна', 'ROLE_POINT_ADMIN', 'Покровська', 3);
insert into user values ('POINT_ADMIN', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'point4.admin@gmail.com', 1, 'Андрій', 'point4.admin@gmail.com', 'Віталійович', 'ROLE_POINT_ADMIN', 'Огинський', 4);
insert into user values ('POINT_ADMIN', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'point5.admin@gmail.com', 1, 'Олексій', 'point5.admin@gmail.com', 'Андрійович', 'ROLE_POINT_ADMIN', 'Олейник', 5);
insert into user values ('POINT_ADMIN', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'point6.admin@gmail.com', 1, 'Марина', 'point6.admin@gmail.com', 'Олександрівна', 'ROLE_POINT_ADMIN', 'Шахова', 6);
insert into user values ('POINT_ADMIN', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'point7.admin@gmail.com', 1, 'Віталій', 'point7.admin@gmail.com', 'Олексійович', 'ROLE_POINT_ADMIN', 'Островський', 7);
insert into user values ('POINT_ADMIN', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'point8.admin@gmail.com', 1, 'Аліна', 'point8.admin@gmail.com', 'Михайлівна', 'ROLE_POINT_ADMIN', 'Таліян', 8);



insert into user values ('DOCTOR', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'drobenko@gmail.com', 1, 'Сергій', 'drobenko@gmail.com', 'Андрійович', 'ROLE_DOCTOR', 'Дробинко', 1);
insert into user values ('DOCTOR', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'perelygina@gmail.com', 1, 'Галина', 'perelygina@gmail.com', 'Олександрівна', 'ROLE_DOCTOR', 'Перелигіна', 1);
insert into user values ('DOCTOR', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'slisarchuk@gmail.com', 1, 'Віктор', 'slisarchuk@gmail.com', 'Васильович', 'ROLE_DOCTOR', 'Слісарчук', 1);

insert into user values ('DOCTOR', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'bacshev@gmail.com', 1, 'Андрій', 'bacshev@gmail.com', 'Олексійович', 'ROLE_DOCTOR', 'Бакшеєв', 2);
insert into user values ('DOCTOR', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'polishuk@gmail.com', 1, 'Василь', 'polishuk@gmail.com', 'Степанович', 'ROLE_DOCTOR', 'Поліщук', 2);
insert into user values ('DOCTOR', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'skakun@gmail.com', 1, 'Тетяна', 'skakun@gmail.com', 'Миколаївна', 'ROLE_DOCTOR', 'Скакун', 2);

insert into user values ('DOCTOR', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'labuk@gmail.com', 1, 'Інна', 'labuk@gmail.com', 'Анатоліївна', 'ROLE_DOCTOR', 'Лабик', 3);
insert into user values ('DOCTOR', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'shelyst@gmail.com', 1, 'Олена', 'shelyst@gmail.com', 'Миколаївна', 'ROLE_DOCTOR', 'Шелист', 3);
insert into user values ('DOCTOR', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'koval@gmail.com', 1, 'Сергій', 'koval@gmail.com', 'Сергійович', 'ROLE_DOCTOR', 'Коваль', 3);

insert into user values ('DOCTOR', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'svinoys@gmail.com', 1, 'Валентина', 'svinoys@gmail.com', 'Романівна', 'ROLE_DOCTOR', 'Свиноус', 4);
insert into user values ('DOCTOR', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'zabolothya@gmail.com', 1, 'Мирослава', 'zabolothya@gmail.com', 'Миколаївна', 'ROLE_DOCTOR', 'Заболотня', 4);
insert into user values ('DOCTOR', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'romanuk@gmail.com', 1, 'Тетяна', 'romanuk@gmail.com', 'Володимирівна', 'ROLE_DOCTOR', 'Романюк', 4);

insert into user values ('DOCTOR', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'yushkevich@gmail.com', 1, 'Наталія', 'yushkevich@gmail.com', 'Володимирівна', 'ROLE_DOCTOR', 'Юшкевич', 5);
insert into user values ('DOCTOR', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'sheiko@gmail.com', 1, 'Майя', 'sheiko@gmail.com', 'Миколаївна', 'ROLE_DOCTOR', 'Шейко', 5);
insert into user values ('DOCTOR', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'fedorchenko@gmail.com', 1, 'Юрій', 'fedorchenko@gmail.com', 'Володимирович', 'ROLE_DOCTOR', 'Федоренко', 5);

insert into user values ('DOCTOR', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'lyashko@gmail.com', 1, 'Валентин', 'lyashko@gmail.com', 'Володимирович', 'ROLE_DOCTOR', 'Ляшко', 6);
insert into user values ('DOCTOR', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'cimoh@gmail.com', 1, 'Тетяна', 'cimoh@gmail.com', 'Іванівна', 'ROLE_DOCTOR', 'Цімох', 6);
insert into user values ('DOCTOR', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'kulak@gmail.com', 1, 'Людмила', 'kulak@gmail.com', 'Василівна', 'ROLE_DOCTOR', 'Кулак', 6);

insert into user values ('DOCTOR', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'sovtus@gmail.com', 1, 'Василь', 'sovtus@gmail.com', 'Петрович', 'ROLE_DOCTOR', 'Совтус', 7);
insert into user values ('DOCTOR', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'gramotny@gmail.com', 1, 'Іван', 'gramotny@gmail.com', 'Михайлович', 'ROLE_DOCTOR', 'Грамотний', 7);
insert into user values ('DOCTOR', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'fedak@gmail.com', 1, 'Оксана', 'fedak@gmail.com', 'Вікторівна', 'ROLE_DOCTOR', 'Федак', 7);

insert into user values ('DOCTOR', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'kocuba@gmail.com', 1, 'Зоя', 'kocuba@gmail.com', 'Володимирівна', 'ROLE_DOCTOR', 'Коцюба', 8);
insert into user values ('DOCTOR', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'vdovychenko@gmail.com', 1, 'Василь', 'vdovychenko@gmail.com', 'Миколайович', 'ROLE_DOCTOR', 'Вдовиченко', 8);
insert into user values ('DOCTOR', default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), 'samoylenko@gmail.com', 1, 'Людмила', 'samoylenko@gmail.com', 'Вікторівна', 'ROLE_DOCTOR', 'Самойленко', 8);

-- Notes

insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1951-10-05"), 'Костянтин',  'Кузьмич', '0922332223', 'Дідик', date ("2022-02-14"), 10, 1);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1946-05-13"), 'Галина',  'Петрівна', '0923571596', 'Олійник', date ("2022-02-14"), 10, 2);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1945-09-05"), 'Роман', 'Євгенійович', '0982157654', 'Мірошник', date ("2022-02-14"), 10, 3);

insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1974-10-25"), 'Федір',  'Сергійович', '0933322565', 'Хрущов', date ("2022-02-14"), 11, 4);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1970-02-24"), 'Анатолій',  'Юхимович', '0925698320', 'Шелест', date ("2022-02-14"), 11, 1);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1961-12-30"), 'Валентина', 'Петрівна', '0634202399', 'Коваленко', date ("2022-02-14"), 11, 2);

insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1945-09-09"), 'Анастасія', 'Василіївна', '0903757988', 'Щербицька', date ("2022-02-14"), 12, 3);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1958-08-22"), 'Ксенія', 'Анатоліївна', '0761164928', 'Кожина', date ("2022-02-14"), 12, 4);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1942-05-04"), 'Юрій', 'Генадійович', '0485149358', 'Коновалов', date ("2022-02-14"), 12, 1);

insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1961-03-11"), 'Данило', 'Павлович', '0361715966', 'Бугай', date ("2022-02-14"), 13, 2);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1956-06-23"), 'Степан', 'Романович', '0828966036', 'Соловей', date ("2022-02-14"), 13, 3);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1975-03-17"), 'Юлія', 'Леонідівна', '0501983221', 'Чуприна', date ("2022-02-14"), 13, 4);

insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1971-11-09"), 'Серафима', 'Станіславівна', '0587496444', 'Могилевська', date ("2022-02-14"), 14, 1);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1970-07-20"), 'Євген', 'Артемович', '0196306634', 'Ісаєв', date ("2022-02-14"), 14, 2);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1954-09-01"), 'Давид', 'Кирилович', '0317411137', 'Лукаш', date ("2022-02-14"), 14, 3);

insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1966-05-07"), 'Павло',  'Ілліч', '0686451123', 'Шавурський', date ("2022-02-14"), 15, 4);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1945-04-15"), 'Максим',  'Ігорьович', '0752052826', 'Майструк', date ("2022-02-14"), 15, 1);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1974-06-27"), 'Єлизавета', 'Федорівна', '0655226271', 'Поліщук', date ("2022-02-14"), 15, 2);

insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1943-08-18"), 'Злата', 'Іванівна', '0585452418', 'Черняк', date ("2022-02-14"), 16, 3);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1957-01-07"), 'Кирило', 'Хомич', '0179215718', 'Риженко', date ("2022-02-14"), 16, 4);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1946-03-18"), 'Мирослава', 'Романівна', '0769438722', 'Клещевич', date ("2022-02-14"), 16, 1);

insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1959-07-13"), 'Карина',  'Мирославівна', '0227728998', 'Григорова', date ("2022-02-14"), 17, 2);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1963-12-15"), 'Олександр',  'Арсенівна', '0829871059', 'Вінник', date ("2022-02-14"), 17, 3);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1953-10-14"), 'Ігор', 'Анатолійович', '0588886814', 'Гурнак', date ("2022-02-14"), 17, 4);

insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1962-05-13"), 'Марія',  'Валентинівна', '0361700457', 'Трунова', date ("2022-02-14"), 18, 1);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1961-12-23"), 'Олеся',  'Михайлівна', '0682995660', 'Шахова', date ("2022-02-14"), 18, 2);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1945-06-10"), 'Єгор', 'Андрійович', '0990010389', 'Прудіус', date ("2022-02-14"), 18, 3);

insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1950-04-18"), 'Софія',  'Віталіївна', '0301957697', 'Собода', date ("2022-02-14"), 19, 4);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1966-08-27"), 'Станіслав',  'Олексійович', '0837195716', 'Локтіонов', date ("2022-02-14"), 19, 1);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1959-11-24"), 'Вікторія', 'Олексіївна', '0537580799', 'Домославська', date ("2022-02-14"), 19, 2);

insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1963-12-21"), 'Дмитро',  'Максимович', '0554118582', 'Бондар', date ("2022-02-14"), 20, 3);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1974-06-16"), 'Сергій',  'Борисович', '0923167918', 'Матвієнко', date ("2022-02-14"), 20, 4);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1957-08-31"), 'Марина', 'Робертівна', '0911035586', 'Ленкевич', date ("2022-02-14"), 20, 1);

insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1996-06-21"), 'Яна',  'Аркадіївна', '0261822512', 'Олійник', date ("2022-02-14"), 21, 2);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1954-10-25"), 'Назар',  'Ігорович', '0371008670', 'Столяр', date ("2022-02-14"), 21, 3);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1956-04-09"), 'Артем', 'Семенович', '0389696966', 'Кочергін', date ("2022-02-14"), 21, 4);

insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1951-09-19"), 'Антоніна', 'Семенівна', '0642635853', 'Тимошенко', date ("2022-02-14"), 22, 1);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1962-04-01"), 'Людмила', 'Миколаївна', '0267964391', 'Северіна', date ("2022-02-14"), 22, 2);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1960-06-24"), 'Дарина', 'Олегівна', '0248182696', 'Махно', date ("2022-02-14"), 22, 3);

insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1955-03-10"), 'Христина', 'Іванівна', '0943676814', 'Соловій', date ("2022-02-14"), 23, 4);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1952-11-18"), 'Антон', 'Андрійович', '0996518279', 'Симоненко', date ("2022-02-14"), 23, 1);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1960-08-10"), 'Іван', 'Олександрович', '0726428684', 'Ткачов', date ("2022-02-14"), 23, 2);

insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1972-12-29"), 'Ярослава', 'Костянтинівна', '0864130249', 'Ющак', date ("2022-02-14"), 24, 3);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1970-08-04"), 'Артур', 'Ігнатович', '0556522909', 'Ларін', date ("2022-02-14"), 24, 4);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1954-07-11"), 'Ілля', 'Платонович', '0947529902', 'Лозниця', date ("2022-02-14"), 24, 1);

insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1962-02-18"), 'Володимир',  'Юхимович', '0996917149', 'Дроздов', date ("2022-02-14"), 25, 2);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1958-10-08"), 'Катерина',  'Олегівна', '0662674040', 'Лебідь', date ("2022-02-14"), 25, 3);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1974-05-01"), 'Денис', 'Матвійович', '0934650858', 'Мальований', date ("2022-02-14"), 25, 4);

insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1996-06-21"), 'Катерина', 'Віталіївна', '0953254123', 'Ткаченко', date ("2022-02-14"), 26, 1);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1984-08-01"), 'Анатолій', 'Олексійович', '0687523265', 'Бовтун', date ("2022-02-14"), 26, 2);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1968-11-21"), 'Валентина', 'Петрівна', '0987418234', 'Зайченко', date ("2022-02-14"), 26, 3);

insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1947-05-03"), 'Сергій', 'Владиславович', '0678962145', 'Білозуб', date ("2022-02-14"), 27, 4);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1950-07-11"), 'Оксана', 'Костянтинівна', '0443693645', 'Вотінцева', date ("2022-02-14"), 27, 1);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1970-04-20"), 'Олена', 'Максимівна', '0678460439', 'Клименко', date ("2022-02-14"), 27, 2);

insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1966-10-01"), 'Микола', 'Олександрович', '0674109308', 'Шевченко', date ("2022-02-14"), 28, 3);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1948-08-14"), 'Світлана', 'Володимирівна', '0988631965', 'Юрченко', date ("2022-02-14"), 28, 4);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1969-04-10"), 'Михайло', 'Сергійович', '0442372060', 'Потапенко', date ("2022-02-14"), 28, 1);

insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1940-09-15"), 'Микита',  'Віталійович', '0675427864', 'Федорченко', date ("2022-02-14"), 29, 2);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1970-07-29"), 'Анна',  'Артемівна', '0891203304', 'Возна', date ("2022-02-14"), 29, 3);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1968-04-27"), 'Богдан', 'Євгенович', '0675064645', 'Задорожний', date ("2022-02-14"), 29, 4);

insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1963-06-30"), 'Володимир', 'Артурович', '0673219557', 'Рудий', date ("2022-02-14"), 30, 1);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1958-11-17"), 'Василина', 'Ігорівна', '0673707034', 'Русач', date ("2022-02-14"), 30, 2);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1944-01-03"), 'Олексій', 'Вадимович', '0977106278', 'Саєвич', date ("2022-02-14"), 30, 3);

insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1955-12-01"), 'Петро',  'Михайлович', '0992210160', 'Косач', date ("2022-02-14"), 31, 4);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1966-04-25"), 'Наталія',  'Миколаївна', '0463232210', 'Майстренко', date ("2022-02-14"), 31, 1);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1964-08-17"), 'Надія', 'Филиппівна', '0630234554', 'Лелюк', date ("2022-02-14"), 31, 2);

insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1954-06-09"), 'Нона',  'Борисівна', '0964568231', 'Орлова', date ("2022-02-14"), 32, 3);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1967-04-12"), 'Зоя',  'Максимівна', '0650032658', 'Косюк', date ("2022-02-14"), 32, 4);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1973-03-07"), 'Віта', 'Віталіївна', '0929220231', 'Бойчук', date ("2022-02-14"), 32, 1);

insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1945-01-02"), 'Ірина',  'Юріївна', '0698012986', 'Гурнак', date ("2022-02-14"), 33, 2);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1962-07-09"), 'Андрій',  'Якович', '0932588720', 'Біблик', date ("2022-02-14"), 33, 3);
insert into note
values (default, CURRENT_TIMESTAMP(), 1, CURRENT_TIMESTAMP(), date ("1956-12-17"), 'Микита', 'Лукич', '0993845889', 'Дубенко', date ("2022-02-14"), 33, 4);
