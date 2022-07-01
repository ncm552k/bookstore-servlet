package business.customerDAO;

import model.customer.Address;

public interface AddressDAO{
    
    public  void addAddress(Address address);
    
    public  void updateAddress(Address address);
    
    public  Address selectByIDCustomer(int customerId);
    
    
}
