package business.controller.UserController;

import business.customerDAO.AccountDAOImplement;
import business.customerDAO.AddressDAOImplement;
import business.customerDAO.CustomerDAOImplement;
import business.customerDAO.FullNameDAOImplement;
import business.orderDAO.CartDAOImplement;
import model.customer.Account;
import model.customer.Address;
import model.customer.Customer;
import model.customer.FullName;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.order.Cart;
@WebServlet(name = "UserRegisterServlet", urlPatterns = {"/UserRegisterServlet"})
public class UserRegisterServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName=req.getParameter("fullName");
        String lastName=req.getParameter("lastName");
        String firstName=req.getParameter("firstName");
        
        String phone=req.getParameter("phone");
        
        String number=req.getParameter("number");
        String street=req.getParameter("street");
        String district=req.getParameter("district");
        String city=req.getParameter("city");
        String country=req.getParameter("country");
        
        String user=req.getParameter("user");
        String password=req.getParameter("password");
        
        String url="/Register.jsp";
        
        String eFullName="";
        if(fullName.trim().equals("")) eFullName="Full name not empty";
        
        String eLastName="";
        if(lastName.trim().equals("")) eLastName="Last name not empty";
        
        String eFirstName="";
        if(firstName.trim().equals("")) eFirstName="Last name not empty";
        
        String ePhone="";
        if(phone.trim().equals("")) ePhone="Phone not empty";
        
        String eNumber="";
        if(number.trim().equals("")) eNumber="House number not empty";
        
        String eStreet="";
        if(street.trim().equals("")) eStreet="Street not empty";
        
        String eDistrict="";
        if(district.trim().equals("")) eDistrict="District not empty";
        
        String eCity="";
        if(city.trim().equals("")) eCity="City not empty";
        
        String eCountry="";
        if(country.trim().equals("")) eCountry="Country not empty";
        
        String eUser="";
        if(user.trim().equals("")) eUser="User not empty";
        
        String ePassword="";
        if(password.trim().equals("")) ePassword="Password not empty";
        
        FullName name=new FullName(fullName, lastName, firstName,-1);
        Address address=new Address(number, street, district, city, country,-1);
        Account account=new Account(user, password,-1);
        Customer customer=new Customer(phone);
        
        
        if(     eFullName.equals("")&&
                eLastName.equals("")&&
                eFirstName.equals("")&&
                ePhone.equals("")&&
                eNumber.equals("")&&
                eStreet.equals("")&&
                eDistrict.equals("")&&
                eCity.equals("")&&
                eUser.equals("")&&
                ePassword.equals("")
                && !new AccountDAOImplement().checkAccountExisted(user)){
            
            String successResiter="Register successfully";
            req.setAttribute("success", successResiter);
            
            
            url="/Login.jsp";
            
            int customerID=new CustomerDAOImplement().addCustomer(customer);
            
            address.setCustomerID(customerID);
            new AddressDAOImplement().addAddress(address);
            
            account.setCustomerID(customerID);
            new AccountDAOImplement().addAccount(account);
            
            name.setCustomerID(customerID);
            new FullNameDAOImplement().addFullName(name);
            
            new CartDAOImplement().addCart(new Cart(customerID,0,new java.sql.Date(new java.util.Date().getTime())));
            
            
        }
        else{
            
            if(new AccountDAOImplement().checkAccountExisted(user)){
                eUser="Existed";
            }
            req.setAttribute("eFullName", eFullName);
            req.setAttribute("eLastName", eLastName);
            req.setAttribute("eFirstName", eFirstName);
            req.setAttribute("ePhone", ePhone);
            req.setAttribute("eNumber", eNumber);
            req.setAttribute("eStreet", eStreet);
            req.setAttribute("eDistrict", eDistrict);
            req.setAttribute("eCity", eCity);
            req.setAttribute("eCountry", eCountry);
            req.setAttribute("eUser", eUser);
            req.setAttribute("ePassword", ePassword);
            
            
            
            req.setAttribute("fullName", name);
            req.setAttribute("address", address);
            req.setAttribute("account", account);
            req.setAttribute("customer", customer);
        }
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    } 

   
}
