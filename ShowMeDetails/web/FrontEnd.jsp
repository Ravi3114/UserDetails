<html>
  <head>
    <title>
      EnterDetailsPage
    </title>
  </head>
  <body>
    <form action="http://localhost:4567/PersonServlet/enter " method="post">
      <input type="hidden" name="hiddenAct" value="up"><html>
        <head>
          <title>
            SignupPage
          </title>
        </head>
        <body>
          <form action="http://localhost:4567/ShowMeDetails/enter" method="post">
            FullName<input type="text" name="fullname"/>
            <p>Gender: male <input type="radio" name="gender" value="male"> female <input type="radio" name="gender" value="female"> </p><br></br>
            <h1>Tick on the Certifications you have done :</h1>
            <p><input type="checkbox" name="program" value="java">Java</p></br>
            <p><input type="checkbox" name="program" value="py"   />Python   </p></br>
            <p><input type="checkbox" name="program" value="cs">CSharp</p></br>
            <p><input type="checkbox" name="program" value="ru">Ruby</p></br></br>
            <h1>Select your Previous company : </h1>
            <select name="company">
              <option value="prod">ProductBased</option>
              <option value="Food">FoodBased</option>
              <option value="car">CarBased</option>
            </select>
            <input type="submit" value="Enter">
          </form>
        </body>
      </html>
