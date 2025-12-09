create table members
(
    id     number primary key,
    name   nvarchar2(20),
    family nvarchar2(20),
    birth_date date,
    gender nvarchar2(6),
    city nvarchar2(15)
);
create sequence member_seq start with 1 increment by 1;

-----------------------------------------------------------

create table books
(
    id     number primary key,
    title  nvarchar2(20),
    author nvarchar2(20)
);
create sequence book_seq start with 1 increment by 1;

-----------------------------------------------------------

create table borrows
(
    id          number primary key,
    member_id number,
    book_id number,
    borrow_date date,
    return_date date,

    foreign key (member_id) references members(id),
    foreign key (book_id) references books(id)
);

create sequence borrow_seq start with 1 increment by 1;

-----------------------------------------------------------


CREATE VIEW BORROW_VIEW AS
SELECT
    BORROWS.ID AS BORROW_ID,
    MEMBERS.ID AS MEMBER_ID,
    MEMBERS.NAME AS MEMBER_NAME,
    MEMBERS.FAMILY AS MEMBER_FAMILY,
    BOOKS.ID AS BOOK_ID,
    BOOKS.TITLE AS BOOK_TITLE,
    BOOKS.AUTHOR AS BOOK_AUTHOR,
    BORROWS.BORROW_DATE,
    BORROWS.RETURN_DATE
FROM MEMBERS
         JOIN BORROWS
              ON MEMBERS.ID = BORROWS.MEMBER_ID
         JOIN BOOKS
              ON BOOKS.ID = BORROWS.BOOK_ID;