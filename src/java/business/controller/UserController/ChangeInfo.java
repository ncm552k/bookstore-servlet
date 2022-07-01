package business.controller.UserController;

import business.customerDAO.AccountDAOImplement;
import business.customerDAO.AddressDAOImplement;
import business.customerDAO.CustomerDAOImplement;
import business.customerDAO.FullNameDAOImplement;
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
import javax.servlet.http.HttpSession;

@WebServlet(name = "ChangeInfo", urlPatterns = {"/ChangeInfo"})
public class ChangeInfo extends HttpServlet {

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
        
        String url="/ChangeInfo.jsp";
        
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
        
        FullName name=new FullName(fullName, lastName, firstName,-1);
        Address address=new Address(number, street, district, city, country,-1);
        Customer customer=new Customer(phone);
        
        
        if(     eFullName.equals("")&&
                eLastName.equals("")&&
                eFirstName.equals("")&&
                ePhone.equals("")&&
                eNumber.equals("")&&
                eStreet.equals("")&&
                eDistrict.equals("")&&
                eCity.equals("")){
            
            req.setAttribute("success", "Change successfully");
            url="/ChangeInfo.jsp";
            
            HttpSession session=req.getSession();
            String s=(String) session.getAttribute("user");
            int customerID=new AccountDAOImplement().getCustomerID(s);
            
            name.setCustomerID(customerID);
            address.setCustomerID(customerID);
            customer.setId(customerID);
            
            new FullNameDAOImplement().updateFullName(name);
            new AddressDAOImplement().updateAddress(address);
            new CustomerDAOImplement().updateCustomer(customer);
            
        }
        else{
            req.setAttribute("eFullName", eFullName);
            req.setAttribute("eLastName", eLastName);
            req.setAttribute("eFirstName", eFirstName);
            req.setAttribute("ePhone", ePhone);
            req.setAttribute("eNumber", eNumber);
            req.setAttribute("eStreet", eStreet);
            req.setAttribute("eDistrict", eDistrict);
            req.setAttribute("eCity", eCity);
            req.setAttribute("eCountry", eCountry);
            req.setAttribute("url", "./ChangeInfo");
            
            
            
//            req.setAttribute("fullName", name);
//            req.setAttribute("address", address);
//            req.setAttribute("customer", customer);
        }
        req.setAttribute("fullName", name);
        req.setAttribute("address", address);
        req.setAttribute("customer", customer);
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    } 

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        if(session.getAttribute("user")==null){
            resp.sendRedirect("index.html");
            return;
        }
        else{
            String user=(String) session.getAttribute("user");
            
            int customerID=new AccountDAOImplement().getCustomerID(user);
            
            Address address=new AddressDAOImplement().selectByIDCustomer(customerID);
            FullName fullName=new FullNameDAOImplement().selectByCustomerID(customerID);
            Customer customer=new CustomerDAOImplement().selectByCustomerID(customerID);
            
            req.setAttribute("address", address);
            req.setAttribute("fullName", fullName);
            req.setAttribute("customer", customer);
            
            getServletContext().getRequestDispatcher("/ChangeInfo.jsp").forward(req, resp);
        }
        
        
    }

    
    
    
    
}

