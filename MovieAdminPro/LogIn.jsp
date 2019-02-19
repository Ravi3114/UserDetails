<html>
  <head>
    <title><% out.println("LogIn");%></title>
  </head>
  <body>
    <h1>This is LogIn page. Please enter your LogIn credentials</h1>
    <form action="http://localhost:4567/MovieAdminPro/LogIn" method="post">
      E-Mail to LogIn:
      <input type="text" name="e_mail">
        <br>
        PassWord to LogIn:
        <input type="text" name="p_word">
        <br>
          <input type="SUBMIT" value="LogIn">
          </form>
        </body>
      </html>
