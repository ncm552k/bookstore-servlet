<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Dang nhap</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <style>
            body {
                font-family: "Helvetica Neue", Helvetica, Arial;
                padding-top: 20px;
                background-color: #e8e8e8
            }

            .container {
                width: 406px;
                max-width: 406px;
                margin: 0 auto;
            }

            #signup {
                padding: 0px 25px 25px;
                background: #fff;
                box-shadow: 
                    0px 0px 0px 5px rgba( 255,255,255,0.4 ), 
                    0px 4px 20px rgba( 0,0,0,0.33 );
                -moz-border-radius: 5px;
                -webkit-border-radius: 5px;
                border-radius: 5px;
                display: table;
                position: static;
            }

            #signup .header {
                margin-bottom: 20px;
            }

            #signup .header h3 {
                color: #333333;
                font-size: 24px;
                font-weight: bold;
                margin-bottom: 5px;
            }

            #signup .header p {
                color: #8f8f8f;
                font-size: 14px;
                font-weight: 300;
            }

            #signup .sep {
                height: 1px;
                background: #e8e8e8;
                width: 406px;
                margin: 0px -25px;
            }

            #signup .inputs {
                margin-top: 25px;
            }

            #signup .inputs label {
                color: #8f8f8f;
                font-size: 12px;
                font-weight: 300;
                letter-spacing: 1px;
                margin-bottom: 7px;
            }

            input::-webkit-input-placeholder {
                color:    #b5b5b5;
            }

            input:-moz-placeholder {
                color:    #b5b5b5;
            }

            #signup .inputs input[type=text], input[type=password] {
                background: #f5f5f5;
                font-size: 0.8rem;
                -moz-border-radius: 3px;
                -webkit-border-radius: 3px;
                border-radius: 3px;
                border: none;
                padding: 13px 10px;
                width: 330px;
                margin-bottom: 20px;
                box-shadow: inset 0px 2px 3px rgba( 0,0,0,0.1 );
                clear: both;
            }

            #signup .inputs input[type=text]:focus, input[type=password]:focus {
                background: #fff;
                box-shadow: 0px 0px 0px 3px #fff38e, inset 0px 2px 3px rgba( 0,0,0,0.2 ), 0px 5px 5px rgba( 0,0,0,0.15 );
                outline: none;   
            }

            #signup .inputs .checkboxy {
                display: block;
                position: static;
                height: 25px;
                margin-top: 10px;
                clear: both;
            }

            #signup .inputs input[type=checkbox] {
                float: left;
                margin-right: 10px;
                margin-top: 3px;
            }

            #signup .inputs label.terms {
                float: left;
                font-size: 14px;
                font-style: italic;
            }

            #signup .inputs #submit {
                width: 100%;
                margin-top: 20px;
                padding: 15px 0;
                color: #fff;
                font-size: 14px;
                font-weight: 500;
                letter-spacing: 1px;
                text-align: center;
                text-decoration: none;
                background: -moz-linear-gradient(
                    top,
                    #b9c5dd 0%,
                    #a4b0cb);
                background: -webkit-gradient(
                    linear, left top, left bottom, 
                    from(#b9c5dd),
                    to(#a4b0cb));
                -moz-border-radius: 5px;
                -webkit-border-radius: 5px;
                border-radius: 5px;
                border: 1px solid #737b8d;
                -moz-box-shadow:
                    0px 5px 5px rgba(000,000,000,0.1),
                    inset 0px 1px 0px rgba(255,255,255,0.5);
                -webkit-box-shadow:
                    0px 5px 5px rgba(000,000,000,0.1),
                    inset 0px 1px 0px rgba(255,255,255,0.5);
                box-shadow:
                    0px 5px 5px rgba(000,000,000,0.1),
                    inset 0px 1px 0px rgba(255,255,255,0.5);
                text-shadow:
                    0px 1px 3px rgba(000,000,000,0.3),
                    0px 0px 0px rgba(255,255,255,0);
                display: table;
                position: static;
                clear: both;
            }

            #signup .inputs #submit:hover {
                background: -moz-linear-gradient(
                    top,
                    #a4b0cb 0%,
                    #b9c5dd);
                background: -webkit-gradient(
                    linear, left top, left bottom, 
                    from(#a4b0cb),
                    to(#b9c5dd));
            }
        </style>
    </head>
    <body>

        <div class="container">

            <form id="signup" action="ChangeInfo" method="POST">

                <div class="header">

                    <h3>Change details personal infomation</h3>

                    <p>${success}</p>

                </div>

                <div class="sep"></div>

                <div class="inputs">

                    <input type="text" placeholder="Full Name" name="fullName" value="${fullName.fullName}" autofocus /> <span style="color: red"><i>${eFullName}</i></span>

                    <input type="text" placeholder="Last Name" name="lastName" value="${fullName.lastName}" /> <span style="color: red"><i>${eLastName}</i></span>
                    <input type="text" placeholder="First Name" name="firstName" value="${fullName.firstName}" /> <span style="color: red"><i>${eFirstName}</i></span>

                    <input type="text" placeholder="Phone"  name="phone" value="${customer.phone}" /> <span style="color: red"><i>${ePhone}</i></span>

                    <input type="text" placeholder="House Number" name="number" value="${address.number}" />  <span style="color: red"><i>${eNumber}</i></span>
                    <input type="text" placeholder="Street" name="street" value="${address.street}" />    <span style="color: red"><i>${eStreet}</i></span>
                    <input type="text" placeholder="District" name="district" value="${address.district}" />    <span style="color: red"><i>${eDistrict}</i></span>
                    <input type="text" placeholder="City" name="city" value="${address.city}" />    <span style="color: red"><i>${eCity}</i></span>
                    <input type="text" placeholder="Country" name="country" value="${address.country}" /> <span style="color: red"><i>${eCountry}</i></span>

                    
                    <input type="submit" id="submit">
                    <br>
                    <a href="XemDanhSachSP">Quay lai</a>

                </div>

            </form>

        </div>

    </body>
</html>