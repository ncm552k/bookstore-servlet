/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package business.controller.OrderController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.order.Cash;
import model.order.Check;
import model.order.Credit;

/**
 *
 * @author vuvin
 */
@WebServlet(name = "SelectPayment", urlPatterns = {"/SelectPayment"})
public class SelectPayment extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] selectedMethod = request.getParameterValues("paymentMethod");
        String url = "/Payment.jsp";
        System.out.println(selectedMethod[0]);
        if (selectedMethod[0].equals("cash")) {
            String cashTendered = request.getParameter("cashTendered");
            String cashTenderedMessage = "";
            if (cashTendered == null || cashTendered.isEmpty()) {
                cashTendered = "";
                cashTenderedMessage = "please enter cashTendered";
                url = "/Payment.jsp";
            } else {
                url = "/Shipment.jsp";
                            try {
                request.getSession().setAttribute("cash", new Cash(Float.parseFloat(cashTendered)));
            } catch (NumberFormatException e) {
                cashTenderedMessage = "please enter float value";
            }
            request.setAttribute("cashTenderedMessage", cashTenderedMessage);
            }

        }
        if (selectedMethod[0].equals("check")) {
            String name = request.getParameter("name");
            String bankID = request.getParameter("bankID");
            String nameMessage = "";
            String bankIDMessage = "";
            if (name == null || name.equals("")) {
                nameMessage = "please enter name";
            }
            if (bankID == null || bankID.equals("")) {
                bankIDMessage = "please enter Bank ID";
            }
            if (nameMessage.equals("") && bankIDMessage.equals("")) {
                 url = "/Shipment.jsp";
                Check check = new Check(name, bankID);
                System.out.println(check.getName());
                System.out.println(check.getBankID());
                request.getSession().setAttribute("check", check);
                System.out.println("dd");
                
            } else {
                url = "/Payment.jsp";
            }
           
            request.setAttribute("nameMessage", nameMessage);
            request.setAttribute("bankIDMessage", bankIDMessage);
        }
        if (selectedMethod[0].equals("credit")) {
            String number = request.getParameter("number");
            String type = request.getParameter("type");
            String numberMessage = "";
            String typeMessage = "";
            String expDateMessage = "";
            String startDateStr = request.getParameter("expDate");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date expDate = new Date(new java.util.Date().getTime());
            try {
                //surround below line with try catch block as below code throws checked exception
                 expDate= new Date( sdf.parse(startDateStr).getTime());
            } catch (ParseException ex) {
                Logger.getLogger(SelectPayment.class.getName()).log(Level.SEVERE, null, ex);
                expDateMessage = ex.getMessage();
            }

            if (number == null || number.equals("")) {
                numberMessage = "please enter name";
            }
            if (type == null || type.equals("")) {
                typeMessage = "please enter Bank ID";
            }
            if (numberMessage.isEmpty() && typeMessage.isEmpty()&& expDateMessage.isEmpty()) {
                url = "/Shipment.jsp";
                request.getSession().setAttribute("credit", new Credit(number, type, expDate));
            } else {
                url = "/Payment.jsp";
                
            }
            
            request.setAttribute("numberMessage", numberMessage);
            request.setAttribute("typeMessage", typeMessage);
            request.setAttribute("expDateMessage", expDateMessage);
            
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

}
