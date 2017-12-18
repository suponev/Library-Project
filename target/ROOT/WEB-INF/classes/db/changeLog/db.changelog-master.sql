CREATE TABLE USER (
  username character varying(32) NOT NULL,
  password character varying(32) ,
);
ALTER TABLE USER ADD PRIMARY KEY (username);
INSERT INTO USER (username, password) VALUES ('admin','admin');


CREATE TABLE BOOK (
  isbn character varying(32) NOT NULL,
  title character varying(32) ,
  author character varying(32) ,
  username character varying(32) ,
);
ALTER TABLE BOOK ADD PRIMARY KEY (isbn);
INSERT INTO BOOK (isbn, title,author,username) VALUES ('10157','Моби Дик' , 'Герман Мелвилл' , null);
INSERT INTO BOOK (isbn, title,author,username) VALUES ('10-YT1','Властелин колец' , 'Дж. Р. Р. Толкиен ' , null);
INSERT INTO BOOK (isbn, title,author,username) VALUES ('9434GT','Гордость и предубеждение' , 'Джейн Остин' , null);
INSERT INTO BOOK (isbn, title,author,username) VALUES ('84300','Винни Пух' , 'Алан Александр Милн' , null);
INSERT INTO BOOK (isbn, title,author,username) VALUES ('HYFE63','Дракула' , 'Брэм Стокер' , null);
INSERT INTO BOOK (isbn, title,author,username) VALUES ('992U','Ключ от всех дверей' , 'Энтони Горовиц' , null);
INSERT INTO BOOK (isbn, title,author,username) VALUES ('UFS822','Искупление' , 'Иэн Макьюэн' , null);
INSERT INTO BOOK (isbn, title,author,username) VALUES ('J-U992','Маленький принц' , 'Антуан де Сент-Экзюпери' , null);
INSERT INTO BOOK (isbn, title,author,username) VALUES ('934JS','Матильда' , 'Роальд Даль' , null);
INSERT INTO BOOK (isbn, title,author,username) VALUES ('455643','Алхимик' , 'Пауло Коэльо' , null);
INSERT INTO BOOK (isbn, title,author,username) VALUES ('6756K2','Собака Баскервилей' , 'Артур Конан Дойль' , null);
INSERT INTO BOOK (isbn, title,author,username) VALUES ('93424UL','В хранилищах музея' , 'Кейт Аткинсон' , null);
