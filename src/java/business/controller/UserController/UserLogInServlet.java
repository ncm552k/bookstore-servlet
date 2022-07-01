
package business.controller.UserController;
import business.customerDAO.AccountDAOImplement;
import model.customer.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "UserLogInServlet", urlPatterns = {"/UserLogInServlet"})
public class UserLogInServlet extends HttpServlet {

    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user=req.getParameter("user");
        String password=req.getParameter("password");
        String url="";
        String errorMessage="";
        Account account=new Account(user, password,-1);
        
        System.out.println(user+"\t"+password);
        
        if(new AccountDAOImplement().checkAccountExact(account)){
            System.out.println("YES");
            req.getSession().setAttribute("user", user);
            req.getSession().setAttribute("customerID",new AccountDAOImplement().getCustomerID(user));
            resp.sendRedirect("XemDanhSachSP");
        }
        else{
            errorMessage="User or Password do not exact. You can write again";
            req.setAttribute("errorMessage", errorMessage);
            url="/Login.jsp";
            req.getServletContext().getRequestDispatcher(url).forward(req, resp);
        }
    }
}
