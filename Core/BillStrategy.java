package Core;

import java.sql.Connection;

public interface BillStrategy {

        void payBill(Connection connection, String billType, double amount, String isPaid);
    }


