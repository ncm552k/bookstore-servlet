package business.customerDAO;

import model.customer.Customer;

public interface CustomerDAO{
    
    public  int addCustomer(Customer customer);
    
    public  void updateCustomer(Customer customer);
    
    public  Customer selectByCustomerID(int customerID);
 
}
