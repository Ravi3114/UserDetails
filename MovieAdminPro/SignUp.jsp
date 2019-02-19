<html>
  <head>
    <title><%out.println("SignUpForm");%></title>
  </head>
  <body>
    <h1> Enter the details in the respective fields </h1>
    <form action="http://localhost:4567/MovieAdminPro/SignUp" method="post">
      FirstName:
      <input type="text" name="fName">
      LastName:
      <input type="text" name="lName">
        <br>
          email:
          <input type="text" name="email">
            password:
            <input type="text" name="pword">
              <br>
                Enter DateOfBirth(yyyy/mm/dd):
                <input type="text" name="DOB">
                  <br>
                <input type="submit" Value="SignUp">
                </form>
              </body>
            </html>
