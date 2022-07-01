package business.customerDAO;

import model.customer.Account;

public interface AccountDAO {
    
    public  boolean checkAccountExisted(String userName);
    
    public  void addAccount(Account account );
    
    public  void updatePassword(Account account);
    
    public  boolean checkAccountExact(Account account);
    
    public  int getCustomerID(String user);
    
}
