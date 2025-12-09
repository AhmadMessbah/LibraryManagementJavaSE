package com.mftplus.model.utils;

public class SqlCommands {
    public static class Member{
        public final static String MEMBER_INSERT = "INSERT INTO MEMBERS VALUES (?,?,?,?,?,?)";
        public final static String MEMBER_UPDATE = "UPDATE MEMBERS SET NAME=?, FAMILY=?, BIRTH_DATE=?, GENDER=?, CITY=? WHERE ID=?";
        public final static String MEMBER_DELETE = "DELETE FROM MEMBERS WHERE ID=?";
        public final static String MEMBER_LOGICAL_DELETE = "UPDATE MEMBERS SET DELETED=1 WHERE ID=?";
        public final static String MEMBER_SELECT_BY_ID = "SELECT ID AS MEMBER_ID, NAME AS MEMBER_NAME, FAMILY AS MEMBER_FAMILY, BIRTH_DATE AS MEMBER_BIRTH_DATE, GENDER AS MEMBER_GENDER, CITY AS MEMBER_CITY FROM MEMBERS WHERE ID=? AND DELETED=0";
        public final static String MEMBER_SELECT_ALL = "SELECT ID AS MEMBER_ID, NAME AS MEMBER_NAME, FAMILY AS MEMBER_FAMILY, BIRTH_DATE AS MEMBER_BIRTH_DATE, GENDER AS MEMBER_GENDER, CITY AS MEMBER_CITY FROM MEMBERS WHERE DELETED=0";
    }

    public static class Book{
        public final static String BOOK_INSERT = "INSERT INTO BOOKS VALUES (?,?,?)";
        public final static String BOOK_UPDATE = "UPDATE BOOKS SET TITLE=?, AUTHOR=? WHERE ID=?";
        public final static String BOOK_DELETE = "DELETE FROM BOOKS WHERE ID=?";
        public final static String BOOK_SELECT_ALL = "SELECT ID AS BOOK_ID, TITLE AS BOOK_TITLE, AUTHOR AS BOOK_AUTHOR FROM BOOKS";
        public final static String BOOK_SELECT_BY_ID = "SELECT ID AS BOOK_ID, TITLE AS BOOK_TITLE, AUTHOR AS BOOK_AUTHOR FROM BOOKS WHERE ID=?";
    }

    public static class Borrow{
        public final static String BORROW_INSERT = "INSERT INTO BORROWS VALUES (?,?,?,?,?)";
        public final static String BORROW_UPDATE = "UPDATE BORROWS SET MEMBER_ID=?, BOOK_ID=?, BORROW_DATE=?, RETURN_DATE=? WHERE ID=?";
        public final static String BORROW_RETURN_BOOK_BY_ID = "UPDATE BORROWS SET RETURN_DATE=? WHERE ID=?";
        public final static String BORROW_DELETE = "DELETE FROM BORROWS WHERE ID=?";
        public final static String BORROW_SELECT_ALL = "SELECT * FROM BORROW_VIEW";
        public final static String BORROW_SELECT_BY_ID = "SELECT * FROM BORROW_VIEW WHERE ID=?";
        public final static String BORROW_SELECT_BY_MEMBER_ID = "SELECT * FROM BORROW_VIEW WHERE MEMBER_ID=?";
        public final static String BORROW_SELECT_BY_BOOK_ID = "SELECT * FROM BORROW_VIEW WHERE BOOK_ID=?";
        public final static String BORROW_SELECT_RETURNED = "SELECT * FROM BORROW_VIEW WHERE RETURN_DATE IS NOT NULL";
        public final static String BORROW_SELECT_UNRETURNED = "SELECT * FROM BORROW_VIEW WHERE RETURN_DATE IS NULL";
        public final static String BORROW_SELECT_UNRETURNED_BY_MEMBER_ID = "SELECT * FROM BORROW_VIEW WHERE MEMBER_ID=? AND RETURN_DATE IS NULL";
        public final static String BORROW_SELECT_COUNT_UNRETURNED_BY_MEMBER_ID = "SELECT COUNT(*) AS UNRETURNED_COUNT FROM BORROW_VIEW WHERE MEMBER_ID=? AND RETURN_DATE IS NULL";
        public final static String BORROW_SELECT_UNRETURNED_BY_BOOK_ID = "SELECT * FROM BORROW_VIEW WHERE BOOK_ID=? AND RETURN_DATE IS NULL";
    }
}
