module com.hiberdata.databasehiber {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires org.hibernate.commons.annotations;
    requires org.hibernate.orm.core;
    requires mysql.connector.j;
    requires java.persistence;

    requires java.naming;

    requires java.sql;

    opens com.hiberdata.databasehiber.domain to org.hibernate.orm.core;


    opens com.hiberdata.databasehiber to javafx.fxml;
    exports com.hiberdata.databasehiber;
    exports com.hiberdata.databasehiber.domain;
}