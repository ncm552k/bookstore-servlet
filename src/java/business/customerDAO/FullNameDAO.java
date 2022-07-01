package business.customerDAO;

import model.customer.FullName;

public interface FullNameDAO {
    
    public  void addFullName(FullName fullName);
    
    public  void updateFullName(FullName fullName);
    
    public  FullName selectByCustomerID(int customerID);
}
